package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.GalleryImageRepository;
import ch.junggarde.api.application.dto.GalleryImageDTO;
import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GalleryService {
    @Inject
    GalleryImageRepository galleryImageRepository;

    @Inject
    ImageService imageService;

    public List<GalleryImageDTO> getGallery() {
        List<GalleryImage> galleryImages = galleryImageRepository.getGallery();

        // Get all imageIds of the gallery images
        List<String> imageIds = galleryImages.stream()
                .map(galleryImage -> galleryImage.getImageId().toString())
                .toList();

        List<Image> images = imageService.getGalleryImages(imageIds);

        List<GalleryImageDTO> response = new ArrayList<>(galleryImages.size());
        // Create DTOs
        galleryImages.forEach(galleryImage -> {
                    UUID imageId = galleryImage.getImageId();
                    for (Image image : images) {
                        if (image.getId().equals(imageId)) {
                            response.add(GalleryImageDTO.fromDomainModel(galleryImage, image));
                            break;
                        }
                    }
                }
        );
        return response;
    }
}

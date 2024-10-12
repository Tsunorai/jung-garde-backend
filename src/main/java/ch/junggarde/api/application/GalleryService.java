package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.GalleryImageRepository;
import ch.junggarde.api.application.dto.GalleryImageDTO;
import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

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

        // Add image to gallery image and map to dto
        return galleryImages.stream()
                .map(galleryImage -> GalleryImageDTO.fromDomainModel(
                                galleryImage,
                                images.stream()
                                        .filter(image -> image.getId().equals(galleryImage.getId()))
                                        .findFirst()
                                        .orElseThrow(RuntimeException::new) // todo create custom exception
                        )
                ).toList();
    }
}

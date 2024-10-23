package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.GalleryImageRepository;
import ch.junggarde.api.adapter.out.ImageRepository;
import ch.junggarde.api.application.dto.GalleryImageDTO;
import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;
import ch.junggarde.api.model.ImageNotFound;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GalleryService {
    @Inject
    GalleryImageRepository galleryImageRepository;

    @Inject
    ImageRepository imageRepository;

    public List<GalleryImageDTO> getGallery() throws ImageNotFound {
        List<GalleryImage> galleryImages = galleryImageRepository.getGallery();

        // Get all imageIds of the gallery images
        List<String> imageIds = galleryImages.stream()
                .map(galleryImage -> galleryImage.getImageId().toString())
                .toList();

        List<Image> images = imageRepository.findImagesByIds(imageIds);

        // Add image to gallery image and map to dto
        return galleryImages.stream()
                .map(galleryImage -> GalleryImageDTO.fromDomainModel(
                                galleryImage,
                                images.stream()
                                        .filter(image -> image.getId().equals(galleryImage.getId()))
                                        .findFirst()
                                        .orElseThrow(() -> new ImageNotFound(galleryImage.getId()))
                        )
                ).toList();
    }

    public List<GalleryImageDTO> addImages(List<GalleryImageDTO> galleryImageDTOs) {
        List<GalleryImageDTO> response = new ArrayList<>(galleryImageDTOs.size());
        List<GalleryImage> galleryImages = new ArrayList<>(galleryImageDTOs.size());
        List<Image> images = new ArrayList<>(galleryImageDTOs.size());

        for (GalleryImageDTO galleryImageDTO : galleryImageDTOs) {
            Image image = new Image(galleryImageDTO.format(), galleryImageDTO.base64());
            GalleryImage galleryImage = new GalleryImage(
                    image.getId(),
                    Year.parse(galleryImageDTO.year()),
                    galleryImageDTO.event(),
                    UUID.fromString(galleryImageDTO.positionId())
            );

            images.add(image);
            galleryImages.add(galleryImage);
            response.add(GalleryImageDTO.fromDomainModel(galleryImage, image));
        }

        imageRepository.saveImages(images);
        galleryImageRepository.saveImages(galleryImages);

        return response;
    }
}

package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.GalleryImageRepository;
import ch.junggarde.api.adapter.out.ImageRepository;
import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GalleryService {
    @Inject
    GalleryImageRepository galleryImageRepository;
    @Inject
    ImageRepository imageRepository;

    public List<GalleryImage> getGallery() {
        List<GalleryImage> galleryImages = galleryImageRepository.getGallery();
        List<String> imageIds = galleryImages.stream()
                .map(galleryImage -> galleryImage.getImage().getId().toString())
                .toList();
        List<Image> images = imageRepository.getGalleryImages(imageIds);
        galleryImages.forEach(galleryImage -> {
                    UUID imageId = galleryImage.getImage().getId();
                    for (Image image : images) {  // Assuming 'images' is a collection of 'Image' objects
                        if (image.getId().equals(imageId)) {
                            galleryImage.setImage(image);
                            break;
                        }
                    }
                }
        );
        return galleryImages;
    }
}

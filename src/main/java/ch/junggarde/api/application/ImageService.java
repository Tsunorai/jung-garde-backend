package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.ImageRepository;
import ch.junggarde.api.model.Image;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ImageService {  // Todo check if needed
    @Inject
    ImageRepository imageRepository;

    public List<Image> getGalleryImages(List<String> imageIds) {
        return imageRepository.getGalleryImages(imageIds);
    }
}

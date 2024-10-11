package ch.junggarde.api.application.dto;

import ch.junggarde.api.model.GalleryImage;
import ch.junggarde.api.model.Image;

public record GalleryImageDTO(
        String id,
        String imageId,
        String format,
        String base64,
        String year,
        String event,
        String positionId) {
    public static GalleryImageDTO fromDomainModel(final GalleryImage galleryImage, final Image image) {
        return new GalleryImageDTO(
                galleryImage.getId().toString(),
                image.getId().toString(),
                image.getFormat(),
                image.getBase64(),
                galleryImage.getYear().toString(),
                galleryImage.getEvent(),
                galleryImage.getPositionId().toString()
        );
    }
}

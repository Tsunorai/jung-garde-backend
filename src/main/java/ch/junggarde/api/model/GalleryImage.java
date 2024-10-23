package ch.junggarde.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.time.Year;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class GalleryImage {
    private UUID id;
    private UUID imageId;
    private Year year;
    private String event;
    private UUID positionId;

    public GalleryImage(UUID imageId, Year year, String event, UUID positionId) {
        this.id = UUID.randomUUID();
        this.imageId = imageId;
        this.year = year;
        this.event = event;
        this.positionId = positionId;
    }
}

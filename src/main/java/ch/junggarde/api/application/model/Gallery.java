package ch.junggarde.api.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Year;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
    private UUID id;
    private Image image;
    private Year year;
    private String event;
    private UUID positionId;
}

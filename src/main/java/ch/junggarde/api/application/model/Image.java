package ch.junggarde.api.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private UUID id;
    private String base64;

    public UUID randomId() {
        return UUID.randomUUID();
    }
}

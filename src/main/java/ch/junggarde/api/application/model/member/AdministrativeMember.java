package ch.junggarde.api.application.model.member;

import ch.junggarde.api.application.model.Image;
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
public class AdministrativeMember {
    private UUID id;
    private Member member;
    private Role role;
    private String description;
    private Image image;
    private Member supervisor;
}

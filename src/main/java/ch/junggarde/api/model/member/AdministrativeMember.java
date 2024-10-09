package ch.junggarde.api.model.member;

import ch.junggarde.api.model.Image;
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
    private String jobTitle;
    private String description;
    private Image image;
    private AdministrativeMember supervisor;
}

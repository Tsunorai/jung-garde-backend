package ch.junggarde.api.application.model.member;

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
public final class Member {
    private UUID id;
    private String firstname;
    private String lastname;
    private Instrument instrument;
}

package ch.junggarde.api.model.member;

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
public class Member {
    private UUID id;
    private String firstname;
    private String lastname;
    private Instrument instrument;
}

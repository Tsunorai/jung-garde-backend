package ch.junggarde.api.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private UUID id;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String name;
    private AppointmentType type;
}

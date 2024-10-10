package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.AppointmentRepository;
import ch.junggarde.api.model.Appointment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AppointmentService {
    @Inject
    AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }
}

package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.model.Appointment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AppointmentRepository extends ReactiveCrudRepository<Appointment, Long> {
    public Flux<Appointment> findByDoctorId(Long id);
}

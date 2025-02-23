package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.model.Appointment;
import com.example.demoSkh.demoSkh.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/doctor/{doctorId}")
    public Flux<Appointment> findByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.findByDoctorId(doctorId);
    }

    @GetMapping
    public Flux<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Appointment> findById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @PostMapping
    public Mono<Appointment> save(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public Mono<Appointment> update(@RequestBody Appointment appointment, @PathVariable Long id) {
        return appointmentService.update(appointment, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return appointmentService.delete(id);
    }
}

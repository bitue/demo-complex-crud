package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.dto.AppointmentDto;
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
    public Flux<AppointmentDto> findByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.findByDoctorId(doctorId);
    }

    @GetMapping
    public Flux<AppointmentDto> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AppointmentDto> findById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @PostMapping
    public Mono<AppointmentDto> save(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.save(appointmentDto);
    }

    @PutMapping("/{id}")
    public Mono<AppointmentDto> update(@RequestBody AppointmentDto appointmentDto, @PathVariable Long id) {
        return appointmentService.update(appointmentDto, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return appointmentService.delete(id);
    }
}

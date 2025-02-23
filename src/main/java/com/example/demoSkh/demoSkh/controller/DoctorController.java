package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.dto.DoctorDto;
import com.example.demoSkh.demoSkh.services.DoctorService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Mono<DoctorDto> saveDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorService.save(doctorDto);
    };

    @GetMapping("/{id}")
    public Mono<DoctorDto> findDoctorById( @PathVariable Long id) {
        System.out.println(id);
       return doctorService.findById(id) ;
    }

    @GetMapping
    public Flux<DoctorDto> getAllDoctors() {
        return doctorService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto , @PathVariable long id) {
        return doctorService.update(doctorDto, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteDoctor(@PathVariable long id) {
        return doctorService.deleteById(id);
    }

}

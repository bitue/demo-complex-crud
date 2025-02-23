package com.example.demoSkh.demoSkh.controller;
import com.example.demoSkh.demoSkh.model.Doctor;
import com.example.demoSkh.demoSkh.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public Mono<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    };

    @GetMapping("/{id}")
    public Mono<Doctor> findDoctorById( @PathVariable Long id) {
        System.out.println(id);
       return doctorService.findById(id) ;
    }

    @GetMapping
    public Flux<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Doctor> updateDoctor(@RequestBody Doctor doctor , @PathVariable long id) {
        return doctorService.update(doctor, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteDoctor(@PathVariable long id) {
        return doctorService.deleteById(id);
    }






}

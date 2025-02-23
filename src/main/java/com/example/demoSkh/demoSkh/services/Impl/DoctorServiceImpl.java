package com.example.demoSkh.demoSkh.services.Impl;
import com.example.demoSkh.demoSkh.dto.DoctorDto;
import com.example.demoSkh.demoSkh.model.Doctor;
import com.example.demoSkh.demoSkh.repository.DoctorRepository;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    DoctorServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<DoctorDto> save(DoctorDto doctorDto) {
        return doctorRepository.save(modelMapper.map(doctorDto, Doctor.class))
                .map((doctor)-> modelMapper.map(doctor, DoctorDto.class));
    }

    @Override
    public Flux<DoctorDto> findAll() {
        return doctorRepository.findAll().map(doctor -> modelMapper.map(doctor, DoctorDto.class));
    }

    @Override
    public Mono<DoctorDto> findById(Long id) {
        return doctorRepository.findById(id).map(doctor -> modelMapper.map(doctor, DoctorDto.class));
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return doctorRepository.deleteById(id);
    }

    @Override
    public Mono<DoctorDto> update(DoctorDto doctorDto, Long id) {
        return doctorRepository.findById(id)
                .flatMap(existingDoctor -> {
                    existingDoctor.setName(doctorDto.getName());
                    existingDoctor.setAddress(doctorDto.getAddress());
                    existingDoctor.setDesignation(doctorDto.getDesignation());
                    existingDoctor.setSpecialization(doctorDto.getSpecialization());
                    return doctorRepository.save(existingDoctor).map(doctor -> modelMapper.map(doctor, DoctorDto.class));
                });
    }

}

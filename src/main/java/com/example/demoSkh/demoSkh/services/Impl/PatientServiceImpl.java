package com.example.demoSkh.demoSkh.services.Impl;
import com.example.demoSkh.demoSkh.dto.PatientDto;
import com.example.demoSkh.demoSkh.model.Patient;
import com.example.demoSkh.demoSkh.repository.PatientRepository;
import com.example.demoSkh.demoSkh.services.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Override
    public Mono<PatientDto> savePatient(PatientDto patientDto) {
        return patientRepository.save(modelMapper.map(patientDto, Patient.class)).map(patient->modelMapper.map(patient, PatientDto.class));
    }

    @Override
    public Mono<PatientDto> updatePatient(PatientDto patientDto, Long id) {
       return patientRepository.findById(id)
               .flatMap(patient -> {
                   patient.setName(patientDto.getName());
                   patient.setAddress(patientDto.getAddress());
                   patient.setPhone(patientDto.getPhone());
                   return patientRepository.save(modelMapper.map(patient, Patient.class)).map(updatedPatient->modelMapper.map(updatedPatient, PatientDto.class));
       });

    }

    @Override
    public Mono<PatientDto> getPatient(Long id) {
        return patientRepository.findById(id).map(patient -> modelMapper.map(patient, PatientDto.class));
    }

    @Override
    public Flux<PatientDto> getAllPatients() {
        return patientRepository.findAll().map(person -> modelMapper.map(person, PatientDto.class));
    }

    @Override
    public Mono<Void> deletePatient(Long id) {
        return patientRepository.deleteById(id);
    }
}

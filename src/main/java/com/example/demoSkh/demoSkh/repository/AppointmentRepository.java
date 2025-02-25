package com.example.demoSkh.demoSkh.repository;
import com.example.demoSkh.demoSkh.dto.AppointmentResponseDto;
import com.example.demoSkh.demoSkh.model.Appointment;
import com.example.demoSkh.demoSkh.model.AppointmentResponse;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;



/*

    private Long appointmentId;
    private String patientName;
    private String patientPhone;
    private String doctorName;
    private String doctorSpecialty;
    private String details;
 */



@Repository
public interface AppointmentRepository extends ReactiveCrudRepository<Appointment, Long> {
    public Flux<Appointment> findByDoctorId(Long id);

//    @Query("SELECT a.appointment_id, p.name AS patientName, p.phone AS patientPhone, " +
//            "d.name AS doctorName, d.specialization AS doctorSpecialty, a.details AS appointmentDetails " +
//            "FROM appointment a " +
//            "INNER JOIN patient p ON a.patient_id = p.patient_id " +
//            "INNER JOIN doctor d ON a.doctor_id = d.doctor_id")

//
//    @Query("SELECT a.appointment_id AS appointmentId, p.name AS patientName, p.phone AS patientPhone, " +
//        "d.name AS doctorName, d.specialization AS doctorSpecialty, a.details AS details " +
//        "FROM appointment a " +
//        "INNER JOIN patient p ON a.patient_id = p.patient_id " +
//        "INNER JOIN doctor d ON a.doctor_id = d.doctor_id")

    @Query("SELECT a.appointment_id , p.name AS patient_name , p.phone AS patient_phone , " +
            "d.name AS doctor_name , d.specialization AS doctor_specialization, a.details  " +
            "FROM appointment a " +
            "LEFT JOIN patient p ON a.patient_id = p.patient_id " +
            "LEFT JOIN doctor d ON a.doctor_id = d.doctor_id")
    public Flux<AppointmentResponse> AppointmentInformation ();
}

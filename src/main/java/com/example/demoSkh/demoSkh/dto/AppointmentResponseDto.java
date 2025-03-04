package com.example.demoSkh.demoSkh.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentResponseDto {
    private Long appointmentId;
    private String patientName;
    private String patientPhone;
    private String doctorName;
    private String doctorSpecialty;
    private String details;
}

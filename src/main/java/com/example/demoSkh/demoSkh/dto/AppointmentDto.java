package com.example.demoSkh.demoSkh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String details;

}

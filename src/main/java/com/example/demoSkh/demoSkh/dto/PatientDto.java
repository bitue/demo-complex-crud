package com.example.demoSkh.demoSkh.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PatientDto {
    private Long patientId;
    private String name;
    private String address;
    private String phone;
    private Long doctorId;
}

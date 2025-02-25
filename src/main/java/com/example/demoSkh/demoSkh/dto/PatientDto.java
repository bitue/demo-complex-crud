package com.example.demoSkh.demoSkh.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PatientDto {
    private Long patientId;
    private String name;
    private String address;
    private String phone;
    @Column("date_of_registration")
    private String dateOfRegistration;
    private String city;
    private String state;
}

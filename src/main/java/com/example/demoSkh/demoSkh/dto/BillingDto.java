package com.example.demoSkh.demoSkh.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillingDto {
    private Long billingId;
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private Long billAmount;
}

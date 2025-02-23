package com.example.demoSkh.demoSkh.services.Impl;
import com.example.demoSkh.demoSkh.dto.BillingDto;
import com.example.demoSkh.demoSkh.model.Billing;
import com.example.demoSkh.demoSkh.repository.AppointmentRepository;
import com.example.demoSkh.demoSkh.repository.BillingRepository;
import com.example.demoSkh.demoSkh.services.BillingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class BillingServiceImpl implements BillingService {

    private final ModelMapper modelMapper;
    private BillingRepository billingRepository;
    private AppointmentRepository appointmentRepository;

    @Override
    public Mono<BillingDto> save(BillingDto billingDto) {
        // check the appointId is valid or not then save it
        return checkAppointIdIsValid(billingDto.getAppointmentId()).then(billingRepository.save(modelMapper.map(billingDto, Billing.class)))
                .map(ele -> modelMapper.map(ele, BillingDto.class));
    }

    @Override
    public Mono<BillingDto> findById(Long id) {
        return billingRepository.findById(id).map(ele -> modelMapper.map(ele, BillingDto.class));
    }

    @Override
    public Flux<BillingDto> findAll() {
        return billingRepository.findAll().map(ele -> modelMapper.map(ele, BillingDto.class));
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return billingRepository.deleteById(id);
    }

    @Override
    public Mono<BillingDto> update(Long id, BillingDto billingDto) {
       return  Mono.when(checkAppointIdIsValid(billingDto.getAppointmentId()))
                .then(billingRepository.findById(id))
                .switchIfEmpty(Mono.error(new RuntimeException("No Billing Id found "))).flatMap(ele -> {
                    ele.setBillAmount(billingDto.getBillAmount());
                    ele.setAppointmentId(billingDto.getAppointmentId());
                    ele.setBillAmount(billingDto.getBillAmount());
                    return billingRepository.save(ele).map(ele2 -> modelMapper.map(ele2, BillingDto.class));
                });
    }

    @Override
    public Flux<BillingDto> findByAppointmentId(Long appointmentId) {
        return billingRepository.findByAppointmentId(appointmentId).map(ele -> modelMapper.map(ele, BillingDto.class));
    }

    private Mono<Void> checkAppointIdIsValid(Long appointmentId){
        if (appointmentId == null) {
            return Mono.error(new IllegalArgumentException("AppointmentId cannot be null"));
        }

        return appointmentRepository.findById(appointmentId)
                .switchIfEmpty(Mono.error(new RuntimeException("AppointmentId not found")))
                .then();
    }
}

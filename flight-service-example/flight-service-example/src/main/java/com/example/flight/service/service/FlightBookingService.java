package com.example.flight.service.service;

import com.example.flight.service.dto.FlightBookingAcknowledge;
import com.example.flight.service.dto.FlightBookingRequest;
import com.example.flight.service.entity.PassengerInfo;
import com.example.flight.service.entity.PaymentInfo;
import com.example.flight.service.repo.PassengerInfoRepository;
import com.example.flight.service.repo.PaymentInfoRepository;
import com.example.flight.service.util.PaymentUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepo;

    @Autowired
    private PaymentInfoRepository paymentInfoRepo;
    public FlightBookingAcknowledge bookFlight(FlightBookingRequest request){
        FlightBookingAcknowledge response = null;
        PassengerInfo passengerInfoRequest = request.getPassengerInfo();
        passengerInfoRequest=passengerInfoRepo.save(passengerInfoRequest);

        PaymentInfo paymentInfo = request.getPaymentInfo();


        PaymentUtil.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfoRequest.getFare());
         paymentInfo.setPassengerId( passengerInfoRequest.getPassengerId());
        paymentInfo.setAmount(passengerInfoRequest.getFare());
        paymentInfoRepo.save(paymentInfo);
        return new FlightBookingAcknowledge("SUCCESS",passengerInfoRequest.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfoRequest);


    }
}

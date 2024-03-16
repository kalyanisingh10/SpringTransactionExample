package com.example.flight.service.repo;

import com.example.flight.service.entity.PassengerInfo;
import com.example.flight.service.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String > {
}

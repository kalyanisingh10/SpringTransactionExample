package com.example.flight.service;

import com.example.flight.service.dto.FlightBookingAcknowledge;
import com.example.flight.service.dto.FlightBookingRequest;
import com.example.flight.service.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {


	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/book-flight-ticket")
	public FlightBookingAcknowledge bookFlight(@RequestBody FlightBookingRequest bookingRequest){
		return flightBookingService.bookFlight(bookingRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}

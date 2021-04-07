package com.devrezaur.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.Payment;
import com.devrezaur.main.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	public Payment pay(Payment payment) {
		return paymentRepo.save(payment);
	}
}

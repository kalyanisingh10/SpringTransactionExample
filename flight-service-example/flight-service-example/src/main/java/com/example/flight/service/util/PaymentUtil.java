package com.example.flight.service.util;

import com.example.flight.service.exception.TransactionFailException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtil {

    private static final Map<String,Double> paymentDetails= new HashMap<>();

    static {
        paymentDetails.put("acc1", 12000.0);
        paymentDetails.put("acc2", 13000.0);
        paymentDetails.put("acc3", 14000.0);
        paymentDetails.put("acc4", 15000.0);

    }

    public static boolean validateCreditLimit(String accNo, double paidAmount){
        System.out.println(paymentDetails.get(accNo));
        if(paidAmount > paymentDetails.get(accNo)){
           throw new TransactionFailException("Insufficient balanace");
        }else{
          return true;
        }

    }
}

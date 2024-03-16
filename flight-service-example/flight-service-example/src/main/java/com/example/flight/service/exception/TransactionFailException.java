package com.example.flight.service.exception;

public class TransactionFailException extends RuntimeException{
    public TransactionFailException( String msg) {
        super(msg);

    }
}

package com.hossvel;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FraudService {

    public boolean check(TransferRequest request) {
        // Simula fraude si el monto es mayor a 5000
        return request.amount > 5000;
    }
}


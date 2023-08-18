package com.example.voltix.CircuitBreakers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CircuitBreakerRepository extends MongoRepository<CircuitBreakerModel, String> {
    public java.util.Optional<CircuitBreakerModel> findById(String id);

    CircuitBreakerModel findByCircuitBreakerName(String circuitBreakerName);
}

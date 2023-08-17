package com.example.voltix.Alerte;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlerteRepository extends MongoRepository<AlerteModel, String> {
    // List<AlerteModel> findByCircuitBreaker_Id(String circuitBreakerId);

}

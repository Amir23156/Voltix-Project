package com.example.voltix.Alerte;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlerteRepository extends MongoRepository<AlerteModel, String> {
    // List<AlerteModel> findByCircuitBreaker_Id(String circuitBreakerId);
    List<AlerteModel> findByViewedAndCause_Id(boolean viewed, String causeId);

    long countByViewedFalse();

}

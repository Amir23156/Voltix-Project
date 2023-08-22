package com.example.voltix.ZoneConsomationHistory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneConsomationRepository extends MongoRepository<ZoneConsomationModel, String> {
    List<ZoneConsomationModel> findByZone_Id(String circuitBreakerId);

}

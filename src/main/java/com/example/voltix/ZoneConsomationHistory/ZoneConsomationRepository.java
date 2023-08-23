package com.example.voltix.ZoneConsomationHistory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.voltix.Zones.ZoneModel;

public interface ZoneConsomationRepository extends MongoRepository<ZoneConsomationModel, String> {
    List<ZoneConsomationModel> findByZoneIdOrderByDateAsc(String zoneId);

}

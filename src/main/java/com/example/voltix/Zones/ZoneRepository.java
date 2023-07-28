package com.example.voltix.Zones;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ZoneRepository extends MongoRepository<ZoneModel,Integer> {
    public java.util.Optional<ZoneModel> findById(String id);
    ZoneModel findByZoneName(String zoneName);
}

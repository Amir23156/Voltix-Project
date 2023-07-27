package com.example.voltix.Zones;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ZoneRepository extends MongoRepository<ZoneModel,Integer> {
    
}

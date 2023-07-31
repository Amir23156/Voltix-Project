package com.example.voltix.Machine;

import com.example.voltix.Zones.ZoneModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineRepository extends MongoRepository<ZoneModel,Integer> {

}

package com.example.voltix.Zones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    public ZoneModel addZone(ZoneModel zone) {
        return zoneRepository.save(zone);
    }


    
     public List<ZoneModel> findAll(){
     return zoneRepository.findAll();
     }
    


    public ZoneModel findZoneByName(String zoneName) {
        return zoneRepository.findByZoneName(zoneName);
    }

    public List<ZoneModel> getZonesByBuildings(String id) {
        System.out.println("im here ");
        // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
        System.out.println("im here ");

        return zoneRepository.findByBuilding_Id(id);
    }

    public void deleteZoneById(String id) {
        Optional<ZoneModel> zoneOptional = zoneRepository.findById(id);
        if (zoneOptional.isPresent()) {
            ZoneModel zone = zoneOptional.get();
            zoneRepository.delete(zone);
        } else {
            // Handle the case when the zone with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate
            // action.
        }
    }

    public ZoneModel findZoneById(String zoneId) {
        return zoneRepository.findById(zoneId).orElse(null);
    }

}
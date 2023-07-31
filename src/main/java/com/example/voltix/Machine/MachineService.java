package com.example.voltix.Machine;

import com.example.voltix.Zones.ZoneModel;
import com.example.voltix.Zones.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MachineService {
    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }
    public MachineModel CreateMachine(MachineModel machine)
    {return machineRepository.save(machine) ;}

    public List<ZoneModel> findAll(){
        return zoneRepository.findAll();
    }

    public ZoneModel findZoneByName(String zoneName) {
        return zoneRepository.findByZoneName(zoneName);
    }

    public void deleteZoneById(String id) {
        Optional<ZoneModel> zoneOptional = zoneRepository.findById(id);
        if (zoneOptional.isPresent()) {
            ZoneModel zone = zoneOptional.get();
            zoneRepository.delete(zone);
        } else {
            // Handle the case when the zone with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
        }
    }

    public ZoneModel findZoneById(String zoneId) {
        return zoneRepository.findById(zoneId).orElse(null);
    }


}

package com.example.voltix.ZoneConsomationHistory;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.Machine.MachineModel;
import com.example.voltix.Zones.*;

import com.example.voltix.Machine.MachineRepository;
import com.example.voltix.Zones.ZoneModel;
import com.example.voltix.Zones.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneConsomationService {
    private final ZoneConsomationRepository zoneConsomationRepository;
    private final ZoneRepository zoneRepository;
    private final CircuitBreakerRepository circuitBreakerRepository;
    private final MachineRepository machineRepository;

    @Autowired
    public ZoneConsomationService(MachineRepository machineRepository,
            CircuitBreakerRepository circuitBreakerRepository, ZoneRepository zoneRepository,
            ZoneConsomationRepository zoneConsomationRepository) {
        this.zoneConsomationRepository = zoneConsomationRepository;
        this.machineRepository = machineRepository;
        this.zoneRepository = zoneRepository;
        this.circuitBreakerRepository = circuitBreakerRepository;
    }

    public ZoneConsomationModel CreateZoneConsomation(ZoneConsomationModel zoneConsomationModel) {
        return zoneConsomationRepository.save(zoneConsomationModel);
    }

    public List<ZoneConsomationModel> findAll() {
        return zoneConsomationRepository.findAll();
    }

    public void deleteZoneConsomationById(String id) {
        zoneConsomationRepository.deleteById(id);
    }

    public void updatZoneConsomation(ZoneConsomationModel zoneConsomation) {
        zoneConsomationRepository.save(zoneConsomation);
    }

    public ZoneConsomationModel findById(String id) {
        System.out.println("id");
        System.out.println("salem" + id);

        return zoneConsomationRepository.findById(id).orElse(null);
    }

    public List<ZoneConsomationModel> getConsomatopForZone(String id) {
        System.out.println("im here ");
        List<ZoneConsomationModel> liste = new ArrayList<>();

        // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
        System.out.println("im here ");
        List<ZoneConsomationModel> zoneConsomation = zoneConsomationRepository.findByZone_Id(id);
        return zoneConsomation;
    }

}

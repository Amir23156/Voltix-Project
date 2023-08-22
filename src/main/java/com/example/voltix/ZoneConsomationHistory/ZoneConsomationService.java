package com.example.voltix.ZoneConsomationHistory;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.Machine.MachineModel;
import com.example.voltix.Zones.*;

import com.example.voltix.Machine.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneConsomationService {
    private final ZoneConsomationRepository zoneConsomationRepository;
    private final ZoneService zoneService;
    private final MachineRepository machineRepository;
    private final CircuitBreakerRepository circuitBreakerRepository;

    @Autowired
    public ZoneConsomationService(MachineRepository machineRepository,
            CircuitBreakerRepository circuitBreakerRepository, ZoneRepository zoneRepository,
            ZoneConsomationRepository zoneConsomationRepository, ZoneService zoneService) {
        this.zoneConsomationRepository = zoneConsomationRepository;
        this.machineRepository = machineRepository;
        this.zoneService = zoneService;
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

   /* public List<ZoneConsomationModel> getMostConsumedZone() {
        System.out.println("im here ");

        List<ZoneModel> zoneListe = zoneService.findAll();
        ZoneModel MostsZoneConsumed = zoneListe.get(0);
        double Consumption = 0;
        // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
        for (ZoneModel zoneModel : zoneListe) {
            List<ZoneConsomationModel> zoneConsomation = zoneConsomationRepository.findByZone_Id(zoneModel.getId());
            double totalConsumpt = zoneConsomation.stream()
                    .mapToDouble(ZoneConsomationModel::getConsomation)
                    .sum();
            if (totalConsumpt > Consumption) {
                MostsZoneConsumed = zoneModel;
                Consumption = totalConsumpt;
            }
        }
        return zoneConsomation;

    }
    */
    
}

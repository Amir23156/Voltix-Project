package com.example.voltix.Machine;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.Zones.ZoneModel;
import com.example.voltix.Zones.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {
    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public MachineModel CreateMachine(MachineModel machine) {
        return machineRepository.save(machine);
    }

    public List<MachineModel> findAll() {
        return machineRepository.findAll();
    }

    public List<MachineModel> getMachinesByCircuitBreaker(String id) {
        System.out.println("im here ");
        // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
        System.out.println("im here ");

        return machineRepository.findByCircuitBreaker_Id(id);
    }

    public void deleteMachineById(String id) {
        machineRepository.deleteById(id);
    }

    public void updatMachine(MachineModel user) {
        machineRepository.save(user);
    }

    public MachineModel findById(String id) {
        System.out.println("id");
        System.out.println("salem" + id);
        return machineRepository.findById(id).orElse(null);
    }

}

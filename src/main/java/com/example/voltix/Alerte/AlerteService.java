package com.example.voltix.Alerte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.Machine.MachineModel;

@Service
public class AlerteService {
    private final AlerteRepository alerteRepository;
    private final CircuitBreakerRepository circuitBreakerRepository;

    @Autowired
    public AlerteService(AlerteRepository alerteRepository, CircuitBreakerRepository circuitBreakerRepository) {
        this.alerteRepository = alerteRepository;
        this.circuitBreakerRepository = circuitBreakerRepository;
    }

    public AlerteModel CreateAlerte(AlerteModel alerte) {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println(alerte);
        return alerteRepository.save(alerte);
    }

    public List<AlerteModel> findAll() {
        return alerteRepository.findAll();
    }

    /*
     * public List<AlerteModel> getMachinesByCircuitBreaker(String id) {
     * System.out.println("im here ");
     * // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
     * System.out.println("im here ");
     * 
     * return alerteRepository.findByCircuitBreaker_Id(id);
     * }
     */
    public void deleteMachineById(String id) {
        alerteRepository.deleteById(id);
    }

    public void updatMachine(AlerteModel user) {
        alerteRepository.save(user);
    }

    public AlerteModel findById(String id) {
        System.out.println("id");
        System.out.println("salem" + id);
        return alerteRepository.findById(id).orElse(null);
    }

}

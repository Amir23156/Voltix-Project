package com.example.voltix.Alerte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.Machine.MachineModel;
import com.example.voltix.Machine.MachineRepository;

@Service
public class ConsumptionMonitoringService {

    @Autowired
    private MachineRepository machineRepository; // Inject your machine repository
    @Autowired
    private CircuitBreakerRepository circuitBreakerRepository; // Inject your circuit breaker repository
    @Autowired
    private AlerteService alerteService; // Inject your alert service

    @Scheduled(fixedRate = 6000) // Run every minute, adjust as needed
    public void monitorConsumptionAndCreateAlerts() {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhaaaaaaaaaaa");
        List<CircuitBreakerModel> circuitBreakers = circuitBreakerRepository.findAll();

        for (CircuitBreakerModel circuitBreaker : circuitBreakers) {
            double totalConsumption = calculateTotalConsumption(circuitBreaker);

            if (circuitBreaker.getLimitConsomation() != 0) {
                if (totalConsumption > circuitBreaker.getLimitConsomation()) {
                    // Create an alert
                    AlerteModel alerte = new AlerteModel();
                    alerte.setContent(
                            "Consumption limit exceeded for circuit breaker " + circuitBreaker.getCircuitBreakerName());
                    alerte.setType("Consumption");
                    alerte.setCause(circuitBreaker);

                    alerteService.CreateAlerte(alerte);
                }
            }
        }
    }

    private double calculateTotalConsumption(CircuitBreakerModel circuitBreaker) {
        double totalConsumption = 0.0;
        List<MachineModel> machines = machineRepository.findByCircuitBreaker_Id(circuitBreaker.getId());

        for (MachineModel machine : machines) {

            totalConsumption += machine.getConsomation();
        }
        System.out.println("zzzzzzzzzzz");
        System.out.println(totalConsumption);
        return totalConsumption;
    }

}

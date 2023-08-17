package com.example.voltix.Alerte;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.CircuitBreakers.CircuitBreakerService;
import com.example.voltix.Zones.ZoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Alerte")
public class AlerteController {
    @Autowired

    private final AlerteService alerteService;

    @Autowired
    public AlerteController(AlerteService alerteService) {

        this.alerteService = alerteService;

    }

    /*
     * @GetMapping("/getMachinesForCircuitBreaker/{id}")
     * 
     * public ResponseEntity<List<AlerteModel>>
     * getMachinesByCircuitBreaker(@PathVariable String id) {
     * System.out.println("iiiiiiiiiiiii");
     * System.out.println("zzzzzzzzzzzz");
     * // CircuitBreakerModel
     * // circuitBreaker=circuitBreakerService.findCircuitBreakerById(id);
     * List<MachineModel> machines = machineService.getMachinesByCircuitBreaker(id);
     * 
     * // List<MachineModel> students =
     * // machineService.getMachineofCircuitBreaker(circuitBreaker);
     * System.out.println("zzzzzzzzzzzz");
     * System.out.println(machines);
     * 
     * return ResponseEntity.ok(machines);
     * 
     * }
     */

    @GetMapping
    public List<AlerteModel> getAllAlerte() {
        return alerteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMachineById(@PathVariable String id) {
        AlerteModel alerte = alerteService.findById(id);
        if (alerte != null) {
            return ResponseEntity.ok(alerte);
        } else {
            String errorMessage = "Alerte with id '" + id + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<AlerteModel> createMachine(@RequestBody AlerteModel alerte) {
        AlerteModel createdUser = alerteService.CreateAlerte(alerte);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> updateMachine(@PathVariable String id, @RequestBody AlerteModel alerte) {

        AlerteModel existingMachine = alerteService.findById(alerte.getId());

        if (existingMachine != null) {
            System.out.println("zzzzzzzzz");
            System.out.println(existingMachine);
            System.out.println(alerte);

            alerte.setId(alerte.getId());
            alerteService.updatMachine(alerte);
            System.out.println("zzzzzzzzz");
            System.out.println(alerte);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable String id) {
        alerteService.deleteMachineById(id);
        return ResponseEntity.noContent().build();
    }
}

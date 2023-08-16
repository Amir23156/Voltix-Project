package com.example.voltix.Machine;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.Zones.ZoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public List<MachineModel> getAllMachine() {
        return machineService.findAll();
    }
    @GetMapping("/getForId/{id}")
    public List<MachineModel> getMachineOfCircuitBreaker() {
        return machineService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMachineById(@PathVariable String id) {
        MachineModel machine = machineService.findZoneById(id);
        if (machine != null) {
            return ResponseEntity.ok(machine);
        } else {
            String errorMessage = "machine with id '" + id + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<MachineModel> createMachine(@RequestBody MachineModel machine) {
        MachineModel createdUser = machineService.CreateMachine(machine);
        System.out.println("deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                System.out.println(createdUser);
                System.out.println(createdUser.getCircuitBreaker());

      CircuitBreakerModel circuitB=  createdUser.getCircuitBreaker();
      try{
circuitB.getMachinesListe().add(createdUser)  ;   }
catch(Exception e) {
System.out.println("geeee");
}
    //circuit.getMachinesListe().add( createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(machine);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> updateMachine(@PathVariable String id, @RequestBody MachineModel machine) {

        MachineModel existingMachine = machineService.findZoneById(machine.getId());

        if (existingMachine != null) {
            System.out.println("zzzzzzzzz");
            System.out.println(existingMachine);
            System.out.println(machine);

            machine.setId(machine.getId());
            machineService.updatMachine(machine);
            System.out.println("zzzzzzzzz");
            System.out.println(machine);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable String id) {
        machineService.deleteMachineById(id);
        return ResponseEntity.noContent().build();
    }
}

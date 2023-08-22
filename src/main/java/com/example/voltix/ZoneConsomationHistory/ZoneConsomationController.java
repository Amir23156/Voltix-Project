package com.example.voltix.ZoneConsomationHistory;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.CircuitBreakers.CircuitBreakerRepository;
import com.example.voltix.CircuitBreakers.CircuitBreakerService;
import com.example.voltix.Machine.MachineModel;
import com.example.voltix.Machine.MachineService;
import com.example.voltix.Zones.ZoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zoneConsomation")
public class ZoneConsomationController {
    @Autowired

    private final ZoneConsomationService zoneConsomationService;
       @Autowired
    private final MachineService machineService;

    @Autowired
    public ZoneConsomationController(MachineService machineService, ZoneConsomationService zoneConsomationService) {

        this.zoneConsomationService = zoneConsomationService;
        this.machineService = machineService;
    }

    @GetMapping("/getZoneConsomation/{id}")

    public ResponseEntity<List<ZoneConsomationModel>> getZoneConsomation(@PathVariable String id) {

        List<ZoneConsomationModel> zoneConsomations = zoneConsomationService.getConsomatopForZone(id);

        return ResponseEntity.ok(zoneConsomations);

    }

    @GetMapping
    public List<ZoneConsomationModel> getAllMachine() {
        return zoneConsomationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsomationById(@PathVariable String id) {
        ZoneConsomationModel machine = zoneConsomationService.findById(id);
        if (machine != null) {
            return ResponseEntity.ok(machine);
        } else {
            String errorMessage = "machine with id '" + id + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<MachineModel> createMachine(@RequestBody ZoneConsomationModel zoneConsomationModel) {
        ZoneConsomationModel zoneConsomation = zoneConsomationService.CreateZoneConsomation(zoneConsomationModel);

        return ResponseEntity.ok().build();
    }

}

package com.example.voltix.Zones;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class ZoneController {

    private final ZoneService zoneService;
    @Autowired
    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @PostMapping("/AddZone")
    public ResponseEntity<ZoneModel> addZone(@RequestBody ZoneModel zone) {

       return new ResponseEntity<ZoneModel>(zoneService.addZone(zone), HttpStatus.ACCEPTED);
    }

  /*  @GetMapping("/FindAllZones")
    public ResponseEntity<List<ZoneModel>> findAll() {
       return new ResponseEntity<List<ZoneModel>>(zoneService.findAll(), HttpStatus.ACCEPTED);
    }  */
    @GetMapping("/FindAllZonesForBuilding/{buildingId}")
    public ResponseEntity<List<ZoneModel>> findAllZonesForBuilding(@PathVariable String buildingId) {
        List<ZoneModel> zones = zoneService.findAllZonesForBuilding(buildingId);
        return new ResponseEntity<>(zones, HttpStatus.ACCEPTED);
}


    @GetMapping("/FindZoneByName/{zoneName}")
    public ResponseEntity<?> findZoneByName(@PathVariable String zoneName) {
        ZoneModel zone = zoneService.findZoneByName(zoneName);
        if (zone != null) {
            return ResponseEntity.ok(zone);
        } else {
            String errorMessage = "Zone with name '" + zoneName + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/DeleteZone/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        zoneService.deleteZoneById(id);
        return new ResponseEntity<>("Zone with ID " + id + " deleted", HttpStatus.OK);
    }
    
    @PutMapping("/UpdateZone/{id}")
    public ResponseEntity<ZoneModel> updateZone(@PathVariable String id, @RequestBody ZoneModel updatedZone) {
       ZoneModel existingZone = zoneService.findZoneById(id);
       if (existingZone != null) {
                // Effectuer ici les mises à jour nécessaires sur l'objet existingZone en utilisant les setters appropriés de la classe ZoneModel
             existingZone.setZoneName(updatedZone.getZoneName());
             existingZone.setZoneSurface(updatedZone.getZoneSurface());
             existingZone.setZoneMainActivity(updatedZone.getZoneMainActivity());
             existingZone.setAttendanceDays(updatedZone.getAttendanceDays());
             existingZone.setWorkStartTime(updatedZone.getWorkStartTime());
             existingZone.setWorkEndTime(updatedZone.getWorkEndTime());
                // Ajouter d'autres mises à jour pour les autres propriétés de ZoneModel si nécessaire
    
             ZoneModel savedZone = zoneService.addZone(existingZone);
             return new ResponseEntity<>(savedZone, HttpStatus.OK);
       } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
     }
}
    


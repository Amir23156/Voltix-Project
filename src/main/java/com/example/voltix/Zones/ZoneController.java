package com.example.voltix.Zones;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class ZoneController {
    @Autowired

    private ZoneService zoneService;
    @RequestMapping("/api/AddOrUpdateZone")
    @PostMapping
    public ResponseEntity<ZoneModel> saveOrUpdate(@RequestBody ZoneModel zone) {
       return new ResponseEntity<ZoneModel>(zoneService.saveOrUpdate(zone), HttpStatus.ACCEPTED);
    }

    @RequestMapping("/api/FindAllZones")
    @GetMapping
    public ResponseEntity<List<ZoneModel>> findAll() {
       return new ResponseEntity<List<ZoneModel>>(zoneService.findAll(), HttpStatus.ACCEPTED);
    } 

    @RequestMapping("/api/DeleteZone")
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody ZoneModel zone) {
        zoneService.delete(zone);
        return new ResponseEntity<>("Zone deleted", HttpStatus.ACCEPTED);
}

    

    
}



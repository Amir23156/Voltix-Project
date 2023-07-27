package com.example.voltix.Zones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

        public ZoneModel saveOrUpdate(ZoneModel zone){
            return zoneRepository.save(zone);
        }

        public List<ZoneModel> findAll(){
            return zoneRepository.findAll();
        }

        public void delete(ZoneModel zone) {
            zoneRepository.delete(zone);
        }







}
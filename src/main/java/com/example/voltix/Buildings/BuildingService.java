package com.example.voltix.Buildings;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingModel addBuilding(BuildingModel building) {
        return buildingRepository.save(building);
    }

    public List<BuildingModel> findAll() {
        return buildingRepository.findAll();
    }

    public BuildingModel findBuildingByName(String buildingName) {
        return buildingRepository.findByBuildingName(buildingName);
    }

    public void deleteBuildingById(String id) {
        Optional<BuildingModel> buildingOptional = buildingRepository.findById(id);
        if (buildingOptional.isPresent()) {
            BuildingModel building = buildingOptional.get();
            buildingRepository.delete(building);
        } else {
            // Handle the case when the building with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate
            // action.
        }
    }

    public BuildingModel findBuildingById(String buildingId) {
        return buildingRepository.findById(buildingId).orElse(null);
    }

}
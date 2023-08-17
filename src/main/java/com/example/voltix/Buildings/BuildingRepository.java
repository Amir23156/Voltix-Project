package com.example.voltix.Buildings;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface BuildingRepository extends MongoRepository<BuildingModel,Integer> {
    public java.util.Optional<BuildingModel> findById(String id);
    BuildingModel findByBuildingName(String buildingName);
}

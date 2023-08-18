package com.example.voltix.Buildings;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.voltix.Zones.ZoneModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "buildings")
public class BuildingModel {
    @Id
    private String id;
    private String buildingName;
    private String buildingLocation;
   
    private List<ZoneModel> zones;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation;
    } 
       
    public List<ZoneModel> getZones() {
        return zones;
    }

    public void setZones(List<ZoneModel> zones) {
        this.zones = zones;
    }
}
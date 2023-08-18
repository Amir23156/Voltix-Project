package com.example.voltix.Buildings;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.voltix.CircuitBreakers.CircuitBreakerModel;
import com.example.voltix.Sites.SiteModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Document(collection = "buildings")
public class BuildingModel {
    @Id
    private String id;
    private String buildingName;
    private String buildingLocation;
    @DBRef
    private SiteModel circuitBreaker;
}
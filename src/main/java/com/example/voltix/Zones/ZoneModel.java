package com.example.voltix.Zones;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "zones")
public class ZoneModel {
    @Id
    private String id;
    private String name;

}
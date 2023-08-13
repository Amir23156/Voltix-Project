package com.example.voltix.Machine;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Machines")
public class MachineModel {
    @Id
    private String id;
    private String name;
    private String type;
    private double consomation;
    private String imageLink;
    private String marque;

}

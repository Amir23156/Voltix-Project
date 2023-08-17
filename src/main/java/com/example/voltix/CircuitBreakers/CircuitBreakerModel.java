package com.example.voltix.CircuitBreakers;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.voltix.Machine.MachineModel;
import lombok.Data;

@Data
@Document(collection = "circuitBreakers")
public class CircuitBreakerModel {
    @Id
    private String id;
    private String circuitBreakerName;
    private String circuitBreakerRefrence;
    private double LimitConsomation;

}

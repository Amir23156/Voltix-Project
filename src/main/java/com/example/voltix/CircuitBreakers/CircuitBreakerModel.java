package com.example.voltix.CircuitBreakers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "circuitbreakers")
public class CircuitBreakerModel {
    @Id
    private String id;
    private String circuitbreakerName;
    private long circuitbreakerRefrence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcircuitbreakerName() {
        return circuitbreakerName;
    }

    public void setcircuitbreakerName(String circuitbreakerName) {
        this.circuitbreakerName = circuitbreakerName;
    }
    public long getcircuitbreakerRefrence() {
        return circuitbreakerRefrence;
    }

    public void setcircuitbreakerRefrence(long circuitbreakerRefrence) {
        this.circuitbreakerRefrence = circuitbreakerRefrence;
    }


    
}

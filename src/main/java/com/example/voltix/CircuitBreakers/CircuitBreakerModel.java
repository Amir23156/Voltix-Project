package com.example.voltix.CircuitBreakers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "circuitBreakers")
public class CircuitBreakerModel {
    @Id
    private String id;
    private String circuitBreakerName;
    private long circuitBreakerRefrence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcircuitBreakerName() {
        return circuitBreakerName;
    }

    public void setcircuitBreakerName(String circuitBreakerName) {
        this.circuitBreakerName = circuitBreakerName;
    }
    public long getcircuitBreakerRefrence() {
        return circuitBreakerRefrence;
    }

    public void setcircuitBreakerRefrence(long circuitBreakerRefrence) {
        this.circuitBreakerRefrence = circuitBreakerRefrence;
    }


    
}

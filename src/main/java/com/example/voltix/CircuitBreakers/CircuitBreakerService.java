package com.example.voltix.CircuitBreakers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.voltix.Machine.MachineModel;

@Service
public class CircuitBreakerService {
    @Autowired
    private CircuitBreakerRepository circuitBreakerRepository;

    public CircuitBreakerModel addCircuitBreaker(CircuitBreakerModel circuitbreaker) {
        return circuitBreakerRepository.save(circuitbreaker);
    }

    public List<CircuitBreakerModel> findAll() {
        return circuitBreakerRepository.findAll();
    }

    public CircuitBreakerModel findCircuitBreakerByName(String circuitBreakerName) {
        return circuitBreakerRepository.findByCircuitBreakerName(circuitBreakerName);
    }

    public void deleteCircuitBreakerById(String id) {
        Optional<CircuitBreakerModel> circuitBreakerOptional = circuitBreakerRepository.findById(id);
        if (circuitBreakerOptional.isPresent()) {
            CircuitBreakerModel circuitBreaker = circuitBreakerOptional.get();
            circuitBreakerRepository.delete(circuitBreaker);
        } else {
            // Handle the case when the zone with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate
            // action.
        }
    }

    public CircuitBreakerModel updateCircuitBreaker(String id, CircuitBreakerModel updatedcircuitBreaker) {
        CircuitBreakerModel result = new CircuitBreakerModel();
        try {
            System.out.println("im heeeeeerrrrrrrrrrrrrrr");
            System.out.println(updatedcircuitBreaker.getId());
            System.out.println(updatedcircuitBreaker.toString());
            result = circuitBreakerRepository.save(updatedcircuitBreaker);
            System.out.println(id);
            System.out.println(result);
        } catch (StackOverflowError e) {
            System.out.println("ssssssssssssssssssssssssssssssss");
            System.out.println(e);
        }
        // System.out.println(updatedcircuitBreaker);
        return result;
    }

    public CircuitBreakerModel findCircuitBreakerById(String Id) {
        return circuitBreakerRepository.findById(Id).orElse(null);
    }

}

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
    public CircuitBreakerModel addCircuitBreaker(CircuitBreakerModel circuitbreaker){
           return circuitBreakerRepository.save(circuitbreaker);
    }
    public List<CircuitBreakerModel> findAll(){
           return circuitBreakerRepository.findAll();
    }
    public List<MachineModel> getMachinesoFcircuitBreaker(@PathVariable String classroomId) {
        CircuitBreakerModel circuitBreaker = circuitBreakerRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
                                System.out.println(circuitBreaker);

        return circuitBreaker.getMachinesListe();
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
                // You can throw an exception, log a message, or take any other appropriate action.
        }
    }


    
    public CircuitBreakerModel updateCircuitBreaker(String id , CircuitBreakerModel updatedcircuitBreaker) {
        return circuitBreakerRepository.save(updatedcircuitBreaker);
    }
    
    public CircuitBreakerModel findCircuitBreakerById(String Id) {
        return circuitBreakerRepository.findById(Id).orElse(null);
    }
    
}

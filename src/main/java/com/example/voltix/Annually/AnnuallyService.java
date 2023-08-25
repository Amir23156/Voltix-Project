package com.example.voltix.Annually;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnuallyService {

    @Autowired
    private AnnuallyRepository annuallyRepository;


    
     public List<AnnuallyModel> findAll(){
     return annuallyRepository.findAll();
     }
    

    public List<AnnuallyModel> getAnnuallysByZones(String id) {
        System.out.println("im here ");
        // System.out.println(machineRepository.findByCircuitBreaker_Id(id));
        System.out.println("im here ");

        return annuallyRepository.findByZone_Id(id);
    }


    public AnnuallyModel findAnnuallyById(String annuallyId) {
        return annuallyRepository.findById(annuallyId).orElse(null);
    }


    public AnnuallyModel addAnnually(AnnuallyModel annually) {
        return annuallyRepository.save(annually);
    }
}
package com.example.voltix.Monthly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.voltix.Zones.ZoneModel;
import lombok.Data;

@Data
@Document(collection = "Monthly")
public class MonthlyModel {
    @Id
    private String id;
    private List<String> hours = new ArrayList<>(); // Initialized hours list
    private List<Double> values = new ArrayList<>(); // List of double values
    @DBRef
    private ZoneModel zone;

        // Constructor
    public MonthlyModel() {
        hours.add("January");
        hours.add("February");
        hours.add("March");
        hours.add("April");
        hours.add("May");
        hours.add("June");
        hours.add("July");
        hours.add("August");
        hours.add("September");
        hours.add("October");
        hours.add("November");
        hours.add("December");

        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            double randomValue = roundToTwoDecimals(1 + random.nextDouble() * 99); // Generate a random value between 0 and 100
            values.add(randomValue); // Add the value to the list
        }
        
    }
    
      // Method to round a double to two decimal places
      private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
   
}

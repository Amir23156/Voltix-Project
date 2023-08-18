package com.example.voltix.Zones;


import java.util.List;

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
    private String zoneName;
    private String zoneSurface;
    private String zoneMainActivity;
    private List<String> attendanceDays;
    private String workStartTime; 
    private String workEndTime; 
    private String buildingId;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneSurface() {
        return zoneSurface;
    }

    public void setZoneSurface(String zoneSurface) {
        this.zoneSurface = zoneSurface;
    } 
    
        public String getZoneMainActivity() {
        return zoneMainActivity;
    }

    public void setZoneMainActivity(String zoneMainActivity) {
        this.zoneMainActivity = zoneMainActivity;
    } 

    public List<String> getAttendanceDays() {
        return attendanceDays;
    }
    
    public void setAttendanceDays(List<String> attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }
    
}
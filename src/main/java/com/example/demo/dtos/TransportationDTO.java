package com.example.demo.dtos;

import com.example.demo.enums.TransportationType;
import com.example.demo.models.Transportation;

public class TransportationDTO {
    private Long id; // Optional for responses
    private LocationDTO originLocation; // Full Location for responses
    private LocationDTO destinationLocation; // Full Location for responses
    private TransportationType transportationType;
    private TransportationOperatingDaysDTO operatingDays; // Embedded operating days

    public TransportationDTO() {
    }

    public TransportationDTO(Long id, LocationDTO originLocation, LocationDTO destinationLocation, TransportationType transportationType, TransportationOperatingDaysDTO operatingDays) {
        this.id = id;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.transportationType = transportationType;
        this.operatingDays = operatingDays;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationDTO getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(LocationDTO originLocation) {
        this.originLocation = originLocation;
    }

    public LocationDTO getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(LocationDTO destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public TransportationType getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    public TransportationOperatingDaysDTO getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(TransportationOperatingDaysDTO operatingDays) {
        this.operatingDays = operatingDays;
    }
}

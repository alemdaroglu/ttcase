package com.example.demo.dtos;

import com.example.demo.dtos.TransportationOperatingDaysDTO;
import com.example.demo.enums.TransportationType;

public class TransportationCreateDTO {
    private Long originLocationId;
    private Long destinationLocationId;
    private TransportationType transportationType;
    private TransportationOperatingDaysDTO operatingDays;

    public TransportationCreateDTO() {}

    public TransportationCreateDTO(Long originLocationId, Long destinationLocationId, TransportationType transportationType, TransportationOperatingDaysDTO operatingDays) {
        this.originLocationId = originLocationId;
        this.destinationLocationId = destinationLocationId;
        this.transportationType = transportationType;
        this.operatingDays = operatingDays;
    }

    public Long getOriginLocationId() {
        return originLocationId;
    }

    public void setOriginLocationId(Long originLocationId) {
        this.originLocationId = originLocationId;
    }

    public Long getDestinationLocationId() {
        return destinationLocationId;
    }

    public void setDestinationLocationId(Long destinationLocationId) {
        this.destinationLocationId = destinationLocationId;
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

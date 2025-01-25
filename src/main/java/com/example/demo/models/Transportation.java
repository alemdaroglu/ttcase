package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Transportation {

    private @Id
    @GeneratedValue Long id;
    private String originLocation;
    private String destinationLocation;
    private String transportationType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private TransportationOperatingDays operatingDays;

    public Transportation() {

    }

    Transportation(String originLocation, String destinationLocation, String transportationType, TransportationOperatingDays operatingDays) {

        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.transportationType = transportationType;
        this.operatingDays = operatingDays;
    }


    public Long getId() {
        return this.id;
    }

    public String getOriginLocation() {
        return this.originLocation;
    }

    public String getDestinationLocation() {
        return this.destinationLocation;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOriginLocation(String name) {
        this.originLocation = name;
    }

    public void setDestinationLocation(String country) {
        this.destinationLocation = country;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }


    public TransportationOperatingDays getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(TransportationOperatingDays operatingDays) {
        this.operatingDays = operatingDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Transportation transportation))
            return false;
        return Objects.equals(this.id, transportation.id)
                && Objects.equals(this.originLocation, transportation.originLocation)
                && Objects.equals(this.destinationLocation, transportation.destinationLocation)
                && Objects.equals(this.transportationType, transportation.transportationType)&&
                Objects.equals(operatingDays, transportation.operatingDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.originLocation,
                this.destinationLocation,
                this.transportationType,
                operatingDays);
    }

    @Override
    public String toString() {
        return "Transportation{" + "id=" + this.id + '}';
    }
}
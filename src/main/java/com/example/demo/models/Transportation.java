package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Transportation {

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="origin_location_id", nullable=false)
    private Long originLocationId;
    @Column(name="destination_location_id", nullable=false)
    private Long destinationLocationId;
    @Column(name="transportation_type", nullable=false)
    private String transportationType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private TransportationOperatingDays operatingDays;

    public Transportation() {

    }

    Transportation(Long originLocationId, Long destinationLocationId, String transportationType,
                   TransportationOperatingDays operatingDays) {

        this.originLocationId = originLocationId;
        this.destinationLocationId = destinationLocationId;
        this.transportationType = transportationType;
        this.operatingDays = operatingDays;
    }


    public Long getId() {
        return this.id;
    }

    public Long getOriginLocationId() {
        return this.originLocationId;
    }

    public Long getDestinationLocationId() {
        return this.destinationLocationId;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOriginLocationId(Long id) {
        this.originLocationId = id;
    }

    public void setDestinationLocationId(Long id) {
        this.destinationLocationId = id;
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
                && Objects.equals(this.originLocationId, transportation.originLocationId)
                && Objects.equals(this.destinationLocationId, transportation.destinationLocationId)
                && Objects.equals(this.transportationType, transportation.transportationType)&&
                Objects.equals(operatingDays, transportation.operatingDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.originLocationId,
                this.destinationLocationId,
                this.transportationType,
                operatingDays);
    }

    @Override
    public String toString() {
        return "Transportation{" + "id=" + this.id + '}';
    }
}
package com.example.demo.models;

import com.example.demo.dtos.TransportationDTO;
import com.example.demo.enums.TransportationType;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Transportation {

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "transportation_type", nullable = false)
    @Enumerated(EnumType.STRING) // This ensures the enum is stored as a string in the database
    private TransportationType transportationType;

    @OneToOne(mappedBy = "transportation", cascade = CascadeType.ALL, orphanRemoval = true)
    private TransportationOperatingDays operatingDays;

    @ManyToOne
    @JoinColumn(name = "origin_location_id", referencedColumnName = "id")
    private Location originLocation;

    @ManyToOne
    @JoinColumn(name = "destination_location_id", referencedColumnName = "id")
    private Location destinationLocation;

    public Transportation() {

    }

    public Transportation(
            Location originLocation,
            Location destinationLocation,
            TransportationType transportationType,
            TransportationOperatingDays operatingDays) {
        this.transportationType = transportationType;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.operatingDays = operatingDays;
    }


    public Long getId() {
        return this.id;
    }

    public Location getOriginLocation() {
        return this.originLocation;
    }

    public Location getDestinationLocation() {
        return this.destinationLocation;
    }


    public TransportationType getTransportationType() {
        return transportationType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOriginLocation(Location originLocation) {
        this.originLocation = originLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }


    public void setTransportationType(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    public TransportationOperatingDays getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(TransportationOperatingDays operatingDays) {
        if (operatingDays != null) {
            operatingDays.setTransportation(this);
        }
        this.operatingDays = operatingDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Transportation transportation))
            return false;
        return Objects.equals(this.id, transportation.id)
                && Objects.equals(this.transportationType, transportation.transportationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.transportationType);
    }

    @Override
    public String toString() {
        return "Transportation{" + "id=" + this.id + '}';
    }
}
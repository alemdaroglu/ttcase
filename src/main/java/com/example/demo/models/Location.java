package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Location {

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;
    @Column(name="country", nullable=false)
    private String country;
    @Column(name="city", nullable=false)
    private String city;
    @Column(name="location_code", nullable=false, unique=true)
    private String locationCode;

    public Location() {

    }

    Location(String name, String country, String city, String locationCode) {

        this.name = name;
        this.country = country;
        this.city = city;
        this.locationCode = locationCode;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return city;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Location location))
            return false;
        return Objects.equals(this.id, location.id)
                && Objects.equals(this.name, location.name)
                && Objects.equals(this.country, location.country)
                && Objects.equals(this.city, location.city)
                && Objects.equals(this.locationCode, location.locationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.country, this.city, this.locationCode);
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + this.id + '}';
    }
}
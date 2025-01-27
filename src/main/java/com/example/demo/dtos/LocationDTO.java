package com.example.demo.dtos;

import com.example.demo.models.Location;

public class LocationDTO {
    private Long id; // Optional for responses; can be null for creation
    private String name;
    private String country;
    private String city;
    private String locationCode;

    public LocationDTO() {
    }

    public LocationDTO(Long id, String name, String country, String city, String locationCode) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.locationCode = locationCode;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}

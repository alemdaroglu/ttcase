package com.example.demo.mappers;

import com.example.demo.dtos.TransportationCreateDTO;
import com.example.demo.models.Location;
import com.example.demo.models.Transportation;
import com.example.demo.models.TransportationOperatingDays;
import com.example.demo.repositories.LocationRepository;

public class TransportationCreateMapper {

    public static Transportation toEntity(TransportationCreateDTO transportationCreateDTO, LocationRepository locationRepository) {
        if (transportationCreateDTO == null) {
            return null;
        }

        // Create the Transportation entity
        Transportation transportation = new Transportation();

        // Set the origin and destination locations
        if (transportationCreateDTO.getOriginLocationId() != null) {
            Location originLocation = locationRepository.findById(transportationCreateDTO.getOriginLocationId())
                    .orElseThrow(() -> new IllegalArgumentException("Origin location not found for ID: " + transportationCreateDTO.getOriginLocationId()));
            transportation.setOriginLocation(originLocation);
        }

        if (transportationCreateDTO.getDestinationLocationId() != null) {
            Location destinationLocation = locationRepository.findById(transportationCreateDTO.getDestinationLocationId())
                    .orElseThrow(() -> new IllegalArgumentException("Destination location not found for ID: " + transportationCreateDTO.getDestinationLocationId()));
            transportation.setDestinationLocation(destinationLocation);
        }

        // Set the transportation type
        if (transportationCreateDTO.getTransportationType() != null) {
            transportation.setTransportationType(transportationCreateDTO.getTransportationType());
        }

        // Set the operating days
        if (transportationCreateDTO.getOperatingDays() != null) {
            TransportationOperatingDays operatingDays = TransportationOperatingDaysMapper.toEntity(transportationCreateDTO.getOperatingDays());

            // Set the transportation reference in the operating days
            operatingDays.setTransportation(transportation);

            // Set the operating days to the transportation
            transportation.setOperatingDays(operatingDays);
        }

        return transportation;
    }
}

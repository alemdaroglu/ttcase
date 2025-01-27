package com.example.demo.mappers;

import com.example.demo.dtos.LocationDTO;
import com.example.demo.dtos.TransportationDTO;
import com.example.demo.models.Location;
import com.example.demo.models.Transportation;

public class TransportationMapper {

    // Convert Transportation entity to TransportationDTO
    public static TransportationDTO toDto(Transportation transportation) {
        if (transportation == null) {
            return null;
        }
        return new TransportationDTO(
                transportation.getId(),
                LocationMapper.toDto(transportation.getOriginLocation()),
                LocationMapper.toDto(transportation.getDestinationLocation()),
                transportation.getTransportationType(),
                TransportationOperatingDaysMapper.toDto(transportation.getOperatingDays())
        );
    }

    // Convert TransportationDTO to Transportation entity
    public static Transportation toEntity(TransportationDTO transportationDTO) {
        if (transportationDTO == null) {
            return null;
        }
        return new Transportation(
                LocationMapper.toEntityWithId(transportationDTO.getOriginLocation()),
                LocationMapper.toEntityWithId(transportationDTO.getDestinationLocation()),
                transportationDTO.getTransportationType(),
                TransportationOperatingDaysMapper.toEntity(transportationDTO.getOperatingDays())
        );
    }

    // Convert TransportationDTO to Transportation entity (for update, with ID)
    public static Transportation toEntityWithId(TransportationDTO transportationDTO) {
        if (transportationDTO == null) {
            return null;
        }
        Transportation transportation = toEntity(transportationDTO);
        transportation.setId(transportationDTO.getId()); // Set ID explicitly for updates
        return transportation;
    }
}

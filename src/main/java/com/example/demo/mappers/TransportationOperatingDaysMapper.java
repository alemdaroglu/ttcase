package com.example.demo.mappers;

import com.example.demo.dtos.TransportationOperatingDaysDTO;
import com.example.demo.models.TransportationOperatingDays;

public class TransportationOperatingDaysMapper {

    // Convert TransportationOperatingDays entity to TransportationOperatingDaysDTO
    public static TransportationOperatingDaysDTO toDto(TransportationOperatingDays operatingDays) {
        if (operatingDays == null) {
            return null;
        }
        return new TransportationOperatingDaysDTO(
                operatingDays.getMonday(),
                operatingDays.getTuesday(),
                operatingDays.getWednesday(),
                operatingDays.getThursday(),
                operatingDays.getFriday(),
                operatingDays.getSaturday(),
                operatingDays.getSunday(),
                operatingDays.getTransportation()
        );
    }

    // Convert TransportationOperatingDaysDTO to TransportationOperatingDays entity
    public static TransportationOperatingDays toEntity(TransportationOperatingDaysDTO operatingDaysDTO) {
        if (operatingDaysDTO == null) {
            return null;
        }
        return new TransportationOperatingDays(
                operatingDaysDTO.getMonday(),
                operatingDaysDTO.getTuesday(),
                operatingDaysDTO.getWednesday(),
                operatingDaysDTO.getThursday(),
                operatingDaysDTO.getFriday(),
                operatingDaysDTO.getSaturday(),
                operatingDaysDTO.getSunday(),
                operatingDaysDTO.getTransportation()
        );
    }
}

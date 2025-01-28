package com.example.demo.controllers;

import com.example.demo.dtos.TransportationCreateDTO;
import com.example.demo.dtos.TransportationDTO;
import com.example.demo.dtos.TransportationOperatingDaysDTO;
import com.example.demo.mappers.TransportationMapper;
import com.example.demo.models.Location;
import com.example.demo.models.Transportation;
import com.example.demo.models.TransportationOperatingDays;
import com.example.demo.repositories.LocationRepository;
import com.example.demo.repositories.TransportationRepository;
import com.example.demo.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transportations")
public class TransportationController {

    private final TransportationRepository transportationRepository;
    private final LocationRepository locationRepository;

    public TransportationController(TransportationRepository transportationRepository,
                                    LocationRepository locationRepository) {
        this.transportationRepository = transportationRepository;
        this.locationRepository = locationRepository;
    }

    // Get all transportations
    @GetMapping
    public ResponseEntity<List<TransportationDTO>> getAllTransportations() {
        return ResponseEntity.ok(transportationRepository.findAll()
                .stream()
                .map(TransportationMapper::toDto)
                .collect(Collectors.toList()));
    }

    // Get a single transportation by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransportationDTO> getTransportationById(@PathVariable Long id) {
        return transportationRepository.findById(id)
                .map(TransportationMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new transportation
    @PostMapping
    public ResponseEntity<TransportationDTO> createTransportation(@Valid @RequestBody TransportationCreateDTO transportationCreateDTO) {
        Transportation transportation = TransportationMapper.toEntity(
                transportationCreateDTO,
                locationRepository);
        Transportation savedTransportation = transportationRepository.save(transportation);
        return ResponseEntity.status(201).body(TransportationMapper.toDto(savedTransportation));
    }

    // Update an existing transportation
    @PatchMapping("/{id}")
    public ResponseEntity<TransportationDTO> updateTransportation(
            @PathVariable Long id,
            @RequestBody TransportationCreateDTO updatedTransportation) {
        return transportationRepository.findById(id)
                .map(existingTransportation -> {
                    if (updatedTransportation.getOriginLocationId() != null) {
                        Location originLocation = locationRepository.findById(updatedTransportation.getOriginLocationId())
                                .orElseThrow(() -> new IllegalArgumentException("Origin location not found for ID: " + updatedTransportation.getOriginLocationId()));
                        existingTransportation.setOriginLocation(originLocation);
                    }
                    if (updatedTransportation.getDestinationLocationId() != null) {
                        Location destinationLocation = locationRepository.findById(updatedTransportation.getDestinationLocationId())
                                .orElseThrow(() -> new IllegalArgumentException("Destination location not found for ID: " + updatedTransportation.getDestinationLocationId()));
                        existingTransportation.setDestinationLocation(destinationLocation);
                    }
                    if (updatedTransportation.getTransportationType() != null) {
                        existingTransportation.setTransportationType(updatedTransportation.getTransportationType());
                    }
                    if (updatedTransportation.getOperatingDays() != null) {
                        TransportationOperatingDays existingOperatingDays = existingTransportation.getOperatingDays();
                        TransportationOperatingDaysDTO newOperatingDaysDTO = updatedTransportation.getOperatingDays();
                        Utils.updateIfNotNull(newOperatingDaysDTO.getMonday(), existingOperatingDays::setMonday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getTuesday(), existingOperatingDays::setTuesday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getWednesday(), existingOperatingDays::setWednesday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getThursday(), existingOperatingDays::setThursday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getFriday(), existingOperatingDays::setFriday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getSaturday(), existingOperatingDays::setSaturday);
                        Utils.updateIfNotNull(newOperatingDaysDTO.getSunday(), existingOperatingDays::setSunday);
                    }
                    Transportation savedTransportation = transportationRepository.save(existingTransportation);
                    return ResponseEntity.ok(TransportationMapper.toDto(savedTransportation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a transportation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportation(@PathVariable Long id) {
        if (transportationRepository.existsById(id)) {
            transportationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

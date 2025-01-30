package com.example.demo.controllers;

import com.example.demo.dtos.LocationCreateDTO;
import com.example.demo.dtos.LocationDTO;
import com.example.demo.mappers.LocationMapper;
import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/locations")
@PreAuthorize("hasRole('ADMIN')")
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // Get all locations
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENCY')")
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        return ResponseEntity.ok(locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDto)
                .collect(Collectors.toList()));
    }

    // Get a single location by ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id)
                .map(LocationMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new location
    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@Valid @RequestBody LocationCreateDTO locationCreateDTO) {
        Location savedLocation = locationRepository.save(LocationMapper.toEntity(locationCreateDTO));
        return ResponseEntity.status(201).body(LocationMapper.toDto(savedLocation));
    }

    // Update an existing location
    @PatchMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @RequestBody LocationDTO updatedLocation) {
        return locationRepository.findById(id)
                .map(existingLocation -> {
                    if (updatedLocation.getName() != null) {
                        existingLocation.setName(updatedLocation.getName());
                    }
                    if (updatedLocation.getCountry() != null) {
                        existingLocation.setCountry(updatedLocation.getCountry());
                    }
                    if (updatedLocation.getCity() != null) {
                        existingLocation.setCity(updatedLocation.getCity());
                    }
                    if (updatedLocation.getLocationCode() != null) {
                        existingLocation.setLocationCode(updatedLocation.getLocationCode());
                    }
                    Location savedLocation = locationRepository.save(existingLocation);
                    return ResponseEntity.ok(LocationMapper.toDto(savedLocation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<LocationDTO>> createLocations(
            @Valid @RequestBody List<LocationCreateDTO> locationCreateDTOs) {
        List<Location> locations = locationCreateDTOs.stream()
                .map(dto -> new Location(dto.getName(), dto.getCountry(), dto.getCity(), dto.getLocationCode()))
                .collect(Collectors.toList());

        List<Location> savedLocations = locationRepository.saveAll(locations);
        List<LocationDTO> response = savedLocations.stream()
                .map(LocationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(201).body(response);
    }
}

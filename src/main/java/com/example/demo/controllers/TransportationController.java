package com.example.demo.controllers;

import com.example.demo.models.Transportation;
import com.example.demo.repositories.TransportationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transportations")
public class TransportationController {

    private final TransportationRepository transportationRepository;

    TransportationController(TransportationRepository transportationRepository) {
        this.transportationRepository = transportationRepository;
    }

    // Get all transportations
    @GetMapping
    public List<Transportation> getAllTransportations() {
        return transportationRepository.findAll();
    }

    // Get a single transportation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transportation> getTransportationById(@PathVariable Long id) {
        Optional<Transportation> transportation = transportationRepository.findById(id);
        return transportation.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new transportation
    @PostMapping
    public Transportation createTransportation(@RequestBody Transportation transportation) {
        return transportationRepository.save(transportation);
    }

    // Update an existing transportation
    @PutMapping("/{id}")
    public ResponseEntity<Transportation> updateTransportation(
            @PathVariable Long id,
            @RequestBody Transportation updatedTransportation) {
        return transportationRepository.findById(id)
                .map(existingTransportation -> {
                    existingTransportation.setOriginLocation(updatedTransportation.getOriginLocation());
                    existingTransportation.setDestinationLocation(updatedTransportation.getDestinationLocation());
                    existingTransportation.setTransportationType(updatedTransportation.getTransportationType());
                    Transportation savedTransportation = transportationRepository.save(existingTransportation);
                    return ResponseEntity.ok(savedTransportation);
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
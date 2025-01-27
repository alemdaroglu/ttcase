package com.example.demo.services;

import com.example.demo.dtos.RouteDTO;
import com.example.demo.repositories.LocationRepository;
import com.example.demo.repositories.TransportationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final LocationRepository locationRepository;
    private final TransportationRepository transportationRepository;

    public RouteServiceImpl(LocationRepository locationRepository, TransportationRepository transportationRepository) {
        this.locationRepository = locationRepository;
        this.transportationRepository = transportationRepository;
    }

    @Override
    public List<RouteDTO> findMatchingRoutes() {
        return new ArrayList<RouteDTO>();
    }
}

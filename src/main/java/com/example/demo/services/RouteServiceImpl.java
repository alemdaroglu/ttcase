package com.example.demo.services;

import com.example.demo.dtos.RouteDTO;
import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;
import com.example.demo.repositories.TransportationRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final LocationRepository locationRepository;
    private final TransportationRepository transportationRepository;

    public RouteServiceImpl(LocationRepository locationRepository, TransportationRepository transportationRepository) {
        this.locationRepository = locationRepository;
        this.transportationRepository = transportationRepository;
    }

    @Override
    public List<RouteDTO> findMatchingRoutes(
            String originLocationCode, String destinationLocationCode, Date travelDate) {
        Location originLocation = locationRepository.findByLocationCode(originLocationCode)
                .orElseThrow(() -> new IllegalArgumentException("Location with code " + originLocationCode + " not found"));
        Location destinationLocation = locationRepository.findByLocationCode(originLocationCode)
                .orElseThrow(() -> new IllegalArgumentException("Location with code " + destinationLocationCode + " " +
                        "not found"));

        boolean beforeFlight = false;
        boolean afterFlight = false;
        // determine the minimum number of stops
        if (originLocation.getLocationCode().length() != 3) {
            beforeFlight = true;
        }
        if (destinationLocation.getLocationCode().length() != 3) {
            afterFlight = true;
        }
        // find available airports



        return new ArrayList<RouteDTO>();
    }
}

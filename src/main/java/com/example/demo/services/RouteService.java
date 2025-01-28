package com.example.demo.services;

import com.example.demo.dtos.RouteDTO;

import java.util.Date;
import java.util.List;

public interface RouteService {
    List<RouteDTO> findMatchingRoutes(
            String originLocationCode,
            String destinationLocationCode,
            Date travelDate);
}

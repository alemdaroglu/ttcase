package com.example.demo.services;

import com.example.demo.dtos.RouteDTO;
import java.util.List;

public interface RouteService {
    List<RouteDTO> findMatchingRoutes();
}

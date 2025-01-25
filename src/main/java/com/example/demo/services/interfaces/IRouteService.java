package com.example.demo.services.interfaces;

import com.example.demo.dtos.RouteDTO;

import java.util.List;

public interface IRouteService {
    public List<RouteDTO> findMatchingRoutes();
}

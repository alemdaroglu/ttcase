package com.example.demo.services.interfaces;

import com.example.demo.dtos.Route;

import java.util.List;

public interface IRouteService {
    public List<Route> findMatchingRoutes();
}

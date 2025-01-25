package com.example.demo.services;

import com.example.demo.dtos.Route;
import com.example.demo.repositories.TransportationRepository;
import com.example.demo.services.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService implements IRouteService {
    @Autowired
    TransportationRepository transportationRepository;

    public List<Route> findMatchingRoutes(){
        return new ArrayList<Route>();
    }
}

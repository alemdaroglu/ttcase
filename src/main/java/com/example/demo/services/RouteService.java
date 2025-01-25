package com.example.demo.services;

import com.example.demo.dtos.RouteDTO;
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

    public List<RouteDTO> findMatchingRoutes(){
        return new ArrayList<RouteDTO>();
    }
}

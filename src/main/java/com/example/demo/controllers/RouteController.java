package com.example.demo.controllers;

import com.example.demo.dtos.RouteDTO;
import com.example.demo.services.RouteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    // Get all locations
    @GetMapping
    public List<RouteDTO> getMatchingRoutes(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return routeService.findMatchingRoutes();
    }

}

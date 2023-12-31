package com.garage.app.garageapp.service;

import com.garage.app.garageapp.dto.VehicleRequest;

public interface GarageService {
    int makePark(VehicleRequest request);

    Boolean leave(int slot);

    String getStatus();
}

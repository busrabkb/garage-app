package com.garage.app.garageapp.serviceImpl;

import com.garage.app.garageapp.dto.Vehicle;
import com.garage.app.garageapp.dto.VehicleRequest;
import com.garage.app.garageapp.service.GarageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GarageServiceImpl implements GarageService {
    @Value("${app.max-slots}")
    private Integer MAX_SLOTS;
    private Map<Integer, Vehicle> garageSlots = new HashMap<>();

    public int makePark(VehicleRequest request) {
        var vehicle = new Vehicle(request.getPlate(), request.getColor(), request.getType());
        int allocatedSlot = allocateSlot(vehicle);
        return  allocatedSlot;
    }

    public Boolean leave(int slot) {
        if (garageSlots.containsKey(slot)) {
            garageSlots.remove(slot);
            return true;
        } else {
            return false;
        }
    }

    public String getStatus() {
        var result = new StringBuilder("Status:\n");
        for (var entry : garageSlots.entrySet()) {
            result.append(entry.getValue()).append(" [").append(entry.getKey()).append("]\n");
        }
        return result.toString().trim();
    }

    private int allocateSlot(Vehicle vehicle) {
        for (var i = 1; i <= MAX_SLOTS; i++) {
            if (!garageSlots.containsKey(i)) {
                garageSlots.put(i, vehicle);
                return i;
            }
        }
        return -1;
    }
}

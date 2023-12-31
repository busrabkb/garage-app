package com.garage.app.garageapp.controller;

import com.garage.app.garageapp.dto.VehicleRequest;
import com.garage.app.garageapp.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garage")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping("/park")
    public ResponseEntity<String> makePark(@RequestBody VehicleRequest request) {
        int allocatedSlot =  garageService.makePark(request);

        return (allocatedSlot != -1)
                ? ResponseEntity.ok("Allocated " + allocatedSlot + " slot.")
                : ResponseEntity.badRequest().body("Garage is full.");
    }

    @PostMapping("/leave/{slot}")
    public ResponseEntity<String> makeLeave(@PathVariable int slot) {
       Boolean succeeed = garageService.leave(slot);
       return  (succeeed) ?
             ResponseEntity.ok("Slot " + slot + " has been freed.")
       :
             ResponseEntity.badRequest().body("Slot " + slot + " is already empty.");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        var result = garageService.getStatus();
        return ResponseEntity.ok(result);
    }

}


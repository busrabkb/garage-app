package com.garage.app.garageapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleRequest {
    private String plate;
    private String color;
    private String type;

}
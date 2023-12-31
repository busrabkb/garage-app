package com.garage.app.garageapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private String plate;
    private String color;
    private String type;

    @Override
    public String toString() {
        return plate + " " + color + " " + type;
    }
}
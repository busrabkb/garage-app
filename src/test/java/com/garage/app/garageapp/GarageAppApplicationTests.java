package com.garage.app.garageapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garage.app.garageapp.controller.GarageController;
import com.garage.app.garageapp.dto.VehicleRequest;
import com.garage.app.garageapp.service.GarageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class GarageAppApplicationTests {

	@InjectMocks
	private GarageController garageController;

	@Mock
	private GarageService garageService;

	@Mock
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private VehicleRequest vehicleRequest;

	@Test
	public void testGetStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/garage/status"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testMakePark() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/garage/park")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"plate\":\"ABC123\", \"color\":\"Red\", \"type\":\"Car\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

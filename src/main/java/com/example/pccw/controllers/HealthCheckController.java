package com.example.pccw.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pccw.entity.Heartbeat;

@RestController
public class HealthCheckController {

	@GetMapping("/heartbeat")
	public Heartbeat greeting() {
		return new Heartbeat("x.y.x", "2020-01-01T10:12:12.123Z");
	}
}

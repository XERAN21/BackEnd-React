package com.asagao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.Color;
import com.asagao.Service.Interface.ColorService;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@GetMapping
	public List<Color> getColors() {
		return colorService.getColors();
	}
}

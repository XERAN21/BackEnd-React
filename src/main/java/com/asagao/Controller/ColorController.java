package com.asagao.Controller;

import java.awt.Color;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Service.Interface.ColorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/colors")
@RequiredArgsConstructor
public class ColorController {

	private final ColorService colorService;
	  
	  @GetMapping
	  public List<Color> list(HttpSession session) {
	       return colorService.getColors();
	  }
}

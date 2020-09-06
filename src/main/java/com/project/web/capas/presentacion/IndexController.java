package com.project.web.capas.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping(value = "/index/{nombre}")
	public String index(@RequestParam String nombre) {
		return "index";
	}
	
}

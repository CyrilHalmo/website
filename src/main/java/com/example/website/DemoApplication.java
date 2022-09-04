package com.example.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DemoApplication {
	
	@RequestMapping("/")
	String home(Model model) {
		model.addAttribute("subtitle", "test");
		return "index";
	}
	
	@RequestMapping("/de")
	String homeDE(Model model) {
		model.addAttribute("subtitle", "Wenn Programmieren auf Passion trifft");
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

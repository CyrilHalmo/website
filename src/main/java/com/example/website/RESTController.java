package com.example.website;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class RESTController extends SpringBootServletInitializer {

	@RequestMapping("/")
	String home() {
		if (LocaleContextHolder.getLocale().equals(Locale.GERMAN))
			return "redirect:/de";
		return "redirect:/en";
	}

	@RequestMapping("/de")
	String homeDE(Model model) {
		model.addAttribute("language", Locale.GERMAN);
		return "index";
	}

	@RequestMapping("/en")
	String homeEN(Model model) {
		model.addAttribute("language", Locale.ENGLISH);
		return "index";
	}
	
	@GetMapping("getFragment/{language}/{fragmentName}")
	String getFragment(@PathVariable("language") String language, @PathVariable("fragmentName") String fragmentName) {
		return "fragments/" + language + ".html :: " + fragmentName;
	}
	
	@GetMapping("openBrickBreaker")
	String getBrickBreakerGame() {
		return "fragments/brickBreaker.html :: game";
	}
	
	@GetMapping("{language}/closeBrickBreaker")
	String getBrickBreakerPlaceholder(Model model, @PathVariable("language") String language) {
		model.addAttribute("language", language);
		return "fragments/brickBreaker.html :: placeholder";
	}

	public static void main(String[] args) {
		SpringApplication.run(RESTController.class, args);
	}

}

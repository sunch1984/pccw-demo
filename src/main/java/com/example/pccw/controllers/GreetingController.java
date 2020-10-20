package com.example.pccw.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Controller
public class GreetingController {

	@GetMapping("/")
	public void dcos(HttpServletResponse response) throws IOException {
	   response.sendRedirect("/docs");
	}

	@GetMapping("/docs")
	public String dcos() {
		return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/index.html";
	}
	
	

}

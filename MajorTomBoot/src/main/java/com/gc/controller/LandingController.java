package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
	@RequestMapping("/")
	public String forwardToLanding()
	{
		return "forward:index.html";
	}
}

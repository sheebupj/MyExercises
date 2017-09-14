package net.nestgroup.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class firstController {
	@RequestMapping("/page")
	public String form() {
		return "page";
	}
	
	@RequestMapping("/page1")
	public String form1() {
		return "page1";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
}

package com.easyskillup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


	@GetMapping("/")
	public String index() {
		return "<h1>Index Page</h1>";
	}
	
	@GetMapping("/users")
	public String users() {
		return "<h1>User Page</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Admin Page</h1>";
	}
}

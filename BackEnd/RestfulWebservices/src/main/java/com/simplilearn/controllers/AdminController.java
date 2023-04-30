package com.simplilearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Admin;
import com.simplilearn.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/Admin")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@PostMapping("/login")
	public boolean findbyusername(@PathVariable String username,@PathVariable String password)
	{
		Admin admin= adminservice.getAdminbyusername(username);
		String user=admin.getUsername();
		String pass=admin.getPassword();
		if(username == user&& password==pass)  
			      return false;
		else
		          return true;
	
	}
	@PostMapping("/changepassword")
	public Admin ChangePassword(@PathVariable String username,@PathVariable String password)
	{
		Admin admin=adminservice.getAdminbyusername(username);
		if(username==admin.getUsername())
			    admin.setUsername(username);
			    admin.setPassword(password);
		        adminservice.save(admin);
		        return admin;
		       
	}
}

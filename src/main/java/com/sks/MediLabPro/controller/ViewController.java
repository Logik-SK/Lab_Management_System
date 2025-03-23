package com.sks.MediLabPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "html/login.html";
	}

	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "html/dashboard.html";
	}

	@GetMapping("/patients")
	public String patientsPage() {
		return "html/patients.html";
	}
	@GetMapping("/doctors")
	public String doctorsPage() {
		return "html/doctors.html";
	}
	@GetMapping("/addPatient")
	public String addPatient() {
		return "html/addPatient.html";
	}
	@GetMapping("/addDoctor")
	public String addDoctor() {
		return "html/addDoctor.html";
	}
	@GetMapping("/navbar")
	public String fetchNavbar() {
		return "html/navbar.html";
	}
	@GetMapping("/sidebar")
	public String fetchSidebar() {
		return "html/sidebar.html";
	}
	@GetMapping("/viewPatient")
	public String viewPatient() {
		return "html/viewPatient.html";
	}
	@GetMapping("/appointments")
	public String getMethodName() {
		return "html/appointments.html";
	}
	

}

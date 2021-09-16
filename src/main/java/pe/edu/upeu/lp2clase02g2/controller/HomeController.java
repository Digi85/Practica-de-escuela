package pe.edu.upeu.lp2clase02g2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
@GetMapping("/")
public String mensaje() {
	return "Bienvenido a Spring Boot";
}
@GetMapping("/prueba")
public String mensaje2() {
	return "Test de Postman";
}
}

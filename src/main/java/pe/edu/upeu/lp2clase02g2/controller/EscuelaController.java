package pe.edu.upeu.lp2clase02g2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.lp2clase02g2.model.Escuela;
import pe.edu.upeu.lp2clase02g2.service.EscuelaService;

@RestController
@RequestMapping("/api/escuela")
public class EscuelaController {
@Autowired
private EscuelaService escuelaService;

@PostMapping("/create")
public ResponseEntity<Escuela> save(@RequestBody Escuela escuela){
	try {
		Escuela ec = escuelaService.create(new Escuela(escuela.getIdescuela(), escuela.getNombre()));
		return new ResponseEntity<>(ec, HttpStatus.CREATED);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/all")
public ResponseEntity<List<Escuela>> getEscuelas(){
	try {
		List<Escuela> list = new ArrayList<>();
		list = escuelaService.readAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/{id}")
public ResponseEntity<Escuela> getUser(@PathVariable("id") long id){
	Escuela escuela = escuelaService.read(id);
		if(escuela.getIdescuela()>0) {
			return new ResponseEntity<>(escuela, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
	try {
		escuelaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/update/{id}")
public ResponseEntity<Escuela> update(@RequestBody Escuela ec, @PathVariable("id") long id){
	try {
		Escuela ee = escuelaService.read(id);
		if(ee.getIdescuela()>0) {
			ee.setNombre(ec.getNombre());
			return new ResponseEntity<>(escuelaService.create(ee),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			

	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}

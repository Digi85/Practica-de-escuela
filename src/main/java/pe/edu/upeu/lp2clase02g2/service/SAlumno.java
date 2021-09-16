package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Alumno;

public interface SAlumno {
	Alumno create(Alumno al);
	List<Alumno> readAll();
	Alumno read(Long id);
	void delete(Long id);
	Alumno update(Alumno al);
}

package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Alumno;
import pe.edu.upeu.lp2clase02g2.repository.AlumnoRepository;
@Service
public class AlumnoService implements SAlumno{

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Override
	public Alumno create(Alumno al) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(al);
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno read(Long id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

	@Override
	public Alumno update(Alumno al) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(al);
	}

}

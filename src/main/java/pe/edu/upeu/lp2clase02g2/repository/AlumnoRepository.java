package pe.edu.upeu.lp2clase02g2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.lp2clase02g2.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}

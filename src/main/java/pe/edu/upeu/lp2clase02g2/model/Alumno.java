package pe.edu.upeu.lp2clase02g2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long idalumno;

@Column(name="nombre")
private String nombre;

public Alumno() {
	super();
}
public Alumno(String nombre) {
	super();
	this.nombre = nombre;
}
public long getIdalumno() {
	return idalumno;
}
public void setIdalumno(long idalumno) {
	this.idalumno = idalumno;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

}

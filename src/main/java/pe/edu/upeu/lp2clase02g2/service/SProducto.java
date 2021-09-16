package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Producto;

public interface SProducto {
	Producto create(Producto p);
	List<Producto> readAll();
	Producto read(Long id);
	void delete(Long id);
	Producto update(Producto p);
}

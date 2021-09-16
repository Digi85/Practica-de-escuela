package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Producto;
import pe.edu.upeu.lp2clase02g2.repository.ProductoRepository;
@Service
public class ProductoService implements SProducto{
@Autowired
private ProductoRepository productoRepository;
	@Override
	public Producto create(Producto p) {
		// TODO Auto-generated method stub
		return productoRepository.save(p);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto read(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto update(Producto p) {
		// TODO Auto-generated method stub
		return null;
	}

}

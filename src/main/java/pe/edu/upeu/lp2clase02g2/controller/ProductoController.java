package pe.edu.upeu.lp2clase02g2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.lp2clase02g2.model.Producto;
import pe.edu.upeu.lp2clase02g2.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> save(@RequestBody Producto prod){
		try {
			Producto p = productoService.create(new Producto(prod.getIdproducto(), prod.getNombre(), prod.getPrecio(), prod.getCantidad()));
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("producto/update/{id}")
	public ResponseEntity<Producto> update2(@RequestBody Producto prod, @PathVariable("id") long id){
		try {
			Producto p = productoService.read(id);
			if(p.getIdproducto()>0) {
				p.setNombre(prod.getNombre());
				p.setPrecio(prod.getPrecio());
				p.setCantidad(prod.getCantidad());
				return new ResponseEntity<>(productoService.create(p),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

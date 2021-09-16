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

import pe.edu.upeu.lp2clase02g2.model.Post;
import pe.edu.upeu.lp2clase02g2.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
@Autowired
private PostService postService;

@PostMapping("/create")
public ResponseEntity<Post> save(@RequestBody Post post){
	try {
		Post po = postService.create(new Post(post.getIdpost(), post.getTitulo(), post.getDescripcion()));
		return new ResponseEntity<>(po, HttpStatus.CREATED);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/all")
public ResponseEntity<List<Post>> gePost(){
	try {
		List<Post> list = new ArrayList<>();
		list = postService.readAll();
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
public ResponseEntity<Post> getUser(@PathVariable("id") long id){
	Post post = postService.read(id);
		if(post.getIdpost()>0) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
	try {
		postService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/update/{id}")
public ResponseEntity<Post> update(@RequestBody Post post, @PathVariable("id") long id){
	try {
		Post pp = postService.read(id);
		if(pp.getIdpost()>0) {
			pp.setTitulo(post.getTitulo());
			pp.setDescripcion(post.getDescripcion());
			return new ResponseEntity<>(postService.create(pp),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			

	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}

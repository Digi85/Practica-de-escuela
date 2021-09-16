package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g2.model.Post;

public interface SPost {
	Post create(Post post);
	List<Post> readAll();
	Post read(Long id);
	void delete(Long id);
	Post update(Post al);
}

package pe.edu.upeu.lp2clase02g2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g2.model.Post;
import pe.edu.upeu.lp2clase02g2.repository.PostRepository;

@Service
public class PostService implements SPost{
@Autowired
private PostRepository postRepository;

@Override
public Post create(Post post) {
	// TODO Auto-generated method stub
	return postRepository.save(post);
}

@Override
public List<Post> readAll() {
	// TODO Auto-generated method stub
	return postRepository.findAll();
}

@Override
public Post read(Long id) {
	// TODO Auto-generated method stub
	return postRepository.findById(id).get();
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	postRepository.deleteById(id);
}

@Override
public Post update(Post al) {
	// TODO Auto-generated method stub
	return postRepository.save(al);
}
}

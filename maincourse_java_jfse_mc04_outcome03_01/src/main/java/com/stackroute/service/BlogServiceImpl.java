package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository repository;

	public BlogServiceImpl() {
	}

	@Override
	public Blog saveBlog(Blog blog) {
		return repository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return repository.findAll();
	}

	@Override
	public Blog getBlogById(int id) {
		Optional<Blog> blog=repository.findById(id);
		if (!blog.isPresent()){
			return null;
		}
		return blog.get();
	}

	@Override
	public Blog deleteBlog(int id) {
		Blog blog = getBlogById(id);
		if (blog==null){
			return null;
		}
		repository.deleteById(id);
		return blog;
	}

	@Override
	public Blog updateBlog(Blog blog) {
		return repository.save(blog);
	}

}

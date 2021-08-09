package com.stackroute.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping(path = "/api/v1")
public class BlogController {

    /* Provide implementation code for these methods */
	private BlogService blogService;
	

    /*This method should save blog and return savedBlog Object */
//	@RequestMapping(value = "/blogs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	@PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        try {
        	ResponseEntity<Blog> response= new ResponseEntity<>(blogService.saveBlog(blog),HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    /*This method should fetch all blogs and return the list of all blogs */
	@GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        try {
			List<Blog> blogs = blogService.getAllBlogs();
			if (blogs==null||blogs.isEmpty()) {
				return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(blogs,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    /*This method should fetch the blog taking its id and return the respective blog */
	@GetMapping("blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
		try {
	        Blog blog=blogService.getBlogById(id);
	        if (blog==null) {
				return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			}
	        return new ResponseEntity<Blog>(blog,HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    /*This method should delete the blog taking its id and return the deleted blog */
	@DeleteMapping("blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) {
		try {
			Blog blog = blogService.deleteBlog(id);
	        if (blog==null) {
				return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			}
	        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    /*This method should update blog and return the updatedBlog */
	@PutMapping("blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        try {

			if (blog==null) {
				return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Blog>(blogService.updateBlog(blog),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
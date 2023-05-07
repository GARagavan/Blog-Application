package com.springboot.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.service.postservice;
import com.springboot.blog.service.impl.PostDto;

import lombok.Delegate;

@RestController
@RequestMapping("/api/post")
public class postcontroller {
	
	
    private postservice service;  //creating an interface

	public postcontroller(postservice service) {
		
		this.service = service;
	}
	
	//create blog post
	@PostMapping
	public ResponseEntity<PostDto> createpost(@RequestBody PostDto postDto){
		return new ResponseEntity<>(service.createpost(postDto),HttpStatus.CREATED);
	}
	
	//create All post rest api
	
@GetMapping
public List<PostDto>getallpost(){
	return service.getallpost();
}

  //get post by id
  @GetMapping("/{id}")
 public ResponseEntity<PostDto> getpostbyid(@PathVariable(name="id") Long id){
	 return ResponseEntity.ok(service.getpostbyid(id));
 }
  
  //update post by id rest api
  @PutMapping("/{id}")
  public ResponseEntity<PostDto> updatepost(@RequestBody PostDto postDto ,@PathVariable(name="id") Long id){
	PostDto postResponse=service.updatepost(postDto, id); 
	return new ResponseEntity<>(postResponse,HttpStatus.OK);
  }
  
//Delete post rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletepost(@PathVariable(name="id") Long id){
		service.deletepostbyid(id);
		return new ResponseEntity<>("post entity deleted successfully",HttpStatus.OK);
	}
    
}


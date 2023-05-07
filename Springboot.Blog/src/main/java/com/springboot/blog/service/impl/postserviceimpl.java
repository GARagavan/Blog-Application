package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.postrepository;
import com.springboot.blog.service.postservice;
@Service

public class postserviceimpl implements postservice {
	
	private postrepository repository;
	
//@Autowired  we omit the annotation by using one constructor
	public postserviceimpl(postrepository repository) {
		
		this.repository = repository;
	}


	@Override
	public PostDto createpost(PostDto postDto) {
		//convert Dto to entity
//		post p=new post();
//		p.setTitle(postDto.getTitle());
//		p.setDescription(postDto.getDescription());
//		p.setContent(postDto.getContent());
		post p=maptoentity(postDto);
		post newpost=repository.save(p);
		
		
		//convert entity to Dto
		
		PostDto postresponse =maptoDto(newpost);
//		PostDto postresponse =new PostDto();
//		postresponse.setTitle(newpost.getTitle());
//		postresponse.setId(newpost.getId());
//		postresponse.setDescription(newpost.getDescription());
//		postresponse.setContent(newpost.getContent());
//		
//	
		return postresponse;
	}
	


	@Override
	public List<PostDto> getallpost() {
	
		List<post> posts =repository.findAll();
		return posts.stream().map(p->maptoDto(p)).collect(Collectors.toList());
	}
	//gGet post by id
	@Override
	public PostDto getpostbyid(Long id) {
		post p=repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","id",id));
		return maptoDto(p);
	}
	
	
	//convert Entity to Dto
	private PostDto maptoDto(post p) {
		PostDto Dto =new PostDto();
		Dto.setTitle(p.getTitle());
		Dto.setId(p.getId());
	    Dto.setDescription(p.getDescription());
		Dto.setContent(p.getContent());
		return Dto;
	}
	
	//convert Dto to Entity
	private post maptoentity (PostDto postDto) {
		post p=new post();
		p.setTitle(postDto.getTitle());
		p.setDescription(postDto.getDescription());
		p.setContent(postDto.getContent());
		return p;
		
	}

//Update post by id
	@Override
	public PostDto updatepost(PostDto postDto, Long id) {
		post p=repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","id",id));
		
		p.setTitle(postDto.getTitle());
		p.setDescription(postDto.getDescription());
		p.setContent(postDto.getContent());
		
		post updatepost=repository.save(p);
		return maptoDto(updatepost);
	
	}


	@Override
	public void deletepostbyid(Long id) {
		post p=repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","id",id));
		repository.delete(p);
		
	}


	
	


	
	

}

package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.service.impl.PostDto;

public interface postservice{
	
	//public  PostDto createPost (PostDto postDto);
	 public PostDto createpost(PostDto postDto);

	public List<PostDto> getallpost();
	
	public 	PostDto getpostbyid(Long id);
	
	public  PostDto updatepost (PostDto postDto,Long id);
	
	public void deletepostbyid(Long id);
}

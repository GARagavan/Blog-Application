package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.entity.post;

//@Repository//jpa repository internally takes all this stuff

public interface postrepository extends JpaRepository<post, Long> {
	
	

}

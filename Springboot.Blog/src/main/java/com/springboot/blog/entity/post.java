package com.springboot.blog.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
		name="Posts", uniqueConstraints= {@UniqueConstraint(columnNames= {"Title"})}
		)
public class post {
	@Id
	@GeneratedValue(
			strategy=GenerationType.IDENTITY
			)
	private Long id;
	
	@Column(name="Title1",nullable=false)
	private String title;
	
	@Column(name="Description1",nullable=false)
	private String description;
	
	@Column(name="Content1",nullable=false)
	private String content;

}

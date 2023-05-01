package com.upencoding.blog.services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.upencoding.blog.payloads.CategoryDto;
@ComponentScan
public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	void deleteCategory(Integer categoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategories(); 

}

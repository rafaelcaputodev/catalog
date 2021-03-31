package com.caputo.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caputo.dscatalog.Repositories.CategoryRepository;
import com.caputo.dscatalog.dto.CategoryDTO;
import com.caputo.dscatalog.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;
	
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRep.findAll();
		
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
	}
}
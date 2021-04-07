package com.caputo.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import com.caputo.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caputo.dscatalog.Repositories.CategoryRepository;
import com.caputo.dscatalog.dto.CategoryDTO;
import com.caputo.dscatalog.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRep.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Category entity = categoryRep.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}
}
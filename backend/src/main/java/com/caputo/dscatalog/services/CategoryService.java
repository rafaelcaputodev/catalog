package com.caputo.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caputo.dscatalog.Repositories.CategoryRepository;
import com.caputo.dscatalog.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRep;
	
	public List<Category> findAll() {
		return categoryRep.findAll();
	}
}
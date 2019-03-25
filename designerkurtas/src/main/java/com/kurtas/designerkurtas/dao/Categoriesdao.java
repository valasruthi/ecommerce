package com.kurtas.designerkurtas.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kurtas.designerkurtas.model.CategoryDetails;

@Component

public interface Categoriesdao {
	public boolean newCategoriesdata(CategoryDetails cdt);
	public CategoryDetails getctid(int id);
	public List<CategoryDetails> retrieveAllUsers();
    public boolean updateCatdata(CategoryDetails cdet);
    public boolean deleteCdata(CategoryDetails cdet);
}

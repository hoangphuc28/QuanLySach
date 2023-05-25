package com.example.quanlysach.Service;

import com.example.quanlysach.Model.Book;
import com.example.quanlysach.Model.Category;
import com.example.quanlysach.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
    categoryRepo.save(category);
    }
    public Category getCategory(Long id) {
       return categoryRepo.findById(id).orElse(null);
    }
    public void remove(Long id) {
        categoryRepo.deleteById(id);
    }
    public void updateCategory(Category newCategory) {
        var cate = getCategory(newCategory.getId());
        cate.setName(newCategory.getName());
        categoryRepo.save(cate);
    }
}

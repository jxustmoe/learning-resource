package cn.jxust.repository;

import cn.jxust.model.Category;

import java.util.List;

public interface CategoryDAO {

    public void addCategory(Category category);

    public void deleteCategory(int categoryId);

    public void alterCatogory(Category category);

    public List<Category> getAllCategory();
}

package cn.jxust.repository;

import cn.jxust.model.Category;

import java.util.List;

public interface CategoryDAO {

    public void addCategory(Category category);

    public void deleteCategory(int categoryId);

    public void alterCatogory(Category category);

    /**
     * 根据名字返回category，没有返回null
     */
    public Category getCategoryByName(String name);

    public List<Category> getAllCategory();


}

package cn.jxust.controller.mock;

import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.model.Category;
import cn.jxust.service.CategoryService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Primary
@Component
public class StubCategoryService implements CategoryService {
    @Override
    public void addCategory(Category category) throws CategoryExistException {
        if(category.getId()==1) throw new CategoryExistException("exist");
    }

    @Override
    public void deleteCategory(int categoryId) {
    }

    @Override
    public void alterCategory(Category category) throws CategoryNotExistException {
        if (category.getId()==1) throw new CategoryNotExistException("not exist");
    }

    @Override
    public List<List<Category>> getCategories() {
        List<List<Category>> list=new ArrayList<>();
        List<Category> sublist=new ArrayList<>();
        sublist.add(new Category(1,"1",0));
        sublist.add(new Category(2,"2",1));
        sublist.add(new Category(3,"3",1));
        sublist.add(new Category(4,"4",1));
        sublist.add(new Category(5,"5",1));
        list.add(sublist);
        return list;
    }
}

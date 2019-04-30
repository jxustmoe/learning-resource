package cn.jxust.service;

import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.model.Category;
import cn.jxust.repository.CategoryDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Override
    public void addCategory(Category category) throws CategoryExistException {
        if(categoryDAO.getCategoryByName(category.getName())!=null)
            throw new CategoryExistException("资源已存在");
        categoryDAO.addCategory(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryDAO.deleteCategory(categoryId);
    }

    @Override
    public void alterCategory(Category category) throws CategoryNotExistException {
        if(categoryDAO.getCategoryById(category.getId())==null)
            throw new CategoryNotExistException("资源不存在");
        categoryDAO.alterCategory(category);
    }

    @Override
    public List<List<Category>> getCategories() {
        Map<Integer,List<Category>> map=new HashMap<>();
        List<Category> allCategory = categoryDAO.getAllCategory();
        //日志
        log.info(allCategory.toString());
        for(Category category:allCategory){
            List<Category> list;
            if(category.getPid()==0){
                list= map.get(category.getId());
                if(list==null) list=new ArrayList<>();
                list.add(0,category);
                map.put(category.getId(),list);
            }else {
                list = map.get(category.getPid());
                if(list==null) list=new ArrayList<>();
                list.add(category);
                map.put(category.getPid(),list);
            }
        }
        return new ArrayList<>(map.values());
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}

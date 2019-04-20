package cn.jxust.controller;


import cn.jxust.model.Category;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @RequestMapping("/add")
    public String add(Category category){
        return null;
    }

    @RequestMapping("/delete")
    public String delete(int categoryId){
        return null;
    }

    @RequestMapping("/update")
    public String update(Category category){
        return null;
    }

    @RequestMapping("/show")
    public Map<Category,List<Category>> show(){
        return null;
    }
}

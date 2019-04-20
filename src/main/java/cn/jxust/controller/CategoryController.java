package cn.jxust.controller;


import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.model.Category;
import cn.jxust.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("/add")
    public Message<Category> add(Category category){
        Message<Category> message=new Message<>();
        try {
            service.addCategory(category);
        } catch (CategoryExistException e) {
            message.setStatusCode(500);
            message.setStatusMessage("目录已存在");
            log.error(message.getStatusMessage(),e);
        }
        return message;
    }

    @RequestMapping("/delete")
    public Message<Category> delete(@RequestParam int categoryId){
        Message<Category> message=new Message<>();
        service.deleteCategory(categoryId);
        message.setStatusCode(200);
        log.error("delete category id:{}",categoryId);
        return message;
    }

    @RequestMapping("/update")
    public Message update(Category category){
        Message message=new Message();
        try {
            service.alterCategory(category);
        } catch (CategoryNotExistException e) {
            message.setStatusCode(500);
            message.setStatusMessage("目录不存在");
            log.error(message.getStatusMessage(),e);
        }
        return message;
    }

    @RequestMapping("/show")
    public Message<Map<Category,List<Category>>> show(){
        Message<Map<Category,List<Category>>> message=new Message<>();
        message.setData(service.getCategories());
        return message;
    }
}

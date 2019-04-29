package cn.jxust.controller;


import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ParameterInvalidException;
import cn.jxust.model.Category;
import cn.jxust.service.CategoryService;
import cn.jxust.support.ParameterCheckUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
@Getter
@Setter
public class CategoryController {

    private CategoryService service;

    @RequestMapping("/add")
    public Message<Category> add(Category category) throws CategoryExistException, ParameterInvalidException {
        //日志
        log.info("param is: "+category.toString());
        //验证
        ParameterCheckUtils.isValidCategoryName(category);
        //业务
        service.addCategory(category);
        //正确结果
        Message<Category> message=new Message<>();
        message.setStatusMessage("添加成功");
        return message;
    }

    @RequestMapping("/delete")
    public Message<Category> delete(int categoryId) throws ParameterInvalidException {
        //日志
        log.info("delete category id:{}",categoryId);
        //验证
        ParameterCheckUtils.isValidCategoryId(categoryId);
        //业务
        service.deleteCategory(categoryId);
        //正确结果
        Message<Category> message=new Message<>();
        message.setStatusMessage("删除成功");
        return message;
    }

    @RequestMapping("/update")
    public Message update(Category category) throws CategoryNotExistException, ParameterInvalidException {
        //日志
        log.info("param is:",category);
        //验证
        ParameterCheckUtils.isValidCategoryId(category);
        ParameterCheckUtils.isValidCategoryName(category);
        //业务
        service.alterCategory(category);
        //正确结果
        Message message=new Message();
        message.setStatusMessage("修改成功");
        return message;
    }

    @RequestMapping("/show")
    public Message<List<List<Category>>> show(){
        //业务
        List<List<Category>> categories = service.getCategories();
        //结果
        Message<List<List<Category>>> message=new Message<>();
        message.setData(categories);
        message.setStatusMessage("ok");
        return message;
    }

    public CategoryService getService() {
        return service;
    }

    @Autowired
    public void setService(CategoryService service) {
        this.service = service;
    }

}

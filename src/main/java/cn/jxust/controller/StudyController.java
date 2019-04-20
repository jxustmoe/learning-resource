package cn.jxust.controller;


import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;
import cn.jxust.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studyRes")
@Slf4j
public class StudyController {

    @Autowired
    private ResourceService service;

    @RequestMapping("/add")
    public Message add(Resource resource){
        Message message=new Message();
        try {
            service.addResource(resource);
        } catch (CategoryNotExistException e) {
            message.setStatusCode(500);
            message.setStatusMessage("目录已存在");
            log.error(message.getStatusMessage(),e);
        }
        return message;
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam int resourceId){
        service.deleteResource(resourceId);
        log.info("delete resource id:{}",resourceId);
    }

    @RequestMapping("/update")
    public Message update(Resource resource){
        Message message=new Message();
        try {
            service.alterResource(resource);
        } catch (ResourceNotExistException e) {
            message.setStatusCode(500);
            message.setStatusMessage("资源不存在");
            log.error(message.getStatusMessage(),e);
        }
        return message;
    }

    @RequestMapping("/show")
    //这方法出现了严重的控制耦合，应该尽量避免这种耦合
    //所谓控制耦合，是指参数决定了代码的运行逻辑
    public Message<Page<Resource>> show(String categoryId, @RequestParam(defaultValue = "1") int page, String keyword){
        Page<Resource> resourcePage;
        if(keyword==null&&categoryId==null){
            resourcePage = service.getAllResoruces(page);
        }else if(keyword==null){
            resourcePage = service.getPagedResoures(Integer.parseInt(categoryId),page);
        }else {
            resourcePage = service.getPageResoruces(keyword);
        }
        Message<Page<Resource>> message=new Message<>();
        message.setData(resourcePage);
        return message;
    }
}


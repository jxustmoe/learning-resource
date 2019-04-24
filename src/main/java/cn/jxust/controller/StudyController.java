package cn.jxust.controller;


import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;
import cn.jxust.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studyRes")
@Slf4j
public class StudyController {

    private ResourceService service;

    @RequestMapping("/add")
    public Message add(Resource resource) throws CategoryNotExistException {
        log.info("param is: "+resource.toString());

        service.addResource(resource);

        Message message=new Message();
        message.setStatusCode(200);
        message.setStatusMessage("添加成功");
        return message;
    }

    @RequestMapping("/delete")
    public Message<Resource> delete(@RequestParam int resourceId){
        log.info("param is: "+resourceId);

        service.deleteResource(resourceId);

        Message<Resource> message=new Message<>();
        message.setStatusCode(200);
        message.setStatusMessage("删除成功");
        return message;
    }

    @RequestMapping("/update")
    public Message update(Resource resource) throws ResourceNotExistException {
        log.info("param is :"+resource);

        service.alterResource(resource);

        Message message=new Message();
        message.setStatusCode(200);
        message.setStatusMessage("修改成功");
        return message;
    }

    @RequestMapping("/show")
    //这方法出现了严重的控制耦合，应该尽量避免这种耦合
    //所谓控制耦合，是指参数决定了代码的运行逻辑
    public Message<Page<Resource>> show(String categoryId, @RequestParam(defaultValue = "1") int page, String keyword){
        log.info("param is : id: "+categoryId+",pageNum : "+page+",keyword :"+keyword);
        Page<Resource> resourcePage;
        if(keyword==null&&categoryId==null){
            log.info("get all resources");
            resourcePage = service.getAllResoruces(page);
        }else if(keyword==null){
            log.info("get paged resources");
            resourcePage = service.getPagedResoures(Integer.parseInt(categoryId),page);
        }else {
            log.info("get key word resource");
            resourcePage = service.getPageResoruces(keyword);
        }
        Message<Page<Resource>> message=new Message<>();
        message.setData(resourcePage);
        return message;
    }

    public ResourceService getService() {
        return service;
    }

    @Autowired
    public void setService(ResourceService service) {
        this.service = service;
    }

}


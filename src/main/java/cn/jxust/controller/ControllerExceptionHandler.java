package cn.jxust.controller;

import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(CategoryExistException.class)
    public Message handleCategoryExist(CategoryExistException e){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("目录已存在");
        log.error(message.getStatusMessage());
        return message;
    }

    @ExceptionHandler(CategoryNotExistException.class)
    public Message handleCategoryExist(CategoryNotExistException e){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("目录不存在");
        log.error(message.getStatusMessage());
        return message;
    }

    @ExceptionHandler(ResourceNotExistException.class)
    public Message handleResourceNotExist(ResourceNotExistException e){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("资源不存在");
        log.error(message.getStatusMessage());
        return message;
    }

    @ExceptionHandler(Exception.class)
    public Message handlerWideExp(Exception e){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("服务器打盹了");
        log.error(message.getStatusMessage(),e);
        return message;
    }
}

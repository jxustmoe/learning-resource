package cn.jxust.controller;

import cn.jxust.controller.model.Message;
import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ParameterInvalidException;
import cn.jxust.exception.ResourceNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//统一处理异常逻辑。
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

    @ExceptionHandler(ServletRequestBindingException.class)
    public Message handleParameterBindError(Exception e){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("没有提供参数,或者参数为空");
        log.warn(message.getStatusMessage());
        return message;
    }

    @ExceptionHandler({ParameterInvalidException.class, MethodArgumentTypeMismatchException.class})
    public Message handleParameterInvalid(){
        Message message=new Message();
        message.setStatusCode(500);
        message.setStatusMessage("参数为空或者非法");
        log.warn(message.getStatusMessage());
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

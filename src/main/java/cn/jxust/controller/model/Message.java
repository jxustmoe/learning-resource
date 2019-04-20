package cn.jxust.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message<T> {
    //状态码200表示ok，500表示异常
    private int statusCode=200;
    //具体原因
    private String statusMessage="";
    //具体数据
    private T data;
}

package cn.jxust.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Resource {
    private int id;
    private String name;
    private int categoryId;
    private String link;
    private String uploadTime;
}

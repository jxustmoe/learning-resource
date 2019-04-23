package cn.jxust.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Resource {
    private int id;
    private String name;
    private int categoryId;
    private String link;
    private String uploadTime;
}

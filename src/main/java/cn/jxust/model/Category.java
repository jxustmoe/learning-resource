package cn.jxust.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    private int id;
    private String name;
    private int pId;
}

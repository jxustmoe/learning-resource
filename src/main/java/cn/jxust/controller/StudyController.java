package cn.jxust.controller;


import cn.jxust.model.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studyRes")
public class StudyController {
    @RequestMapping("/add")
    public String add(Resource resource){
        return null;
    }

    @RequestMapping("/delete")
    public String delete(int resourceId){
        return null;
    }

    @RequestMapping("/update")
    public String update(Resource resource){
        return null;
    }

    @RequestMapping("/show")
    public List<Resource> show(int categoryId, @RequestParam(defaultValue = "1") int page, int keyword){
        return null;
    }
}


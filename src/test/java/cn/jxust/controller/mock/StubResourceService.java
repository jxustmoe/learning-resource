package cn.jxust.controller.mock;

import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;
import cn.jxust.service.ResourceService;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class StubResourceService implements ResourceService {
    private Page<Resource> page;

    @Override
    public void addResource(Resource resource) throws CategoryNotExistException {
        if (resource.getId()==1) throw new CategoryNotExistException("not exist");
    }

    @Override
    public void deleteResource(int resourceId) {

    }

    @Override
    public void alterResource(Resource resource) throws ResourceNotExistException {
        if (resource.getId()==1) throw new ResourceNotExistException("not exist");
    }

    @Override
    //返回3资源
    public Page<Resource> getPagedResoures(int categoryId, int pageNum) {
        List<Resource> list = setData();
        page=new Page<>(new PageInfo<>(list));
        page.getData().remove(4);
        page.getData().remove(3);
        return page;
    }

    @Override
    //返回4个资源
    public Page<Resource> getPageResoruces(String keyWord) {
        List<Resource> list = setData();
        page=new Page<>(new PageInfo<>(list));
        page.getData().remove(4);
        return page;
    }

    @Override
    //返回5个资源
    public Page<Resource> getAllResoruces(int pageNum) {
        return new Page<>(new PageInfo<>(setData()));
    }

    public List<Resource> setData(){
        List<Resource> list=new ArrayList<>();
        list.add(new Resource(1,"1",1,"a.com","1998"));
        list.add(new Resource(2,"1",1,"a.com","1998"));
        list.add(new Resource(3,"1",1,"a.com","1998"));
        list.add(new Resource(4,"1",1,"a.com","1998"));
        list.add(new Resource(5,"1",1,"a.com","1998"));
        return list;
    }
}

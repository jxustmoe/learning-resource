package cn.jxust.repository;

import cn.jxust.model.Resource;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ResourceDAO {

    public void addResource(Resource resource);

    public void deleteResource(Resource resource);

    public void alterResource(Resource resource);

    public PageInfo<Resource> SpecificQuery(int categoryId,int pageNum,int pageSize);

    public PageInfo<Resource> BlueQuery(String keyWord,int PageNum,int pageSize);

    public PageInfo<Resource> getAllResources(int pageNum);
}

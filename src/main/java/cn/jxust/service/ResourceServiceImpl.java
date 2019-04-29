package cn.jxust.service;

import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Category;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;
import cn.jxust.repository.CategoryDAO;
import cn.jxust.repository.ResourceDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResourceServiceImpl implements ResourceService {
    private ResourceDAO resourceDAO;
    private CategoryDAO categoryDAO;

    public void addResource(Resource resource) throws CategoryNotExistException{
        Category category = categoryDAO.getCategoryById(resource.getCategoryId());
        if(category==null) throw new CategoryNotExistException("资源目录不存在");
        resourceDAO.addResource(resource);
    }

    public void deleteResource(int resourceId){
        resourceDAO.deleteResourceById(resourceId);
    }


    public void alterResource(Resource resource) throws ResourceNotExistException{
        Resource resource1 = resourceDAO.getResourceById(resource.getId());
        if(resource1==null) throw new ResourceNotExistException("不存在该资源");
        resourceDAO.alterResource(resource);
    }

    //明确查询
    public Page<Resource> getPagedResources(int categoryId, int pageNum){
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceDAO.specificQuery(categoryId, pageNum, 10));
        PageHelper.clearPage();
        return new Page<>(pageInfo);
    }

    //模糊查询
    public Page<Resource> getPageResources(String keyWord, int page){
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceDAO.blurQuery(keyWord, page, 10));
        PageHelper.clearPage();
        return new Page<>(pageInfo);
    }
    //全部查询
    public Page<Resource> getAllResources(int pageNum) {
        PageInfo<Resource> pageInfo=new PageInfo<>(resourceDAO.getAllResources(pageNum,10));
        PageHelper.clearPage();
        return new Page<>(pageInfo);
    }

    @Autowired
    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}

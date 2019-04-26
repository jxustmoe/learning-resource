package cn.jxust.serviceImp;

import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;
import cn.jxust.repository.ResourceDAO;
import cn.jxust.service.ResourceService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class ResourceServiceImp implements ResourceService {
    private ResourceDAO resourceDAO;
    private PageInfo pageInfo;
    public ResourceServiceImp(ResourceDAO resourceDAO, PageInfo pageInfo){
        this.resourceDAO=resourceDAO;
        this.pageInfo=pageInfo;
    }

    /**
     * 这里存在疑问：我是通过获取库中所有resource的categoryId,与要添加的resource的categoryId
     * 进行对比，确定是否存在该目录。要是新增了一个目录那就查不到这个categoryId了。
     * 如果不用这个方法，那就得调用categoryDAO，但接口没给。。
     * @param resource 资源
     * @throws CategoryNotExistException
     */
    public void addResource(Resource resource) throws CategoryNotExistException{
        int pageNum=pageInfo.getPageNum();
        Page<Resource> page=getAllResoruces(pageNum);
        List<Resource> list=page.getData();
        if(resource!=null) {
            for (Resource resource1 : list) {
                if (resource.getId() != resource1.getId() && resource.getCategoryId() == resource1.getCategoryId()) {
                    resourceDAO.addResource(resource);
                } else {
                    throw new CategoryNotExistException("不存在对应的目录！");
                }
            }
        }
    }
    public void deleteResource(int resourceId){
         List<Resource>  list = pageInfo.getList();
        Resource resource=list.get(resourceId);
        resourceDAO.deleteResource(resource);
    }
    public void alterResource(Resource resource) throws ResourceNotExistException{
        if(resource!=null) {
            int pageNum = pageInfo.getPageNum();
            Page<Resource> page = getAllResoruces(pageNum);
            List<Resource> list = page.getData();
            for (Resource resource1 : list) {
                if (resource.getId() == resource1.getId()) {
                    resourceDAO.alterResource(resource);
                } else {
                    throw new ResourceNotExistException("不存在该资源！");
                }
            }
        }
        throw new ResourceNotExistException("不存在该资源！");
    }
    public Page<Resource> getPagedResoures(int categoryId, int pageNum){
        int pageSize=pageInfo.getPageSize();
        PageInfo<Resource> pageInfo1=resourceDAO.SpecificQuery(categoryId,pageNum,pageSize);
        Page<Resource> page=new Page<>(pageInfo1);
        return page;
    }
    public Page<Resource> getPageResoruces(String keyWord){
        int pageNum=pageInfo.getPageNum();
        int pageSize=pageInfo.getPageSize();
        PageInfo<Resource> pageInfo1=resourceDAO.BlueQuery(keyWord,pageNum,pageSize);
        return new Page<>(pageInfo1);
    }
    public Page<Resource> getAllResoruces(int pageNum) {
        PageInfo<Resource> pageInfo1=resourceDAO.getAllResources(pageNum);
        return new Page<>(pageInfo1);
    }
}

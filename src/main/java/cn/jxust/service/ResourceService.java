package cn.jxust.service;

import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.exception.ResourceNotExistException;
import cn.jxust.model.Page;
import cn.jxust.model.Resource;

public interface ResourceService {

    /**
     * 添加资源，资源重复性比较大，所以直接放数据库中存
     * 但在添加之前，应该判断目录是否存在,如果不存在，应该抛出异常
     * @param resource 资源
     */
    public void addResource(Resource resource) throws CategoryNotExistException;

    /**
     * 存不存在都没有什么影响
     * @param resourceId 资源id
     */
    public void deleteResource(int resourceId);

    /**
     * 修改也要注意，如果资源不存在，应该抛出异常
     * @param resource 资源
     */
    public void alterResource(Resource resource) throws ResourceNotExistException;

    /**
     * 明确查询
     * 有两种情况，目录或不存在者是父目录，返回空list，该目录下没有资源，返回空list
     *是子目录，且有数据,返回有数据的list
     * @param categoryId 目录id
     * @param pageNum Page
     * @return
     */
    public Page<Resource> getPagedResoures(int categoryId,int pageNum);

    /**
     *模糊查询，重载方法，交给数据库，让数据库使用like搞
     * 直接返回就行了。
     * @param keyWord 关键字
     * @return Page
     */
    public Page<Resource> getPageResoruces(String keyWord);

    /**
     * 返回任何类型的资料
     * @return
     */
    public Page<Resource> getAllResoruces(int pageNum);
}

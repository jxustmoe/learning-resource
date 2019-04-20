package cn.jxust.service;

import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    /**
     * 添加目录，现根据name，验证目录是否存在，如果存在应该抛出异常。
     * 这个目录可能是也可能是子目录，到底是哪个目录由pid，如果pid为0，那么就是父目录
     * 如果不为0，那么就是子目录。
     * 其实我们根本不用考虑父目录子目录的问题，我们只要往数据库中存就对了。
     * @param category 目录
     */
    public void addCategory(Category category)throws CategoryExistException;

    /**
     * 删除目录，至于这个目录有没有，我们也不用考虑，因为如果没有
     * 数据库影响的行数为0，如果有，删就完事了。
     * 如果是删除父目录，则要把主目录一并删掉，所以这里必须要有事务
     * @param categoryId 目录id
     */
    public void deleteCategory(int categoryId);

    /**
     * 修改之前，验证categoryId是否存在，
     * 如果不存在，应该抛出异常
     * @param category 目录
     */
    public void alterCategory(Category category) throws CategoryNotExistException;


    /**
     * 把DAO返回的List组成Map
     * 第一个泛型类型为父目录，一个父目录包含一个List子目录
     * @return 父子目录
     */
    public Map<Category, List<Category>> getCategories();
}

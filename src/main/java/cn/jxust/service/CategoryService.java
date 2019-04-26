package cn.jxust.service;

import cn.jxust.exception.CategoryExistException;
import cn.jxust.exception.CategoryNotExistException;
import cn.jxust.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    /**
     * 添加一个目录，添加前通过调用dao层方法判断该目录是否已经存在，存在则抛出异常
     * 这个目录可能是父目录也可能是子目录，可以通过pid的值判断。
     * 如果pid为0，那么就是父目录，如果不为0，那么就是子目录。
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
     * 子List的一个元素放父目录，后面都放子目录
     * 相当于，一个二维数组，每一行第一个元素放父目录，后面放子目录
     * @return 父子目录
     */
    public List<List<Category>> getCategories();
}

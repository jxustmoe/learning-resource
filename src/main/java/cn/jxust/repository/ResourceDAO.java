package cn.jxust.repository;

import cn.jxust.model.Resource;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ResourceDAO {

    void addResource(Resource resource);

    void alterResource(Resource resource);

    //page
    List<Resource> specificQuery(@Param("categoryId") int categoryId, @Param("pageNumKey") int pageNum,@Param("pageSizeKey") int pageSize);

    //page
    List<Resource> blurQuery(@Param("keyWord") String keyWord,@Param("pageNumKey") int PageNum, @Param("pageSizeKey") int pageSize);

    //page
    List<Resource> getAllResources(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);

    Resource getResourceById(int resourceId);

    void deleteResourceById(int resourceId);

}

package cn.jxust.support;

import cn.jxust.exception.ParameterInvalidException;
import cn.jxust.model.Category;
import cn.jxust.model.Resource;

public class ParameterCheckUtils {
    public static boolean isValidCategoryName(Category category) throws ParameterInvalidException {
        if(category.getName()==null|| category.getName().equals(""))
            throw new ParameterInvalidException("目录名字为空或者非法");
        return true;
    }

    public static void isValidCategoryId(Category category) throws ParameterInvalidException {
        isValidCategoryId(category.getId());
    }

    public static void isValidCategoryId(int categoryId) throws ParameterInvalidException {
        if (categoryId<=0)
            throw new ParameterInvalidException("目录id非法");
    }

    public static void isValidResourceContent(Resource resource) throws ParameterInvalidException {
        if(resource.getName()==null||resource.getName().equals(""))
            throw new ParameterInvalidException("资源名字为空或者非法");
        if(resource.getLink()==null)
            throw new ParameterInvalidException("链接不能为空");
        if(resource.getUploadTime()==null)
            throw new ParameterInvalidException("上传时间不能为为空");
    }
    public static void isValidResourceId(Resource resource) throws ParameterInvalidException {
        isValidResourceId(resource.getId());
    }

    public static void isValidResourceId(int resourceId) throws ParameterInvalidException {
        if(resourceId<=0)
            throw new ParameterInvalidException("资源id非法");
    }
}

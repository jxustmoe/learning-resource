package cn.jxust.model;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//由于PageInfo过于复杂，我们用不了那么多的功能，所以这里对它进行封装。
public class Page<T> {
    //当前页
    private int pageNum;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有下一页
    private boolean hasNextPage;
    //数据
    private List<T> data;

    public Page(PageInfo<T> pageInfo) {
        this.data=pageInfo.getList();
        this.hasNextPage=pageInfo.isHasNextPage();
        this.hasPreviousPage=pageInfo.isHasPreviousPage();
    }
}

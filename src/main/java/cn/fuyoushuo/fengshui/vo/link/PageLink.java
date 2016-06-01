package cn.fuyoushuo.fengshui.vo.link;


import cn.fuyoushuo.fengshui.constant.LinkType;

/**
 * Created by MALIANG on 2016/1/19.
 */
public class PageLink extends ResourceLink{

    private int page;

    public PageLink() {super(LinkType.pageLink);
    }

    public PageLink bind(int page,String resourcePath){
        this.setPage(page);
        this.setResourcePath(resourcePath);
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

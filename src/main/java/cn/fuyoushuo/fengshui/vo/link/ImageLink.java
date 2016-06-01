package cn.fuyoushuo.fengshui.vo.link;


import cn.fuyoushuo.fengshui.constant.LinkType;

/**
 * Created by mike ma on 2016/1/17.
 */
public class ImageLink extends ResourceLink {

    public ImageLink() {
        super(LinkType.imgLink);
    }

    public ImageLink bind(String name,String resourcePath){
        this.setName(name);
        this.setResourcePath(resourcePath);
        return this;
    }
}

package cn.fuyoushuo.fengshui.vo.link;


import cn.fuyoushuo.fengshui.constant.LinkType;

/**
 * Created by MALIANG on 2016/1/5.
 */
public class ResourceLink {

    private String name;

    private String resourcePath;

    private LinkType linkType;

    public ResourceLink(LinkType linkType) {
        this.linkType = linkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public LinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }
}

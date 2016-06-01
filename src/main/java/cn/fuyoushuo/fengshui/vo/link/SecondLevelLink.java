package cn.fuyoushuo.fengshui.vo.link;

import cn.fuyoushuo.fengshui.constant.LinkType;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/5.
 */
public class SecondLevelLink extends ResourceLink {

    public SecondLevelLink() {
        super(LinkType.secondLevelLink);
    }

    private List<ArticleLink> articleLinks;

    //与自身相同一级的标签
    private List<SecondLevelLink> secondLevelLinks;

    public SecondLevelLink bind(String name,String resourcePath){
        super.setName(name);
        super.setResourcePath(resourcePath);
        return this;
    }

    public SecondLevelLink bindSameLevelLinks(List<SecondLevelLink> links){
        this.secondLevelLinks = links;
        return this;
    }

    public SecondLevelLink bindArticels(List<ArticleLink> articleLinks){
        this.articleLinks = articleLinks;
        return this;
    }

    public List<ArticleLink> getArticleLinks() {
        return articleLinks;
    }

    public void setArticleLinks(List<ArticleLink> articleLinks) {
        this.articleLinks = articleLinks;
    }

    public List<SecondLevelLink> getSecondLevelLinks() {
        return secondLevelLinks;
    }
}

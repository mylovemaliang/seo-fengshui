package cn.fuyoushuo.fengshui.vo.link;

import cn.fuyoushuo.fengshui.constant.LinkType;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/5.
 */
public class FirstLevelLink extends ResourceLink {

    public FirstLevelLink() {
        super(LinkType.firstLevelLink);
    }

    private List<SecondLevelLink> secondLevelLinks;

    private List<ArticleLink> randomArticleLinks;

    private List<ArticleLink> rankedArticleLinks;

    private List<ImageLink> imageLinks;

    public FirstLevelLink bind(String name,String resourcePath){
        super.setName(name);
        super.setResourcePath(resourcePath);
        return this;
    }

    public FirstLevelLink bindSecondLevelLinks(List<SecondLevelLink> secondLevelLinks){
        this.secondLevelLinks = secondLevelLinks;
        return this;
    }

    public FirstLevelLink bindRandomArticles(List<ArticleLink> articleLinks){
        this.randomArticleLinks = articleLinks;
        return this;
    }

    public FirstLevelLink bindRankedArticles(List<ArticleLink> articleLinks){
        this.rankedArticleLinks = articleLinks;
        return this;
    }

    public FirstLevelLink bindImages(List<ImageLink> imageLinks){
        this.imageLinks = imageLinks;
        return this;
    }

    public List<SecondLevelLink> getSecondLevelLinks() {
        return secondLevelLinks;
    }

    public void setSecondLevelLinks(List<SecondLevelLink> secondLevelLinks) {
        this.secondLevelLinks = secondLevelLinks;
    }

    public List<ArticleLink> getRandomArticleLinks() {
        return randomArticleLinks;
    }

    public void setRandomArticleLinks(List<ArticleLink> randomArticleLinks) {
        this.randomArticleLinks = randomArticleLinks;
    }

    public List<ArticleLink> getRankedArticleLinks() {
        return rankedArticleLinks;
    }

    public void setRankedArticleLinks(List<ArticleLink> rankedArticleLinks) {
        this.rankedArticleLinks = rankedArticleLinks;
    }

    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }
}

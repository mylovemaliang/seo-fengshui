package cn.fuyoushuo.fengshui.vo.link;

import cn.fuyoushuo.fengshui.constant.LinkType;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/5.
 */
public class ArticleLink extends ResourceLink {

     public ArticleLink() { super(LinkType.articleLink);}

     private SecondLevelLink secondLevelLink;

     //显示文章的部分文章
     private String content;

     //文章时间的字符串表现形式
     private String articleDate;

     private List<String> recommendStrs;

     public ArticleLink bind(String name,String resourcePath){
           super.setName(name);
           super.setResourcePath(resourcePath);
           return this;
     }

     public ArticleLink bindSecondLevelLink(SecondLevelLink secondLevelLink){
           this.secondLevelLink = secondLevelLink;
           return this;
     }

     public ArticleLink bindContent(String content){
         this.content = content;
         return this;
     }

     public ArticleLink bindArticleDate(String date){
         this.articleDate = date;
         return this;
     }

     public ArticleLink bindRecommendStrs(List<String> recommendStrs){
         this.recommendStrs = recommendStrs;
         return this;
     }

    public SecondLevelLink getSecondLevelLink() {
        return secondLevelLink;
    }

    public void setSecondLevelLink(SecondLevelLink secondLevelLink) {
        this.secondLevelLink = secondLevelLink;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public String getContent() {
        return content;
    }

    public List<String> getRecommendStrs() {
        return recommendStrs;
    }
}

package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.fengshui.vo.link.FirstLevelLink;
import cn.fuyoushuo.fengshui.vo.link.SecondLevelLink;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MALIANG on 2016/1/4.
 * 文章VO
 */
public class ArticleVo extends BasePageVo implements Serializable{

     //文章对应的一级类目
     private FirstLevelLink currentFirstLevelLink;

     //文章对应的二级类目
     private SecondLevelLink currentSecondLevelLink;

     //全部的一级类目
     private List<FirstLevelLink> allFirstLevelLinks;

     //随机产生的二级标签
     private List<SecondLevelLink> randomSecondLevelLinks;

     //文章对应的tag标签
     private List<TagLink> tagLinks;

     //文章对应的百度关键字
     private List<String> baiduWords;

     //文章标题
     private String title;

     //文章正文
     private String content;

     //部分内容
     private String abstractContent;

     //格式后的文章日期
     private String articleDate;

     //阅读的次数
     private int readTimes;

     private int artiType;


     private ArticleLink randomArticle;

     private ArticleLink lastArticle;

     private ArticleLink nextArticle;

    //同级的各类文章
     private List<ArticleLink> recommendArtis;

     private List<ArticleLink> hotestArtis;

     private List<ArticleLink> randomArtis;

     private List<ArticleLink> morelikeArtis;

     //文章的评论
     private List<CommentLink> commentList;

     private List<TagLink> randomFirstLevelTags;

     public ArticleVo bindRandomFirstLevelTags(List<TagLink> randomFirstLevelTags){
        this.randomFirstLevelTags = randomFirstLevelTags;
        return this;
    }


     public ArticleVo bindFirstLevelLinkAndSecondLevelLink(FirstLevelLink firstLevelLink,SecondLevelLink secondLevelLink){
         this.currentFirstLevelLink = firstLevelLink;
         this.currentSecondLevelLink = secondLevelLink;
         return this;
     }

    public ArticleVo bindAllFirstLevelLinks(List<FirstLevelLink> firstLevelLinks){
         this.allFirstLevelLinks = firstLevelLinks;
         return this;
     }

    public ArticleVo bindAllSecondLevelLinks(List<SecondLevelLink> secondLevelLinks){
         this.randomSecondLevelLinks = secondLevelLinks;
         return this;
     }

    public ArticleVo bindTagLinks(List<TagLink> tagLinks){
         this.tagLinks = tagLinks;
         return this;
     }

    public ArticleVo bindArticleInfo(String title,String content,String articleDate,int readTimes,int artiType){
         this.title = title;
         this.content = content;
         this.articleDate = articleDate;
         this.readTimes = readTimes;
         this.artiType = artiType;
         return this;
     }

    public ArticleVo bindRelateArticles(ArticleLink lastArticlelink,ArticleLink randomArticleLink,ArticleLink nextArticleLink){
         this.lastArticle = lastArticlelink;
         this.randomArticle = randomArticleLink;
         this.nextArticle = nextArticleLink;
         return this;
     }

    public ArticleVo bindOtherArticles(List<ArticleLink> recommendArtis,List<ArticleLink> hotestArtis,List<ArticleLink> randomArtis,List<ArticleLink> morelikeArtis){
         this.recommendArtis = recommendArtis;
         this.hotestArtis = hotestArtis;
         this.randomArtis = randomArtis;
         this.morelikeArtis = morelikeArtis;
         return this;
     }

    public ArticleVo bindComments(List<CommentLink> commentLinks){
        this.commentList = commentLinks;
        return this;
    }

    public ArticleVo bindBaiduWords(List<String> words){
        this.baiduWords = words;
        return this;
    }

    public ArticleVo bindAbstractContent(String content){
        this.abstractContent = content;
        return this;
    }

    public FirstLevelLink getCurrentFirstLevelLink() {
        return currentFirstLevelLink;
    }

    public SecondLevelLink getCurrentSecondLevelLink() {
        return currentSecondLevelLink;
    }

    public List<FirstLevelLink> getAllFirstLevelLinks() {
        return allFirstLevelLinks;
    }

    public List<SecondLevelLink> getRandomSecondLevelLinks() {
        return randomSecondLevelLinks;
    }

    public List<TagLink> getTagLinks() {
        return tagLinks;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public ArticleLink getRandomArticle() {
        return randomArticle;
    }

    public List<ArticleLink> getRecommendArtis() {
        return recommendArtis;
    }

    public List<ArticleLink> getRandomArtis() {
        return randomArtis;
    }

    public List<ArticleLink> getHotestArtis() {
        return hotestArtis;
    }

    public List<ArticleLink> getMorelikeArtis() {
        return morelikeArtis;
    }

    public List<CommentLink> getCommentList() {
        return commentList;
    }

    public List<String> getBaiduWords() {
        return baiduWords;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public ArticleLink getNextArticle() {
        return nextArticle;
    }

    public ArticleLink getLastArticle() {
        return lastArticle;
    }

    public List<TagLink> getRandomFirstLevelTags() {
        return randomFirstLevelTags;
    }

    public int getArtiType() {
        return artiType;
    }
}

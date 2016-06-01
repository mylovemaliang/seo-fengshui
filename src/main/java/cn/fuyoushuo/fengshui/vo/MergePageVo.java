package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.sitegroup.vo.link.*;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/12.
 */
public class MergePageVo extends BasePageVo{

      private TagLink currentTagLink;

      private List<FirstLevelLink> firstLevelLinks;

      private List<TagLink> randomTagLinks;

      private List<ArticleLink> articleLinks;

      private List<CommentLink> commentLinks;

      private List<ImageLink> imageLinks;

      private List<VideoLink> videoLinks;

      //全站文章筛选
      private List<ArticleLink> recommendArtis;

      private List<ArticleLink> hotestArtis;

      private List<ArticleLink> randomArtis;

      private String pageKeyWord;

      public MergePageVo bindSelfInfo(TagLink tagLink){
          this.currentTagLink = tagLink;
          return this;
      }

      public MergePageVo bindImgAndVideo(List<ImageLink> imageLinks,List<VideoLink> videoLinks){
          this.imageLinks = imageLinks;
          this.videoLinks = videoLinks;
          return this;
      }

     public MergePageVo bindFirstLevelLinksAndTagLinks(List<FirstLevelLink> firstLevelLinks,List<TagLink> tagLinks){
          this.firstLevelLinks = firstLevelLinks;
          this.randomTagLinks = tagLinks;
          return this;
     }

     public MergePageVo bindTagArticles(List<ArticleLink> articleLinks){
         this.articleLinks = articleLinks;
         return this;
     }

     public MergePageVo bindTagComments(List<CommentLink> commentLinks){
         this.commentLinks = commentLinks;
         return this;
     }

    public MergePageVo bindOtherArtis(List<ArticleLink> recommendArtis,List<ArticleLink> hotestArtis,List<ArticleLink> randomArtis){
         this.recommendArtis = recommendArtis;
         this.hotestArtis = hotestArtis;
         this.randomArtis = randomArtis;
         return this;
    }

    public MergePageVo bindPageKeyWord(String pageKeyWord){
        this.pageKeyWord = pageKeyWord;
        return this;
    }



    public TagLink getCurrentTagLink() {
        return currentTagLink;
    }

    public List<FirstLevelLink> getFirstLevelLinks() {
        return firstLevelLinks;
    }

    public List<TagLink> getRandomTagLinks() {
        return randomTagLinks;
    }

    public List<ArticleLink> getArticleLinks() {
        return articleLinks;
    }

    public List<CommentLink> getCommentLinks() {
        return commentLinks;
    }

    public List<ArticleLink> getRecommendArtis() {
        return recommendArtis;
    }

    public List<ArticleLink> getHotestArtis() {
        return hotestArtis;
    }

    public List<ArticleLink> getRandomArtis() {
        return randomArtis;
    }

    public List<VideoLink> getVideoLinks() {
        return videoLinks;
    }

    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public String getPageKeyWord() {
        return pageKeyWord;
    }
}


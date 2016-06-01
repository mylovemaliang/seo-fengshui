package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.sitegroup.vo.link.ArticleLink;
import cn.fuyoushuo.sitegroup.vo.link.CommentLink;
import cn.fuyoushuo.sitegroup.vo.link.FirstLevelLink;
import cn.fuyoushuo.sitegroup.vo.link.TagLink;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/12.
 */
public class TagPageVo extends BasePageVo{

      private TagLink currentTagLink;

      private FirstLevelLink currentFirstLevelLink;

      private List<FirstLevelLink> firstLevelLinks;

      private List<TagLink> randomTagLinks;

      private List<ArticleLink> articleLinks;

      private List<CommentLink> commentLinks;

      //一级类目下的文章
      private List<ArticleLink> recommendArtis;

      private List<ArticleLink> hotestArtis;

      private List<ArticleLink> randomArtis;

      public TagPageVo bindSelfInfo(TagLink tagLink,FirstLevelLink firstLevelLink){
          this.currentTagLink = tagLink;
          this.currentFirstLevelLink = firstLevelLink;
          return this;
      }

     public TagPageVo bindFirstLevelLinksAndTagLinks(List<FirstLevelLink> firstLevelLinks,List<TagLink> tagLinks){
          this.firstLevelLinks = firstLevelLinks;
          this.randomTagLinks = tagLinks;
          return this;
     }

     public TagPageVo bindTagArticles(List<ArticleLink> articleLinks){
         this.articleLinks = articleLinks;
         return this;
     }

     public TagPageVo bindTagComments(List<CommentLink> commentLinks){
         this.commentLinks = commentLinks;
         return this;
     }

    public TagPageVo bindOtherArtis(List<ArticleLink> recommendArtis,List<ArticleLink> hotestArtis,List<ArticleLink> randomArtis){
         this.recommendArtis = recommendArtis;
         this.hotestArtis = hotestArtis;
         this.randomArtis = randomArtis;
         return this;
    }

    public TagLink getCurrentTagLink() {
        return currentTagLink;
    }

    public FirstLevelLink getCurrentFirstLevelLink() {
        return currentFirstLevelLink;
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
}

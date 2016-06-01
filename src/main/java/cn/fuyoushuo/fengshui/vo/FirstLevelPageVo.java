package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.fengshui.vo.link.*;

import java.util.List;

/**
 * Created by MALIANG on 2016/1/4.
 * 一级类目详情页
 */
public class FirstLevelPageVo extends BasePageVo{

    /**
     * 描述多有的一级分类
     */
    private List<FirstLevelLink> firstLevelLinks;

    /**
     * 描述当前页内容的分类
     */
    private FirstLevelLink currentLevelLink;

    /**
     * 推荐的长尾词
     */
    private List<WordLink> recommendFirstLevelTags;

    /**
     * 热门文章
     */
    private List<ArticleLink> hotArtis;

    /**
     * 相关图片
     */
    private List<ImageLink> relatedImages;

    /**
     * 相关视频
     */
    private List<VideoLink> relatedVideos;

    public List<FirstLevelLink> getFirstLevelLinks() {
        return firstLevelLinks;
    }

    public void setFirstLevelLinks(List<FirstLevelLink> firstLevelLinks) {
        this.firstLevelLinks = firstLevelLinks;
    }

    public List<WordLink> getRecommendFirstLevelTags() {
        return recommendFirstLevelTags;
    }

    public void setRecommendFirstLevelTags(List<WordLink> recommendFirstLevelTags) {
        this.recommendFirstLevelTags = recommendFirstLevelTags;
    }

    public FirstLevelLink getCurrentLevelLink() {
        return currentLevelLink;
    }

    public void setCurrentLevelLink(FirstLevelLink currentLevelLink) {
        this.currentLevelLink = currentLevelLink;
    }

    public List<ArticleLink> getHotArtis() {
        return hotArtis;
    }

    public void setHotArtis(List<ArticleLink> hotArtis) {
        this.hotArtis = hotArtis;
    }

    public List<ImageLink> getRelatedImages() {
        return relatedImages;
    }

    public void setRelatedImages(List<ImageLink> relatedImages) {
        this.relatedImages = relatedImages;
    }

    public List<VideoLink> getRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(List<VideoLink> relatedVideos) {
        this.relatedVideos = relatedVideos;
    }
}

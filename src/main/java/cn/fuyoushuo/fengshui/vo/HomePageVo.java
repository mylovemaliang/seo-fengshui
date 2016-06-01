package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.fengshui.vo.link.ArticleLink;
import cn.fuyoushuo.fengshui.vo.link.FirstLevelLink;

import java.util.List;

/**
 * Created by MALIANG on 2016/6/1.
 * 描述首页的页面元素
 */
public class HomePageVo extends BasePageVo {

     /**
     * 推荐的文章
     */
     private List<ArticleLink> weekRecommendArtis;

     /**
     * 最热的文章
     */
     private List<ArticleLink> hotestArtis;

    /**
     * 各子类目数据
     */
     private List<FirstLevelLink> firstLevelLinks;


    private HomePageVo bindWeekRecommendArtis(List<ArticleLink> artis){
        this.weekRecommendArtis = artis;
        return this;
    }

    private HomePageVo bindHotestArtis(List<ArticleLink> artis){
        this.hotestArtis = artis;
        return this;
    }

    private HomePageVo bindFirstLevelLinks(List<FirstLevelLink> links){
        this.firstLevelLinks = links;
        return this;
    }

    public List<ArticleLink> getWeekRecommendArtis() {
        return weekRecommendArtis;
    }

    public List<ArticleLink> getHotestArtis() {
        return hotestArtis;
    }

    public List<FirstLevelLink> getFirstLevelLinks() {
        return firstLevelLinks;
    }
}

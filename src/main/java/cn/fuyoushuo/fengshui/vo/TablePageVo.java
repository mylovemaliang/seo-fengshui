package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.sitegroup.entity.Category;
import cn.fuyoushuo.sitegroup.ext.ResourcePathManger;
import cn.fuyoushuo.sitegroup.utils.CommonUtils;
import cn.fuyoushuo.sitegroup.vo.link.ArticleLink;
import cn.fuyoushuo.sitegroup.vo.link.FirstLevelLink;
import cn.fuyoushuo.sitegroup.vo.link.PageLink;
import cn.fuyoushuo.sitegroup.vo.link.SecondLevelLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MALIANG on 2016/1/7.
 */
public class TablePageVo extends BasePageVo{

     private long currentPage = 1;

     private long totalElements;

     private long totalPages;

     private PageLink lastPage;

     private PageLink nextPage;

     private FirstLevelLink currentFirstLevelLink;

     private List<FirstLevelLink> firstLevelLinks;

     private List<SecondLevelLink> randomSecondLevelLinks;

     private SecondLevelLink currentSecondLevelLink;

     private List<ArticleLink> recommendArtis;

     private List<ArticleLink> hotestArtis;

     private List<ArticleLink> lastestArtis;

     private List<PageLink> pageLinks = new ArrayList<PageLink>();

     public TablePageVo bindPageInfo(Long cateId,int currentPage,long totalElements){
         this.currentPage = currentPage;
         this.totalElements = totalElements;
         this.pageLinks.clear();
         Long totalPage = totalElements % 20 == 0 ? totalElements / 20 : totalElements / 20 + 1;
         totalPage = totalPage > 10 ? 10 : totalPage;
         this.setTotalPages(totalPage);
         Category rootCategory = CommonUtils.getRootCategory(cateId);
         ResourcePathManger resourcePathManger = new ResourcePathManger(this.getCurrentSite()).bindRootCate(rootCategory).bindSiteType(this.getSiteType());
         this.bindLastAndNextPage(currentPage == 1 ? new PageLink().bind(1,resourcePathManger.generateTablePagePath(cateId,1).getPath()) : new PageLink().bind(currentPage-1,resourcePathManger.generateTablePagePath(cateId,currentPage-1).getPath()),
                 currentPage == 10 ? new PageLink().bind(10,resourcePathManger.generateTablePagePath(cateId,10).getPath()) : new PageLink().bind(currentPage+1,resourcePathManger.generateTablePagePath(cateId,currentPage+1).getPath()));
         for(int i = 1;i <= totalPage;i++){
             PageLink pageLink = new PageLink().bind(i,resourcePathManger.generateTablePagePath(cateId,i).getPath());
             pageLinks.add(pageLink);
         }
         return this;
     }

    public TablePageVo bindCurrentFirstLevelLink(FirstLevelLink firstLevelLink){
        this.currentFirstLevelLink = firstLevelLink;
        return this;
    }

     public TablePageVo bindFirstLevelLinks(List<FirstLevelLink> firstLevelLinks){
         this.firstLevelLinks = firstLevelLinks;
         return this;
     }

     public TablePageVo bindRandomSecondLevelLinks(List<SecondLevelLink> links){
         this.randomSecondLevelLinks = links;
         return this;
     }

     public TablePageVo bindCurrentSecondLevelLink(SecondLevelLink link){
         this.currentSecondLevelLink = link;
         return this;
     }

     public TablePageVo bindPagedArticles(List<ArticleLink> articleLinks){
         this.currentSecondLevelLink.setArticleLinks(articleLinks);
         return this;
     }

     public TablePageVo bindExtreArtis(List<ArticleLink> recommendArtis,List<ArticleLink> hotestArtis,List<ArticleLink> lastestArtis){
         this.recommendArtis = recommendArtis;
         this.hotestArtis = hotestArtis;
         this.lastestArtis = lastestArtis;
         return this;
     }

    public TablePageVo bindLastAndNextPage(PageLink lastPage,PageLink nextPage){
        this.lastPage = lastPage;
        this.nextPage = nextPage;
        return this;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public List<FirstLevelLink> getFirstLevelLinks() {
        return firstLevelLinks;
    }

    public List<SecondLevelLink> getRandomSecondLevelLinks() {
        return randomSecondLevelLinks;
    }

    public SecondLevelLink getCurrentSecondLevelLink() {
        return currentSecondLevelLink;
    }

    public List<ArticleLink> getHotestArtis() {
        return hotestArtis;
    }

    public List<ArticleLink> getRecommendArtis() {
        return recommendArtis;
    }

    public List<ArticleLink> getLastestArtis() {
        return lastestArtis;
    }

    public List<PageLink> getPageLinks() {
        return pageLinks;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public FirstLevelLink getCurrentFirstLevelLink() {
        return currentFirstLevelLink;
    }

    public PageLink getLastPage() {
        return lastPage;
    }

    public PageLink getNextPage() {
        return nextPage;
    }
}

package cn.fuyoushuo.fengshui.ext;


import cn.fuyoushuo.fengshui.utils.CommonUtils;
import com.fuyoushuo.seores.article.Interface.IArticleService;
import com.fuyoushuo.seores.article.entity.Article;
import com.fuyoushuo.seores.category.Interface.ICategoryService;
import com.fuyoushuo.seores.category.entity.Category;
import com.fuyoushuo.seores.img.Interface.IImgService;
import com.fuyoushuo.seores.img.entity.Img;
import com.fuyoushuo.seores.site.Interface.ISiteService;
import com.fuyoushuo.seores.site.entity.Site;
import com.fuyoushuo.seores.topic.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MALIANG on 2015/11/23.
 */
@Component
public class InitStarData {


    @Autowired
    ISiteService siteService;

    private Site currentSite;

    @Autowired
    IArticleService articleService;

    @Autowired
    IImgService imgService;

    @Autowired
    ICategoryService categoryService;

    private Map<Long,Category> categoryMap = new LinkedHashMap<Long,Category>();

    private Map<Long,Img> indexImages = new LinkedHashMap<Long,Img>();

    private List<Topic> todayTopics = new ArrayList<Topic>();

    private String currentUrlCreateVersion = "";



    public Site getCurrentSite() {
        return currentSite;
    }

    public void setCurrentSite(Site currentSite) {
        this.currentSite = currentSite;
    }

    public Map<Long, Img> getIndexImages() {
        return indexImages;
    }

    public void setIndexImages(Map<Long, Img> indexImages) {
        this.indexImages = indexImages;
    }

    public List<Topic> getTodayTopics() {
        return todayTopics;
    }

    public void setTodayTopics(List<Topic> todayTopics) {
        this.todayTopics = todayTopics;
    }

    public void initCates(){ reflashCatesMap();}

    public void initSite() {
        reflashSite();
    }

    public void initIndexImgs(){
        reflashIndexImgs();
    }

    public void initTodayTopics(){reflashTodayTopics();}

    //刷新内存中的站点
    public void reflashSite(){
        Site param = new Site();
        param.setName("fengshui_site");
        List<Site> listBy = siteService.findListBy(param);
        currentSite = CollectionUtils.isEmpty(listBy) ? null : listBy.get(0);
     }

    //刷新内存中的首页图片
    public void reflashIndexImgs(){
        List<Img> images = imgService.getImages(currentSite.getId(), null, null, 13l, null, null, null, null);
        if(CollectionUtils.isEmpty(images)) return;
        int size = images.size();
        List<Article> articles = articleService.getArticles(currentSite.getId(), null, null, null, size, null, true);
        if(CollectionUtils.isEmpty(articles) || articles.size() != size) return;
        for(int i=0;i<size;i++){
            Img imgItem = images.get(i);
            Article article = articles.get(i);
            images.get(i).setTitle(articles.get(i).getTitle());
            images.get(i).setArticle(article);
            indexImages.put(imgItem.getId(),imgItem);
        }
    }

    //刷新今天内存中的热点新闻
    public void reflashTodayTopics(){
        List<Article> articles = articleService.getArticles(currentSite.getId(), null, null, null, 6, null, true);
        List<Topic> topics = CommonUtils.transArtisToTopics(articles);
        setTodayTopics(topics);
    }

    //刷新内存中的类目信息
    public void reflashCatesMap(){
        Category param = new Category();
        param.setSiteId(currentSite.getId());
        List<Category> categories = categoryService.findListBy(param);
        if(CollectionUtils.isEmpty(categories)) return;
        for(Category category : categories){
            this.categoryMap.put(category.getId(),category);
        }
    }

    public String getCurrentUrlCreateVersion() {
        return currentUrlCreateVersion;
    }

    public void setCurrentUrlCreateVersion(String currentUrlCreateVersion) {
        this.currentUrlCreateVersion = currentUrlCreateVersion;
    }

    public Map<Long, Category> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Long, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }
}

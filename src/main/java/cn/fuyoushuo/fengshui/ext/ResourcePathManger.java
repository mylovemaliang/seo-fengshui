package cn.fuyoushuo.fengshui.ext;

import cn.fuyoushuo.fengshui.constant.SiteType;
import cn.fuyoushuo.sitegroup.constant.SiteType;
import cn.fuyoushuo.sitegroup.entity.Category;
import cn.fuyoushuo.sitegroup.entity.Site;
import com.fuyoushuo.seores.article.entity.Article;
import com.fuyoushuo.seores.category.entity.Category;
import com.fuyoushuo.seores.img.entity.Img;
import com.fuyoushuo.seores.site.entity.Site;
import com.fuyoushuo.seores.video.entity.Video;
import com.fuyoushuo.seores.word.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

/**
 * Created by MALIANG on 2016/1/13.
 */
public class ResourcePathManger {

    public static final Logger logger = LogManager.getLogger(ResourcePathManger.class);

    private String path;

    private SiteType siteType  = SiteType.PC;


    public ResourcePathManger(SiteType siteType) {
         this.siteType = siteType;
    }

    /**
     * 组装首页地址
     * @return
     */
    public ResourcePathManger generateSitePath(){
        if(siteType == SiteType.PC){
            this.path = "/";
        }else {
            this.path = "/";
        }
        return this;
    }

    /**
     * 组装一级类目页面
     * @param category
     * @return
     */
    public ResourcePathManger generateFirstLevelPagePath(Category category){
         if(siteType == SiteType.PC) {
             this.path = "/cate/p/"+category.getId()+".html";
         }else{
             this.path = "/cate/m/"+category.getId()+".html";
         }
         return this;
    }


    /**
     * 组装关键字页(相当于二级类目)
     * @param word
     * @param page
     * @return
     */
    public ResourcePathManger generateKeyWordPagePath(Word word,int page){
        if(siteType == SiteType.PC) {
            this.path = "/kw/p/"+word.getDateString()+"/"+word.getId()+".html";
        }else{
            this.path = "/kw/m"+word.getDateString()+"/"+word.getId()+".html";
        }
        return this;
    }

    /**
     * 组装长尾词聚合页
     * @param word
     * @return
     */
    public ResourcePathManger generateLongWordPagePath(Word word){
        if(siteType == SiteType.PC) {
            this.path = "/w/p/"+word.getDateString()+"/"+word.getId()+".html";
        }else {
            this.path = "/w/m/"+word.getDateString()+"/"+word.getId()+".html";
        }
        return this;
    }

    /**
     * 组装文章页
     * @param article
     * @return
     */
    public ResourcePathManger generateArticlePagePath(Article article){
        if(siteType == SiteType.PC) {
          this.path = "/a/p/"+article.getImportDate()+"/"+article.getId()+".html";
        }else{
          this.path = "/a/m/"+article.getImportDate()+"/"+article.getId()+".html";
        }
        return this;
    }

    /**
     * 组装视频页
     * @param video
     * @return
     */
    public ResourcePathManger generateVideoPagePath(Video video){
        if(siteType == SiteType.PC) {
            this.path = "/video/p/"+video.getImportDate()+"/"+video.getId()+".html";
        }else{
            this.path = "/video/m/"+video.getImportDate()+"/"+video.getId()+".html";
        }
        return this;
    }

    /**
     * 组装
     * @param img
     * @return
     */
    public ResourcePathManger generateImagePagePath(Img img){
        if(siteType == SiteType.PC){
            this.path = "/pic/p/"+img.getImportDate()+"/"+img.getId()+".html";
        }else{
            this.path = "/pic/m/"+img.getImportDate()+"/"+img.getId()+".html";
        }
        return this;
    }

    public String getPath(){
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SiteType getSiteType() {
        return siteType;
    }

    public void setSiteType(SiteType siteType) {
        this.siteType = siteType;
    }
}

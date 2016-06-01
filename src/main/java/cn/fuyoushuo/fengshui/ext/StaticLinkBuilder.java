package cn.fuyoushuo.fengshui.ext;

import cn.fuyoushuo.starworld.constants.SiteType;
import com.fuyoushuo.seores.article.Interface.IArticleService;
import com.fuyoushuo.seores.article.entity.Article;
import com.fuyoushuo.seores.biz.star.Interface.IBizStarService;
import com.fuyoushuo.seores.biz.star.entity.BizStar;
import com.fuyoushuo.seores.category.Interface.ICategoryService;
import com.fuyoushuo.seores.coment.Interface.ICommentService;
import com.fuyoushuo.seores.img.Interface.IImgService;
import com.fuyoushuo.seores.img.entity.Img;
import com.fuyoushuo.seores.site.Interface.ISiteService;
import com.fuyoushuo.seores.site.entity.Site;
import com.fuyoushuo.seores.video.Interface.IVideoService;
import com.fuyoushuo.seores.video.entity.Video;
import com.fuyoushuo.seores.word.Interface.IWordService;
import com.fuyoushuo.seores.word.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by MALIANG on 2016/4/7.
 */
@Component
public class StaticLinkBuilder {

    public static final Logger logger = LogManager.getLogger(StaticLinkBuilder.class);

    //当前线程池引用
    private ExecutorService executor;

    private String domain;

    @Value("${starWord.links.path}")
    private String staticPagePaths;

    //验证当前任务
    private String version;

    @Autowired
    InitStarData initStarData;

    @Autowired
    IBizStarService starService;

    @Autowired
    IArticleService articleService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ICommentService commentService;

    @Autowired
    IImgService imgService;

    @Autowired
    ISiteService siteService;

    @Autowired
    IVideoService videoService;

    @Autowired
    IWordService wordService;


    public Boolean startBuildLink2Disk(SiteType siteType){
        if(siteType == null){
            logger.info("current siteType is null,please try again");
            return false;
        }
        if(executor != null && !executor.isShutdown()){
            logger.info("current thread is running,please wait some minutes!");
            return false;
        }
        if(executor == null){
            executor = Executors.newFixedThreadPool(10);
        }
        version = UUID.randomUUID().toString();
        try{
          Site currentSite = initStarData.getCurrentSite();
        if(siteType == SiteType.PC){
            domain = "http://"+currentSite.getDomain();
        }else{
            domain = "http://"+currentSite.getmDomain();
        }
        Set<Future<Boolean>> futureList = new HashSet<Future<Boolean>>();
        if(siteType != null){
            futureList.add(executor.submit(new MainPageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new starPageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new articlePageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new imagePageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new videoPageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new wordPageUrl(currentSite, siteType)));
            futureList.add(executor.submit(new WriteLinkToDisk()));
        }
        for(Future<Boolean> future : futureList){
             future.get();
        }
          return true;
        }catch (Exception e){
            logger.error("执行产生URL任务失败,msg={}",e);
            return false;
        }finally {
            if(!executor.isShutdown()){
                 executor.shutdown();
                 executor = null;
                 logger.info("任务已经执行完毕");
            }
        }
    }



    private class MainPageUrl implements Callable<Boolean>{

        private SiteType siteType;

        private Site site;

        public MainPageUrl(Site site,SiteType siteType) {
            this.siteType = siteType;
            this.site = site;
        }

        @Override
        public Boolean call() throws Exception {
            String title = site.getName();
            String sitePath = domain;
            if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(sitePath)){
                LinkPathStringQueen.getMyQueen().put(title+"#|#"+sitePath);
            }
            return true;
        }
    }

    private class starPageUrl implements Callable<Boolean>{

        private Site site;

        private SiteType siteType;

        public starPageUrl(Site site,SiteType siteType) {
            this.siteType = siteType;
            this.site = site;
        }

        @Override
        public Boolean call() throws Exception {
            List<BizStar> allStars = starService.findListBy(new BizStar());
            if(!CollectionUtils.isEmpty(allStars)){
                 for(BizStar star : allStars){
                     String title = star.getStarName();
                     String path = "";
                     if(siteType == SiteType.PC){
                         path = domain + "/star/p/"+star.getImportDate()+"/"+star.getId()+".html";
                     }else{
                         path = domain+ "/star/m/"+star.getImportDate()+"/"+star.getId()+".html";
                     }
                     if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(path)){
                        LinkPathStringQueen.getMyQueen().put(title+"#|#"+path);
                     }
                 }
            }
            return true;
        }
    }


    private class articlePageUrl implements Callable<Boolean>{

        private Site site;

        private SiteType siteType;

        public articlePageUrl(Site site, SiteType siteType) {
            this.site = site;
            this.siteType = siteType;
        }

        @Override
        public Boolean call() throws Exception {
            List<Article> articles = articleService.getArticles(site.getId(), null, null, null, null, null, null);
            if(!CollectionUtils.isEmpty(articles)){
                for(Article article : articles){
                    String title = article.getTitle();
                    String path = "";
                    if(siteType == SiteType.PC){
                        path = domain + "/a/p/"+article.getImportDate()+"/"+article.getId()+".html";
                    }else{
                        path = domain+ "/a/m/"+article.getImportDate()+"/"+article.getId()+".html";
                    }
                    if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(path)){
                        LinkPathStringQueen.getMyQueen().put(title+"#|#"+path);
                    }
                }
            }
            return true;
        }
    }

    private class imagePageUrl implements Callable<Boolean> {

        private Site site;

        private SiteType siteType;

        public imagePageUrl(Site site,SiteType siteType) {
            this.siteType = siteType;
            this.site = site;
        }

        @Override
        public Boolean call() throws Exception {
            List<Img> images = imgService.getImages(site.getId(), null, null, null, null, null, null, null);
            if(!CollectionUtils.isEmpty(images)){
                for(Img img : images){
                    //tag
                    Long id = img.getId();
                    String title = img.getTitle();
                    String path = "";
                    if(siteType == SiteType.PC){
                       path = domain + "/pic/p/"+img.getImportDate()+"/"+id+".html";
                    }else{
                       path = domain + "/pic/m/"+img.getImportDate()+"/"+id+".html";
                    }
                    if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(path)){
                        LinkPathStringQueen.getMyQueen().put(title+"#|#"+path);
                    }
                }
            }
            return true;
        }
    }

    private class videoPageUrl implements Callable<Boolean> {

        private Site site;

        private SiteType siteType;

        public videoPageUrl(Site site,SiteType siteType) {
            this.siteType = siteType;
            this.site = site;
        }

        @Override
        public Boolean call() throws Exception {
            List<Video> videos = videoService.getVideos(site.getId(), null, null, null, null, null, null);
            if(!CollectionUtils.isEmpty(videos)){
                for(Video video : videos){
                    //tag
                    Long id = video.getId();
                    String title = video.getTitle();
                    String path = "";
                    if(siteType == SiteType.PC){
                        path = domain + "/video/p/"+video.getImportDate()+"/"+id+".html";
                    }else{
                        path = domain + "/video/m/"+video.getImportDate()+"/"+id+".html";
                    }
                    if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(path)){
                        LinkPathStringQueen.getMyQueen().put(title+"#|#"+path);
                    }
                }
            }
            return true;
        }
    }

    private class wordPageUrl implements Callable<Boolean> {

        private Site site;

        private SiteType siteType;

        public wordPageUrl(Site site,SiteType siteType) {
            this.siteType = siteType;
            this.site = site;
        }

        @Override
        public Boolean call() throws Exception {
            Word param = new Word();
            param.setWordType(1);
            param.setSiteId(site.getId());
            List<Word> longWords = wordService.findListBy(param);
            if(!CollectionUtils.isEmpty(longWords)){
                for(Word word : longWords){
                    //tag
                    Long id = word.getId();
                    String title = word.getWordName();
                    String path = "";
                    if(siteType == SiteType.PC){
                        path = domain + "/w/p/"+word.getDateString()+"/"+id+".html";
                    }else{
                        path = domain + "/w/m/"+word.getDateString()+"/"+id+".html";
                    }
                    if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(path)){
                        LinkPathStringQueen.getMyQueen().put(title+"#|#"+path);
                    }
                }
            }
            return true;
        }
    }



    private class WriteLinkToDisk implements Callable<Boolean>{

        @Override
        public Boolean call() {
            while(true){
                LinkedList<String> links = LinkPathStringQueen.getMyQueen().taskAll();
                if(CollectionUtils.isEmpty(links)){
                    break;
                }
                write2Disk(links);
                links = null;
            }
            return true;
        }
    }

    private void write2Disk(LinkedList<String> list){
        if(CollectionUtils.isEmpty(list) || StringUtils.isEmpty(version)){
            logger.warn("no data...");
            return;
        }
        FileOutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        try{
          String path = staticPagePaths;
          File file = new File(path);
          if(file.exists() && !initStarData.getCurrentUrlCreateVersion().equals(version)){
              if(file.delete()){
                  file.createNewFile();
              }
          }
          if(!file.exists()){
            if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
            file.createNewFile();
          }
          out = new FileOutputStream(file,true);
          writer = new OutputStreamWriter(out,"utf-8");
          bw = new BufferedWriter(writer);
          for(String content : list){
              bw.write(content);
              bw.newLine();
              bw.flush();
          }
          //更新版本号
          initStarData.setCurrentUrlCreateVersion(version);
        }catch (Exception e){
            logger.error("write2Disk error,msg={}",e);
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    logger.error("writer close error,msg={}",e);
                }
            }
        }
    }
}

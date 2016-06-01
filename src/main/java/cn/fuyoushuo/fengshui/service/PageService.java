package cn.fuyoushuo.fengshui.service;

import cn.fuyoushuo.fengshui.ext.InitStarData;
import cn.fuyoushuo.fengshui.utils.CommonUtils;
import cn.fuyoushuo.fengshui.vo.HomePageVo;
import com.fuyoushuo.seores.article.Interface.IArticleService;
import com.fuyoushuo.seores.article.entity.Article;
import com.fuyoushuo.seores.biz.star.Interface.IBizStarService;
import com.fuyoushuo.seores.category.Interface.ICategoryService;
import com.fuyoushuo.seores.coment.Interface.ICommentService;
import com.fuyoushuo.seores.img.Interface.IImgService;
import com.fuyoushuo.seores.site.Interface.ISiteService;
import com.fuyoushuo.seores.site.entity.Site;
import com.fuyoushuo.seores.topic.Interface.ITopicService;
import com.fuyoushuo.seores.video.Interface.IVideoService;
import com.fuyoushuo.seores.word.Interface.IWordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MALIANG on 2016/6/1.
 */
@Service
public class PageService {

    public static final Logger logger = LogManager.getLogger(PageService.class);

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

    @Autowired
    ITopicService topicService;

    //产生首页数据
    public HomePageVo buildHomePage(){
        Site currentSite = initStarData.getCurrentSite();
        Long siteId = currentSite.getId();
        HomePageVo homePageVo = new HomePageVo();
        List<Article> totalArtis = articleService.getArtiGroupByWordRandom(siteId, null, null, null, 19);
        List<List<Article>> itemsList = CommonUtils.getItemsList(totalArtis, "10:9");
        List<Article> recommendArtis = itemsList.get(0);
        List<Article> hotArtis = itemsList.get(1);




        return homePageVo;
    }




}

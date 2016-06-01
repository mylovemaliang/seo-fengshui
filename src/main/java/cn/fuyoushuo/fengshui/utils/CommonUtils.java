package cn.fuyoushuo.fengshui.utils;

import cn.fuyoushuo.fengshui.ext.InitStarData;
import cn.fuyoushuo.fengshui.ext.ResourcePathManger;
import cn.fuyoushuo.fengshui.vo.link.*;
import com.fuyoushuo.seores.article.entity.Article;
import com.fuyoushuo.seores.biz.star.entity.BizStar;
import com.fuyoushuo.seores.category.entity.Category;
import com.fuyoushuo.seores.coment.entity.Comment;
import com.fuyoushuo.seores.img.Interface.IImgService;
import com.fuyoushuo.seores.img.entity.Img;
import com.fuyoushuo.seores.topic.entity.Topic;
import com.fuyoushuo.seores.video.entity.Video;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by MALIANG on 2016/4/7.
 */
public class CommonUtils {

    public static final InitStarData INIT_STAR_DATA = SpringBeanUtil.getBean(InitStarData.class);

    public static final IImgService IMG_SERVICE = (IImgService) SpringBeanUtil.getBean("imgService");

    /**
     * 获取随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandomInt(int min,int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }

    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     * @param set 随机数结果集
     */
    public static void randomSet(int min, int max, int n,int total, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = random.nextInt(max)%(max-min+1) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < total) {
            randomSet(min, max,total-setSize,total,set);// 递归
        }
        return;
    }

    //对文章内容进行内链替换
//    public static void handlerArticleContent(Article starArticle){
//        if(starArticle == null) return;
//        String content = starArticle.getDetailContent();
//        if(StringUtils.isEmpty(content)) return;
//        Collection<BizStar> stars = INIT_STAR_DATA.getStars();
//        for(BizStar star : stars){
//        	content = replaceStarNameForArticle(content, star, 0);
//            //content=content.replaceFirst("(?<=<p[^>]{0,100}?>[^<]{0,1000})("+star.getStarName()+")(?=[^>]{0,1000}</p>)","<a href='/stardetail/"+star.getId()+".html'><strong>"+star.getStarName()+"</strong></a>");
//        }
//        starArticle.setDetailContent(content);
//    }

    //对文章内容组装成热点
    public static List<Topic> transArtisToTopics(List<Article> articles){
        if(CollectionUtils.isEmpty(articles)) return null;
        List<Topic> topics = new ArrayList<Topic>();
        for(Article article : articles){
            Topic topic = new Topic();
            topic.setId(article.getId());
            topic.setTitle(article.getTitle());
            topic.setContent(article.getDescription());
            topic.setDatePublished(article.getDatePublished());
            topic.setImportDate(article.getImportDate());
            topics.add(topic);
        }
        return topics;
    }

    //为文章找到长尾词对应的图片
    public static void addArticlesImgs(List<Article> articles){
       if(CollectionUtils.isEmpty(articles)) return;
       for(Article article:articles){
           Long longWordId = article.getLongWordId();
           if(longWordId == null) continue;
           List<Img> images = IMG_SERVICE.getImages(1l, null, longWordId, null, null, 1, true, null);
           article.setRelatedImg(CollectionUtils.isEmpty(images) ? null : images.get(0));
       }
    }

    public static String replaceStarNameForArticle(String htmlContent, BizStar star, int fromIndex){
        int leftIndex = htmlContent.indexOf(">", fromIndex);
        if(leftIndex>0){
            int rightIndex = htmlContent.indexOf("<", leftIndex+1);
            if(rightIndex>0){
                if(rightIndex>(leftIndex+1)){
                    String subContent = htmlContent.substring(leftIndex+1, rightIndex);

                    int indexName = subContent.indexOf(star.getStarName());
                    if(indexName>=0){
                        subContent = subContent.substring(0, indexName) + "<a href='/star/p/"+star.getImportDate()+"/"+star.getId()+".html' target='_blank'><strong>"+star.getStarName()+"</strong></a>" + subContent.substring(indexName+star.getStarName().length(), subContent.length());

                        htmlContent = htmlContent.substring(0, leftIndex+1) + subContent + htmlContent.substring(rightIndex);

                        return htmlContent;
                    }else{
                        return replaceStarNameForArticle(htmlContent, star, rightIndex+1);
                    }
                }else{
                    return replaceStarNameForArticle(htmlContent, star, rightIndex+1);
                }
            }else{
                return htmlContent;
            }
        }else{
            return htmlContent;
        }
    }

    /**
     * 根据比例切割数组
     * @param total 开始数组
     * @param cutRegex 切割比例,如4:3:2
     * @return
     */
    public static <T> List<List<T>> getItemsList(List<T> total,String cutRegex){
         List<List<T>> resultList = new ArrayList<List<T>>();
         if(StringUtils.isEmpty(cutRegex)){
             return resultList;
         }
         String[] split = cutRegex.split(":");
         if(CollectionUtils.isEmpty(total)){
             for(String item : split){
                 List<T> items = new ArrayList<T>();
                 resultList.add(items);
             }
             return resultList;
         }
        LinkedList<Integer> cutInts = new LinkedList<Integer>();
        int size = split.length;
        int totalElementsNum = total.size();
        int totalCutNum = 0;
        for(int i=0;i<size;i++){
            int count = Integer.parseInt(split[i]);
            totalCutNum += count;
            cutInts.add(count);
        }
        int startIndex = 0;
        for(int j=0;j<size;j++){
            if(cutInts.size() == 1){
                resultList.add(total.subList(startIndex,totalElementsNum));
                break;
            }
            Integer thisCut = cutInts.removeLast();
            int currentNum = totalElementsNum*thisCut/totalCutNum == 0 ? 1 : totalElementsNum* thisCut /totalCutNum;
            List subList = total.subList(startIndex, startIndex + currentNum);
            resultList.add(subList);
            startIndex = startIndex + currentNum;
        }
        return resultList;
    }

    public static List<ArticleLink> transArticleToLink(ResourcePathManger resourcePathManger,List<Article> articles){
        List<ArticleLink> links = new ArrayList<ArticleLink>();
        if(CollectionUtils.isEmpty(articles)){
            return links;
        }

        return links;
    }


    public static List<FirstLevelLink> transFirstLevelCatesToLinks(ResourcePathManger resourcePathManger,List<Category> categories){
        if(CollectionUtils.isEmpty(categories)){
            return null;
        }
        List<FirstLevelLink> firstLevelLinks = new ArrayList<FirstLevelLink>();
        for(Category category : categories){

        }

        return firstLevelLinks;
    }

    /**
     * 组装二级类目链接
     * @param categories
     * @return
     */
    public static List<SecondLevelLink> transSecondLevelCatesToLinks(ResourcePathManger resourcePathManger,List<Category> categories){
        if(CollectionUtils.isEmpty(categories)){
            return null;
        }
        List<SecondLevelLink> secondLevelLinks = new ArrayList<SecondLevelLink>();
        for(Category category : categories){

        }
        return secondLevelLinks;
    }

    /**
     * 转化评论为LINK形式
     * @param comments
     * @return
     */
    public static List<CommentLink> transCommentsToLinks(List<Comment> comments){
        List<CommentLink> commentLinks = new ArrayList<CommentLink>();
        if(!CollectionUtils.isEmpty(comments)){
            for(Comment comment : comments){

            }
        }
        return commentLinks;
    }


    public static List<ImageLink> transImagesToLinks(List<Img> images){
        List<ImageLink> imageLinks = new ArrayList<ImageLink>();
        if(!CollectionUtils.isEmpty(images)){
            for(Img image : images){
                ImageLink imageLink = new ImageLink();
                imageLink.setName(image.getTitle());
                imageLink.setResourcePath(image.getImgUrl());
                imageLinks.add(imageLink);
            }
        }
        return imageLinks;
    }

    public static List<VideoLink> transVideosToLinks(List<Video> videos){
        List<VideoLink> videoLinks = new ArrayList<VideoLink>();
        if(!CollectionUtils.isEmpty(videos)){
            for(Video video : videos){
                VideoLink videoLink = new VideoLink();
                videoLink.setName(video.getTitle());
                videoLink.setResourcePath(video.getUrl());
                videoLinks.add(videoLink);
            }
        }
        return videoLinks;
    }




}

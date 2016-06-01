package cn.fuyoushuo.fengshui.ext;

import cn.fuyoushuo.starworld.entity.dto.SearchLink;
import cn.fuyoushuo.starworld.entity.dto.StarSearchDto;
import cn.fuyoushuo.starworld.utils.BeanToMapUtil;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by MALIANG on 2016/5/19.
 */
public class SearchConditonMap {

    private static Map<String, List<String>> conditionMap = new LinkedHashMap<String, List<String>>();

    private final static String urlTemplate = "/star_search/%sex%-%birthPlace%-%job%-%constellation%-%zodiac%-1.html";

    static {
        String sex = "sex";
        List<String> sexSet = Arrays.asList("男", "女");

        String birthPlace = "birthPlace";
        List<String> birthPlaceSet = Arrays.asList("内地", "香港", "台湾", "美国", "日本", "韩国", "英国", "法国", "加拿大", "意大利", "德国", "新加坡");

        String job = "job";
        List<String> jobSet = Arrays.asList("演员", "歌手", "导演", "模特", "主持人", "监制", "编剧", "作家", "作词家", "作曲家", "音乐家");

        String constellation = "constellation";
        List<String> constellationSet = Arrays.asList("水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天枰座", "天蝎座", "射手座", "魔蝎座");

        String zodiac = "zodiac";
        List<String> zodiacSet = Arrays.asList("鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪");

        conditionMap.put(sex, sexSet);
        conditionMap.put(birthPlace, birthPlaceSet);
        conditionMap.put(job, jobSet);
        conditionMap.put(constellation, constellationSet);
        conditionMap.put(zodiac, zodiacSet);
    }


    public static Map<String,List<SearchLink>> getSearchLinks(StarSearchDto dto){
        Map<String,String> paramMap;
        try{
             if(dto==null || dto.isAllEmpty()){
                 paramMap = BeanToMapUtil.convertBean(new StarSearchDto());
             }else{
                 paramMap = BeanToMapUtil.convertBean(dto);
             }
             Map<String,List<SearchLink>> resultMap = new LinkedHashMap<String,List<SearchLink>>();
             for(Map.Entry<String,List<String>> entry : conditionMap.entrySet()){
                   String key = entry.getKey();
                   List<String> values = entry.getValue();
                   List<SearchLink> links = new ArrayList<SearchLink>();
                   for(String item : values){
                     SearchLink searchLink = createSearchLink(paramMap, key, item);
                     links.add(searchLink);
                   }
                   resultMap.put(key,links);
             }
             return resultMap;
        }catch (Exception e){
               e.printStackTrace();
        }
        return null;
    }

    private static SearchLink createSearchLink(Map<String,String> paramMap,String key,String value){
        String url = urlTemplate;
        if(!value.equals(paramMap.get("key"))){
             url = url.replace("%"+key+"%",value);
        }
        Set<Map.Entry<String, String>> entries = paramMap.entrySet();
        for(Map.Entry<String, String> entry : entries){
            String itemKey = entry.getKey();
            if("allEmpty".equals(itemKey)) continue;
            String itemValue = entry.getValue();
            if(itemKey.equals(key)) continue;
            if(StringUtils.isEmpty(itemValue)){
                itemValue = "0";
            }
            url = url.replace("%"+itemKey+"%",itemValue);
        }
        return new SearchLink(value,url);
    }

    public static void main(String[] args) {
        Map<String, List<SearchLink>> searchLinks = SearchConditonMap.getSearchLinks(new StarSearchDto());
        System.out.println("success");
    }

}
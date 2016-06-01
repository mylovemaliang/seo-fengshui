package cn.fuyoushuo.fengshui.vo.link;


import cn.fuyoushuo.fengshui.constant.LinkType;

/**
 * Created by MALIANG on 2016/1/5.
 */
public class WordLink extends ResourceLink {

     public WordLink() {
          super(LinkType.tagLink);
     }

     public WordLink bind(String name,String resourcePath){
          super.setName(name);
          super.setResourcePath(resourcePath);
          return this;
     }
}

package cn.fuyoushuo.fengshui.constant;

/**
 * Created by MALIANG on 2016/1/4.
 */
public enum LinkType {

    firstLevelLink(1,"一级链接"),

    secondLevelLink(2,"二级链接"),

    articleLink(3,"文章链接"),

    tagLink(4,"tag链接"),

    imgLink(5,"图片标签"),

    videoLink(6,"视频标签"),

    pageLink(7,"分页链接");

    private int code;

    private String desc;

    private LinkType(int code, String desc) {
        this.code= code;
        this.desc = desc;
    }
}

package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.fengshui.constant.SiteType;
import com.fuyoushuo.seores.site.entity.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by MALIANG on 2016/1/13.
 */
public class BasePageVo {

    public static final Logger logger = LogManager.getLogger(BasePageVo.class);

    private Site currentSite;

    private String countCode;

    private String seoTitle;

    private String seoKeyword;

    private String seoDesc;

    private String selfMLink;

    private String selfLink;

    private SiteType siteType;

    public Site getCurrentSite() {
        return currentSite;
    }

    public void setCurrentSite(Site currentSite) {
        this.currentSite = currentSite;
    }

    public String getCountCode() {
        return countCode;
    }

    public void setCountCode(String countCode) {
        this.countCode = countCode;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public String getSeoDesc() {
        return seoDesc;
    }

    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc;
    }

    public String getSelfMLink() {
        return selfMLink;
    }

    public void setSelfMLink(String selfMLink) {
        this.selfMLink = selfMLink;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public SiteType getSiteType() {
        return siteType;
    }

    public void setSiteType(SiteType siteType) {
        this.siteType = siteType;
    }
}

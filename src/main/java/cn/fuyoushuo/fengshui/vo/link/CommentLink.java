package cn.fuyoushuo.fengshui.vo.link;

/**
 * Created by mike ma on 2016/1/9.
 */
public class CommentLink {

    private String nickName;

    private String content;

    /**
     * 对应相对应的时间字符串
     */
    private String formatDate;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
}

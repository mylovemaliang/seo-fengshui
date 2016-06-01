package cn.fuyoushuo.fengshui.vo;

import cn.fuyoushuo.sitegroup.basic.ContentDesc;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by MALIANG on 2015/12/28.
 */
public class PageVo<T> implements Serializable{

    private Long total;

    private List<T> elements;

    private JSONArray columns;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public PageVo(Long total, List<T> elements) {
        this.total = total;
        this.elements = elements;
    }

    public PageVo bindEntityForGrid(Class cls){
        JSONArray array = new JSONArray();
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields) {
            ContentDesc contentDesc = field.getAnnotation(ContentDesc.class);
            if(contentDesc != null && contentDesc.isShow()){
                JSONObject object = new JSONObject();
                object.put("field",contentDesc.field());
                object.put("title",contentDesc.title());
                object.put("width",contentDesc.width());
                array.add(object);
            }
        }
        this.setColumns(array);
        return this;
    }


    public JSONArray getColumns() {
        return columns;
    }

    public void setColumns(JSONArray columns) {
        this.columns = columns;
    }
}

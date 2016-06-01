package cn.fuyoushuo.fengshui.constant;

/**
 * Created by MALIANG on 2016/1/19.
 */
public enum SiteType {


    M(1,"移动端"),

    PC(2,"pc端");

    private int typeCode;

    private String typeDesc;

    SiteType(int typeCode, String typeDesc) {
        this.typeCode = typeCode;
        this.typeDesc = typeDesc;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public static SiteType getTypeByCode(Integer typeCode){
        if(typeCode == null){
            return null;
        }
        for(SiteType siteType : values()){
           if(siteType.getTypeCode() == typeCode){
               return siteType;
           }
        }
        return null;
    }
}

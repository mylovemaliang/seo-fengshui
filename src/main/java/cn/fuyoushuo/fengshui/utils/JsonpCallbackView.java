package cn.fuyoushuo.fengshui.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author 尹正飞
 * @Email zhengfei.yin@b5m.com
 * @Version 2013-6-19 下午1:04:53
 **/

public class JsonpCallbackView {
	public static ModelAndView Render(Object obj, String jsonpCallback, HttpServletResponse response) {
		PrintWriter out = null ;
		try {
			StringBuffer jsonp = new StringBuffer();
			if(StringUtils.isBlank(jsonpCallback)){
				jsonp.append(JsonUtil.Object2JsonStr(obj));
				response.setContentType("application/json");
			}else{
				jsonp.append(jsonpCallback + "(" +JsonUtil.Object2JsonStr(obj) + ")");
				response.setContentType("application/javascript");
			}
			response.setCharacterEncoding("utf-8");
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher m = p.matcher(jsonp.toString());
			StringBuffer res = new StringBuffer();
			while(m.find()){
				m.appendReplacement(res, "\\"+toUnicode(m.group()));
			}
			m.appendTail(res);
			
			out = response.getWriter() ;		
			out.write(res.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != out)
				out.close();
		}

		return null;
	}
	
	public static ModelAndView Render1(Object obj, String jsonpCallback, HttpServletResponse response) {
		PrintWriter out = null ;
		try {
			StringBuffer jsonp = new StringBuffer();
			if(StringUtils.isBlank(jsonpCallback)){
				jsonp.append(obj.toString());
				response.setContentType("application/json");
			}else{
				jsonp.append(jsonpCallback + "(" +obj.toString() + ")");
				response.setContentType("application/javascript");
			}
			response.setCharacterEncoding("utf-8");
			out = response.getWriter() ;		
			out.write(jsonp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != out)
				out.close();
		}

		return null;
	}
	
	private static String toUnicode(String str){
        char[]arChar=str.toCharArray();
        int iValue=0;
        String uStr="";
        for(int i=0;i<arChar.length;i++){
            iValue=(int)str.charAt(i);          
            if(iValue<=256){
                uStr+="\\"+Integer.toHexString(iValue);
            }else{
                uStr+="\\u"+Integer.toHexString(iValue);
            }
        }
        return uStr;
    }
}

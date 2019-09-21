package LemonHouse.utils;

import com.alibaba.fastjson.JSONArray;

public class LemonUtil {

    public static boolean isBlank(String str){
        return str == null?true:str.length()==0?true:false;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static String groupString(JSONArray array){
        StringBuffer stringBuffer = new StringBuffer();
        if (array != null) {
            String index= "";
            for(int i = 0;i<array.size();i++){
                String src = array.getString(i);
                stringBuffer.append(index.concat(src));
                index = ",";
            }
        }
        return stringBuffer.toString();
    }
}

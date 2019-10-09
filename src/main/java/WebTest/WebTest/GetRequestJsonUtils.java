package WebTest.WebTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.alibaba.fastjson.JSON;


 
 
/**      
 * request 对象的相关操作
 * @author zhangtengda        
 * @version 1.0      
 * @created 2015年5月2日 下午8:25:43     
 */       
public class GetRequestJsonUtils {
 
    /***
     * 获取 request 中 json 字符串的内容
     * 
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
        // POST
        } else {
            return getRequestPostStr(request);
        }
    }
 
    /**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
 
            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
 
    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
    
    public static String stringToJson(String str) {
        try {
            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
            System.out.println(jsonObj.toJSONString() + "\n" + jsonObj.getClass());
            return jsonObj.toJSONString();
            
  
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Map stringToJsonMap(String str) {
        try {
            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
            System.out.println(jsonObj.toJSONString() + "\n" + jsonObj.getClass());
            return jsonObj;
            
  
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
  //读取请求传递过来的JSON格式数据，返回JSON字符串
    public static String readJSONData(HttpServletRequest request) {
            StringBuffer json=new StringBuffer();
            String lineString=null;
            try {
                BufferedReader reader=request.getReader();
                while ((lineString=reader.readLine())!=null) {
                    json.append(lineString);                
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return json.toString();
    }

    public static Map jsonStringToMap(String str) {
    	  
        //第一种方式  
        Map maps = (Map)JSON.parse(str);  
        System.out.println("这个是用JSON类来解析JSON字符串!!!");  
        for (Object map : maps.entrySet()){  
            System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());  
        }  
        return maps;
//        //第二种方式  
//        Map mapTypes = JSON.parseObject(str);  
//        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");  
//        for (Object obj : mapTypes.keySet()){  
//            System.out.println("key为："+obj+"值为："+mapTypes.get(obj));  
//        }  
//        //第三种方式  
//        Map mapType = JSON.parseObject(str,Map.class);  
//        System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");  
//        for (Object obj : mapType.keySet()){  
//            System.out.println("key为："+obj+"值为："+mapType.get(obj));  
//        }  
//        //第四种方式  
//        /** 
//         * JSONObject是Map接口的一个实现类 
//         */  
//        Map json = (Map) JSONObject.parse(str);  
//        System.out.println("这个是用JSONObject类的parse方法来解析JSON字符串!!!");  
//        for (Object map : json.entrySet()){  
//            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());  
//        }  
//        //第五种方式  
//        /** 
//         * JSONObject是Map接口的一个实现类 
//         */  
//        JSONObject jsonObject = JSONObject.parseObject(str);  
//        System.out.println("这个是用JSONObject的parseObject方法来解析JSON字符串!!!");  
//        for (Object map : json.entrySet()){  
//            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());  
//        }  
//        //第六种方式  
//        /** 
//         * JSONObject是Map接口的一个实现类 
//         */  
//        Map mapObj = JSONObject.parseObject(str,Map.class);  
//        System.out.println("这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!");  
//        for (Object map: json.entrySet()){  
//            System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());  
//        }  
//        String strArr = "{{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +  
//                "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}}";  
//       // JSONArray.parse()  
//        System.out.println(json);  
    }
 
}

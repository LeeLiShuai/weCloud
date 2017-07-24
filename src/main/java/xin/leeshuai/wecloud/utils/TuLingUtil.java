package xin.leeshuai.wecloud.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import com.alibaba.fastjson.JSON;

import xin.leeshuai.wecloud.entity.TuLingMessage;

/** 
* @author leeshuai 
* @date 2017年7月23日  
* @description   图灵机器人工具类，将请求信息转发到图灵服务器，并接受图灵服务器返回的数据。
*/
public class TuLingUtil {
    private static  String APIKEY;
    static{  
    	 Properties prop = new Properties();          
         try { 
        	 //读取配置文件里的信息
             prop.load(TuLingUtil.class.getClassLoader().getResourceAsStream("conf/tuling.properties")); 
             APIKEY = prop.getProperty("key");              
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
	}
	/**
	 * @description   获取图灵服务器返回的结果
	 * @param     将请求消息封装后的图灵消息
	 * @return     图灵服务器返回的图灵消息的内容
	 */
	public static String getTuLingResult(TuLingMessage tuLingMessage){
		 BufferedReader in = null;  
		 //设置url地址
		 String  path="http://www.tuling123.com/openapi/api?key="+APIKEY
					+"&info="+tuLingMessage.getText()
					+"&userid="+tuLingMessage.getUserid();
         StringBuilder result = new StringBuilder(); 
         try {
             URL url = new URL(path);
             //新建http连接
             HttpURLConnection conn = (HttpURLConnection)url.openConnection();
             //设置连接方式为get
             conn.setRequestMethod("GET");
             //不开启输出
             conn.setDoOutput(false);
             //开启输入
             conn.setDoInput(true);
             //打开连接
             conn.connect();  
             in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
             String line;
             //拼接结果
             while ((line = in.readLine()) != null) {
                 result.append(line);
             }     
             //新建一个对象接受返回结果
             TuLingMessage tuLingResult=JSON.parseObject(result.toString(),TuLingMessage.class);
             //返回结果的内容
             return tuLingResult.getText();
         } catch (Exception e) {
             e.printStackTrace();
         }
         finally{
             try{
                 if(in!=null){
                     in.close();
                 }
             }
             catch(IOException ex){
                 ex.printStackTrace();
             }
         }
		return null;
	}
    
}
 
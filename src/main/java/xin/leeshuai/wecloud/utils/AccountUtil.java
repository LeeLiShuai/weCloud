package xin.leeshuai.wecloud.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @description 微信账号信息工具类
 * @date 2017年7月20日
 * @author leeshuai
 */
public class AccountUtil {
     private  String appID;
     private  String appsecret;
     private static final AccountUtil instance=new AccountUtil();
 
     /**
      * @description 私有的构造函数，不能再其他类中创建。
      * 单例模式创建并通过static final的instance返回账号信息
      * Properties读取配置文件，为appID和appsecret赋值
      * @param 
      * @return
      */
     private AccountUtil()
     {
    	 Properties prop = new Properties();          
         try { 
             prop.load(AccountUtil.class.getClassLoader().getResourceAsStream("conf/wecloud.properties")); 
             appID = prop.getProperty("appID").trim(); 
             appsecret = prop.getProperty("appsecret").trim(); 
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
     }
     /**
      * @description 返回微信账号id,通过instance获取appID
      * @param 
      * @return appID
      */
     public static String getAppID()
     {
    	 return instance.appID;
     }
     /**
      * @description 返回微信账号密码，通过instance获取appsecret
      * @param 
      * @return  appsecret
      */
     public static String getAppsecret()
     {
    	 return instance.appsecret;
     }
     public static void main(String[] args) {
		System.out.println(instance.appID);
	}

}

package xin.leeshuai.wecloud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.leeshuai.wecloud.service.CoreService;
import xin.leeshuai.wecloud.utils.CheckUtil;

/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description  微信服务核心controller，校验和消息发送接收都是通过此controller
*/
@Controller
@RequestMapping("core")
public class CoreController {
		@Autowired
		private	CoreService coreService;
		@RequestMapping(method = RequestMethod.GET) 
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{  
	       		// 微信加密签名  
	            String signature = request.getParameter("signature"); 
	            // 时间戳  
	            String timestamp = request.getParameter("timestamp");  
	            // 随机数  
	            String nonce = request.getParameter("nonce");  
	            // 随机字符串  
	            String echostr = request.getParameter("echostr");  	  
	            PrintWriter out = response.getWriter();  
	            // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
	            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {  
	                out.print(echostr); 
	            }  
	            out.close();  
	            out = null;  
	    }  
	    @RequestMapping(method = RequestMethod.POST)   
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception  
	    {  
	    	   request.setCharacterEncoding("UTF-8");
			   response.setCharacterEncoding("UTF-8");
			   String signature = request.getParameter("signature");
		       String timestamp = request.getParameter("timestamp");
		       String nonce = request.getParameter("nonce");
		       PrintWriter out=response.getWriter();
		       if(CheckUtil.checkSignature(signature, timestamp, nonce))
		       {
		    	   String respXml=coreService.processRequest(request);
		    	   System.out.println(respXml);
		    	   out.print(respXml);
		       }
		       out.close();
		       out=null;        
	    } 
}
 
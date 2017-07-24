package xin.leeshuai.wecloud.service;

import java.util.Date;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.leeshuai.wecloud.entity.TuLingMessage;
import xin.leeshuai.wecloud.entity.message.response.TextMessage;
import xin.leeshuai.wecloud.utils.MessageUtil;
import xin.leeshuai.wecloud.utils.TuLingUtil;

/** 
* @author leeshuai 
* @date 2017年7月22日  
* @description   解析微信服务器发送过来的请求，并处理
*/
@Service
public class CoreService {
	@Autowired
	private TuLingMessage tuLingMessage;
	public String processRequest(HttpServletRequest request){
		//返回的XML格式的消息数据
		String respXml=null;
		//默认的返回的文本内容
		String respContent="未知消息类型！";
		try {
			//调用消息工具类的请求转化为XML的方法
			Map<String , String > requestMap=MessageUtil.parseXml(request);		
			//请求消息的发送者，即用户
			String formUserName=requestMap.get("FromUserName");
			//请求消息的接受者，即开发者微信号
			String toUserName=requestMap.get("ToUserName");
			//请求消息类型
			String msgType=requestMap.get("MsgType");
			//新建响应消息
			TextMessage textMessage=new TextMessage();
			//响应消息的的发送者是请求消息的接受者
			textMessage.setFromUserName(toUserName);
			//响应消息的接受者是请求消息的发送者
			textMessage.setToUserName(formUserName);
			//响应消息的创建时间
			textMessage.setCreateTime(new Date().getTime());
			//响应消息的类型设为文本类型
			textMessage.setMsgType(MessageUtil.RES_MESSAGE_TYPE_TEXT);
			System.out.println(requestMap);
			if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT))
			{  
				//获取请求消息里的文本内容
				String messageContent=requestMap.get("Content");
				//将文本内容传递给图灵消息
				tuLingMessage.setText(messageContent);
				//发送者设置为图灵信息的id
				tuLingMessage.setUserid(formUserName);
				//获取图灵服务器返回的文本，并设置为回复内容
				respContent = TuLingUtil.getTuLingResult(tuLingMessage);
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE))
			{
				respContent="图片消息";
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE))
			{
				//获取语音翻译后的文本内容
			    String recognition=requestMap.get("recognition");
			    //下列操作同文本信息一样
			    tuLingMessage.setText(recognition);
			    tuLingMessage.setUserid(formUserName);
			    respContent = TuLingUtil.getTuLingResult(tuLingMessage);
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO))
			{
				respContent="视频消息";
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION))
			{
				respContent="位置消息";
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK))
			{
				respContent="链接消息";
			}
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT))
			{
				String eventType=requestMap.get("Event");
				//关注事件
				if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE))
				{
					respContent="欢迎关注，你可以发送语音或者文字跟我聊天，也可以点击下面的“个人云相册”上传您的图片。";
				}
				//取消关注事件，什么都不能做
				else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE))
				{
					
				}
				//
				else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN))
				{
					
				}
				//
				else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION))
				{
					
				}
				//
				else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK))
				{
					
				}
			}
				//设置文本消息的内容
				textMessage.setContent(respContent);
				//将响应消息转化为XML格式
				respXml=MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
 
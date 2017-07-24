package xin.leeshuai.wecloud.entity;

import org.springframework.stereotype.Component;

/** 
* @author leeshuai 
* @date 2017年7月23日  
* @description   图灵机器人消息类,用于获取自动回复内容
*/
@Component
public class TuLingMessage {
	   //消息内容
	   private String text;
	   //发送消息者id
	   private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
 
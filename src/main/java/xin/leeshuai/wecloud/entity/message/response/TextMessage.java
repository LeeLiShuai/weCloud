package xin.leeshuai.wecloud.entity.message.response; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   响应文本信息类
*/
public class TextMessage extends BaseMessage {
	//消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
 
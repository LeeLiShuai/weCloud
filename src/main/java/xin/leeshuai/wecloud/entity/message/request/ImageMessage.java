package xin.leeshuai.wecloud.entity.message.request; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   请求图片消息类
*/
public class ImageMessage extends BaseMessage{
	//图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
 
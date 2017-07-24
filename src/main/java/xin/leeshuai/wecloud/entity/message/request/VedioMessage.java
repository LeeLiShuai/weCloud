package xin.leeshuai.wecloud.entity.message.request; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   请求视频消息类
*/
public class VedioMessage {
	//视频消息媒体ID
	private String MediaId;
	//视频消息缩略图的媒体ID
	private String ThumbMediaId;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
 
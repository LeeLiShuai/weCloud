package xin.leeshuai.wecloud.entity.message.request; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   请求语音消息类
*/
public class VoiceMessage extends BaseMessage{
	//媒体ID
	private String MediaId;
	//语音格式
	private String Format;
	//语音识别结果，utf-8编码
	private String Recognition;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
 
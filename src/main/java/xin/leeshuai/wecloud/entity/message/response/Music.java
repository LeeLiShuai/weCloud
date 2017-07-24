package xin.leeshuai.wecloud.entity.message.response; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description  音乐类，给响应音乐消息类调用  
*/
public class Music {
	//音乐标题
	private String Title;
	//描述
	private String Description;
	//音乐链接
	private String MusicUrl;
	//高质量音乐链接，wifi环境优先使用该链接播放音乐
	private String HQMusicUrl;
	//缩略图的媒体ID，用过上传多媒体文件得到的ID
	private String ThumbMediaId;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
 
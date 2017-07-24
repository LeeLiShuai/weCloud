package xin.leeshuai.wecloud.entity.message.response; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   图文类，给新闻消息类调用
*/
public class Article {
	//图文消息名称
	private String Title;
	//图文消息描述
	private String Description;
	//图片链接，支持JPG，PNG格式大图640*320，小图80*80
	private String PicUrl;
	//点击图文消息跳转链接
	private String Url;
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
	public String getPicUrl() {
		return null == PicUrl ? "" :PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return null==Url ? "" : Url ;
	}
	public void setUrl(String url) {
		Url = url;
	}

}
 
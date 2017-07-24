package xin.leeshuai.wecloud.entity.message.response; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   响应图片信息类
*/
public class ImageMessage extends BaseMessage {
	//图片
	private Image  image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
 
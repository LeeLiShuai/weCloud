package xin.leeshuai.wecloud.entity.message.request;

/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   请求位置消息类
*/
public class LocationMessage extends BaseMessage{
	//地理位置维度
	 private String Location_X;
	 //地理位置经度
	 private String Location_Y;
	 //地图缩放大小
	 private String Svale;
	 //地理位置信息
	 private String Label;
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getSvale() {
		return Svale;
	}
	public void setSvale(String svale) {
		Svale = svale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
}
 
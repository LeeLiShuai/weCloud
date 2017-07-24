package xin.leeshuai.wecloud.entity.message.event; 
/** 
* @author leeshuai 
* @date 2017年7月21日  
* @description   扫描二维码事件
*/
public class QRCodeEvent extends BaseEvent {
	//事件KEY值
	private String EventKey;
	//用于换区二维码图片
	private String Ticket;
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
 
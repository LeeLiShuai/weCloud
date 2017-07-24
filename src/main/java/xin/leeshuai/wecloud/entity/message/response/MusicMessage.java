package xin.leeshuai.wecloud.entity.message.response; 
/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description  响应音乐消息类 
*/
public class MusicMessage extends BaseMessage {
	//音乐
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
 
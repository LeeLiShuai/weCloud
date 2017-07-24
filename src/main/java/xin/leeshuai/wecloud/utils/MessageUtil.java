package xin.leeshuai.wecloud.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import xin.leeshuai.wecloud.entity.message.response.Article;
import xin.leeshuai.wecloud.entity.message.response.ImageMessage;
import xin.leeshuai.wecloud.entity.message.response.MusicMessage;
import xin.leeshuai.wecloud.entity.message.response.NewsMessage;
import xin.leeshuai.wecloud.entity.message.response.TextMessage;
import xin.leeshuai.wecloud.entity.message.response.VideoMessage;
import xin.leeshuai.wecloud.entity.message.response.VoiceMessage;


/** 
* @author leeshuai 
* @date 2017年7月21日  
* @description   封装消息处理工具类，解析请求消息将相应消息转为xml
*/
public class MessageUtil {
	public static final String REQ_MESSAGE_TYPE_TEXT="text";
	public static final String REQ_MESSAGE_TYPE_IMAGE="image";
	public static final String REQ_MESSAGE_TYPE_VOICE="voice";
	public static final String REQ_MESSAGE_TYPE_VIDEO="video";
	public static final String REQ_MESSAGE_TYPE_LOCATION="location";
	public static final String REQ_MESSAGE_TYPE_LINK="link";
	public static final String REQ_MESSAGE_TYPE_EVENT="event";
	public static final String EVENT_TYPE_SUBSCRIBE="subscribe";
	public static final String EVENT_TYPE_UNSUBSCRIBE="unsubscribe";
	public static final String EVENT_TYPE_SCAN="scan";
	public static final String EVENT_TYPE_LOCATION="LOCATION";
	public static final String EVENT_TYPE_CLICK="CLICK";
	public static final String RES_MESSAGE_TYPE_TEXT="text";
	public static final String RES_MESSAGE_TYPE_IMAGE="image";
	public static final String RES_MESSAGE_TYPE_VOICE="voice";
	public static final String RES_MESSAGE_TYPE_VIDEO="video";
	public static final String RES_MESSAGE_TYPE_MUSIC="music";
	public static final String RES_MESSAGE_TYPE_NEWS="news";
	/***
	 * 解析微信发出的请求
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String , String > parseXml(HttpServletRequest request) throws IOException, DocumentException
	{
		//结果保存在hashmap中。
		Map<String , String> map=new HashMap<String,String>();
		//从request中获取输入流
		InputStream inputStream=request.getInputStream();
		//读取输入流
		SAXReader reader=new SAXReader();
		Document document=reader.read(inputStream);
		//根元素
		Element root=document.getRootElement();
		//所有子节点
		List<Element> elementList=root.elements();
		//遍历子节点
		for(Element e:elementList)
		{
			//将自己节点储存到hashmap中
			map.put(e.getName(), e.getText());
		}
		//关闭输入流
		inputStream.close();
		inputStream=null;
		//返回hashmap 
		return map;
	}
	//拓展xstream使其支持CDATA
	private static XStream xStream=new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){
				boolean cdata=true;
				public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz)
				{
					super.startNode(name, clazz);
				}
				protected void writeText(QuickWriter writer,String text){
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}
					else{
						writer.write(text);
					}
				}
			};
		}
	});
	/**
	 * @description 文本消息转化为XML
	 * @param textMessage 文本消息对象
	 * @return   XML
	 */
	public static String messageToXml(TextMessage textMessage){
		xStream.alias("xml",textMessage.getClass() );
		return xStream.toXML(textMessage);
	}
	/**
	 * @description 图片消息转化为XML
	 * @param   图片消息
	 * @return   XML
	 */
	public static String messageToXml(ImageMessage imageMessage){
		xStream.alias("xml", imageMessage.getClass());
		return xStream.toXML(imageMessage);
	}
	/**
	 * @description  语音消息转化为XML
	 * @param    语音消息
	 * @return   XML
	 */
	public static String messageToXml(VoiceMessage voiceMessage)
	{
		xStream.alias("xml", voiceMessage.getClass());
		return xStream.toXML(voiceMessage);
	}
	/**
	 * @description  视频消息转化为XML
	 * @param   视频消息
	 * @return   XML
	 */
	public static String messageToXml(VideoMessage videoMessage)
	{
		xStream.alias("xml", videoMessage.getClass());
		return xStream.toXML(videoMessage);
	}
	/** 
	 * @description  音乐消息转化为XML
	 * @param    音乐消息
	 * @return   XML
	 */
	public static String messageToXml(MusicMessage musicMessage)
	{
		xStream.alias("xml", musicMessage.getClass());
		return xStream.toXML(musicMessage);
	}
	/**
	 * @description  图文消息转化为XML
	 * @param     图文消息
	 * @return   XML
	 */
	public static String messageToXml(NewsMessage newsMessage)
	{
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item", new Article().getClass());
		return xStream.toXML(newsMessage);
	}
}
 
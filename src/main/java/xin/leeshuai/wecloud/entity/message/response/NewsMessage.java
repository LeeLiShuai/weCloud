package xin.leeshuai.wecloud.entity.message.response;

import java.util.List;

/** 
* @author leeshuai 
* @date 2017年7月20日  
* @description   响应图文消息类
*/
public class NewsMessage  extends BaseMessage{
	//图文消息个数，限制在十条之内
	private int ArticleCount;
	//多条图文消息信息，默认第一个为大图
	private List<Article> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
 
package forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person extends BaseBean{

	private String account;		//账号
	private String password;
	private String sex;
	private String name;
	private String birthday;
	private String email;
	private String ipCreated;   //注册时的IP地址
	
	@OneToMany(mappedBy="pReply_author")						//收到的回复
	private List<Reply> replies = new ArrayList<Reply>();
	
	private int news;			//新消息数量
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateLastActived;		//最后一次登录的时间
		
	private String ipLastActived;    //最后一次登录的IP
	
	@ManyToMany(mappedBy = "administrators")
	private Set<Board> boardsAdministrated = new HashSet<Board>();  //管理的版面

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public Date getDateLastActived() {
		return dateLastActived;
	}

	public void setDateLastActived(Date dateLastActived) {
		this.dateLastActived = dateLastActived;
	}

	public String getIpLastActived() {
		return ipLastActived;
	}

	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}

	public Set<Board> getBoardsAdministrated() {
		return boardsAdministrated;
	}

	public void setBoardsAdministrated(Set<Board> boardsAdministrated) {
		this.boardsAdministrated = boardsAdministrated;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setNews(int news) {
		this.news = news;
	}

	public int getNews() {
		return news;
	}
	
	
	
}

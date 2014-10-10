package forum.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//帖子类
@Entity
public class Thread extends BaseBean{
	
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
	
	private String title;
	
	@Basic(fetch =	FetchType.LAZY)
	@Column(columnDefinition = "longtext")			//给列为longtext类型
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Person author;
	
	private String ipCreated;     	//发表时的IP地址
	private int hit;			//人气（点击率）
	
	@OneToOne
	@JoinColumn(name = "author_last_reply_id")
	private Person authorLastReplied;		//最后回复人
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastReplied;		//最后回复时间
	
	private boolean readonly; 		//是否只读
	private boolean	topped;		//是否置顶
	private int replyCount;		//回帖数
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Person getAuthorLastReplied() {
		return authorLastReplied;
	}
	public void setAuthorLastReplied(Person authorLastReplied) {
		this.authorLastReplied = authorLastReplied;
	}
	public Date getDateLastReplied() {
		return dateLastReplied;
	}
	public void setDateLastReplied(Date dateLastReplied) {
		this.dateLastReplied = dateLastReplied;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	public boolean isTopped() {
		return topped;
	}
	public void setTopped(boolean topped) {
		this.topped = topped;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	
}

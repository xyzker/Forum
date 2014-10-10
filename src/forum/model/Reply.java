package forum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reply extends BaseBean	{
	@ManyToOne
	@JoinColumn(name="thread_id")
	private Thread thread;
	
	private String title;	//�ظ��ı���
	
	@Basic(fetch =	FetchType.LAZY)
	@Column(columnDefinition = "longtext")			//����Ϊlongtext����
	private String content;		//�ظ�������
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Person author;
	
	@ManyToOne
	@JoinColumn(name="pReply_id")
	private Reply pReply;				//���ظ�
	
	@OneToMany(mappedBy="pReply")
	private List<Reply> replies = new ArrayList<Reply>();			//�ӻظ�
	
	@ManyToOne
	@JoinColumn(name="pReply_author_id")				//���ظ�����
	private Person pReply_author;
	
	private int floor;		//�ڼ�¥
	private String ipCreated;		//����ʱ��IP��ַ
	
	@Column(name="isRead")
	private boolean read;				//�Ƿ��Ѷ�
	
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
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
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	public void setpReply(Reply pReply) {
		this.pReply = pReply;
	}
	public Reply getpReply() {
		return pReply;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setpReply_author(Person pReply_author) {
		this.pReply_author = pReply_author;
	}
	public Person getpReply_author() {
		return pReply_author;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isRead() {
		return read;
	}
	
	
	
}

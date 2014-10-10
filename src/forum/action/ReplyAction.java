package forum.action;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import forum.model.Board;
import forum.model.Person;
import forum.model.Reply;
import forum.model.Thread;
import forum.service.IBoardService;
import forum.service.IReplyService;
import forum.service.IThreadService;

@ParentPackage("forum")
public class ReplyAction extends ActionSupport {

	private static final long serialVersionUID = 6962020259094852473L;

	private Board board;
	private Thread thread;
	private Reply reply;
	private Reply childReply;			//子回复
	
	@Resource
	private IThreadService<Thread> threadService;
	
	@Resource
	private IReplyService<Reply> replyService;
	
	@Resource
	private IBoardService<Board> boardService;
	
	@Action(value = "/reply/init-add", interceptorRefs = {@InterceptorRef("loginStack")})
	public String initAdd() throws Exception {
		thread = threadService.find(Thread.class, thread.getId());
		board = thread.getBoard();
		return SUCCESS; 
	}
	
	@Action(value="/reply/add", interceptorRefs = {@InterceptorRef("loginStack")})
	public String add() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST); 
		thread = threadService.find(Thread.class, thread.getId());
		Board board = thread.getBoard();
		Person p = (Person) cxt.getSession().get("user");		//当前登录的用户
		reply.setThread(thread);			//回的哪个帖子
		reply.setDateCreated(new Date());    //创建日期
		reply.setAuthor(p);					//作者
		reply.setIpCreated(request.getRemoteAddr());	//创建IP
		reply.setFloor(thread.getReplyCount() + 1);		//回帖处在几楼
		reply.setpReply_author(thread.getAuthor());			//设置要回复的人
		thread.getAuthor().setNews(thread.getAuthor().getNews() + 1);   //被回复者新消息+1
		
		thread.setAuthorLastReplied(p);					//更新帖子最后回复作者
		thread.setDateLastReplied(new Date());			//更新帖子最后回复时间
		thread.setReplyCount(thread.getReplyCount() + 1);     //更新帖子回复数
		
		board.setLastThread(null);
		board.setLastReply(reply);				//设置版面最后回复
		board.setReplyCount(board.getReplyCount() + 1); 	//更新版面回复数
		
		replyService.create(reply);			//创建回帖
		threadService.saveOrUpdate(thread);		//更新帖子
		boardService.saveOrUpdate(board);		//更新版面
		
		return SUCCESS;
	}
	
	@Action(value = "/reply/init-update", interceptorRefs = {@InterceptorRef("loginStack")})
	public String initUpdate() throws Exception {
		reply = replyService.find(Reply.class, reply.getId());
		thread = reply.getThread();
		board = thread.getBoard();
		return SUCCESS; 
	}
	
	@Action(value="/reply/update", interceptorRefs = {@InterceptorRef("loginStack")})
	public String update() throws Exception {
		Reply replyTmp = replyService.find(Reply.class, reply.getId());			//加载原回复
		replyTmp.setContent(reply.getContent());
		replyService.saveOrUpdate(replyTmp);
		reply = replyTmp;
		return SUCCESS;
	}
	
	@Action(value="/reply/delete", interceptorRefs = {@InterceptorRef("loginStack")})
	public String delete() throws Exception {
		reply = replyService.find(Reply.class, reply.getId());
		thread = reply.getThread();
		board = thread.getBoard();
		
		reply.setDeleted(true);
		thread.setReplyCount(thread.getReplyCount() - 1);
		board.setReplyCount(board.getReplyCount() - 1);
		
		replyService.saveOrUpdate(reply);
		threadService.saveOrUpdate(thread);
		boardService.saveOrUpdate(board);
		return SUCCESS;
	}
	
	@Action(value = "/reply/init-addChild", interceptorRefs = {@InterceptorRef("loginStack")})
	public String initAddChild() throws Exception {
		reply = replyService.find(Reply.class, reply.getId());
		thread = reply.getThread();
		return SUCCESS; 
	}
	
	@Action(value="/reply/addChild", interceptorRefs = {@InterceptorRef("loginStack")}, 
			results = {@Result(name="success", location = "/WEB-INF/content/reply/add-success.jsp")})
	public String addChild() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST); 
		reply = replyService.find(Reply.class, reply.getId());
		thread = reply.getThread();
		Board board = thread.getBoard();
		Person p = (Person) cxt.getSession().get("user");		//当前登录的用户
		childReply.setThread(thread);			//回的哪个帖子
		childReply.setDateCreated(new Date());    //创建日期
		childReply.setAuthor(p);					//作者
		childReply.setIpCreated(request.getRemoteAddr());	//创建IP
		childReply.setFloor(thread.getReplyCount() + 1);		//回帖处在几楼
		childReply.setpReply(reply);				//设置父回复
		childReply.setpReply_author(reply.getAuthor());				//设置对谁回复
		reply.getAuthor().setNews(reply.getAuthor().getNews() + 1);		//被回复者新消息+1
		
		thread.setAuthorLastReplied(p);					//更新帖子最后回复作者
		thread.setDateLastReplied(new Date());			//更新帖子最后回复时间
		thread.setReplyCount(thread.getReplyCount() + 1);     //更新帖子回复数
		
		board.setLastThread(null);
		board.setLastReply(childReply);				//设置版面最后回复
		board.setReplyCount(board.getReplyCount() + 1); 	//更新版面回复数
		
		replyService.create(childReply);			//创建回帖
		threadService.saveOrUpdate(thread);		//更新帖子
		boardService.saveOrUpdate(board);		//更新版面
		
		return SUCCESS;
	}
	
	@Action("/reply/show")
	public String show() throws Exception {
		reply = replyService.find(Reply.class, reply.getId());
		if(reply.isRead() == false){			//假如未读
			reply.setRead(true);
			reply.getpReply_author().setNews(reply.getpReply_author().getNews() - 1); //读过之后新消息-1
			ActionContext cxt = ActionContext.getContext();
			cxt.getSession().put("user", reply.getpReply_author());		//session中也同步一下，以免显示不同步
			replyService.saveOrUpdate(reply);
		}
		return SUCCESS;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	public Board getBoard() {
		return board;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public Thread getThread() {
		return thread;
	}

	public void setThreadService(IThreadService<Thread> threadService) {
		this.threadService = threadService;
	}

	public IThreadService<Thread> getThreadService() {
		return threadService;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReplyService(IReplyService<Reply> replyService) {
		this.replyService = replyService;
	}

	public IReplyService<Reply> getReplyService() {
		return replyService;
	}

	public void setBoardService(IBoardService<Board> boardService) {
		this.boardService = boardService;
	}

	public IBoardService<Board> getBoardService() {
		return boardService;
	}

	public void setChildReply(Reply childReply) {
		this.childReply = childReply;
	}

	public Reply getChildReply() {
		return childReply;
	}

}

package forum.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import forum.model.Board;
import forum.model.Person;
import forum.model.Reply;
import forum.model.Thread;
import forum.pagination.Pagination;
import forum.service.IBoardService;
import forum.service.IReplyService;
import forum.service.IThreadService;

@ParentPackage("forum")
public class ThreadAction extends ActionSupport {

	private static final long serialVersionUID = 7791832486056262785L;
	
	private Board board;
	private Thread thread;
	
	private List<Reply> replyList = new ArrayList<Reply>();
	
	@Resource
	private IBoardService<Board> boardService;
	
	@Resource
	private IReplyService<Reply> replyService;
	
	@Resource
	private IThreadService<Thread> threadService;
	
	@Action(value = "/thread/init-add", interceptorRefs = {@InterceptorRef("loginStack")})
	public String initAdd() throws Exception {
		board = boardService.find(Board.class, board.getId());
		return SUCCESS; 
	}
	
	@Action(value="/thread/add", interceptorRefs = {@InterceptorRef("loginStack")})
	public String add() throws Exception {
			ActionContext cxt = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);  
			board = boardService.find(Board.class, board.getId());
			Person p = (Person) cxt.getSession().get("user");		//��ǰ��¼���û�
			thread.setBoard(board);							//���ð���
			thread.setAuthor(p);							//��������
			thread.setAuthorLastReplied(null);				//�������ظ�
			thread.setDateCreated(new Date());				//���ô�������
			thread.setDateLastReplied(new Date());			//�������ظ�����
			thread.setIpCreated(request.getRemoteAddr());		//���õ�ǰIP
			thread.setReadonly(false);				//ֻ����־
			thread.setReplyCount(0);				//���ûظ�����
			thread.setTopped(false);				//�����ö����
			threadService.create(thread);
		return SUCCESS;
	}
	
	@SuppressWarnings("all")
	@Action(value = "/thread/list")
	public String list() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)cxt.get(ServletActionContext.HTTP_RESPONSE);
		thread = threadService.find(Thread.class, thread.getId());			//����
		if(thread.isDeleted() == true) {									//��������Ƿ���ɾ��
			return ERROR;
		}
		Pagination pagination = new Pagination(request, response);		//��ҳ��																//��ҳ��
		pagination.setRecordCount(thread.getReplyCount());				//��������
		replyList = replyService.list("from Reply r where r.deleted = false " +
					"and r.thread.id = " + thread.getId() + " order by r.id asc ", 
					pagination.getFirstResult(), pagination.getPageSize(), null);	//��ҳ����
		threadService.updateHit(thread.getId());			//���µ����
		request.setAttribute("pagination", pagination);
		
		return SUCCESS;
	}
	
	@Action(value = "/thread/init-update", interceptorRefs = {@InterceptorRef("loginStack")})
	public String initUpdate() throws Exception {
		thread = threadService.find(Thread.class, thread.getId());
		board = thread.getBoard();
		return SUCCESS; 
	}
	
	@Action(value="/thread/update", interceptorRefs = {@InterceptorRef("loginStack")})
	public String update() throws Exception {
		Thread threadTmp = threadService.find(Thread.class, thread.getId());			//����ԭ�ظ�
		threadTmp.setTitle(thread.getTitle());
		threadTmp.setContent(thread.getContent());
		threadService.saveOrUpdate(threadTmp);
		thread = threadTmp;
		return SUCCESS;
	}
	
	@Action(value="/thread/delete", interceptorRefs = {@InterceptorRef("loginStack")})
	public String delete() throws Exception {
		thread = threadService.find(Thread.class, thread.getId());
		board = thread.getBoard();
		
		thread.setDeleted(true);
		board.setThreadCount(board.getThreadCount() - 1);
		board.setReplyCount(board.getReplyCount() - thread.getReplyCount());
		
		threadService.saveOrUpdate(thread);
		boardService.saveOrUpdate(board);
		return SUCCESS;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoardService(IBoardService<Board> boardService) {
		this.boardService = boardService;
	}

	public IBoardService<Board> getBoardService() {
		return boardService;
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

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyService(IReplyService<Reply> replyService) {
		this.replyService = replyService;
	}

	public IReplyService<Reply> getReplyService() {
		return replyService;
	}
	
}
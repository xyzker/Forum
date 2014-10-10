package forum.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import forum.model.Board;
import forum.model.Category;
import forum.model.Person;
import forum.model.Thread;
import forum.pagination.Pagination;
import forum.service.IBoardService;
import forum.service.ICategoryService;
import forum.service.IPersonService;
import forum.service.IThreadService;

@ParentPackage("forum")
public class BoardAction extends ActionSupport{

	@Resource
	private IBoardService<Board> boardService;
	
	@Resource
	private ICategoryService<Category> categoryService;
	
	@Resource
	private IPersonService<Person>	personService;
	
	@Resource
	private IThreadService<Thread>	threadService;
	
	private List<Category> categories = new ArrayList<Category>();
	private List<Person> persons = new ArrayList<Person>();
	private List<Thread> threadList = new ArrayList<Thread>();			
	
	private int categoryId;
	private Board board;
	private int[] admins;
	
	private static final long serialVersionUID = 972424575065777917L;

	@Action(value = "/board/init-setAdmin")
	public String initSetAdmin() throws Exception {
		board = boardService.find(Board.class, board.getId());
		persons = personService.list("from Person p where p.deleted = false");
		admins = new int[board.getAdministrators().size()];
		int i = 0;
		for(Iterator<Person> it = board.getAdministrators().iterator();it.hasNext();i++){
			Person p = it.next();
			admins[i] = p.getId();
		}
		return SUCCESS; 
	}
	
	@Action(value="/board/setAdmin")
	public String setAdmin() throws Exception {
		board = boardService.find(Board.class, board.getId());
		board.getAdministrators().clear();			//清空所有版主
		for(int i=0 ; i<admins.length; i++){
			int id = admins[i];
			Person p = personService.find(Person.class, id);
			board.getAdministrators().add(p);
		}
		boardService.update(board);
		return SUCCESS;
	}
	
	@Action(value = "/board/init-add")
	public String initAdd() throws Exception {
		categories = categoryService.list("from Category c where c.deleted = false");
		return SUCCESS; 
	}
	
	@Action(value="/board/add", results = {@Result(name="input", location="/WEB-INF" +
	"/content/board/init-add.jsp")})
	public String add() throws Exception {
		Category category = categoryService.find(Category.class, categoryId);
		board.setCategory(category);
		board.setDateCreated(new Date());
		try{
			boardService.create(board);
		}catch(RuntimeException e){
			categories = categoryService.list("from Category c where c.deleted = false");
			addActionError(e.getMessage() + " 请重新添加！");
			return INPUT;
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("all")
	@Action(value = "/board/list")
	public String list() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)cxt.get(ServletActionContext.HTTP_RESPONSE);
		board = boardService.find(Board.class, board.getId());			//版面
		Pagination pagination = new Pagination(request, response);		//分页器																//分页器
		pagination.setRecordCount(board.getThreadCount());				//设置总数
		threadList = threadService.list("from Thread t where t.deleted = false " +
					"and t.board.id = " + board.getId() + " order by t.dateLastReplied desc ", 
					pagination.getFirstResult(), pagination.getPageSize(), null);	//分页数据
		request.setAttribute("pagination", pagination);
		
		return SUCCESS;
	}

	public void setBoardService(IBoardService<Board> boardService) {
		this.boardService = boardService;
	}

	public IBoardService<Board> getBoardService() {
		return boardService;
	}

	public void setCategoryService(ICategoryService<Category> categoryService) {
		this.categoryService = categoryService;
	}

	public ICategoryService<Category> getCategoryService() {
		return categoryService;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setPersonService(IPersonService<Person> personService) {
		this.personService = personService;
	}

	public IPersonService<Person> getPersonService() {
		return personService;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setAdmins(int[] admins) {
		this.admins = admins;
	}

	public int[] getAdmins() {
		return admins;
	}

	public void setThreadList(List<Thread> threadList) {
		this.threadList = threadList;
	}

	public List<Thread> getThreadList() {
		return threadList;
	}

	public void setThreadService(IThreadService<Thread> threadService) {
		this.threadService = threadService;
	}

	public IThreadService<Thread> getThreadService() {
		return threadService;
	}

}

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
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import forum.model.Person;
import forum.model.Reply;
import forum.pagination.Pagination;
import forum.service.IPersonService;
import forum.service.IReplyService;

@ParentPackage("forum")
public class PersonAction extends ActionSupport{

	private static final long serialVersionUID = 6373119756034963087L;
	
	@Resource
	private IPersonService<Person> personService;
	
	private Person person;
	private String message;
	
	private List<Reply> replyList = new ArrayList<Reply>();
	
	@Resource
	private IReplyService<Reply> replyService;

	public void setPersonService(IPersonService<Person> personService) {
		this.personService = personService;
	}

	public IPersonService<Person> getPersonService() {
		return personService;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Action("/person/init-add")
	public String initAdd() throws Exception {
		return SUCCESS; 
	}
	
	@Action(value = "/person/add", results = {@Result(name="input", location = "/WEB-INF/content/person/init-add.jsp")})
	public String add() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			person.setIpCreated(request.getRemoteAddr());	//记录注册IP
			person.setIpLastActived(request.getRemoteAddr());
			person.setDateCreated(new Date());
			person.setDateLastActived(new Date());
			personService.create(person);
			request.setAttribute("message", "注册成功！");
			return SUCCESS;
		}catch(RuntimeException e){
			addActionError(e.getMessage() + " 请重新注册！");
			return INPUT;
		}
		
	}

	public void validateAdd() {				//validate后面加什么就验证什么方法
		if(person.getAccount() == null || person.getAccount().trim().length() == 0) {
			addFieldError("person.account", "必须输入账号！");
		}
		
		if(person.getPassword() == null || person.getPassword().trim().length() == 0) {
			addFieldError("person.account", "必须输入密码！");
		}
		
	}
	
	@Action("/person/init-login")
	public String initLogin() throws Exception {
		return SUCCESS; 
	}
	
	@Action(value = "/person/login", results = 
			{@Result(name="input", location = 
			"/WEB-INF/content/person/init-login.jsp")})
	public String login() throws Exception {
		Person p = personService.getPerson(person.getAccount(), person.getPassword());
		if(p == null) {
			addActionError("账号或密码错误！请重新登陆。");
			return INPUT;
		}
		System.out.println(p.getAccount());
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);  
		p.setIpLastActived(request.getRemoteAddr());		//记录登陆IP
		p.setDateLastActived(new Date());     	//记录登陆时间
		personService.saveOrUpdate(p);
		cxt.getSession().put("user",p);   //存入session
		request.setAttribute("message", "欢迎回来！");
		return SUCCESS;
	}
	
	@Action(value = "/person/logout", results = {@Result(location="/WEB-INF/content/person/init-login.jsp")})
	public String logout() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		cxt.getSession().put("user", null);
		return SUCCESS;
	}
	
	@Action("/person/viewPerson")
	public String viewPerson() throws Exception {
		person = personService.find(Person.class, person.getId());
		return SUCCESS;
	}
	
	//查看回复该用户的文章
	@Action(value = "/person/viewReplies", interceptorRefs = {@InterceptorRef("loginStack")})
	public String viewReplies() throws Exception {
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)cxt.get(ServletActionContext.HTTP_RESPONSE);
		person = personService.find(Person.class, person.getId());
	System.out.println("用户新消息： " + person.getNews());
		Pagination pagination = new Pagination(request, response);		//分页器	
		pagination.setRecordCount(person.getReplies().size());				//设置总数
		replyList = replyService.viewReplies(person.getId(), pagination.getFirstResult(), pagination.getPageSize());	//分页实体
		request.setAttribute("pagination", pagination);
		
		return SUCCESS;
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

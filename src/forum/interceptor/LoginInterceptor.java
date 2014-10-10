package forum.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import forum.model.Person;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 7918143213426544935L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Person person = (Person)ActionContext.getContext().getSession().get("user");
		//ActionSupport action = (ActionSupport)invocation.getAction();
		/*if(action instanceof PersonAction){			//PersonAction不验证
			System.out.println("这是PersonAction,不用验证");
			return invocation.invoke();
		}*/
		if(person != null){							//用户已登陆
			System.out.println("用户已登陆");
			return invocation.invoke();
		}
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);  
		request.setAttribute("message", "请先登录！");
		System.out.println("用户没有登陆");
		return "login";
	}

}

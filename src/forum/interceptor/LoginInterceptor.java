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
		/*if(action instanceof PersonAction){			//PersonAction����֤
			System.out.println("����PersonAction,������֤");
			return invocation.invoke();
		}*/
		if(person != null){							//�û��ѵ�½
			System.out.println("�û��ѵ�½");
			return invocation.invoke();
		}
		ActionContext cxt = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)cxt.get(ServletActionContext.HTTP_REQUEST);  
		request.setAttribute("message", "���ȵ�¼��");
		System.out.println("�û�û�е�½");
		return "login";
	}

}
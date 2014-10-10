package forum.action.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import forum.model.Person;
import forum.service.IPersonService;

@ParentPackage("forum")
public class AvatarAction extends ActionSupport{

	private static final long serialVersionUID = -9038842004046046694L;
	
	@Resource
	private IPersonService<Person> personService;
	
	private Person person;
	
	private File avatar;				//文件域
	private String avatarContentType;		//文件类型
	private String avatarFileName;			//文件名
	private String savePath;			//文件保存位置，接受struts.xml的配置
	
	@Action(value = "/person/addAvatar", interceptorRefs = {@InterceptorRef("loginStack"), 
			@InterceptorRef("uploadStack") }, results = {@Result(name="input", location = 
			"/WEB-INF/content/person/addAvatar-input.jsp", params = {"person.id", "${person.id}"})})
	public String addAvatar() throws Exception {
		person = personService.find(Person.class, person.getId());
		String[] strs = avatarFileName.split("\\.");		//得到本来文件的扩展名,即strs[1]
		//设置文件名
		avatarFileName = person.getAccount() + "." + strs[1];
		//设置文件保存路径
		savePath = ServletActionContext.getServletContext().getRealPath("/images/avatar");
		//以服务器的文件保存地址和文件名建立上传文件输出流
		FileOutputStream fos = new FileOutputStream(getSavePath() + 
								"\\" + getAvatarFileName());
		FileInputStream fis = new FileInputStream(getAvatar());
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer)) > 0){
			fos.write(buffer, 0, len);
		}
		fis.close();
        fos.close();
		return SUCCESS;
	}
	
	@Action("/person/addAvatar-input")
	public String initAvatar() throws Exception {
		person = personService.find(Person.class, person.getId());
		return SUCCESS;
	}

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

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSavePath() {
		return savePath;
	}
}

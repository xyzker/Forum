package forum.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import forum.model.Category;
import forum.service.ICategoryService;

@ParentPackage("forum")
public class CategoryAction extends ActionSupport{

	private static final long serialVersionUID = -1671658317373786388L;
	
	@Resource
	private ICategoryService<Category> categoryService;
	
	private Category category;
	
	private List<Category> categories = new ArrayList<Category>();
	
	@Action(value = "/category/list")
	public String list() throws Exception {
		categories = categoryService.list("from Category");
		return SUCCESS;
	}
	
	@Action("/category/init-add")
	public String initAdd() throws Exception {
		return SUCCESS; 
	}
	
	@Action(value="/category/add", results = {@Result(name="input", location="/WEB-INF" +
											"/content/category/init-add.jsp")})
	public String add() throws Exception {
		try{
			category.setDateCreated(new Date());
			categoryService.create(category);
		}catch(RuntimeException e){
			addActionError(e.getMessage() + " «Î÷ÿ–¬ÃÌº”£°");
			return INPUT;
		}
		return SUCCESS;
	}
	
	@Action("/category/viewCategory")
	public String viewCategory() throws Exception {
		category = categoryService.find(Category.class, category.getId());
		return SUCCESS;
	}

	public void setCategoryService(ICategoryService<Category> categoryService) {
		this.categoryService = categoryService;
	}

	public ICategoryService<Category> getCategoryService() {
		return categoryService;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
}

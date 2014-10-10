package forum.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Category;
import forum.service.ICategoryService;

@Component("categoryService")
@Transactional
public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T> implements ICategoryService<T> {

	@Override
	public void create(T category) {		//创建实体
		if(dao.createQuery("from Category c where c.name = :name and " +		//检查同名类别是否存在
				"c.deleted = false ").setParameter("name", category.getName()).list().size() > 0){
			throw new RuntimeException("类别 " + category.getName() + " 已经存在。");
		}
		dao.saveOrUpdate(category);
	}

}

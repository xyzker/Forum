package forum.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Category;
import forum.service.ICategoryService;

@Component("categoryService")
@Transactional
public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T> implements ICategoryService<T> {

	@Override
	public void create(T category) {		//����ʵ��
		if(dao.createQuery("from Category c where c.name = :name and " +		//���ͬ������Ƿ����
				"c.deleted = false ").setParameter("name", category.getName()).list().size() > 0){
			throw new RuntimeException("��� " + category.getName() + " �Ѿ����ڡ�");
		}
		dao.saveOrUpdate(category);
	}

}

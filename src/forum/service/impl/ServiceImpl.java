package forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import forum.dao.IDao;
import forum.model.BaseBean;
import forum.service.IService;

@Transactional
public abstract class ServiceImpl<T extends BaseBean> implements IService<T>{
	
	@Resource
	protected IDao<T> dao;

	public IDao<T> getDao() {
		return dao;
	}

	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	public abstract void create(T baseBean);

	@Override
	public void delete(T baseBean) {
		baseBean.setDeleted(true);		//����ɾ����־λ
		dao.delete(baseBean);
	}

	@Override
	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	@Override
	public int getTotalCount(String hql, Object... params) {
		return dao.getTotalCount(hql, params);
	}

	@Override
	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params) {
		return dao.list(hql, firstResult, maxSize, params);
	}

	@Override
	public List<T> list(String hql) {
		return dao.list(hql);
	}

	@Override
	public void saveOrUpdate(T baseBean) {
		dao.saveOrUpdate(baseBean);
	}
	
	public void update(T baseBean) {
		dao.update(baseBean);
	}
}

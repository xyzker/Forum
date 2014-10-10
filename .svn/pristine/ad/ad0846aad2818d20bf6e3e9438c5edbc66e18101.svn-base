package forum.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Person;
import forum.service.IPersonService;

@Component("personService")
@Transactional
public class PersonServiceImpl<T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

	@Override
	//创建Perosn
	public void create(T person) {
		if(findPersonByAccount(person.getAccount()) != null){	//检查同账号实体是否存在
			throw new RuntimeException("账号" + person.getAccount() + "已经存在。");
		}
		this.getDao().saveOrUpdate(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	//根据账号查询Person
	public T findPersonByAccount(String account) {
		List<T> person = (List<T>)this.getDao().createQuery("select p from Person" +
				" p where lower(p.account) = lower(:account) and deleted = " +
				"false ").setParameter("account", account.trim()).list();
		
		if(person.size() > 0)
			return person.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	//根据账号密码查询实体
	public T getPerson(String account, String password) {
		List<T> person = (List<T>)this.getDao().createQuery("select p from Person " +
				"p where lower(p.account) = lower(:account) and p.password = :password " +
				"and deleted = false ").setParameter("account", account.trim())
				.setParameter("password", password).list();
		
		if(person.size() > 0)
			return person.get(0);
		return null;
	}


}

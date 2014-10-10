package forum.model;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import forum.service.IBoardService;
import forum.service.IPersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class ModelTest {
	
	@Resource
	private IPersonService<Person> personService;
	
	@Resource
	private IBoardService<Board> boardService;
	
	@Test
	public void testModel(){
		Person p = personService.find(Person.class, 5);
		Board b = boardService.find(Board.class, 5);
		b.getAdministrators().add(p);
		System.out.println(b.getId());
		System.out.println(b.getName());
		boardService.update(b);
		
	}
	
}

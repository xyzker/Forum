package forum.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Board;
import forum.service.IBoardService;

@Component("boardService")
@Transactional
public class BoardServiceImpl<T extends Board> extends ServiceImpl<T> implements IBoardService<T> {

	@Override
	public void create(T board) {		//创建实体
		if(dao.createQuery("from Board b where b.name = :name and " +		//检查同名类别是否存在
				"b.deleted = false ").setParameter("name", board.getName()).list().size() > 0){
			throw new RuntimeException("版面 " + board.getName() + " 已经存在。");
		}
		dao.saveOrUpdate(board);
	}

}

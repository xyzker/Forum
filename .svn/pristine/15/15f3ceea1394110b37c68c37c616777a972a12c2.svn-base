package forum.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Reply;
import forum.service.IReplyService;

@Component("replyService")
@Transactional
public class ReplyServiceImpl<T extends Reply> extends ServiceImpl<T> implements IReplyService<T>{

	@Override
	public void create(T reply) {
		dao.saveOrUpdate(reply);
	}

	@SuppressWarnings("all")
	@Override
	public List<T> viewReplies(int person_id, int firstResult, int maxSize) {
		return dao.list("from Reply r where r.deleted = false and r.pReply_author.id = " + person_id + 
				" order by r.dateCreated desc ", firstResult, maxSize, null);
	}

}

package forum.service;

import java.util.List;

import forum.model.Reply;

public interface IReplyService<T extends Reply> extends IService<T> {
	public List<T> viewReplies(int person_id, int firstResult, int maxSize);		//查询回复用户文章的分页实体
}

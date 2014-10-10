package forum.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import forum.model.Thread;
import forum.service.IThreadService;

@Component("threadService")
@Transactional
public class ThreadServiceImpl<T extends Thread> extends ServiceImpl<T> implements IThreadService<T>{

	@Override
	@SuppressWarnings("all")
	public void create(T thread) {
		dao.saveOrUpdate(thread);				//保存帖子
		int totalCount =  dao.getTotalCount("from Thread t where t.deleted = false and " +
							"t.board.id = " + thread.getBoard().getId(), null);		//查询改帖子所在版面的帖子数
		
		dao.createQuery("update Board b set b.lastThread.id = :lastThreadId, b.lastReply.id = " +
						"null, threadCount = :threadCount where b.id = :boardId")
						.setParameter("lastThreadId", thread.getId())
						.setParameter("threadCount", totalCount)
						.setParameter("boardId", thread.getBoard().getId())
						.executeUpdate();						//更新版面的帖子数和最新发表的帖子
	}

	@Override
	public void updateHit(int threadId) {						//更新点击率
		dao.createQuery("update Thread t set t.hit = t.hit + 1 where t.id = :id")
						.setParameter("id", threadId).executeUpdate();
	}

}

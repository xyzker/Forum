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
		dao.saveOrUpdate(thread);				//��������
		int totalCount =  dao.getTotalCount("from Thread t where t.deleted = false and " +
							"t.board.id = " + thread.getBoard().getId(), null);		//��ѯ���������ڰ����������
		
		dao.createQuery("update Board b set b.lastThread.id = :lastThreadId, b.lastReply.id = " +
						"null, threadCount = :threadCount where b.id = :boardId")
						.setParameter("lastThreadId", thread.getId())
						.setParameter("threadCount", totalCount)
						.setParameter("boardId", thread.getBoard().getId())
						.executeUpdate();						//���°���������������·��������
	}

	@Override
	public void updateHit(int threadId) {						//���µ����
		dao.createQuery("update Thread t set t.hit = t.hit + 1 where t.id = :id")
						.setParameter("id", threadId).executeUpdate();
	}

}

package forum.service;

import forum.model.Thread;

public interface IThreadService<T extends Thread> extends IService<T> {
	public void updateHit(int threadId);		//更新帖子点击率
}

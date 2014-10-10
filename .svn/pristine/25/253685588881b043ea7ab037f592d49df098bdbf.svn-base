package forum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseBean{
	private String name;
	
	@OneToMany(mappedBy = "category")		//版面下的子版面
	private List<Board> boards = new ArrayList<Board>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
	
	
	
}

package entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *		<p>
 *  		StateGame transfer object. Represents StateGame table in database
 *		</p>
 */

public class StateGame implements Serializable {

	private static final long serialVersionUID = 3715741579304538898L;

	private Long id;
	private String name;
		
	public StateGame() {}
	
	public StateGame(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StateGame {id=" + id + ", name=" + name + "}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateGame other = (StateGame) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *         <p>
 *         Position transfer object. Represents Position table in database
 *         </p>
 */
public class Position implements Serializable {

	private static final long serialVersionUID = 297556133211460594L;

	private long id;
	private String title;
	private String whiteMan;
	private String blackMan;
	private String whiteKing;
	private String blackKing;
	private boolean blackMoveFirst;

	public Position() {
	}

	public Position(long id, String title, String whiteMan, String blackMan, String whiteKing, String blackKing,
			boolean blackMoveFirst) {
		super();
		this.id = id;
		this.title = title;
		this.whiteMan = whiteMan;
		this.blackMan = blackMan;
		this.whiteKing = whiteKing;
		this.blackKing = blackKing;
		this.blackMoveFirst = blackMoveFirst;
	}

	@Override
	public String toString() {
		return "Position {id=" + id + ", title=" + title + ", whiteMan=" + whiteMan + ", blackMan=" + blackMan
				+ ", whiteKing=" + whiteKing + ", blackKing=" + blackKing + ", blackMoveFirst=" + blackMoveFirst + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blackKing == null) ? 0 : blackKing.hashCode());
		result = prime * result + ((blackMan == null) ? 0 : blackMan.hashCode());
		result = prime * result + (blackMoveFirst ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((whiteKing == null) ? 0 : whiteKing.hashCode());
		result = prime * result + ((whiteMan == null) ? 0 : whiteMan.hashCode());
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
		Position other = (Position) obj;
		if (blackKing == null) {
			if (other.blackKing != null)
				return false;
		} else if (!blackKing.equals(other.blackKing))
			return false;
		if (blackMan == null) {
			if (other.blackMan != null)
				return false;
		} else if (!blackMan.equals(other.blackMan))
			return false;
		if (blackMoveFirst != other.blackMoveFirst)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (whiteKing == null) {
			if (other.whiteKing != null)
				return false;
		} else if (!whiteKing.equals(other.whiteKing))
			return false;
		if (whiteMan == null) {
			if (other.whiteMan != null)
				return false;
		} else if (!whiteMan.equals(other.whiteMan))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWhiteMan() {
		return whiteMan;
	}

	public void setWhiteMan(String whiteMan) {
		this.whiteMan = whiteMan;
	}

	public String getBlackMan() {
		return blackMan;
	}

	public void setBlackMan(String blackMan) {
		this.blackMan = blackMan;
	}

	public String getWhiteKing() {
		return whiteKing;
	}

	public void setWhiteKing(String whiteKing) {
		this.whiteKing = whiteKing;
	}

	public String getBlackKing() {
		return blackKing;
	}

	public void setBlackKing(String blackKing) {
		this.blackKing = blackKing;
	}

	public boolean isBlackMoveFirst() {
		return blackMoveFirst;
	}

	public void setBlackMoveFirst(boolean blackMoveFirst) {
		this.blackMoveFirst = blackMoveFirst;
	}

}

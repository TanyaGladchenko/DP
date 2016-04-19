/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *		<p>
 *  		Moves transfer object. Represents Moves table in database
 *		</p>
 */
public class Moves implements Serializable {

	private static final long serialVersionUID = -4968557571656907972L;

	private long id;
	private long protocolId;
	private int number;
	private String moveWhite;
	private String commentWhite;
	private String moveBlack;
	private String commentBlack;
		
	@Override
	public String toString() {
		return "Moves {id=" + id + ", protocolId=" + protocolId + ", number=" + number + ", moveWhite=" + moveWhite
				+ ", commentWhite=" + commentWhite + ", moveBlack=" + moveBlack + ", commentBlack=" + commentBlack
				+ "}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentBlack == null) ? 0 : commentBlack.hashCode());
		result = prime * result + ((commentWhite == null) ? 0 : commentWhite.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((moveBlack == null) ? 0 : moveBlack.hashCode());
		result = prime * result + ((moveWhite == null) ? 0 : moveWhite.hashCode());
		result = prime * result + number;
		result = prime * result + (int) (protocolId ^ (protocolId >>> 32));
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
		Moves other = (Moves) obj;
		if (commentBlack == null) {
			if (other.commentBlack != null)
				return false;
		} else if (!commentBlack.equals(other.commentBlack))
			return false;
		if (commentWhite == null) {
			if (other.commentWhite != null)
				return false;
		} else if (!commentWhite.equals(other.commentWhite))
			return false;
		if (id != other.id)
			return false;
		if (moveBlack == null) {
			if (other.moveBlack != null)
				return false;
		} else if (!moveBlack.equals(other.moveBlack))
			return false;
		if (moveWhite == null) {
			if (other.moveWhite != null)
				return false;
		} else if (!moveWhite.equals(other.moveWhite))
			return false;
		if (number != other.number)
			return false;
		if (protocolId != other.protocolId)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProtocolId() {
		return protocolId;
	}
	public void setProtocolId(long protocolId) {
		this.protocolId = protocolId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMoveWhite() {
		return moveWhite;
	}
	public void setMoveWhite(String moveWhite) {
		this.moveWhite = moveWhite;
	}
	public String getCommentWhite() {
		return commentWhite;
	}
	public void setCommentWhite(String commentWhite) {
		this.commentWhite = commentWhite;
	}
	public String getMoveBlack() {
		return moveBlack;
	}
	public void setMoveBlack(String moveBlack) {
		this.moveBlack = moveBlack;
	}
	public String getCommentBlack() {
		return commentBlack;
	}
	public void setCommentBlack(String commentBlack) {
		this.commentBlack = commentBlack;
	}
}

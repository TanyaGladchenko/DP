/**
 * 
 */
package org.draught.common.entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *		<p>
 *  		Protocol transfer object. Represents Protocol table in database
 *  	</p>
 */
public class Protocol implements Serializable {

	private static final long serialVersionUID = -2006078514582952452L;

	private long id;
	private long positionId;
	private long whitePlayerId;
	private long blackPlayerId;
	private long stateGameId;
	private String title;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (blackPlayerId ^ (blackPlayerId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (positionId ^ (positionId >>> 32));
		result = prime * result + (int) (stateGameId ^ (stateGameId >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (int) (whitePlayerId ^ (whitePlayerId >>> 32));
		return result;
	}
	
	
	
	@Override
	public String toString() {
		return "Protocol {id=" + id + ", positionId=" + positionId + ", whitePlayerId=" + whitePlayerId
				+ ", blackPlayerId=" + blackPlayerId + ", stateGameId=" + stateGameId + ", title=" + title + "}";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Protocol other = (Protocol) obj;
		if (blackPlayerId != other.blackPlayerId)
			return false;
		if (id != other.id)
			return false;
		if (positionId != other.positionId)
			return false;
		if (stateGameId != other.stateGameId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (whitePlayerId != other.whitePlayerId)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}
	public long getWhitePlayerId() {
		return whitePlayerId;
	}
	public void setWhitePlayerId(long whitePlayerId) {
		this.whitePlayerId = whitePlayerId;
	}
	public long getBlackPlayerId() {
		return blackPlayerId;
	}
	public void setBlackPlayerId(long blackPlayerId) {
		this.blackPlayerId = blackPlayerId;
	}
	public long getStateGameId() {
		return stateGameId;
	}
	public void setStateGameId(long stateGameId) {
		this.stateGameId = stateGameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
}

/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *         <p>
 *         Protocol transfer object. Represents Protocol table in database
 *         </p>
 */
public class Protocol implements Serializable {

	private static final long serialVersionUID = -2006078514582952452L;

	private Long id;
	private Long positionId;
	private Long whitePlayerId;
	private Long blackPlayerId;
	private Long stateGameId;
	private String title;

	public Protocol(Long id, Long positionId, Long whitePlayerId, Long blackPlayerId, Long stateGameId, String title) {
		super();
		this.id = id;
		this.positionId = positionId;
		this.whitePlayerId = whitePlayerId;
		this.blackPlayerId = blackPlayerId;
		this.stateGameId = stateGameId;
		this.title = title;
	}

	public Protocol() {
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getWhitePlayerId() {
		return whitePlayerId;
	}

	public void setWhitePlayerId(Long whitePlayerId) {
		this.whitePlayerId = whitePlayerId;
	}

	public Long getBlackPlayerId() {
		return blackPlayerId;
	}

	public void setBlackPlayerId(Long blackPlayerId) {
		this.blackPlayerId = blackPlayerId;
	}

	public Long getStateGameId() {
		return stateGameId;
	}

	public void setStateGameId(Long stateGameId) {
		this.stateGameId = stateGameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

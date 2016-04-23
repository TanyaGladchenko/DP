/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author Tatyana_Gladchenko
 *         <p>
 *         PlayerStatistic transfer object. Represents PlayerStatistic table in
 *         database
 *         </p>
 */
public class PlayerStatistic implements Serializable {

	private static final long serialVersionUID = -8781023245472539369L;

	private long id;
	private long playerId;
	private int gamesLoose;
	private int gamesWon;
	private int gamesDraw;

	public PlayerStatistic(long id, long playerId, int gamesLoose, int gamesWon, int gamesDraw) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.gamesLoose = gamesLoose;
		this.gamesWon = gamesWon;
		this.gamesDraw = gamesDraw;
	}

	public PlayerStatistic() {
	}

	@Override
	public String toString() {
		return "PlayerStatistic {id=" + id + ", playerId=" + playerId + ", gamesLoose=" + gamesLoose + ", gamesWon="
				+ gamesWon + ", gamesDraw=" + gamesDraw + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gamesDraw;
		result = prime * result + gamesLoose;
		result = prime * result + gamesWon;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (playerId ^ (playerId >>> 32));
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
		PlayerStatistic other = (PlayerStatistic) obj;
		if (gamesDraw != other.gamesDraw)
			return false;
		if (gamesLoose != other.gamesLoose)
			return false;
		if (gamesWon != other.gamesWon)
			return false;
		if (id != other.id)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getGamesLoose() {
		return gamesLoose;
	}

	public void setGamesLoose(int gamesLoose) {
		this.gamesLoose = gamesLoose;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGamesDraw() {
		return gamesDraw;
	}

	public void setGamesDraw(int gamesDraw) {
		this.gamesDraw = gamesDraw;
	}
}

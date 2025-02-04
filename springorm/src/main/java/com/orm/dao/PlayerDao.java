package com.orm.dao;

import java.util.List;

import com.orm.entities.Player;

//PlayerDao interface for accessing database
public interface PlayerDao {
	
	public int insertPlayer(Player player);
	
	public Player getPlayer(int playerId);
	
	public List<Player> getAllPlayers();
	
	public boolean isContainPlayer(Player player);
	
	public boolean deletePlayer(int playerId);
	
	public void updatePlayer(Player player);
}

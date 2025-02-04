package com.orm.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.orm.entities.Player;


public class PlayerDaoImpl implements PlayerDao{

	private HibernateTemplate hiberTemplate;
	
	public HibernateTemplate getHiberTemplate() {
		return this.hiberTemplate;
	}


	public void setHiberTemplate(HibernateTemplate hiberTemplate) {
		this.hiberTemplate = hiberTemplate;
	}


	public PlayerDaoImpl() {
		super();
	}
	
	
	// method to insert Player object into database
	@Override
	@Transactional
	public int insertPlayer(Player player) {
		 Integer rows = (Integer)this.hiberTemplate.save(player);
		 return rows;
	}


	// method to get single data from database
	@Override
	public Player getPlayer(int playerId) {
		Player player = this.hiberTemplate.get(Player.class, playerId);
		return player;
	}

	// method to get all data from database
	@Override
	public List<Player> getAllPlayers() {
		List<Player> playersList = this.hiberTemplate.loadAll(Player.class);
		return playersList;
	}

	
	// method to update data in database
	@Override
	@Transactional
	public void updatePlayer(Player player) {
		this.hiberTemplate.update(player);
	}


	@Override
	@Transactional
	public boolean deletePlayer(int playerId) {
		Player player = this.hiberTemplate.get(Player.class, playerId);
		if(!isContainPlayer(player)) {
			return false;
		}
		this.hiberTemplate.delete(player);
		return true;
	}


	@Override
	public boolean isContainPlayer(Player player) {
		/*
		 * boolean isContain = true;
		 * 
		 * if(player == null) { isContain = false; }
		 * 
		 * return isContain;
		 */
		
		return (player != null);
	}
	
}

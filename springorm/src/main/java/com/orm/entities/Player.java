package com.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@Column(name = "player_id")
	private int id;
	
	@Column(name = "jer_no")
	private int jerNo;
	
	@Column(name = "player_name")
	private String name;
	
	@Column(name = "total_score")
	private int totalScore;
	
	public Player(int id, int jerNo, String name, int totalScore) {
		super();
		this.id = id;
		this.jerNo = jerNo;
		this.name = name;
		this.totalScore = totalScore;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJerNo() {
		return jerNo;
	}

	public void setJerNo(int jerNo) {
		this.jerNo = jerNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", jerNo=" + jerNo + ", name=" + name + ", totalScore=" + totalScore + "]";
	}
	
	
}

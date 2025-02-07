package com.user.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_profile")
	private String userProfile;
	
	@Column(name="user_followers")
	private long followersNo;
	
	
	private String description;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userProfile=" + userProfile + ", followersNo="
				+ followersNo + ", description=" + description + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String userName, String userProfile, long followersNo, String description) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userProfile = userProfile;
		this.followersNo = followersNo;
		this.description = description;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public long getFollowersNo() {
		return followersNo;
	}

	public void setFollowersNo(long followersNo) {
		this.followersNo = followersNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

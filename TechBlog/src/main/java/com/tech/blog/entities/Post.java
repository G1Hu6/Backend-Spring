package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
	
	private int pId;
	private String pTitle;
	private String pContent;
	private String pCode;
	private String pImage;
	private Timestamp pDate;
	private int catId;
	private int userId;
	
	public Post() {
		
	}
	
	public Post(String pTitle, String pContent, String pCode, String pImage, Timestamp pDate,int catId, int userId) {
		
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pImage = pImage;
		this.pDate = pDate;
		this.catId = catId;
		this.userId = userId;
	}
	
public Post(int pId,String pTitle, String pContent, String pCode, String pImage, Timestamp pDate,int catId, int userId) {
		
	this.pId = pId;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pImage = pImage;
		this.pDate = pDate;
		this.catId = catId;
		this.userId = userId;
	}
	
	public Post(String pTitle, String pContent, String pCode, String pImage,int catId) {
		
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pImage = pImage;
		this.catId = catId;
	}
	
	
	// Getters and Setters...
	
	public int getpId() {
		return pId;
	}
	
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public String getpTitle() {
		return pTitle;
	}
	
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	
	public String getpImage() {
		return pImage;
	}
	
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpCode() {
		return pCode;
	}
	
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	public Timestamp getpDate() {
		return pDate;
	}
	
	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

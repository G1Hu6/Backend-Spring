package com.spring_core.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("demo")
public class DemoSpel {
	
	@Value("#{23 + 90}")
	int x = 0;
	
	@Value("#{(22 > 33)? 22: 23}")
	int y = 0;
	
	@Value("#{ (java.lang.Math).sqrt(625)}")
	private double squrt;
	
	@Value("#{new java.lang.Boolean(true)}")
	private boolean isActive;
	
	@Value("#{ T(java.lang.Math).PI}")
	private double pi;
	
	@Value("#{new String(\"Pranav\")}")
	private String name;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getSqurt() {
		return squrt;
	}

	public void setSqurt(double squrt) {
		this.squrt = squrt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DemoSpel [x=" + x + ", y=" + y + ", squrt=" + squrt + ", isActive=" + isActive + ", pi=" + pi
				+ ", name=" + name + "]";
	}

	public DemoSpel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

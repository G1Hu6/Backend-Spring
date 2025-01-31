package com.standalone.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	
	private List<String> friends;
	@Autowired
	@Qualifier("fee")
	private Map<String, Integer> course;
	@Autowired
	@Qualifier("props")
	private Properties props;

	public Map<String, Integer> getCourse() {
		return course;
	}

	public void setCourse(Map<String, Integer> course) {
		this.course = course;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Person [friends=" + friends + "]";
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

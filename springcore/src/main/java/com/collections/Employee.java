package com.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Properties;

public class Employee {
	
	private String empName;
	private List<Integer> empPhoneNo;
	private Set<String> empLocations;
	private Properties props;
	private Map<String, String> empInfo;
	
	public Employee() {
		super();
	}
	
	public Employee(String empName, List<Integer> empPhoneNo, Set<String> empLocations, Properties props, Map<String, String> empInfo) {
		this.empName = empName;
		this.empPhoneNo = empPhoneNo;
		this.empLocations = empLocations;
		this.props = props;
		this.empInfo = empInfo;
	}

	public String getEmpName() {
		System.out.println("get name");
		return empName;
	}

	public void setEmpName(String empName) {
		System.out.println("set name");
		this.empName = empName;
	}

	public List<Integer> getEmpPhoneNo() {
		System.out.println("get phone");
		return empPhoneNo;
	}

	public void setEmpPhoneNo(List<Integer> empPhoneNo) {
		System.out.println("set phone");
		this.empPhoneNo = empPhoneNo;
	}

	public Set<String> getEmpLocations() {
		System.out.println("get locations");
		return empLocations;
	}

	public void setEmpLocations(Set<String> empLocations) {
		System.out.println("set locations");
		this.empLocations = empLocations;
	}

	public Properties getProps() {
		System.out.println("get props");
		return props;
	}

	public void setProps(Properties props) {
		System.out.println("set props");
		this.props = props;
	}

	public Map<String, String> getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(Map<String, String> empInfo) {
		this.empInfo = empInfo;
	}
 }

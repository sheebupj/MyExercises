package net.nestgroup.webmvc.dto;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDTO {
	
	private int id;
	
	private String firstName;
	
	private String address;
	 
	private Integer project;
	
	private String projectName;
	
	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	

}

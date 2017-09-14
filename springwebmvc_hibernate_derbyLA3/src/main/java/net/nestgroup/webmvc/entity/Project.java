package net.nestgroup.webmvc.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT1")
public class Project {
	@Id
	@Column(name = "pr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "PROJECT_DESTRIPTION")
	private String projectDiscription;
	
	
	 @OneToMany(mappedBy="project")
	 
	private Collection<Employee> employee ;
	
	public Collection<Employee> getEmployees() {
		return employee;
	}
	public void setEmployees(Collection<Employee> employees) {
		employee = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectDiscription() {
		return projectDiscription;
	}
	public void setProjectDiscription(String projectDiscription) {
		this.projectDiscription = projectDiscription;
	}
	public Collection<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Collection<Employee> employee) {
		this.employee = employee;
	}
	
	
}

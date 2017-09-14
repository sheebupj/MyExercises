package net.nestgroup.webmvc.utilities;

import java.util.ArrayList;
import java.util.List;

import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Project;

public class Utils {
	
	
	
	public static Employee getemplyee(){
		Employee employee= new Employee();
		employee.setFirstName("name1");
		
		Project project = new Project();
		
		project.setProjectName("projectmame1");
		
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(employee);
		project.setEmployees(employees);
	
		employee.setProject(project);
		
		return employee;
		
		
	}

}

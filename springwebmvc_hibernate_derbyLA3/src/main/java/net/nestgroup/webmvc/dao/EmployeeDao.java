package net.nestgroup.webmvc.dao;

import java.util.List;

import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Project;

public interface EmployeeDao {

	Project getProjectById(Integer id);

	Project addPorject(Project p);

	List<Project> listProjects();

	void addEmployee(Employee p);

	List<Employee> listEmps();

}
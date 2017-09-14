package net.nestgroup.webmvc.dao;

import java.util.List;

import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.entity.Project;

public interface PersonDAO {
	 public void addPerson(Person p);
	    public void updatePerson(Person p);
	    public List<Person> listPersons();
	    public Person getPersonById(int id);
	    public void removePerson(int id);
	    public Project addPorject(Project p);
	    public List<Project> listProjects();
		public Project getProjectById(Integer id);
		

}

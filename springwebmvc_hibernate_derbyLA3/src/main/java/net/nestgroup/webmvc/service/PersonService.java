package net.nestgroup.webmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import net.nestgroup.webmvc.dao.PersonDAO;
import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.entity.Project;

public interface PersonService {

	void setPersonDAO(PersonDAO personDAO);

	void addPerson(Person p);

	List<Person> listPersons();

	Project getProjectById(Integer id);

	void addProject(Project p);

	List<Project> listProject();

}
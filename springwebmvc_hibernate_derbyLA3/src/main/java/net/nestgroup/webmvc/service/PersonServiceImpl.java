package net.nestgroup.webmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import net.nestgroup.webmvc.dao.EmployeeDao;
import net.nestgroup.webmvc.dao.PersonDAO;
import net.nestgroup.webmvc.dto.EmployeeDTO;
import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.entity.Project;
import net.nestgroup.webmvc.utilities.EntityDTOConverters;
import net.nestgroup.webmvc.utilities.Utils;

@Service
public class PersonServiceImpl implements  PersonService {
     
    private PersonDAO personDAO;
   
    
    

	

	/* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#setPersonDAO(net.nestgroup.webmvc.dao.PersonDAO)
	 */

	public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#addPerson(net.nestgroup.webmvc.entity.Person)
	 */
 
	
    @Transactional
	public void addPerson(Person p) {
        this.personDAO.addPerson(p);
      
      
    }
    
    /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#listPersons()
	 */


    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }
    
    
    
    /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#getProjectById(java.lang.Integer)
	 */
 

    public Project getProjectById(Integer id) {
         
      return this.personDAO.getProjectById(id);
    }
    /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#addProject(net.nestgroup.webmvc.entity.Project)
	 */
 
	
    @Transactional
    public void addProject(Project p) {
        this.personDAO.addPorject(p);
        
    }
    /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.PersonService#listProject()
	 */
 

    @Transactional
    public List<Project> listProject() {
        return this.personDAO.listProjects();
        
    }
    
    
    
  
 
   
 
}

package net.nestgroup.webmvc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.entity.Project;

@Repository
public class PersonDAOImpl implements PersonDAO {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

	}


	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

		// logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();

		return personsList;
	}

	


	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		return p;
	}


	public Project getProjectById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project p = (Project) session.load(Project.class, id);
		return p;
	}

	
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}

	}

	
	
	public Project addPorject(Project p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return (Project) session.merge(p);
	}
	
	@SuppressWarnings("unchecked")

	public List<Project> listProjects() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Project> projectList = session.createQuery("from Project").list();
		return projectList;
	}

	

}

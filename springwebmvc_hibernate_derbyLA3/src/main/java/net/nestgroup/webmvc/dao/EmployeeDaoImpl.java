package net.nestgroup.webmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Project;

@Repository
public class EmployeeDaoImpl implements EmployeeDao  {
		// private static final Logger logger =
		// LoggerFactory.getLogger(PersonDAOImpl.class);

		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
		/* (non-Javadoc)
		 * @see net.nestgroup.webmvc.dao.EmployeeDao#getProjectById(java.lang.Integer)
		 */
		public Project getProjectById(Integer id) {
			Session session = this.sessionFactory.getCurrentSession();
			Project p = (Project) session.load(Project.class, id);
			return p;
		}
		/* (non-Javadoc)
		 * @see net.nestgroup.webmvc.dao.EmployeeDao#addPorject(net.nestgroup.webmvc.entity.Project)
		 */
		
		public Project addPorject(Project p) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			return (Project) session.merge(p);
		}
		
		/* (non-Javadoc)
		 * @see net.nestgroup.webmvc.dao.EmployeeDao#listProjects()
		 */
		@SuppressWarnings("unchecked")
			public List<Project> listProjects() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Project> projectList = session.createQuery("from Project").list();
			return projectList;
		}
		/* (non-Javadoc)
		 * @see net.nestgroup.webmvc.dao.EmployeeDao#addEmployee(net.nestgroup.webmvc.entity.Employee)
		 */
		public void addEmployee(Employee p) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			session.save(p);
		}
		/* (non-Javadoc)
		 * @see net.nestgroup.webmvc.dao.EmployeeDao#listEmps()
		 */
		@SuppressWarnings("unchecked")
		public List<Employee> listEmps() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Employee> EmployeeList = session.createQuery("from Employee").list();
			return EmployeeList;
		}

	


}

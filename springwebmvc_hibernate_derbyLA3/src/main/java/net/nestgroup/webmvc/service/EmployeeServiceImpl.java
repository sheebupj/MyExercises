package net.nestgroup.webmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.nestgroup.webmvc.dao.EmployeeDao;
import net.nestgroup.webmvc.dto.EmployeeDTO;
import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Project;
import net.nestgroup.webmvc.utilities.EntityDTOConverters;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
    
     

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	  /* (non-Javadoc)
	 * @see net.nestgroup.webmvc.service.EmployeeService#addEmployee(net.nestgroup.webmvc.dto.EmployeeDTO)
	 */


	    @Transactional
	    public void addEmployee(EmployeeDTO employeeDTO) {
	    	Project project = employeeDao.getProjectById(employeeDTO.getProject());
	    	Employee employee = EntityDTOConverters.dtoToEmployee(employeeDTO);
	    	employee.setProject(project);
	        this.employeeDao.addEmployee(employee);
	   }
	    
	    /* (non-Javadoc)
		 * @see net.nestgroup.webmvc.service.EmployeeService#listEmployee()
		 */

		
	    @Transactional
	    public List<EmployeeDTO> listEmployee() {
	        List<Employee> employees= this.employeeDao.listEmps();
	        List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
	        EmployeeDTO employeeDTO=null;
	        for(Employee employee:employees){
	        	employeeDTO=EntityDTOConverters.entityToDTOEmplyee(employee);
	        	employeeDTOs.add(employeeDTO);
	        }
	        return employeeDTOs;
	        
	    }

}

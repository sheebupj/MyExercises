package net.nestgroup.webmvc.utilities;

import net.nestgroup.webmvc.dto.EmployeeDTO;
import net.nestgroup.webmvc.entity.Employee;

public class EntityDTOConverters {
	
	public static Employee dtoToEmployee(EmployeeDTO employeeDTO){
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setAddress(employeeDTO.getAddress());
		return employee;
	}
	public static EmployeeDTO entityToDTOEmplyee(Employee employee){
		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setAddress(employee.getAddress());
		employeeDto.setProject(employee.getProject().getId());
		employeeDto.setProjectName(employee.getProject().getProjectName());
		return employeeDto;
	}

}

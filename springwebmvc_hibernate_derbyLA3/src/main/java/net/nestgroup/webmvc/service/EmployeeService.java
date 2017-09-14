package net.nestgroup.webmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import net.nestgroup.webmvc.dto.EmployeeDTO;

public interface EmployeeService {

	void addEmployee(EmployeeDTO employeeDTO);

	List<EmployeeDTO> listEmployee();

}
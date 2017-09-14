package net.nestgroup.webmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.nestgroup.webmvc.dto.EmployeeDTO;
import net.nestgroup.webmvc.entity.Employee;
import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.entity.Project;
import net.nestgroup.webmvc.service.EmployeeService;
import net.nestgroup.webmvc.service.PersonService;

@Controller
public class EmployeeProjectController {
	private PersonService personService;
	
	private EmployeeService employeeService;
	
public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String proejct(Model model) {
		model.addAttribute("project", new Project());
		return "project";
	}

	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public String listPersons(@ModelAttribute("project") Project p, Model model) {
		personService.addProject(p);
		model.addAttribute("projects", personService.listProject());
		return "project";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employeeDTO", new EmployeeDTO());
		model.addAttribute("projects", getProjects());
		model.addAttribute("projectid", new Integer(0));
		return "employee";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, Model model) {
		employeeService.addEmployee(employeeDTO);
		model.addAttribute("projects", getProjects());
		model.addAttribute("employeeDTO", new EmployeeDTO());
		model.addAttribute("employeeDTOs", employeeService.listEmployee());
		return "employee";
	}

	private Map<Integer, String> getProjects() {
		List<Project> projects = personService.listProject();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Project pr : projects) {
			map.put(pr.getId(), pr.getProjectName());
		}
		return map;
	}

}

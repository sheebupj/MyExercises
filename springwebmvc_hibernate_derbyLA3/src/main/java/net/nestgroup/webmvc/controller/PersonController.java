package net.nestgroup.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.nestgroup.webmvc.entity.Person;
import net.nestgroup.webmvc.service.PersonService;

@Controller
public class PersonController {
     

    private PersonService personService;
     
    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }
     
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String person(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }
    
    @RequestMapping(value = "/allpersons", method = RequestMethod.GET)
    public String listPersons(Model model) {
    	List<Person> persons = personService.listPersons();
        model.addAttribute("persons" , persons);
        return "allpersons";
    }
     
  
    
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p, Model model){
         
        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }
       // List<Person> persons = personService.listPersons();
       // model.addAttribute("persons" , persons);
         
        return  "allpersons";
         
    }
     
   
  
     
}

package com.orange.craft.api;

import com.orange.craft.entity.Person;

import com.orange.craft.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/API/V1")
public class PersonController {

    @Autowired
    private PersonService personService;


   @RequestMapping(value="/Persons" ,method =RequestMethod.GET)
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }


    @RequestMapping(value ="/Person/{id}",method =RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") long id)  {
        return personService.getPersonById(id);

    }

    @RequestMapping(value ="/Person/add",method =RequestMethod.POST)
    public Person AddPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @RequestMapping(value ="/Person/update/{id}",method =RequestMethod.PUT)
    public Person updatePerson(@PathVariable("id") long id,@RequestBody Person person) {
        return  personService.updatePerson(id,person);
    }

    @RequestMapping(value ="/Person/delete/{id}",method =RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id)  {
         personService.delete(id);

    }

}

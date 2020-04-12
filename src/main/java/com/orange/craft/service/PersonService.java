package com.orange.craft.service;


import com.orange.craft.entity.Person;
import com.orange.craft.repository.IpersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private IpersonRepository ipersonRepository;

    public List<Person> getAllPersons(){
        return ipersonRepository.findAll();
    }
    public Person getPersonById(long personId) throws ResourceNotFoundException{
        return ipersonRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found on :: " + personId));
    }

    public Person addPerson(Person person){
        return ipersonRepository.save(person);
    }

    public Person updatePerson(long personId,Person personUpdated){
        Person person = ipersonRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found on :: " + personId));
        person.setFirstName(personUpdated.getFirstName());
        person.setLastName(personUpdated.getLastName());
        person.setAddress(personUpdated.getAddress());

        return  ipersonRepository.save(person);
    }

    public void delete(long personId) {
        Person person = ipersonRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found on :: " + personId));
        ipersonRepository.delete(person);
    }

}

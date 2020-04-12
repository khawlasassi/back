package com.orange.craft.service;


import com.orange.craft.entity.Person;
import com.orange.craft.repository.IpersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private IpersonRepository ipersonRepository;

    @Test
    public void getAllPersonsShouldPassCorrectly() {
        // given
        Person person1 = new Person(1,"monsif","elgmiri","av al maghreb al Arabi ocean");
        Person person2 = new Person(2,"toto","titi","rue abtal agdal");
        ArrayList persons = new ArrayList() {{
            add(new Person(1,"monsif","elgmiri","av al maghreb al Arabi ocean"));
            add(new Person(2,"toto","titi","rue abtal agdal"));
        }};


        // when
        Mockito.when(ipersonRepository.findAll()).thenReturn(persons);

        // then
        List<Person> pers = personService.getAllPersons();
        Assert.assertEquals(2, pers.size());
    }

}


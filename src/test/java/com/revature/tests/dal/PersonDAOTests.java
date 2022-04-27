package com.revature.tests.dal;

import com.revature.dal.PersonDAOImp;
import com.revature.dal.PersonDAOInterface;
import com.revature.entity.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonDAOTests {

    public static PersonDAOInterface personDao;
    public static Person person;

    @BeforeClass
    public void setup(){
        personDao = new PersonDAOImp();
        person = new Person(0,"Test Person");
    }

    @Test(priority = 1)
    public void createPersonSuccess(){
        Person result = personDao.createPerson(person);
        Assert.assertNotEquals(result.getId(), 0);
    }

    @Test(dependsOnMethods = {"createPersonSuccess"})
    public void getPersonSuccess(){
        Assert.assertEquals(personDao.getPerson(1).getId(),1);
    }

    @Test
    public void personDoesNotExist(){
        Assert.assertNull(personDao.getPerson(0));
    }

}

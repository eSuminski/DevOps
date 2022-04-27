package com.revature.tests.sl;

import com.revature.custom_exception.NoDerrek;
import com.revature.custom_exception.PersonNotFound;
import com.revature.dal.PersonDAOImp;
import com.revature.dal.PersonDAOInterface;
import com.revature.entity.Person;
import com.revature.sl.PersonServiceImp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonServiceTests {

    public static PersonDAOInterface personDao;
    public static PersonServiceImp serviceImp;

    @BeforeClass
    public void setup(){
        personDao = new PersonDAOImp();
        serviceImp = new PersonServiceImp(personDao);
    }

    @Test(expectedExceptions = NoDerrek.class, expectedExceptionsMessageRegExp = "No Derreks allowed!")
    public void noDerek(){
        Person person = new Person(0,"Derrek");
        serviceImp.serviceCreatePerson(person);
    }

    @Test(expectedExceptions = PersonNotFound.class, expectedExceptionsMessageRegExp = "Could not find the person")
    public void personNotFound(){
        serviceImp.serviceGetPerson(0);
    }
}

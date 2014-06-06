package be.seriousbusiness.java.mongodb.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.java.mongodb.entity.Person;

@ContextConfiguration("classpath:test-application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPersonController {
	@Autowired 
	private PersonController personController;
	
	@After
	public void after(){
		personController=null;
	}
	
	/**
	 * Test the add and remove function of PersonController.</br>
	 * A new Person will be created and added, afterwards it will be deleted.
	 */
	@Test
	public void testAdd_remove(){
		final Person person=new Person();
		person.setFirstName("TestFirstName");
		person.setLastName("TestLastName");
		personController.add(person);
		List<Person> allPersons=personController.getAll();
		Assert.assertEquals("No person should be found.",1,allPersons.size());
		personController.remove(person);
		allPersons=personController.getAll();
		Assert.assertEquals("No person should be found.",0,allPersons.size());
	}
 
}

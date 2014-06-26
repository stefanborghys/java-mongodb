package be.seriousbusiness.java.mongodb.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.java.mongodb.entity.Person;

@ContextConfiguration({"classpath:test-application-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRepositoryTest extends MongoDbTestSetup {
	private static final Logger LOGGER=LoggerFactory.getLogger(PersonRepositoryTest.class);
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Check if a person cannot be found when looked up in the repository</br>
	 * by first and last name.
	 * @param person
	 */
	private void testPersonNotFound(final Person person){
		Person foundPerson=personRepository.findByFirstName(person.getFirstName());
		Assert.assertNull(foundPerson);
		foundPerson=personRepository.findByLastName(person.getLastName());
		Assert.assertNull(foundPerson);
	}
	
	/**
	 * Check if a person can be found when looked up in the repository</br>
	 * by it's first and last name.
	 * @param person
	 */
	private void testPersonFound(final Person person){
		Person foundPerson=personRepository.findByFirstName(person.getFirstName());
		Assert.assertNotNull(foundPerson);
		foundPerson=personRepository.findByLastName(person.getLastName());
		Assert.assertNotNull(foundPerson);
	}
	
	/**
	 * Test the CRUD operations of Spring's MongoRepository.</br>
	 * Added this test to verify if the MongoDB is up and running</br>
	 * and all Spring configuration is correct.</br>
	 * </br>
	 * This test will create a new Person containing a first and last name.</br>
	 * Both will be updated and afterwards the Person is deleted.
	 */
	@Test
	public void testCRUD(){
		final Long currentTimeMillis=System.currentTimeMillis();
		final String firstName="TestFirstName"+currentTimeMillis,
				lastName="TestLastName"+currentTimeMillis,
				updatedFirstName="UpdatedTestFirstName"+currentTimeMillis,
				updatedLastName="UpdatedTestLastName"+currentTimeMillis;
		final Person person=new Person();
		LOGGER.debug("New Person: {}",person);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		LOGGER.debug("Set Person first and last name: {}",person);
		testPersonNotFound(person);
		personRepository.save(person);
		testPersonFound(person);
		LOGGER.debug("Saved Person: {}",person);
		person.setFirstName(updatedFirstName);
		person.setLastName(updatedLastName);
		personRepository.save(person);
		testPersonFound(person);
		LOGGER.debug("Updated Person: {}",person);
		personRepository.delete(person);
		LOGGER.debug("Deleted Person: {}",person);
		testPersonNotFound(person);
	}

}

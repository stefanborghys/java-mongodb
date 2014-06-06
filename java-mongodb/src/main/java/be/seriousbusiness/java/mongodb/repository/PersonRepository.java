package be.seriousbusiness.java.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import be.seriousbusiness.java.mongodb.entity.Person;

public interface PersonRepository extends MongoRepository<Person,String> {
	public Person findByFirstName(final String firstName);
	public Person findByLastName(final String lastName);
}

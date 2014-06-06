package be.seriousbusiness.java.mongodb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.seriousbusiness.java.mongodb.entity.Person;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	public void add(final Person person){
		personRepository.save(person);
	}
	
	public List<Person> getAll(){
		return personRepository.findAll();
	}
 	
	public void remove(final Person person){
		personRepository.delete(person);
	}
	
}

package be.seriousbusiness.java.mongodb.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Person {
	@Id
	private String id;
	private String firstName;
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		final Map<String,Object> attributes=new HashMap<String,Object>();
		attributes.put("id",id);
		attributes.put("firstName",firstName);
		attributes.put("lastName",lastName);
		return EntityStringBuilder.toString("Person",attributes);
	}
	
	
}

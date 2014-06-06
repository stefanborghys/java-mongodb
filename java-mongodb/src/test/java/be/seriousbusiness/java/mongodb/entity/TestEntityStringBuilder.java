package be.seriousbusiness.java.mongodb.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestEntityStringBuilder {
	
	@Test
	public void testBuild(){
		final String ENTITY_NAME="Person",ID="id",FIRST_NAME="firstName",LAST_NAME="lastName";
		final int ID_VALUE=1234;
		final String FIRST_NAME_VALUE="test first name",LAST_NAME_VALUE="test last name";
		final Map<String,Object> attributes=new LinkedHashMap<String,Object>();
		attributes.put(ID,ID_VALUE);
		attributes.put(FIRST_NAME,FIRST_NAME_VALUE);
		attributes.put(LAST_NAME,LAST_NAME_VALUE);
		final String expected=ENTITY_NAME+"["+ID+"="+ID_VALUE+", "+FIRST_NAME+"='"+FIRST_NAME_VALUE+"', "+LAST_NAME+"='"+LAST_NAME_VALUE+"']";
		final String actual=EntityStringBuilder.toString(ENTITY_NAME,attributes);
		Assert.assertEquals("The returned entity string is incorrect.",expected,actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBuild_nullName(){
		final String ID="id",FIRST_NAME="firstName",LAST_NAME="lastName";
		final int ID_VALUE=1234;
		final String FIRST_NAME_VALUE="test first name",LAST_NAME_VALUE="test last name";
		final Map<String,Object> attributes=new LinkedHashMap<String,Object>();
		attributes.put(ID,ID_VALUE);
		attributes.put(FIRST_NAME,FIRST_NAME_VALUE);
		attributes.put(LAST_NAME,LAST_NAME_VALUE);
		EntityStringBuilder.toString(null,attributes);
	}
	
	@Test
	public void testBuild_nullMap(){
		final String ENTITY_NAME="Person";
		final String expected=ENTITY_NAME+"[]";
		final String actual=EntityStringBuilder.toString(ENTITY_NAME,null);
		Assert.assertEquals("The returned entity string is incorrect.",expected,actual);
	}

}

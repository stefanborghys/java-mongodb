package be.seriousbusiness.java.mongodb.entity;

import java.util.Map;

/**
 * 
 * @author seriousbusiness
 *
 */
public class EntityStringBuilder {
	
	/**
	 * Create a String representation of a an entity by providing the entity name and attributes.
	 * @param name Name of the entity
	 * @param attributes <code>Map</code> containing attribute(s) by name and value
	 * @return
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty.
	 */
	public static String toString(final String name,final Map<String,Object> attributes) throws IllegalArgumentException{
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The name cannot be null or empty");
		}
		final StringBuilder stringBuilder=new StringBuilder(name);
		stringBuilder.append("[");
		if(attributes!=null && !attributes.isEmpty()){
			for(Map.Entry<String,Object> attribute : attributes.entrySet()){
				stringBuilder.append(attribute.getKey()).append("=");
				final Object value=attribute.getValue();
				if(value==null){
					stringBuilder.append("NULL");
				}else if(value instanceof String){
					stringBuilder.append("'").append(value).append("'");
	
				}else{
					stringBuilder.append(value);
				}
				stringBuilder.append(",").append(" ");
	
			}
			stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

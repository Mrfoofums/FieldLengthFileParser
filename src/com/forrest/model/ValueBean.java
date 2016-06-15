/**
 * 
 */
package com.forrest.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Forrest Knight
 *
 */
public abstract class ValueBean {

	/**
	 * 
	 * @param fieldName the name of the field to set
	 * @param value to set it to
	 */
	public void setValue(String fieldName, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try{
		Method method = this.getClass().getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), new Class [] {value.getClass()});
		method.invoke(this, value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

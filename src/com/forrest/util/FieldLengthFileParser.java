/**
 * 
 */
package com.forrest.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.forrest.model.ValueBean;

/**
 * @author Forrest Knight
 *
 */
public class FieldLengthFileParser<T extends FieldLengthFileDescriptor, L extends ValueBean> {	

	/**
	 * 
	 */
	ArrayList<L> parsed = new ArrayList<L>();
	
	/**
	 * 
	 * @param path of the file
	 * @param descriptor user defined bean descriptor
	 * @param bean the bean to map to
	 * @return an Array of bean L
	 */
	public ArrayList<L> parse(Path path, T descriptor, L bean){
		System.out.println("in parse function");
		try(Stream<String> stream = Files.lines(path)){
			stream.forEach((s)->{
				try{
					parseLine(s,descriptor,bean);
				}catch(Exception ex){
					ex.printStackTrace();
					
				}
			});
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return parsed;
	}
	
/**
 * Parse this individual line
 * @param s
 * @param descriptor
 * @param bean
 * @throws InstantiationException
 * @throws IllegalAccessException
 */
private void parseLine(String s, T descriptor, L bean) throws InstantiationException, IllegalAccessException {
	System.out.println("In parse line function");
	 final L newBean = (L) bean.getClass().newInstance();
	 descriptor.getDescription().entrySet().stream().forEach((entry)->{
		 String value = "";
		 int start = entry.getValue().getStartPosition();
		 int end = entry.getValue().getEndPosition();
		 if(end <= s.length()){
			 try{
				 value = s.substring(start-1,end);
				 newBean.setValue(entry.getKey(), value);
				 parsed.add(newBean);
			 }catch(Exception ex){ex.printStackTrace();}
		 }
	 });
	 
	
}
	
	
}

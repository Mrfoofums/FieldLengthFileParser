/**
 * 
 */
package com.forrest.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

import com.forrest.util.FieldLengthFileParser;

/**
 * @author forrest
 *
 */
public class ParseTest {

	@Test
	public void testIt(){
		Path p = Paths.get("resources/testFile.txt");
		
		FieldLengthFileParser<TestDescriptor,TestBean> parser = new FieldLengthFileParser<TestDescriptor,TestBean>();
		ArrayList<TestBean> results =parser.parse(p, new TestDescriptor(), new TestBean());
		
		results.stream().forEach((line)->{
			System.out.println(line.getFirst());
			System.out.println(line.getSecond());
			System.out.println(line.getThird());
		});
	}
}

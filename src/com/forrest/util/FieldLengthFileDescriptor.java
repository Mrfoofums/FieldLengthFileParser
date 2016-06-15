package com.forrest.util;

import java.util.Map;

public interface FieldLengthFileDescriptor {
	
	/**
	 * Specify the position in the string for hte given fileName
	 */
	void addDescription(String fiedlName, Position p);
	/**
	 * 
	 * @return the description map
	 */
	Map<String,Position> getDescription();
}

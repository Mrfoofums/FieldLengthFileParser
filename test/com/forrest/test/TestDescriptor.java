package com.forrest.test;

import java.util.HashMap;
import java.util.Map;

import com.forrest.util.FieldLengthFileDescriptor;
import com.forrest.util.Position;

public class TestDescriptor implements FieldLengthFileDescriptor {

	private final HashMap<String,Position> descriptions = new HashMap<String, Position>();
	
	@Override
	public void addDescription(String fiedlName, Position p) {
		descriptions.putIfAbsent(fiedlName, p);
	}
	
	public TestDescriptor(){
		addDescription("first", new Position(1,4));
		addDescription("second", new Position(6,12));
		addDescription("third", new Position(14,18));
	}

	@Override
	public Map<String, Position> getDescription() {
		return descriptions;
	}

}

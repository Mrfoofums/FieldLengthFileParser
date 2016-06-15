package com.forrest.util;
/**
 * 
 * @author Forrest Knight
 *
 */
public class Position {

	private final int startPosition;
	private final int endPosition;
	
	public Position(int startPosition,int endPosition){
		this.startPosition=startPosition;
		this.endPosition=endPosition;
	}
	
	public int getStartPosition() {
		return startPosition;
	}

	public int getEndPosition() {
		return endPosition;
	}

}

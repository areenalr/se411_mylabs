package edu.psu.se411.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Class Under Unit Test.
 */
public class Stack {

	private final ArrayList<String> elements;
	
	public Stack() {
		this(10);
	}
	
	public Stack(int capacity) {
		int initCapacity = capacity > 0 ? capacity : 10;
		elements = new ArrayList<String>(initCapacity);
	}
	
	public void push(String pushValue) {
		elements.add(pushValue);
	}
	
	public String pop() {
		if(elements.isEmpty()) {
			throw new NoSuchElementException("Stack is empty, cannot pop");
		}
		
		return elements.remove(elements.size() - 1);
	}
	
	
	
}

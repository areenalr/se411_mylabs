package lab5;

import lab5.InvalidAgeException;

public class Ex1 {

	public static void validateAge(int age)throws InvalidAgeException {
		if(age <18) {
			throw new InvalidAgeException("Age must be 18 or older. Provided age:"
					+ " " + age);
		} else {
			System.out.println("Age valid message.");
		}
	}
	
	public static void main(String [] args) {
		try {
			validateAge(20);
			validateAge(15);
		} catch(InvalidAgeException e) {
			System.out.println("Caught exception:" + e.getMessage());
		}
	}

}
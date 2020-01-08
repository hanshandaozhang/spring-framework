package org.springframework.context.lookup;

/**
 * @author meisen
 * @date 2020-01-07
 */
public class User {
	private Long testId;

	private String testName;

	private int testAge;

	public User() {
	}

	public User(Long testId, String testName) {
		this.testId = testId;
		this.testName = testName;
	}

	public void showMe() {
		System.out.println("I'am a user");
	}

	private void testInitMethod() {
		System.out.println("This is a init method");
	}

	private void testDestroyMethod() {
		System.out.println("This is a destroy method");
	}

	public void print() {
		System.out.println("print something");
	}
}

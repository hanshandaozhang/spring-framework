package org.springframework.context.lookup;

/**
 * @author meisen
 * @date 2020-01-07
 */
public class User {
	private Long userId;

	private String userName;

	private int testAge;

	public User() {
	}

	public User(Long userId, String userName) {
		this.userId = userId;
		this.userName = userName;
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

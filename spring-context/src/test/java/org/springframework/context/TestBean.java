package org.springframework.context;

/**
 * @author meisen
 * @date 2020-01-07
 */
public class TestBean {
	private Long testId;

	private String testName;

	private int testAge;

	public TestBean() {
	}

	public TestBean(Long testId, String testName) {
		this.testId = testId;
		this.testName = testName;
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

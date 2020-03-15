package org.springframework.context.replaced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author meisen
 * @date 2020-01-08
 */
public class TestChangeMethod {

	public void changeMe() {
		System.out.println("changeMe");
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("services.xml");
		TestChangeMethod method = (TestChangeMethod) ac.getBean("testChangeMethod");
		method.changeMe();
	}
}

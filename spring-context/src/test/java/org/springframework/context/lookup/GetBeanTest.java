package org.springframework.context.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author meisen
 * @date 2020-01-08
 */
public abstract class GetBeanTest {

	private void showMe() {
		this.getBean().showMe();
	}

	public abstract User getBean();

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("services.xml");
		GetBeanTest test = (GetBeanTest) ac.getBean("getBeanTest");
		test.showMe();
	}
}

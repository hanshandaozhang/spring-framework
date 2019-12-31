package org.springframework.context;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.beans.Introspector;

/**
 * @author meisen
 * @date 2019-12-20
 */
public class LoadXmlTest {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
//		GenericApplicationContext context = new GenericApplicationContext();
//		new XmlBeanDefinitionReader(context).loadBeanDefinitions("service.xml");
//		context.refresh();
//		LoadXmlTest test = context.getBean("xmlTest", LoadXmlTest.class);
//		test.print();

		System.out.println(Introspector.decapitalize("LoadXmlTest") );
	}

	private void print() {
		System.out.println("1231231231`23");
	}

}

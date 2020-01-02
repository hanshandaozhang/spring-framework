package org.springframework.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

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

//		System.out.println(Introspector.decapitalize("LoadXmlTest") );

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("services.xml"));
		System.out.println(factory.getBeanDefinitionCount());
		LoadXmlTest test = factory.getBean("xmlTest", LoadXmlTest.class);
		test.print();
	}

	private void print() {
		System.out.println("1231231231`23");
	}

}

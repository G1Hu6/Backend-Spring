package com.spring_core.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_core/spel/config.xml");
		DemoSpel demo = context.getBean("demo",DemoSpel.class);
		System.out.println(demo);
		Expression expression = new SpelExpressionParser().parseExpression("12+12");
		System.out.println(expression.getValue());
	}
}

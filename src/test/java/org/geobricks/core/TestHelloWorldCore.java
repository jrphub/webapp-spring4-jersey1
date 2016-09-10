package org.geobricks.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

//This is needed for injection of beans by Autowiring
@RunWith(SpringJUnit4ClassRunner.class)
///WEB-INF is not accessible from the test classpath
//So, give fullpath
//@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext_main.xml")
//or put WEB-INF in classpath and give
@ContextConfiguration("classpath:applicationContext_test.xml")
//The below will find application context, but will through bean initialization errors
//@ContextConfiguration("classpath:**/applicationContext.xml")

@Component
public class TestHelloWorldCore extends TestCase {
	
	@Autowired
    private HelloWorldCore c;


	@Override
    protected void setUp() throws Exception {
        super.setUp();
    }
	
	@Test
    public void testSayHello() {
        assertEquals(c.sayHello("Guido"), "Hello Guido!");
    }
	
	@Test
    public void testSayHelloJSON() {
        assertEquals(c.sayHelloJSON("Guido"), "{\"hello\":\"Guido\"}");
    }

}
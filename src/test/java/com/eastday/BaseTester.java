package com.eastday;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.annotation.WebListener;



@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value="test")
@WebAppConfiguration
@TestExecutionListeners(listeners = {
		DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:spring-config.xml","classpath*:springMVC-servlet.xml"})
public class BaseTester {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

}

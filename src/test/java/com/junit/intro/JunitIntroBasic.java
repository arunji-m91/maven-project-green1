package com.junit.intro;

public class JunitIntroBasic {

	/*
	 * JUnit is an open source unit Testing tool and used to test small/large units
	 * of code Validation
	 * 
	 * To perform unit testing, we need to create test cases. The unit test case is
	 * a code which ensures that the program logic works as expected.
	 * 
	 * The org.junit package contains many interfaces and classes for junit testing
	 * such as Assert, Test, Before, After etc.
	 * 
	 * The Junit 4.x framework is annotation based,
	 * 
	 * Annotations
	 * 
	 * @BeforeClass -->if you want to execute some statement before all the test
	 * cases
	 * 
	 * @Before -->it will be executed before every @Test
	 * 
	 * @@Test -->Test cases
	 * 
	 * @After -->will be executed after every @Test annotated method
	 * 
	 * @AfterClass -->used if you want to execute some statement after all test
	 * cases in this order only execute
	 * 
	 * 
	 * @Ignore -->if you want to ignore some statements during test execution
	 * 
	 */

	// important rule
	/*
	 * no main method no need to create object to call any annotation method all
	 * annotation method should be public
	 * 
	 * @BeforeClass and @AfterClass both must be static
	 */

	/* some methods
	 * void assertEquals(boolean expected,boolean actual): checks that two
	  primitives/objects are equal. It is overloaded. 
	  
	  void assertTrue(boolean condition)  -->checks that a condition is true.
	  void assertFalse(boolean condition): checks that a condition is false.
	  void assertNull(Object obj): checks that object is null.
	  void assertNotNull(Object obj): checks that object is not null.
	  
	  
	 */

}

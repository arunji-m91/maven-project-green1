package suit.level.execution;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({T1.class,T2.class,T3.class})

public class Execution {
/*
 * suitlevel execution 
 * suit collection of classes
 * i create 3 classes for understanding
 * 
 * in junit we cannot run multiple classes at same time if we want to run multiple number of classes
 * we go for suit level
 * 
 * for suit level we need to create a class so this is that class
 * 
 * condition we mention given annotation
 * 
 * @RunWith(Suite.class)
 * @SuiteClasses({T1.class,T2.class,T3.class}) -->it mention in which class do you want to run all
 * test classes
 * 
 */
	
	public static void main(String[] args) {
		
		
		Result runClasses = JUnitCore.runClasses(Execution.class);
		int runCount = runClasses.getRunCount();
		System.out.println("total run count of test case "+runCount);
		
		int ignoreCount = runClasses.getIgnoreCount();
		System.out.println("the ignore count is "+ignoreCount);
		
		int failureCount = runClasses.getFailureCount();
		System.out.println("the failure test count is "+failureCount);
		/*
		 * if you want to test ignore and failure 
		 * give @ignore annotation and check
		 * and make any testcase to fail and check
		 */
		
		List<Failure> failures = runClasses.getFailures();
		for (Failure failure : failures) {
			System.out.println("the failures count are :"+failures);
			
		}
	}
	
	
	
	
	
	
	
}

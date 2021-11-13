

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import java.io.IOException;

import org.junit.runner.Runner;

import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;



public class testRunner {

	
	
	@Test
public void SoapTest() {
	

try {
		WsdlProject ws= new WsdlProject("F:\\SoapUI\\Automation-soapui-project.xml");
		
		TestSuite testsuite=ws.getTestSuiteByName("Testing");
		for(int i=0; i<testsuite.getTestCaseCount();i++)
		{
			System.out.println("Total test cases are"+testsuite.getTestCaseCount());
			WsdlTestCase testcase= (WsdlTestCase) testsuite.getTestCaseAt(i);
			TestRunner runner =testcase.run(new PropertiesMap(), false);
			System.out.println("testcase Completed");
			//Assert.assertEquals(Status.FINISHED, runner.getStatus());
		
			com.eviware.soapui.model.testsuite.TestRunner.Status status= runner.getStatus();
		
			System.out.println("This is status output==>"+status);
		//assert.assertEquals(com.eviware.soapui.model.iface.Submit.Status.FINISHED, runner.getStatus());
			assertEquals((com.eviware.soapui.model.iface.Submit.Status.FINISHED).toString(), runner.getStatus().toString());
		//assertEquals(Status.FINISHED, runner.getStatus());
		}
		

	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	}


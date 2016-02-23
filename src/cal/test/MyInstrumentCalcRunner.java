package cal.test;

import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;
import junit.framework.TestSuite;


public class MyInstrumentCalcRunner extends InstrumentationTestRunner {
	@Override
	public TestSuite getAllTests(){
		InstrumentationTestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(CalcTestCase.class);
		return suite;
	}
	
	@Override
	public ClassLoader getLoader(){
		return MyInstrumentCalcRunner.class.getClassLoader();
	}

}

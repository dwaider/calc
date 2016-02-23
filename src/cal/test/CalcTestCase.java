package cal.test;

import cal.rash.CalcRegul;
import junit.framework.Assert;
import junit.framework.TestCase;

public class CalcTestCase extends TestCase {
	private CalcRegul calculator;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCalc1(){
		calculator = CalcRegul.get();
		CalcRegul.setText("1+2*4+3-5");
	    Assert.assertEquals("7.0", calculator.getScob());
	    
	}	
	public void testCalc2(){
		calculator = CalcRegul.get();
		calculator.setText("1+2+((5*4*7)*65+3)-(3+8)");
	    Assert.assertEquals("9095.0", calculator.getScob());
	    
	}
	
	public void testCalc3(){
		calculator = CalcRegul.get();
		calculator.setText("12/6");
	    Assert.assertEquals("2.0", calculator.getScob());
	}
	
	public void testCalc4(){
		calculator = CalcRegul.get();
		calculator.setText("12/6+(10.0*3+1)");
	    Assert.assertEquals("33.0", calculator.getScob());
	}

}

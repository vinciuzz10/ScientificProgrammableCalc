package CustomClasses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Group #14
 */
public class ComplexNumberTest {
    
    private ComplexNumber n1;
    private ComplexNumber n2;
    private ComplexNumber n3;
    private ComplexNumber n4;
    private ComplexNumber n5;
    private ComplexNumber n6;
    
    public ComplexNumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        n1 = new ComplexNumber(5, 3);
        n2 = new ComplexNumber(4, 2);
        n3 = new ComplexNumber(3, 0);
        n4 = new ComplexNumber(2, 0);
        n5 = new ComplexNumber(0, 1);
        n6 = new ComplexNumber(0, 3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        double expResult = 3.0;
        double result = n1.getImaginary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        double expResult = 5.0;
        double result = n1.getReal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getComplexString method, of class ComplexNumber.
     */
    @Test
    public void testGetComplexString() {
        System.out.println("getComplexString");
        String expResult = "5.0+3.0j";
        String result = n1.getComplexString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber expResult1 = new ComplexNumber(9,5);
        ComplexNumber result1 = n1.add(n2);
        assertTrue(expResult1.equals(result1));
        
        ComplexNumber expResult2 = new ComplexNumber(5);
        ComplexNumber result2 = n3.add(n4);
        assertTrue(expResult2.equals(result2));
        
        ComplexNumber expResult3 = new ComplexNumber(0,4);
        ComplexNumber result3 = n5.add(n6);
        assertTrue(expResult3.equals(result3));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The testAdd failed.\n Expected:"+ expResult.getComplexString()+"\nObtained:"+result.getComplexString());
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber expResult1 = new ComplexNumber(1,1);
        ComplexNumber result1 = n1.subtract(n2);
        assertTrue(expResult1.equals(result1));
        
        ComplexNumber expResult2 = new ComplexNumber(1);
        ComplexNumber result2 = n3.subtract(n4);
        assertTrue(expResult2.equals(result2));
        
        ComplexNumber expResult3 = new ComplexNumber(0,-2);
        ComplexNumber result3 = n5.subtract(n6);
        assertTrue(expResult3.equals(result3)); 
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        
        // complex * complex
        ComplexNumber expResult1 = new ComplexNumber(14,22);
        ComplexNumber result1 = n1.multiply(n2);
        assertTrue(expResult1.equals(result1));
        
        // real * real
        ComplexNumber expResult2 = new ComplexNumber(6);
        ComplexNumber result2 = n3.multiply(n4);
        assertTrue(expResult2.equals(result2));
        
        // imaginary * imaginary
        ComplexNumber expResult3 = new ComplexNumber(-3);
        ComplexNumber result3 = n5.multiply(n6);
        assertTrue(expResult3.equals(result3));
        
        // real * imaginary 
        ComplexNumber expResult4 = new ComplexNumber(15, 9);
        ComplexNumber result4 = n1.multiply(n3);
        assertTrue(expResult4.equals(result4));
        
        // multiply by 0
        ComplexNumber expResult5 = new ComplexNumber(0);
        ComplexNumber result5 = n1.multiply(ComplexNumber.ZERO);
        assertTrue(expResult5.equals(result5));
        
    }

    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        
        // complex / complex
        ComplexNumber expResult1 = new ComplexNumber(1.3,0.1);
        ComplexNumber result1 = n1.divide(n2);
        assertTrue(expResult1.equals(result1));
        
        // real / real
        ComplexNumber expResult2 = new ComplexNumber(1.5);
        ComplexNumber result2 = n3.divide(n4);
        assertTrue(expResult2.equals(result2));
        
        // imaginary / imaginary
        ComplexNumber expResult3 = new ComplexNumber(0.33333333);
        ComplexNumber result3 = n5.divide(n6);
        assertTrue(expResult3.equals(result3));
        
        // imaginary / real 
        ComplexNumber expResult4 = new ComplexNumber(1.66666666, 1);
        ComplexNumber result4 = n1.divide(n3);
        assertTrue(expResult4.equals(result4));
        
        // divide by 0
        ComplexNumber expResult5 = new ComplexNumber(Double.POSITIVE_INFINITY);
        ComplexNumber result5 = n1.divide(ComplexNumber.ZERO);
        assertTrue(expResult5.equals(result5));
    }

    /**
     * Test of abs method, of class ComplexNumber.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        double expResult = 5.83095189;
        double result = n1.abs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of phase method, of class ComplexNumber.
     */
    @Test
    public void testPhase() {
        System.out.println("phase");
        ComplexNumber instance = new ComplexNumber(6,12.0);
        double expResult1 = Math.atan(12/6);
        double result1 = instance.phase();
        assertEquals(expResult1, result1, 0.0);
        
        // phase of 0 = NaN
        double expResult2 = Double.NaN;
        double result2 = ComplexNumber.ZERO.phase();
        assertEquals(expResult1, result1, 0.0);
        
        // phase of positive real number
        double expResult3 = 0;
        double result3 = n3.phase();
        assertEquals(expResult3, result3, 0.0);
        
        // phase of imaginary real number
        double expResult4 = Math.PI/2;
        double result4 = n5.phase();
        assertEquals(expResult4, result4, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        
        // Sqrt of a complex Number
        ComplexNumber expResult1 = new ComplexNumber(2.32711751,0.64457423);
        ComplexNumber result1 = n1.sqrt();
        assertEquals(expResult1, result1);
        
        // Sqrt of 0
        ComplexNumber expResult2 = new ComplexNumber(0);
        ComplexNumber result2 = ComplexNumber.ZERO.sqrt();
        assertEquals(expResult2, result2);
        
        // Sqrt of negative real number
        ComplexNumber expResult3 = new ComplexNumber(0,2);
        ComplexNumber result3 = new ComplexNumber(-4).sqrt();
        assertEquals(expResult3, result3);
        
        // Sqrt of imaginary number
        ComplexNumber expResult4 = new ComplexNumber(1.41421356,-1.41421357);
        ComplexNumber result4 = new ComplexNumber(0,-4).sqrt();
        assertEquals(expResult4, result4);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of opposite method, of class ComplexNumber.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        ComplexNumber expResult = new ComplexNumber(-5,-3);
        ComplexNumber result = n1.opposite();
        assertTrue(expResult.equals(result));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of conjugate method, of class ComplexNumber.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        
        ComplexNumber expResult1 = new ComplexNumber(5,-3);
        ComplexNumber result1 = n1.conjugate();
        assertTrue(expResult1.equals(result1));
        
        // conjugate of 0
        ComplexNumber expResult2 = new ComplexNumber(0);
        ComplexNumber n0 = new ComplexNumber(0);
        ComplexNumber result2 = n0.conjugate();
        assertTrue(expResult2.equals(result2));
        
        // conjugate of imaginary number
        ComplexNumber expResult3 = new ComplexNumber(0,-3);
        ComplexNumber result3 = n6.conjugate();
        assertTrue(expResult3.equals(result3));
        
        // conjugate of real number
        ComplexNumber expResult4 = new ComplexNumber(3);
        ComplexNumber result4 = n3.conjugate();
        assertTrue(expResult4.equals(result4));
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber(-123.76,-98.765);
        String expResult = "-123.76-98.765j";
        String result = instance.getComplexString();
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ComplexNumber.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ComplexNumber(2.0,-4.0);
        ComplexNumber instance = new ComplexNumber(2.0,-4.0);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parseComplexNumber method, of class ComplexNumber.
     */
    @Test
    public void testParseComplexNumber() {
        System.out.println("parseComplexNumber");
        String numberAsString = "5+3j";
        ComplexNumber expResult = new ComplexNumber(5,3);
        ComplexNumber result = ComplexNumber.parseComplexNumber(numberAsString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

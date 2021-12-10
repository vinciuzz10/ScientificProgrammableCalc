package CustomClasses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlfonsoGiso
 */
public class ComplexNumberTest {
    
    private ComplexNumber n1;
    private ComplexNumber n2;
    
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
        ComplexNumber expResult = new ComplexNumber(9,5);
        ComplexNumber result = n1.add(n2);
        assertTrue(expResult.equals(result));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The testAdd failed.\n Expected:"+ expResult.getComplexString()+"\nObtained:"+result.getComplexString());
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber expResult = new ComplexNumber(1,1);
        ComplexNumber result = n1.subtract(n2);
        assertTrue(expResult.equals(result));   
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber expResult = new ComplexNumber(14,22);
        ComplexNumber result = n1.multiply(n2);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        ComplexNumber instance = new ComplexNumber(3,-7);
        ComplexNumber other = new ComplexNumber(2,4);
        ComplexNumber expResult = new ComplexNumber(-1.10000001,-1.3);
        ComplexNumber result = instance.divide(other);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of abs method, of class ComplexNumber.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        ComplexNumber instance = new ComplexNumber(-8,15);
        double expResult = 17;
        double result = instance.abs();
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
        double expResult = Math.atan(12/6);
        double result = instance.phase();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber instance = new ComplexNumber(3,-7);
        ComplexNumber expResult = new ComplexNumber(2.30388509,-1.51917299);
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of opposite method, of class ComplexNumber.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        ComplexNumber instance = new ComplexNumber(-7,56);
        ComplexNumber expResult = new ComplexNumber(7,-56);
        ComplexNumber result = instance.opposite();
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
        ComplexNumber instance = new ComplexNumber(13,-24);
        ComplexNumber expResult = new ComplexNumber(13,24);
        ComplexNumber result = instance.conjugate();
        assertTrue(expResult.equals(result));
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

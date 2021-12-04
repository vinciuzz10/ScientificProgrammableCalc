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
        ComplexNumber instance = new ComplexNumber(12,45);
        double expResult = 45.0;
        double result = instance.getImaginary();
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
        ComplexNumber instance = new ComplexNumber(34.13,76);
        double expResult = 34.13;
        double result = instance.getReal();
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
        ComplexNumber instance = new ComplexNumber(12,-78);
        String expResult = "12.0-78.0j";
        String result = instance.getComplexString();
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
        ComplexNumber instance = new ComplexNumber(1,1);
        ComplexNumber other = new ComplexNumber(4,-3);
        ComplexNumber expResult = new ComplexNumber(5,-2);
        ComplexNumber result = instance.add(other);
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
        ComplexNumber instance = new ComplexNumber(1,1);
        ComplexNumber other = new ComplexNumber(4,-3);
        ComplexNumber expResult = new ComplexNumber(-3,4);
        ComplexNumber result = instance.subtract(other);
        assertTrue(expResult.equals(result));   
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber instance = new ComplexNumber(2,3);
        ComplexNumber other = new ComplexNumber(4,7);
        ComplexNumber expResult = new ComplexNumber(-13,26);
        ComplexNumber result = instance.multiply(other);
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
        ComplexNumber expResult = new ComplexNumber(-1.1,-1.3);
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
        ComplexNumber expResult = new ComplexNumber(2.303,-1.52);
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
    
}
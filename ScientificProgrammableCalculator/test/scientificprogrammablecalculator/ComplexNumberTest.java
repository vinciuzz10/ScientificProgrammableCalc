/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package scientificprogrammablecalculator;

import ComplexNumberClass.ComplexNumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfa1
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
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplexString method, of class ComplexNumber.
     */
    @Test
    public void testGetComplexString() {
        System.out.println("getComplexString");
        ComplexNumber instance = null;
        String expResult = "";
        String result = instance.getComplexString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber other = new ComplexNumber(4,-3);
        ComplexNumber instance = new ComplexNumber(1,1);
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
        ComplexNumber other = new ComplexNumber(4,-3);
        ComplexNumber instance = new ComplexNumber(1,1);
        ComplexNumber expResult = new ComplexNumber(-3,4);
        ComplexNumber result = instance.subtract(other);
        assertTrue(expResult.equals(result));   
        // TODO review the generated test code and remove the default call to fail.
        //fail("The testSubtract failed.\n Expected:"+ expResult.getComplexString()+"\nObtained:"+result.getComplexString());
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber other = new ComplexNumber(4,7);
        ComplexNumber instance = new ComplexNumber(2,3);
        ComplexNumber expResult = null;
        ComplexNumber result = instance.multiply(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        ComplexNumber other = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.divide(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of abs method, of class ComplexNumber.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.abs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of phase method, of class ComplexNumber.
     */
    @Test
    public void testPhase() {
        System.out.println("phase");
        ComplexNumber instance = null;
        double expResult = 0.0;
        double result = instance.phase();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class ComplexNumber.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.sqrt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of opposite method, of class ComplexNumber.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjugate method, of class ComplexNumber.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.conjugate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

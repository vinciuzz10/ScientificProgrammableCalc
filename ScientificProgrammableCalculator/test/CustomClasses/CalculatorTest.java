package CustomClasses;

import DataStructures.Variables;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vinciuzz10
 */
public class CalculatorTest {
    
    private Calculator calc;
    private ComplexNumber n1;
    private ComplexNumber n2;
    private Variables var;
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calc = new Calculator();
        n1 = new ComplexNumber(1,2);
        n2 = new ComplexNumber(2,3);
        var = calc.getVar();
        calc.push(n1);
        calc.push(n2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class Calculator.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        ComplexNumber expResult = n1.add(n2);
        calc.sum();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class Calculator.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ComplexNumber expResult = n1.subtract(n2);
        calc.difference();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of product method, of class Calculator.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        ComplexNumber expResult = n1.multiply(n2);
        calc.product();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of quotient method, of class Calculator.
     */
    @Test
    public void testQuotient() {
        System.out.println("quotient");
        ComplexNumber expResult = n1.divide(n2);
        calc.quotient();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber expResult = n2.sqrt();
        calc.sqrt();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        ComplexNumber expResult = n2.opposite();
        calc.invertSign();
        assertTrue(expResult.equals(calc.pop()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of storeInVariable method, of class Calculator.
     */
    @Test
    public void testStoreInVariable() {
        System.out.println("storeInVariable");
        Character varKey = 'A';
        calc.storeInVariable(varKey);
        assertTrue(var.get(varKey).equals(n2));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pickFromVariable method, of class Calculator.
     */
    @Test
    public void testPickFromVariable() {
        System.out.println("pickFromVariable");
        Character varKey = 'A';
        calc.pickFromVariable(varKey);
        assertTrue(calc.pop().equals(var.get(varKey)));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("addToVariable");
        Character varKey = 'A';
        ComplexNumber expResult = n2.add(n1);
        calc.storeInVariable(varKey);
        calc.addToVariable(varKey);
        assertTrue(var.get(varKey).equals(expResult));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test
    public void testSubtractToVariable() {
        System.out.println("subtractToVariable");
        Character varKey = 'A';
        ComplexNumber expResult = n2.subtract(n1);
        calc.storeInVariable(varKey);
        calc.subtractToVariable(varKey);
        assertTrue(var.get(varKey).equals(expResult));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executeUserOperation method, of class Calculator.
     */
    @Test
    public void testExecuteUserOperation() {
        System.out.println("executeUserOperation");
        UserOperation op = null;
        Calculator instance = new Calculator();
        boolean expResult = false;
        boolean result = instance.executeUserOperation(op);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowedOperations method, of class Calculator.
     */
    @Test
    public void testGetAllowedOperations() {
        System.out.println("getAllowedOperations");
        Calculator instance = new Calculator();
        Set<String> expResult = null;
        Set<String> result = instance.getAllowedOperations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOperationToMap method, of class Calculator.
     */
    @Test
    public void testAddOperationToMap() {
        System.out.println("addOperationToMap");
        UserOperation op = null;
        Calculator instance = new Calculator();
        instance.addOperationToMap(op);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

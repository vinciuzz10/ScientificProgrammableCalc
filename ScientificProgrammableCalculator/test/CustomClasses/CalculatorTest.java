package CustomClasses;

import DataStructures.NumberStack;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStack method, of class Calculator.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack");
        Calculator instance = new Calculator();
        NumberStack expResult = null;
        NumberStack result = instance.getStack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVar method, of class Calculator.
     */
    @Test
    public void testGetVar() {
        System.out.println("getVar");
        Calculator instance = new Calculator();
        Variables expResult = null;
        Variables result = instance.getVar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sum method, of class Calculator.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Calculator instance = new Calculator();
        instance.sum();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class Calculator.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        Calculator instance = new Calculator();
        instance.difference();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of product method, of class Calculator.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        Calculator instance = new Calculator();
        instance.product();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quotient method, of class Calculator.
     */
    @Test
    public void testQuotient() {
        System.out.println("quotient");
        Calculator instance = new Calculator();
        instance.quotient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Calculator instance = new Calculator();
        instance.sqrt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        Calculator instance = new Calculator();
        instance.invertSign();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeInVariable method, of class Calculator.
     */
    @Test
    public void testStoreInVariable() {
        System.out.println("storeInVariable");
        Character varKey = null;
        Calculator instance = new Calculator();
        instance.storeInVariable(varKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pickFromVariable method, of class Calculator.
     */
    @Test
    public void testPickFromVariable() {
        System.out.println("pickFromVariable");
        Character varKey = null;
        Calculator instance = new Calculator();
        instance.pickFromVariable(varKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("addToVariable");
        Character varKey = null;
        Calculator instance = new Calculator();
        instance.addToVariable(varKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test
    public void testSubtractToVariable() {
        System.out.println("subtractToVariable");
        Character varKey = null;
        Calculator instance = new Calculator();
        instance.subtractToVariable(varKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeVariablesStatus method, of class Calculator.
     */
    @Test
    public void testStoreVariablesStatus() {
        System.out.println("storeVariablesStatus");
        Calculator instance = new Calculator();
        instance.storeVariablesStatus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restoreVariableStatus method, of class Calculator.
     */
    @Test
    public void testRestoreVariableStatus() {
        System.out.println("restoreVariableStatus");
        Calculator instance = new Calculator();
        instance.restoreVariableStatus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    
}

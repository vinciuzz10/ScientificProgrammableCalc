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
    
    private NumberStack stack;
    private Variables var;
    private Calculator calculator;
    private ComplexNumber n1;
    private ComplexNumber n2;
    
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
        stack = new NumberStack();
        var = new Variables();
        calculator = new Calculator(stack,var);
        n1 = new ComplexNumber(2,-4);
        n2 = new ComplexNumber(4,13);
        stack.push(n1);
        stack.push(n2);
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
        ComplexNumber expResult= new ComplexNumber(6,9);
        calculator.sum();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class Calculator.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ComplexNumber expResult= new ComplexNumber(-2,-17);
        calculator.difference();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of product method, of class Calculator.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        ComplexNumber expResult= new ComplexNumber(60,10);
        calculator.product();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of quotient method, of class Calculator.
     */
    @Test
    public void testQuotient() {
        System.out.println("quotient");
        ComplexNumber expResult= new ComplexNumber(-0.238,-0.228);
        calculator.quotient();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber expResult= new ComplexNumber(2.966,2.191);
        calculator.sqrt();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        ComplexNumber expResult= new ComplexNumber(-4,-13);
        calculator.invertSign();
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of storeInVariable method, of class Calculator.
     */
    @Test
    public void testStoreInVariable() {
        System.out.println("storeInVariable");
        Character varKey = 'J';
        calculator.storeInVariable(varKey);
        assertEquals(var.get(varKey),n2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pickFromVariable method, of class Calculator.
     */
    @Test
    public void testPickFromVariable() {
        System.out.println("pickFromVariable");
        Character varKey = 'K';
        var.put(varKey,stack.pop());
        calculator.pickFromVariable(varKey);
        assertEquals(var.get(varKey),n2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("addToVariable");
        Character varKey = 'S';
        var.put(varKey,stack.pop());
        calculator.addToVariable(varKey);
        assertEquals(var.get(varKey),n1.add(n2));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test
    public void testSubtractToVariable() {
        System.out.println("subtractToVariable");
        Character varKey = 'S';
        var.put(varKey,stack.pop());
        calculator.subtractToVariable(varKey);
        assertEquals(var.get(varKey),n2.subtract(n1));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of executeUserOperation method, of class Calculator.
     */
    @Test
    public void testExecuteUserOperation() {
        System.out.println("executeUserOperation");
        String[] s ={"+","rad"};
        UserOperation op = new UserOperation("test",s);
        ComplexNumber expResult = n1.add(n2).sqrt();
        calculator.executeUserOperation(op);
        assertEquals(expResult,stack.pop());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of storeVariablesStatus method, of class Calculator.
     */
    @Test
    public void testStoreVariablesStatus() {
        System.out.println("storeVariablesStatus");
        Calculator instance = null;
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
        Calculator instance = null;
        boolean expResult = false;
        instance.restoreVariableStatus();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowedOperations method, of class Calculator.
     */
    @Test
    public void testGetAllowedOperations() {
        System.out.println("getOperationsAllowed");
        Calculator instance = null;
        Set<String> expResult = null;
        Set<String> result = instance.getAllowedOperations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

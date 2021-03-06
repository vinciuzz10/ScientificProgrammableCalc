package DataStructures;

import CustomClasses.ComplexNumber;
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
public class VariablesTest {
    
    private Variables var;
    
    public VariablesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        var = new Variables();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addToVariable method, of class Variables.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("addToVariable");
        Character variableKey = 'A';
        ComplexNumber expValue = new ComplexNumber(3, 3);
        ComplexNumber value = new ComplexNumber(1, 1);
        var.put('A', new ComplexNumber(2, 2));
        
        var.addToVariable(variableKey, value);
        assertTrue(var.get(variableKey).equals(expValue));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtractToVariable method, of class Variables.
     */
    @Test
    public void testSubtractToVariable() {
        System.out.println("subtractToVariable");
        Character variableKey = 'A';
        ComplexNumber expValue = new ComplexNumber(2, 2);
        ComplexNumber value = new ComplexNumber(1, 1);
        var.put('A', new ComplexNumber(3, 3));
        
        var.subtractToVariable(variableKey, value);
        assertTrue(var.get(variableKey).equals(expValue));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}

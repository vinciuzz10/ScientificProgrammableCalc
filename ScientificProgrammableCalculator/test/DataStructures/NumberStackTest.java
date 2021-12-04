package DataStructures;

import CustomClasses.ComplexNumber;
import DataStructures.NumberStack;
import java.util.ArrayList;
import java.util.List;
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
public class NumberStackTest {
    
    private NumberStack stack;
    private ComplexNumber n1;
    private ComplexNumber n2;
    private ComplexNumber n3;
    
    public NumberStackTest() {
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
        n1 = new ComplexNumber(1, 1);
        n2 = new ComplexNumber(2, 2);
        n3 = new ComplexNumber(3, 3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of swap method, of class NumberStack.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        stack.push(n1);
        stack.push(n2);
        stack.swap();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        stack.push(n1);
        stack.push(n2);
        stack.over();
        assertEquals(stack.pop(), n1);
        assertEquals(stack.pop(), n2);
        assertEquals(stack.pop(), n1);
    }

    /**
     * Test of dup method, of class NumberStack.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        stack.push(n1);
        stack.dup();
        assertTrue(stack.pop().equals(n1));
        assertTrue(stack.pop().equals(n1));
    }

    /**
     * Test of toList method, of class NumberStack.
     */
    @Test
    public void testToList() {
        System.out.println("toList");
        List<ComplexNumber> expResult = new ArrayList<>();
        
        /* Push 3 numbers onto the instance stack */
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);
        
        /* Add 3 ComplexNumbers to the expResult list */
        expResult.add(0, n3);
        expResult.add(1, n2);
        expResult.add(2, n1);
        
        /* Verify the results of toList method */
        List<ComplexNumber> result = stack.toList();
        for (int i=0;i<result.size();i++) {
            assertEquals(expResult.get(i), result.get(i));
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

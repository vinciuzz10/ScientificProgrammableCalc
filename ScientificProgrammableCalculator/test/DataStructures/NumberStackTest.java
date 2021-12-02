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
        NumberStack instance = new NumberStack();
        ComplexNumber n1 = new ComplexNumber(5,2);
        ComplexNumber n2 = new ComplexNumber(6,3);
        instance.push(n1);
        instance.push(n2);
        instance.swap();
        assertEquals(instance.pop(), n1);
        assertEquals(instance.pop(), n2);
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        NumberStack instance = new NumberStack();
        ComplexNumber n1 = new ComplexNumber(5,2);
        ComplexNumber n2 = new ComplexNumber(6,3);
        instance.push(n1);
        instance.push(n2);
        instance.over();
        assertEquals(instance.pop(), n1);
        assertEquals(instance.pop(), n2);
        assertEquals(instance.pop(), n1);
    }

    /**
     * Test of dup method, of class NumberStack.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        NumberStack instance = new NumberStack();
        ComplexNumber n = new ComplexNumber(5,2);
        instance.push(n);
        instance.dup();
        assertTrue(instance.pop().equals(n));
        assertTrue(instance.pop().equals(n));
    }

    /**
     * Test of toList method, of class NumberStack.
     */
    @Test
    public void testToList() {
        System.out.println("toList");
        NumberStack instance = new NumberStack();
        List<ComplexNumber> expResult = new ArrayList<>();
        
        ComplexNumber n1 = new ComplexNumber(1,1);
        ComplexNumber n2 = new ComplexNumber(2,2);
        ComplexNumber n3 = new ComplexNumber(3,3);
        
        /* Push 3 numbers onto the instance stack */
        instance.push(n1);
        instance.push(n2);
        instance.push(n3);
        
        /* Add 3 ComplexNumbers to the expResult list */
        expResult.add(0, n3);
        expResult.add(1, n2);
        expResult.add(2, n1);
        
        /* Verify the results of toList method */
        List<ComplexNumber> result = instance.toList();
        for (int i=0;i<result.size();i++) {
            assertEquals(expResult.get(i), result.get(i));
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

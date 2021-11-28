/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package scientificprogrammablecalculator.datastruct;

import DataStructures.NumberStack;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import CompleNumberClass.ComplexNumber;

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
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of over method, of class NumberStack.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        NumberStack instance = new NumberStack();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class NumberStack.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        NumberStack instance = new NumberStack();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toList method, of class NumberStack.
     */
    @Test
    public void testToList() {
        System.out.println("toList");
        NumberStack instance = new NumberStack();
        List<ComplexNumber> expResult = null;
        List<ComplexNumber> result = instance.toList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

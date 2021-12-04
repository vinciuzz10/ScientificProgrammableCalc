package CustomClasses;

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
public class UserOperationTest {
    
    public UserOperationTest() {
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
     * Test of getName method, of class UserOperation.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserOperation instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperation method, of class UserOperation.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        UserOperation instance = null;
        String[] expResult = null;
        String[] result = instance.getOperation();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperationAsString method, of class UserOperation.
     */
    @Test
    public void testGetOperationAsString() {
        System.out.println("getOperationAsString");
        UserOperation instance = null;
        String expResult = "";
        String result = instance.getOperationAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperation method, of class UserOperation.
     */
    @Test
    public void testSetOperation() {
        System.out.println("setOperation");
        String[] operation = null;
        UserOperation instance = null;
        instance.setOperation(operation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserOperation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserOperation instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

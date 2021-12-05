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
    String[] operations;
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
        String[] s= {"+","rad","-"};
        operations = s;
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
        UserOperation instance = new UserOperation("test",operations);
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOperation method, of class UserOperation.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        UserOperation instance = new UserOperation("test",operations);
        String[] expResult = {"+","rad","-"};
        String[] result = instance.getOperation();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOperationAsString method, of class UserOperation.
     */
    @Test
    public void testGetOperationAsString() {
        System.out.println("getOperationAsString");
        UserOperation instance = new UserOperation("test",operations);
        String expResult = "+ rad -";
        String result = instance.getOperationAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOperation method, of class UserOperation.
     */
    @Test
    public void testSetOperation() {
        System.out.println("setOperation");
        String[] operation = {"dup *"};
        UserOperation instance = new UserOperation("test",operations);
        instance.setOperation(operation);
        assertTrue(operation.equals(instance.getOperation()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserOperation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserOperation instance = new UserOperation("test",operations);
        String expResult = "UserOperation{name=test, operation=+ rad -}";
        String result = instance.toString();
        System.out.println(result);
        assertTrue(expResult.equals(result));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

package CustomClasses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Group #14
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CustomClasses.CalculatorTest.class, CustomClasses.UserOperationTest.class, CustomClasses.ComplexNumberTest.class})
public class CustomClassesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

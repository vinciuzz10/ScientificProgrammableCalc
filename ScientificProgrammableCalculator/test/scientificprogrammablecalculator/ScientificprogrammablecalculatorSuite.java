package scientificprogrammablecalculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author alfa1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DataStructures.DatastructSuite.class, CustomClasses.ComplexNumberTest.class, scientificprogrammablecalculator.ScientificProgrammableCalculatorTest.class, scientificprogrammablecalculator.FXMLDocumentControllerTest.class})
public class ScientificprogrammablecalculatorSuite {

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
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
@Suite.SuiteClasses({scientificprogrammablecalculator.datastruct.DatastructSuite.class, scientificprogrammablecalculator.ComplexNumberTest.class, scientificprogrammablecalculator.ScientificProgrammableCalculatorTest.class, scientificprogrammablecalculator.FXMLDocumentControllerTest.class, scientificprogrammablecalculator.exception.ExceptionSuite.class})
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GUI;

import CustomClasses.Calculator;
import CustomClasses.UserOperation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
public class FXMLUserOperationsControllerTest {
    
    public FXMLUserOperationsControllerTest() {
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
     * Test of initialize method, of class FXMLUserOperationsController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLUserOperationsController instance = new FXMLUserOperationsController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadInfo method, of class FXMLUserOperationsController.
     */
    @Test
    public void testLoadInfo() {
        System.out.println("loadInfo");
        List<UserOperation> operationsList = null;
        FXMLDocumentController mainCOntroller = null;
        Calculator calc = null;
        FXMLUserOperationsController instance = new FXMLUserOperationsController();
        instance.loadInfo(operationsList, calc, mainCOntroller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

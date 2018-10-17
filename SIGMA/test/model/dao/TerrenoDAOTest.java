/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ramires
 */
public class TerrenoDAOTest {
    
    private TerrenoDAO tDAO;
    
    public TerrenoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tDAO = new TerrenoDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class TerrenoDAO.
     */
    /*@Test
    public void testRead() {
        System.out.println("read");
        TerrenoDAO instance = new TerrenoDAO();
        List<Terreno> expResult = null;
        List<Terreno> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readOne method, of class TerrenoDAO.
     */
    @Test
    public void testReadOne() {
        System.out.println("readOne");
        //Cliente.setNome("teste");
        assertEquals(1, tDAO.readOne(1).size());
    }
    
    @Test
    public void testRead(){
        System.out.println("read");
        Cliente.setNome("teste");
        assertTrue(!tDAO.read().isEmpty());
    }

    
    
}

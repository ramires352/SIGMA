/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bean.Cliente;
import model.bean.Plantio;
import model.bean.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class PlantioDAOTest {
    
    PlantioDAO pDAO;
    
    public PlantioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pDAO = new PlantioDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readTerreno method, of class PlantioDAO.
     */
    @Test
    public void testReadTerreno() {

    }

    /**
     * Test of readFiltro method, of class PlantioDAO.
     */
    @Test
    public void testReadFiltro() {
        Cliente.setNome("teste");
        assertTrue(pDAO.readFiltro("01-12-2020", "02-12-2020").isEmpty());
    }

    /**
     * Test of read method, of class PlantioDAO.
     */
    @Test
    public void testRead() {
        Cliente.setNome("teste");
        assertTrue(pDAO.read().isEmpty());
    }

    /**
     * Test of delete method, of class PlantioDAO.
     */
    @Test
    public void testDelete() {

    }

    /**
     * Test of plantar method, of class PlantioDAO.
     */
    @Test
    public void testPlantar() {

    }
    
}

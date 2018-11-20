/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bean.Cliente;
import model.bean.Colheita;
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
public class ColheitaDAOTest {
    
    ColheitaDAO cDAO;
    
    public ColheitaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cDAO = new ColheitaDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class ColheitaDAO.
     */
    @Test
    public void testRead() {
        Cliente.setNome("teste");
        assertTrue(!cDAO.read().isEmpty());
    }

    /**
     * Test of readFiltro method, of class ColheitaDAO.
     */
    @Test
    public void testReadFiltro() {
        Cliente.setNome("teste");
        assertTrue(cDAO.readFiltro("01-12-2020", "02-12-2020").isEmpty());
    }

    /**
     * Test of readTerreno method, of class ColheitaDAO.
     */
    @Test
    public void testReadTerreno() {

    }
    
}

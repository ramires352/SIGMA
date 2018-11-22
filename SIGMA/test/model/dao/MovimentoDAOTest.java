/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bean.Cliente;
import model.bean.Movimento;
import model.bean.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael21
 */
public class MovimentoDAOTest {
    
    MovimentoDAO mDAO;
    
    public MovimentoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mDAO = new MovimentoDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readTerreno method, of class MovimentoDAO.
     */
    @Test
    public void testReadTerreno() {
        Cliente.setNome("teste");
        for(Movimento m: mDAO.readTerreno(12)){
            assertEquals(m.getIdTerreno(), 12);
        }
    }

    /**
     * Test of read method, of class MovimentoDAO.
     */
    @Test
    public void testRead() {
        Cliente.setNome("teste");
        assertTrue(!mDAO.read().isEmpty());
    }

    
}

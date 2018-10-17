/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.bean.Cliente;
import model.bean.Produto;
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
public class ProdutoDAOTest {
    
    ProdutoDAO pDAO;
    
    public ProdutoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pDAO = new ProdutoDAO();
                
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRead() {
        Cliente.setNome("teste");
        assertTrue(!pDAO.read().isEmpty());
    }


    /**
     * Test of readDefensivos method, of class ProdutoDAO.
     */
    @Test
    public void testReadDefensivos() {
        Cliente.setNome("teste");
        for(Produto p: pDAO.readDefensivos()){
            assertEquals(p.getTipo(), "Defensivo");
        }
    }
    
}

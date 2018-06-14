
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José
 */
public class DaoTest {
    
    public DaoTest() {
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

    @Test
    public void testInserir() {
        Dao<Administrador> dao = new Dao(Administrador.class);
        Administrador adm = new Administrador("PICAPAU", "Pica Pau", "1234");
        dao.inserir(adm);
    }
    
    
//    @Test
//    public void testListar() {
//        Dao<Administrador> dao = new Dao(Administrador.class);
//        List<Administrador> lista = dao.listarTodos();
//        for (Administrador adm : lista){
//            System.out.println(adm.getId() + " - "+adm.getLogin());
//        }
//        
//    }
    
}

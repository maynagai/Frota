
package dao;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Administrador;
import util.JpaUtil;

public class AdministradorDao implements Serializable { 
        
    public Administrador buscarPorNome(String nome) {
        Administrador temp = null;
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.nome = :n";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("n", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    
    public Administrador buscarPorNome(Administrador adm) {
        Administrador temp = null;
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.nome = :n";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("n", adm.getNome());
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
}

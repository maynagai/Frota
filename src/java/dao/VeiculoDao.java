
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Veiculo;
import util.JpaUtil;


public class VeiculoDao implements Serializable{
    
    public Veiculo buscarPorPlaca(String placa) {
        Veiculo temp = new Veiculo();
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT v FROM Veiculo v WHERE v.placa = :p";
        TypedQuery<Veiculo> query = manager.createQuery(sql, Veiculo.class);
        query.setParameter("p", placa);
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

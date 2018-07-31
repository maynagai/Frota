
package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Emprestimo;
import modelo.Usuario;
import modelo.Veiculo;

@ManagedBean (name="emprestarVeiculo")
@ViewScoped
public class EmprestarVeiculo implements Serializable{   

    private List<Veiculo> veiculos;
    private List<Usuario> usuarios;
    private Dao<Veiculo> daoVeiculo;
    private Dao<Usuario> daoUsuario;
    private Emprestimo emprestimo; 
    Dao<Emprestimo> daoEmprestimo; 
    
    public EmprestarVeiculo(){
        daoVeiculo = new Dao(Veiculo.class);
        daoUsuario = new Dao(Usuario.class);
        veiculos = daoVeiculo.listarTodos();
        usuarios = daoUsuario.listarTodos();
        daoEmprestimo = new Dao(Emprestimo.class);
        emprestimo = new Emprestimo();    
    }
    
    public void registrarEmprestimo(){
        daoEmprestimo.inserir(emprestimo);
        emprestimo = new Emprestimo(); 
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Retirada gravada com sucesso", null));
    }
      
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dao<Veiculo> getDaoVeiculo() {
        return daoVeiculo;
    }

    public void setDaoVeiculo(Dao<Veiculo> daoVeiculo) {
        this.daoVeiculo = daoVeiculo;
    }

    public Dao<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(Dao<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }
    
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
}

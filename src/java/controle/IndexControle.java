
package controle;

import dao.AdministradorDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Administrador;

/**
 * Controlador para página de index
 * @author José
 */
@ManagedBean (name="indexControle")
@ViewScoped
public class IndexControle implements Serializable{
    private Administrador adm;
    
    public IndexControle(){
        adm = new Administrador();
    }
    
    public String autenticar(){
        this.adm.setLogin(adm.getLogin().toUpperCase());
        AdministradorDao dao = new AdministradorDao();
        Administrador temp;
        temp = dao.autenticar(adm);
        if (temp == null){  // se houver erro, método autenticar no dao retorna null
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
            return null;  //fica na página
        }  
        return "menu";    // menu.xhtml
    }
    
      public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }
}

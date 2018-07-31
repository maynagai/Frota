package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Registra cada utilização de um veículo.
 *
 * @author José
 */
@Entity
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date retirada;
    @Column
    @Temporal(TemporalType.DATE)
    private Date devolucao;
    @ManyToOne(optional=false )     // MUITOS Emprestimos para UM Veiculo
    @JoinColumn(name="veiculo")
    private Veiculo veiculo;
    @ManyToOne(optional=false )       // MUITOS comprovantes para UM aluno
    @JoinColumn(name="usuario")
    private Usuario usuario;

    public Emprestimo() {
        this.veiculo = new Veiculo();
        this.retirada = new Date();
        this.devolucao = new Date();
        this.usuario = new Usuario();
    }

    public Emprestimo(Veiculo veiculo, Date retirada, Date devolucao, Usuario usuario) {
        this.veiculo = veiculo;
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

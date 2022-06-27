package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {


    @Id
    @SequenceGenerator(name = "medicamento_id_seq", sequenceName = "medicamento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicamento_id_seq")
    private Long id;

    @Column(name = "principio_ativo")
    private String principioAtivo;

    @Column(name = "produto")
    private String produto;

    @Column(name = "classe_terapeutica")
    private String classeTerapeutica;

    public Medicamento(Long id) {
        this.id = id;
    }

    public Medicamento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }
}

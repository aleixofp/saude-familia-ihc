package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipe_medica")
public class EquipeMedica {

    @Id
    @SequenceGenerator(name = "equipe_medica_id_seq", sequenceName = "equipe_medica_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_medica_id_seq")
    private Long id;

    @Column(name = "regiao")
    private String regiao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "equipe_medica_medico",
            joinColumns = @JoinColumn(name = "equipe_medica_id"),
            inverseJoinColumns = @JoinColumn(name = "medico_id"))
    private List<Medico> medicos;

    @Column(name = "ativa")
    private boolean ativa = true;

    @Column(name = "dt_criacao")
    private Date dataCriacao = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
}

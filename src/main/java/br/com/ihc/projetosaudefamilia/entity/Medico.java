package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medico")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Medico extends Pessoa {

    @OneToMany(mappedBy = "medico", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Medico() {

    }
    public Medico(Long id) {
        super(id);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}

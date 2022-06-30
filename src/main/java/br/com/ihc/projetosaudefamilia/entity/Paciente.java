package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Paciente extends Pessoa {

    @OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(Long id) {
        super(id);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}

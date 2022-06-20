package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Paciente extends Pessoa {

    public Paciente() {
    }

    public Paciente(Long id) {
        super(id);
    }
}

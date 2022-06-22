package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Paciente extends Pessoa {

    public Paciente() {
    }

    public Paciente(Long id) {
        super(id);
    }
}

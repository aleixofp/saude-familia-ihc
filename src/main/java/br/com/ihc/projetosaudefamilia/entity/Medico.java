package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Medico extends Pessoa {

    public Medico() {

    }
    public Medico(Long id) {
        super(id);
    }
}

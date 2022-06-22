package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Medico extends Pessoa {

    public Medico() {

    }
    public Medico(Long id) {
        super(id);
    }
}

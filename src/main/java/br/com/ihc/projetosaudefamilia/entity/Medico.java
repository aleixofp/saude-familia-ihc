package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Pessoa {

    public Medico() {

    }
    public Medico(Long id) {
        super(id);
    }
}

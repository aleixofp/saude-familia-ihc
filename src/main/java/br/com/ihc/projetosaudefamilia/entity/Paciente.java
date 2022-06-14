package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa {

    public Paciente() {
    }

    public Paciente(Long id) {
        super(id);
    }
}

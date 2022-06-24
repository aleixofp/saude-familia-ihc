package br.com.ihc.projetosaudefamilia.vo;

import java.util.Date;

public class AtendimentoCompletoVO extends AtendimentoVO {

    private String nomePaciente;
    private String nomeMedico;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
}

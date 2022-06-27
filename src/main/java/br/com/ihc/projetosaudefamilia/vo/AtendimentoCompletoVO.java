package br.com.ihc.projetosaudefamilia.vo;

import java.util.Date;
import java.util.List;

public class AtendimentoCompletoVO extends AtendimentoVO {

    private String nomePaciente;
    private String nomeMedico;

    private List<MedicamentoVO> medicamentos;

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

    public List<MedicamentoVO> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoVO> medicamentos) {
        this.medicamentos = medicamentos;
    }
}

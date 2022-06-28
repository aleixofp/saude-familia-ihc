package br.com.ihc.projetosaudefamilia.vo;

import java.util.Date;
import java.util.List;

public class AtendimentoCompletoVO {

    private Long id;
    private String condicoesSocioeconomicas;
    private String estadoAtualPaciente;
    private boolean empregado;
    private String dataAtendimento;
    private Long idPaciente;
    private Long idMedico;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondicoesSocioeconomicas() {
        return condicoesSocioeconomicas;
    }

    public void setCondicoesSocioeconomicas(String condicoesSocioeconomicas) {
        this.condicoesSocioeconomicas = condicoesSocioeconomicas;
    }

    public String getEstadoAtualPaciente() {
        return estadoAtualPaciente;
    }

    public void setEstadoAtualPaciente(String estadoAtualPaciente) {
        this.estadoAtualPaciente = estadoAtualPaciente;
    }

    public boolean isEmpregado() {
        return empregado;
    }

    public void setEmpregado(boolean empregado) {
        this.empregado = empregado;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
}

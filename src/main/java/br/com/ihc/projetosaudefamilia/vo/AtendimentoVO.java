package br.com.ihc.projetosaudefamilia.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendimentoVO {

    private Long id;
    private String condicoesSocioeconomicas;
    private String estadoAtualPaciente;
    private boolean empregado;
    private Date dataAtendimento;
    private Long idPaciente;
    private Long idMedico;

    private List<Long> idsMedicamentosAdministrados = new ArrayList<>();

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
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

    public List<Long> getIdsMedicamentosAdministrados() {
        return idsMedicamentosAdministrados;
    }

    public void setIdsMedicamentosAdministrados(List<Long> idsMedicamentosAdministrados) {
        this.idsMedicamentosAdministrados = idsMedicamentosAdministrados;
    }
}

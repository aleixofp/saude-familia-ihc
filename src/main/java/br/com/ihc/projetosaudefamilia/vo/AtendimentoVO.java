package br.com.ihc.projetosaudefamilia.vo;

import br.com.ihc.projetosaudefamilia.enums.TipoAtendimentoEnum;

import java.util.Date;

public class AtendimentoVO {
    private TipoAtendimentoEnum tipoAtendimento;
    private Date dataAtendimento;
    private Long idPaciente;
    private Long idMedico;

    public TipoAtendimentoEnum getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimentoEnum tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

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
}

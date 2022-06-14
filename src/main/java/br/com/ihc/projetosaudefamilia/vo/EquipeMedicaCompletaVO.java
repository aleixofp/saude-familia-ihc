package br.com.ihc.projetosaudefamilia.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipeMedicaCompletaVO {

    private Long id;
    private String regiao;
    private List<PessoaVO> medicos;
    private Date dataCriacao;
    private boolean ativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List<PessoaVO> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<PessoaVO> medicos) {
        this.medicos = medicos;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}

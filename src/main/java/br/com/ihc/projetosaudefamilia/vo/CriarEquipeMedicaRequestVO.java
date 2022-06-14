package br.com.ihc.projetosaudefamilia.vo;

import java.util.List;

public class CriarEquipeMedicaRequestVO {

    private List<Long> idsMedicos;
    private String regiao;

    public List<Long> getIdsMedicos() {
        return idsMedicos;
    }

    public void setIdsMedicos(List<Long> idsMedicos) {
        this.idsMedicos = idsMedicos;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}

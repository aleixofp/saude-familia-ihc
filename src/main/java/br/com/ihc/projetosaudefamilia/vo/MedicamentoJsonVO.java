package br.com.ihc.projetosaudefamilia.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicamentoJsonVO {
    @JsonProperty("PRINCIPIO ATIVO")
    private String principioAtivo;
    @JsonProperty("CNPJ")
    private String cnpj;

    @JsonProperty("LABORATORIO")
    private String laboratorio;

    @JsonProperty("REGISTRO")
    private String registro;

    @JsonProperty("EAN")
    private String ean;

    @JsonProperty("PRODUTO")
    private String produto;

    @JsonProperty("APRESENTACAO")
    private String apresentacao;

    @JsonProperty("CLASSE TERAPEUTICA")
    private String classeTerapeutica;

    public MedicamentoJsonVO() {

    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }
}

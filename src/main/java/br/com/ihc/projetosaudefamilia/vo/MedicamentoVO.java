package br.com.ihc.projetosaudefamilia.vo;

import java.util.List;

public class MedicamentoVO {

    private List<String> principiosAtivos;
    private String nome;
    private String classeTerapeutica;

    public List<String> getPrincipiosAtivos() {
        return principiosAtivos;
    }

    public void setPrincipiosAtivos(List<String> principiosAtivos) {
        this.principiosAtivos = principiosAtivos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }
}

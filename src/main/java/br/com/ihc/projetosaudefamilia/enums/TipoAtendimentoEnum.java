package br.com.ihc.projetosaudefamilia.enums;

public enum TipoAtendimentoEnum {
    CONSULTA("Consulta"),
    EXAME("Exame"),
    CIRURGIA("Tratamento");

    private final String descricao;

    TipoAtendimentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoAtendimentoEnum getByDescricao(String descricao) {
        for (TipoAtendimentoEnum tipoAtendimentoEnum : TipoAtendimentoEnum.values()) {
            if (tipoAtendimentoEnum.getDescricao().equals(descricao)) {
                return tipoAtendimentoEnum;
            }
        }
        return null;
    }
}

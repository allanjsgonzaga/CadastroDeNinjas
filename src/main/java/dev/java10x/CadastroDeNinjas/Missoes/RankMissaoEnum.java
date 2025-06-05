package dev.java10x.CadastroDeNinjas.Missoes;

public enum RankMissaoEnum {

    D("D","Muito Fácil"),
    C("C","Fácil"),
    B("B","Médio"),
    A("A","Difícil"),
    S("S","Muito Difícil");

    private String nivel;
    private String dificuldade;

    RankMissaoEnum(String nivel, String dificuldade) {
        this.nivel = nivel;
        this.dificuldade = dificuldade;
    }
}

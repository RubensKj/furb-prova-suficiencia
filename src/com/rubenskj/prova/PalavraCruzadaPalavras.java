package com.rubenskj.prova;

public class PalavraCruzadaPalavras {

    private final short palavrasQtdLinha;
    private final short palavrasQtdColuna;
    private String[][] palavras;

    public PalavraCruzadaPalavras() {
        this.palavrasQtdLinha = 5;
        this.palavrasQtdColuna = 2;
        palavrasEntrada();
    }

    public String[][] palavrasVetor() {
        return palavras;
    }

    private void palavrasEntrada() {
        palavras = new String[palavrasQtdLinha][palavrasQtdColuna];

        palavras[0][0] = "IFELSE";
        palavras[1][0] = "FORA";
        palavras[2][0] = "WHILE";
        palavras[3][0] = "OBJETO";
        palavras[4][0] = "VETOR";
    }

    public void palavrasSaidaNaoResolvido() {
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i][0]);
        }
        System.out.println("----------------------------");
    }

    public void palavrasSaidaResolvido() {
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i][1]);
        }
        System.out.println("----------------------------");
    }
}

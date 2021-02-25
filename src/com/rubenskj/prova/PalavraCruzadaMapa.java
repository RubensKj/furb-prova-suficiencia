package com.rubenskj.prova;

public class PalavraCruzadaMapa {

    private final short mapaQtdLinha;
    private final short mapaQtdColuna;
    private char[][] mapa;

    public PalavraCruzadaMapa() {
        this.mapaQtdLinha = 10;
        this.mapaQtdColuna = 5;
        mapaEntrada();
    }

    private void mapaLinha() {
        for (int i = 0; i < mapaQtdColuna; i++) {
            System.out.print("----");
        }
        System.out.println("-");
    }

    public void mapaSaidaNaoResolvido() {
        for (int i = 0; i < mapaQtdLinha; i++) {
            mapaLinha();
            for (int j = 0; j < mapaQtdColuna; j++) {
                System.out.print("| " + mapa[i][j] + " ");
            }
            System.out.println("|");
        }
        mapaLinha();
        System.out.println("----------------------------");
    }

    public void mapaBusca(String[][] palavras) {
        procuraHorizontal(palavras);
        procuraVertical(palavras);
    }

    private void procuraHorizontal(String[][] palavras) {
        for (int i = 0; i < mapaQtdLinha; i++) {
            String textLine = "";
            for (int j = 0; j < mapaQtdColuna; j++) {
                textLine += mapa[i][j];
            }

            String textInverted = inverteTexto(textLine);

            for (int k = 0; k < palavras.length; k++) {
                String palavra = palavras[k][0];

                if (textLine.contains(palavra)) {
                    salvaPalavra(k, palavra, textLine, palavras, i, textLine.indexOf(palavra));
                }

                if (textInverted.contains(palavra)) {
                    salvaPalavra(k, palavra, textInverted, palavras, i, (textLine.length() - 1) - textInverted.indexOf(palavra));
                }
            }
        }
    }

    private void procuraVertical(String[][] palavras) {
        for (int i = 0; i < mapaQtdColuna; i++) {
            String textLine = "";
            for (int j = 0; j < mapaQtdLinha; j++) {
                textLine += mapa[j][i];
            }

            String textInverted = inverteTexto(textLine);

            for (int k = 0; k < palavras.length; k++) {
                String palavra = palavras[k][0];

                if (textLine.contains(palavra)) {
                    salvaPalavra(k, palavra, textLine, palavras, textLine.indexOf(palavra), i);
                }

                if (textInverted.contains(palavra)) {
                    salvaPalavra(k, palavra, textInverted, palavras, (textLine.length() - 1) - textInverted.indexOf(palavra), i);
                }
            }
        }
    }

    private String inverteTexto(String text) {
        char characters[] = text.toCharArray();
        String textInverted = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            textInverted += characters[i];
        }

        return textInverted;
    }

    private void salvaPalavra(int palavraIndice, String palavra, String textLine, String[][] palavras, int linhaIndice, int colunaIndice) {
        String wordInTextline = pegaPalavraNaLinha(palavra, textLine);

        palavras[palavraIndice][1] = formataPalavra(linhaIndice, colunaIndice, wordInTextline);
    }

    private String pegaPalavraNaLinha(String palavra, String textLine) {
        int indexBegin = textLine.indexOf(palavra);

        if (indexBegin == -1) {
            return null;
        }

        return textLine.substring(indexBegin, palavra.length() + indexBegin);
    }

    private String formataPalavra(int i, int k, String textLine) {
        return "[" + i + "," + k + "] - " + textLine;
    }

    private void mapaEntrada() {
        mapa = new char[mapaQtdLinha][mapaQtdColuna];

        mapa[0][0] = 'C';
        mapa[0][1] = 'C';
        mapa[0][2] = 'Q';
        mapa[0][3] = 'W';
        mapa[0][4] = 'E';
        mapa[1][0] = 'I';
        mapa[1][1] = 'X';
        mapa[1][2] = 'F';
        mapa[1][3] = 'O';
        mapa[1][4] = 'R';
        mapa[2][0] = 'F';
        mapa[2][1] = 'F';
        mapa[2][2] = 'R';
        mapa[2][3] = 'G';
        mapa[2][4] = 'F';
        mapa[3][0] = 'E';
        mapa[3][1] = 'L';
        mapa[3][2] = 'I';
        mapa[3][3] = 'H';
        mapa[3][4] = 'W';
        mapa[4][0] = 'L';
        mapa[4][1] = 'S';
        mapa[4][2] = 'F';
        mapa[4][3] = 'O';
        mapa[4][4] = 'U';
        mapa[5][0] = 'S';
        mapa[5][1] = 'D';
        mapa[5][2] = 'G';
        mapa[5][3] = 'T';
        mapa[5][4] = 'S';
        mapa[6][0] = 'E';
        mapa[6][1] = 'J';
        mapa[6][2] = 'H';
        mapa[6][3] = 'E';
        mapa[6][4] = 'T';
        mapa[7][0] = 'I';
        mapa[7][1] = 'I';
        mapa[7][2] = 'I';
        mapa[7][3] = 'J';
        mapa[7][4] = 'M';
        mapa[8][0] = 'X';
        mapa[8][1] = 'C';
        mapa[8][2] = 'K';
        mapa[8][3] = 'B';
        mapa[8][4] = 'G';
        mapa[9][0] = 'V';
        mapa[9][1] = 'E';
        mapa[9][2] = 'T';
        mapa[9][3] = 'O';
        mapa[9][4] = 'R';
    }
}

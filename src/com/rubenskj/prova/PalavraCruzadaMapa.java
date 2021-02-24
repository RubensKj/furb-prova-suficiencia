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

    // TODO: Implement mapaBusca like documentation
    // Result should be this
    //        palavras[0][1] = "[1,0] - IFELSE";
    //        palavras[1][1] = ".... NÃO achou _ FORA";
    //        palavras[2][1] = "[3,4] - WHILE";
    //        palavras[3][1] = "[9,3] - OBJETO";
    //        palavras[4][1] = "[9,0] - VETOR";
    public void mapaBusca(String[][] palavras) {
        searchHorizontal(palavras);
        searchHorizontalInverted(palavras);
        searchVertical(palavras);
        searchVerticalInverted(palavras);
    }

    private void searchHorizontal(String[][] palavras) {
        for (int i = 0; i < mapaQtdLinha; i++) {
            String textLine = "";
            int locationText = 0;
            for (int j = 0; j < mapaQtdColuna; j++) {
                textLine += mapa[i][j];
                locationText = j;
            }

            for (int k = 0; k < palavras.length; k++) {
                if (textLine.equals(palavras[k][0])) {
                    palavras[k][1] = formatField(i, subtractTextLength(locationText, textLine, false), textLine);
                }
            }
        }
    }

    private void searchHorizontalInverted(String[][] palavras) {
        for (int i = 0; i < mapaQtdLinha; i++) {
            String textLine = "";
            int locationText = 0;
            for (int j = 0; j < mapaQtdColuna; j++) {
                textLine += mapa[i][j];
                locationText = j;
            }

            textLine = invertText(textLine);

            for (int k = 0; k < palavras.length; k++) {
                if (textLine.equals(palavras[k][0])) {
                    palavras[k][1] = formatField(i, subtractTextLength(locationText, textLine, true), textLine);
                }
            }
        }
    }

    // TODO: Implement Vertical
    // This will read the columns first (until the bottom) and if each line sum the text
    private void searchVertical(String[][] palavras) {

    }

    // TODO: Implement Vertical Inverted
    // This will read the columns first (until the bottom) and if each line sum the text but we are going to use the invertText
    private void searchVerticalInverted(String[][] palavras) {

    }

    private String invertText(String text) {
        char characters[] = text.toCharArray();
        String textInverted = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            textInverted += characters[i];
        }

        return textInverted;
    }

    private String formatField(int i, int k, String textLine) {
        return "[" + i + "," + k + "] - " + textLine;
    }

    private int subtractTextLength(int k, String textLine, boolean isInverted) {
        if (isInverted) {
            return k;
        } else {
            return (k - (textLine.length() - 1));
        }
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

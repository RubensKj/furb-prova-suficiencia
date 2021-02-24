package com.rubenskj.prova;

import java.util.Scanner;

public class PalavraCruzadaMain {

    private static PalavraCruzadaPalavras palavras;
    private static PalavraCruzadaMapa mapa;

    public static void main(String[] args) {
        init();

        mapa.mapaBusca(palavras.palavrasVetor());

        Scanner teclado = new Scanner(System.in);

        String textoDigitado = "";
        do {
            printaMenu();

            String textoDigitadoNovo = teclado.next();

            switch (textoDigitadoNovo) {
                case "1":
                    palavras.palavrasSaidaNaoResolvido();
                    break;
                case "2":
                    mapa.mapaSaidaNaoResolvido();
                    break;
                case "3":
                    palavras.palavrasSaidaResolvido();
                    break;
                case "4":
                    textoDigitado = textoDigitadoNovo;
                    break;
                default:
                    System.out.println("opção errada!");
                    break;
            }
        } while (!textoDigitado.equals("4"));
    }

    private static void init() {
        palavras = new PalavraCruzadaPalavras();
        mapa = new PalavraCruzadaMapa();
    }

    private static void printaMenu() {
        System.out.println("_________ Menu: Palavra Cruzada _________");
        System.out.println("1. listar NAO resolvido: palavras");
        System.out.println("2. listar NAO resolvido: mapa");
        System.out.println("3. listar RESOLVIDO: palavras");
        System.out.println("4. sair");

        System.out.print(" __ opção: ");
    }
}

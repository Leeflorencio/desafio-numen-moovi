package com.br.jdev;

import java.util.*;

public class Jokenpo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int usuarioVenceu = 0;
        int maquinaVenceu = 0;
        int usuarioPerdeu = 0;
        int maquinaPerdeu = 0;
        int totalPartidas = 0;
        String ganhadorFinal = "";
        int empates = 0;
        int ganhador = 0;
        int opcao = 0;
        ArrayList<String> opcaoMaquina = new ArrayList<>();

        opcaoMaquina.add("pedra");
        opcaoMaquina.add("tesoura");
        opcaoMaquina.add("papel");

        Random randon = new Random();

        System.out.println("Bem-vindo ao jogo de Jokenpô da Numen e Moovi \nEscolha PEDRA, PAPEL OU TESOURA");

        do {
            String opcaoUsuario = sc.next();

            int indiceAleatorio = randon.nextInt(opcaoMaquina.size());
            String opcaoAleatoriaDaMaquina = opcaoMaquina.get(indiceAleatorio);

            if (!opcaoUsuario.equalsIgnoreCase("pedra") && !opcaoUsuario.equalsIgnoreCase("papel")
                    && !opcaoUsuario.equalsIgnoreCase("tesoura")) {
                System.out.println("Você deve escolher somente entre PEDRA, PAPEL OU TESOURA");
                continue;
            } else {
                System.out.println("Você escolheu : " + opcaoUsuario);
                System.out.println("A máquina escolheu: " + opcaoAleatoriaDaMaquina);
                totalPartidas++;
            }

            if (opcaoUsuario.equalsIgnoreCase(opcaoAleatoriaDaMaquina)) {
                System.out.println("Empate");
                empates++;
            }

            if (opcaoUsuario.equalsIgnoreCase("tesoura")
                    && opcaoAleatoriaDaMaquina.equalsIgnoreCase("papel")) {
                System.out.println("Usuário ganhou! ");
                usuarioVenceu++;
                maquinaPerdeu++;
            } else if (opcaoAleatoriaDaMaquina.equalsIgnoreCase("tesoura")
                    && opcaoUsuario.equalsIgnoreCase("papel")) {
                System.out.println("Máquina ganhou!");
                maquinaVenceu++;
                usuarioPerdeu++;
            } else if (opcaoUsuario.equalsIgnoreCase("pedra")
                    && opcaoAleatoriaDaMaquina.equalsIgnoreCase("tesoura")) {
                System.out.println("Usúario ganhou!");
                usuarioVenceu++;
                maquinaPerdeu++;
            } else if (opcaoAleatoriaDaMaquina.equalsIgnoreCase("pedra")
                    && opcaoUsuario.equalsIgnoreCase("tesoura")) {
                System.out.println("Máquina ganhou!");
                maquinaVenceu++;
                usuarioPerdeu++;
            } else if (opcaoUsuario.equalsIgnoreCase("papel")
                    && opcaoAleatoriaDaMaquina.equalsIgnoreCase("pedra")) {
                System.out.println("Usuário ganhou!");
                usuarioVenceu++;
                maquinaPerdeu++;
            } else if (opcaoAleatoriaDaMaquina.equalsIgnoreCase("papel")
                    && opcaoUsuario.equalsIgnoreCase("pedra")) {
                System.out.println("Máquina ganhou");
                maquinaVenceu++;
                usuarioPerdeu++;
            }

            System.out.println("Deseja continuar jogando? Aperte 2 para continuar, ou 1 para sair do jogo");

            try{
                opcao = sc.nextInt();
            }catch (Exception e){
                System.out.println("Você deve digitar apenas o número 1 ou o número 2");
                sc.next();
                opcao = 0;
            }

        } while (opcao != 1);

        if (usuarioVenceu > maquinaVenceu) {
            ganhador = usuarioVenceu;
            ganhadorFinal = "Usuário";
        } else if (maquinaVenceu > usuarioVenceu){
            ganhador = maquinaVenceu;
            ganhadorFinal = "Máquina";
        }else {
            ganhador = empates;
        }


        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Total de partidas jogadas: " + totalPartidas);
        System.out.println("---------------------------------PLACAR FINAL--------------------------------");
        System.out.println("Usuário: " + usuarioVenceu + "  | Máquina: " + maquinaVenceu);
        System.out.println("-------------------------------DERROTAS---------------------------------");
        System.out.println("Máquina: " + maquinaPerdeu + "  | Usuário: " + usuarioPerdeu);
        System.out.println("-------------------------------EMPATES---------------------------------");
        System.out.println("Total empates: " + empates);
        System.out.println("-------------------------------GANHADOR---------------------------------");
        System.out.println(ganhadorFinal);


    }

}

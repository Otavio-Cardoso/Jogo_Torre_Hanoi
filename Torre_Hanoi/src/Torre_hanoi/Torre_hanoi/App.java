package Torre_hanoi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // torre de hanoi - Otávio Cardoso 2° Semestre ADS - 2023

        //inicializa as torres, com a primeira torre tendo os discos
        int TorreA[] = { 11, 9, 7, 5, 3, 1 },
            TorreB[] = { 0, 0, 0, 0, 0, 0 },
            TorreC[] = { 0, 0, 0, 0, 0, 0 },
        //contador de jogadas para ser exibido na mensagem de vitória
            contadorJogadas = 0;
        //variáveis para controle de jogadas e acertos
        Boolean jogou = false, acertou = false;
        //variáveis para controle de origem e destino recebidos do jogador
        String origem = "", destino = "", posicao = "";
        Scanner leia = new Scanner(System.in);

        //instrui o jogador sobre o objetivo do jogo
        System.out.println(
                "\nO objetivo é mover todas as peças da torre A para a torre C, sem que uma peça maior fique em cima de uma menor.\n");

        //loop principal do jogo
        while (true) {

            jogou = false;
            acertou = false;
            //imprime as torres na tela
            Funcoes.printTorres(TorreA, TorreB, TorreC);
            //loop para receber a jogada do jogador
            while (!acertou) {
                origem = "";
                destino = "";

                System.out.println("Escolha uma torre para retirar a peça: ");
                origem = leia.next();
                System.out.println("Escolha uma torre para colocar a peça: ");
                destino = leia.next();
                //concatena as strings para formar a posição
                posicao = origem + destino;
                //converte a string para maiúscula
                posicao = posicao.toUpperCase();
                //verifica se a jogada é válida
                acertou = Funcoes.posicaoCorreta(posicao);
            }
            //verifica qual a jogada e chama a função movimento para realizar a troca do disco entre as torres
            switch (posicao) {
                case "AB":
                    jogou = Funcoes.movimento(TorreA, TorreB);
                    break;
                case "BA":
                    jogou = Funcoes.movimento(TorreB, TorreA);
                    break;
                case "AC":
                    jogou = Funcoes.movimento(TorreA, TorreC);
                    break;
                case "CA":
                    jogou = Funcoes.movimento(TorreC, TorreA);
                    break;
                case "BC":
                    jogou = Funcoes.movimento(TorreB, TorreC);
                    break;
                case "CB":
                    jogou = Funcoes.movimento(TorreC, TorreB);
                    break;
            }
            //se a jogada for válida, incrementa o contador de jogadas
            if (jogou) {
                contadorJogadas += 1;
            }
            //verifica se o jogador ganhou
            if (TorreC[0] == 11 && TorreC[1] == 9 && TorreC[2] == 7 && TorreC[3] == 5 && TorreC[4] == 3 && TorreC[5] == 1) {
                //imprime as torres na tela
                Funcoes.printTorres(TorreA, TorreB, TorreC);
                System.out.println("\nParabéns, você ganhou em " + contadorJogadas + " jogada(s)!");
                break;
            }
        }
        leia.close();
    }
}
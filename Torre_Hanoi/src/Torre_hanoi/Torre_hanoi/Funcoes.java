package Torre_hanoi;

import java.util.Arrays;

class Funcoes {
    public static boolean movimento(int num1[], int num2[]) {
        int aux = 0;
        int posAux = 0;
        boolean possivel = false;

        // verifica se a torre de origem está vazia
        for (byte i = 5; i >= 0; i--) {
            if (num1[i] != 0) {
                aux = num1[i];
                posAux = i;
                break;
            }
        }
        // verifica se a torre de destino está vazia
        if (num2[0] == 0) {
            possivel = true;
        } else
            // verifica se o disco da torre de origem é menor que o disco da torre de
            // destino
            for (byte i = 1; i < num1.length; i++) {
                if (aux < num2[i - 1]) {
                    possivel = true;
                }
            }
        // se for possível, realiza a troca dos discos
        for (byte i = 0; i < num1.length; i++) {
            if (possivel && num2[i] == 0) {
                num2[i] = aux;
                num1[posAux] = 0;
                break;
            }
        }
        return possivel;
    }

    public static boolean posicaoCorreta(String posicao) {
        boolean acertou = false;
        // verifica se a jogada é válida
        if (posicao.equals("AB") || posicao.equals("BA") || posicao.equals("AC") ||
                posicao.equals("CA") || posicao.equals("BC") || posicao.equals("CB")) {
            acertou = true;
        } else {
            System.out.println("Jogada inválida!, tente novamente.");
        }
        return acertou;
    }

    // função para imprimir as torres
    public static void printTorres(int[] torre1, int[] torre2, int[] torre3) {
        int maxHeight = Math.max(torre1.length, Math.max(torre2.length, torre3.length));

        // imprime os discos
        for (int i = maxHeight - 1; i >= 0; i--) {
            String disco1 = (i < torre1.length) ? gerarDisco(torre1[i]) : " ";
            String disco2 = (i < torre2.length) ? gerarDisco(torre2[i]) : " ";
            String disco3 = (i < torre3.length) ? gerarDisco(torre3[i]) : " ";

        // substitui os espaços em branco por | para melhorar a visualização e adiciona espaços para centralizar os discos
            switch (disco1) {
                case "=":
                    disco1 = "     =     ";
                    break;
                case "===":
                    disco1 = "    ===    ";
                    break;
                case "=====":
                    disco1 = "   =====   ";
                    break;
                case "=======":
                    disco1 = "  =======  ";
                    break;
                case "=========":
                    disco1 = " ========= ";
                    break;
                case "":
                    disco1 = "     |     ";
                    break;
            }
            switch (disco2) {
                case "=":
                    disco2 = "     =     ";
                    break;
                case "===":
                    disco2 = "    ===    ";
                    break;
                case "=====":
                    disco2 = "   =====   ";
                    break;
                case "=======":
                    disco2 = "  =======  ";
                    break;
                case "=========":
                    disco2 = " ========= ";
                    break;
                case "":
                    disco2 = "     |     ";
                    break;
            }
            switch (disco3) {
                case "=":
                    disco3 = "     =     ";
                    break;
                case "===":
                    disco3 = "    ===    ";
                    break;
                case "=====":
                    disco3 = "   =====   ";
                    break;
                case "=======":
                    disco3 = "  =======  ";
                    break;
                case "=========":
                    disco3 = " ========= ";
                    break;
                case "":
                    disco3 = "     |     ";
                    break;
            }
            System.out.println(disco1 + "\t\t" + disco2 + "\t\t" + disco3);
        }

        System.out.println("   _____\t\t   _____\t\t   _____");
        System.out.println("     A\t\t\t     B\t\t\t     C");
    }

    // função que recebe o tamanho do disco e retorna uma string com caracteres "="
    public static String gerarDisco(int size) {
        char[] charDisco = new char[size];
        Arrays.fill(charDisco, '=');

        return new String(charDisco);
    }
}

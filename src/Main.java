import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();

        System.out.println("Digite o nome do primeiro jogador: ");
        String player1 = scanner.next();
        char simbolo1 = 'X';
        System.out.println("Digite o nome do segundo jogador: ");
        String player2 = scanner.next();
        char simbolo2 = 'O';
        System.out.println(player1 + " seu símbolo será: " + simbolo1);
        System.out.println(player2 + " seu símbolo será: " + simbolo2);

        char[][] tabuleiro = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

        System.out.println("Este será o tabuleiro do jogo:\n");
        mostrarTabuleiro(tabuleiro);
        System.out.println("\n");
        System.out.println("Vamos começar. Indique em qual posição (número, sem 0 na frente) você colocará seu símbolo:");

        byte jogadas = 0;

        while(jogadas<9){
            tabuleiro = verificaJogada(player1, simbolo1, tabuleiro);
            mostrarTabuleiro(tabuleiro);
            jogadas++;
            if (vencedor(tabuleiro)){
                System.out.println("O vencedor foi "+player1+". Parabéns!");
                break;
            }
            tabuleiro = verificaJogada(player2, simbolo2, tabuleiro);
            mostrarTabuleiro(tabuleiro);
            jogadas++;
            if (vencedor(tabuleiro)){
                System.out.println("O vencedor foi "+player1+". Parabéns!");
                break;
            }
        }

    }

    private static void inicio() {
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|              Bem-vindo ao Jogo da Velha!               |");
        System.out.println("|   Regras:                                              |");
        System.out.println("|   - Cada jogador fará seu movimento uma vez por rodada.|");
        System.out.println("|   - O jogador deverá escolher o número do local do     |");
        System.out.println("|     tabuleiro onde será colocado seu símbolo.          |");
        System.out.println("|   - Ao completar uma trinca, seja na horizontal,       |");
        System.out.println("|     vertical ou diagonal, o jogador vence.             |");
        System.out.println("|     ESCOLHA SUA ESTRATÉGIA, E QUE VENÇA O MELHOR!      |");
        System.out.println("+--------------------------------------------------------+\n");
    }

    static void mostrarTabuleiro(char[][] posicao) {
        System.out.println(" " + posicao[0][0] + " | " + posicao[0][1] + " | " + posicao[0][2]);
        System.out.println("---|---|---");
        System.out.println(" " + posicao[1][0] + " | " + posicao[1][1] + " | " + posicao[1][2]);
        System.out.println("---|---|---");
        System.out.println(" " + posicao[2][0] + " | " + posicao[2][1] + " | " + posicao[2][2]);

    }

    static char[][] verificaJogada(String player, char simbolo, char[][] posicao) {
        while (true) {
            System.out.println(player + " indique a posição da sua próxima jogada");
            char opcao = scanner.next().charAt(0);
            if (opcao == '1' || opcao == '2' || opcao == '3' || opcao == '4' || opcao == '5' || opcao == '6' || opcao == '7' || opcao == '8' || opcao == '9') {
                switch (opcao) {
                    case '1':
                        posicao[0][0] = simbolo;
                        break;
                    case '2':
                        posicao[0][1] = simbolo;
                        break;
                    case '3':
                        posicao[0][2] = simbolo;
                        break;
                    case '4':
                        posicao[1][0] = simbolo;
                        break;
                    case '5':
                        posicao[1][1] = simbolo;
                        break;
                    case '6':
                        posicao[1][2] = simbolo;
                        break;
                    case '7':
                        posicao[2][0] = simbolo;
                        break;
                    case '8':
                        posicao[2][1] = simbolo;
                        break;
                    case '9':
                        posicao[2][2] = simbolo;
                        break;
                    default:
                        break;
                }
                break;
            } else {
                System.out.println("Opção incorreta, tente novamente");
            }
        }
        return posicao;
    }

    static boolean vencedor(char[][] posicao) {

        String verificaVencedor = null;
        boolean resultado = false;

        for (byte i = 0; i < 8; i++) {

            switch (i) {
                case 0:
                    verificaVencedor = String.valueOf(posicao[0][0] + posicao[0][1] + posicao[0][2]);
                    break;
                case 1:
                    verificaVencedor = String.valueOf(posicao[1][0] + posicao[1][1] + posicao[1][2]);
                    break;
                case 2:
                    verificaVencedor = String.valueOf(posicao[2][0] + posicao[2][1] + posicao[2][2]);
                    break;
                case 3:
                    verificaVencedor = String.valueOf(posicao[0][0] + posicao[1][0] + posicao[2][0]);
                    break;
                case 4:
                    verificaVencedor = String.valueOf(posicao[0][1] + posicao[1][1] + posicao[2][1]);
                    break;
                case 5:
                    verificaVencedor = String.valueOf(posicao[0][2] + posicao[1][2] + posicao[2][2]);
                    break;
                case 6:
                    verificaVencedor = String.valueOf(posicao[0][0] + posicao[1][1] + posicao[2][2]);
                    break;
                case 7:
                    verificaVencedor = String.valueOf(posicao[2][0] + posicao[1][1] + posicao[0][2]);
                    break;
            }
            if (verificaVencedor.equals("XXX")) {
                resultado= true;
                break;
            } else if (verificaVencedor.equals("OOO")) {
                resultado= true;
                break;
            }
        }
        return resultado;
    }
}

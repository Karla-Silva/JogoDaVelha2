import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();

        System.out.println("Digite o nome do primeiro jogador: ");
        String player1 = scanner.next();
        char simbolo1 = 'X';
        int vitoria1 = 0;
        System.out.println("Digite o nome do segundo jogador: ");
        String player2 = scanner.next();
        char simbolo2 = 'O';
        int vitoria2 = 0;
        System.out.println(player1 + " seu símbolo será: " + simbolo1);
        System.out.println(player2 + " seu símbolo será: " + simbolo2);

        char deNovo;
        do{
            char[][] tabuleiro = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

            System.out.println("Este será o tabuleiro do jogo:\n");
            mostrarTabuleiro(tabuleiro);
            System.out.println("\n");
            System.out.println("Vamos começar. Indique em qual posição (número, sem 0 na frente) você colocará seu símbolo:");

            byte jogadas = 0;

            while(jogadas<9){
                tabuleiro = verificaJogada(player1, simbolo1, tabuleiro);
                jogadas++;
                mostrarTabuleiro(tabuleiro);
                if (vencedor(tabuleiro)){
                    System.out.println("O vencedor foi "+player1+". Parabéns!");
                    vitoria1++;
                    break;
                }
                if(jogadas==9){
                    System.out.println("Deu empate!");
                    break;
                }
                tabuleiro = verificaJogada(player2, simbolo2, tabuleiro);
                jogadas++;
                mostrarTabuleiro(tabuleiro);
                if (vencedor(tabuleiro)){
                    System.out.println("O vencedor foi "+player1+". Parabéns!");
                    vitoria2++;
                    break;
                }
            }

            System.out.println("Pontuação "+player1+": "+vitoria1);
            System.out.println("Pontuação "+player2+": "+vitoria2);
            while(true) {
                System.out.println("Deseja jogar novamente? N-Não S-Sim");
                deNovo = scanner.next().charAt(0);

                if (deNovo !='S' && deNovo != 's' && deNovo != 'N' && deNovo != 'n') {
                    System.err.println("Opção incorreta, tente novamente");
                }else {
                    break;
                }

            }

        }while(deNovo =='S'||deNovo=='s');

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
            String opcao = scanner.next();
            if (opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5") || opcao.equals("6") || opcao.equals("7") || opcao.equals("8") || opcao.equals("9")) {
                switch (opcao) {
                    case "1":
                        if (posicao[0][0] == 'X' || posicao[0][0] == 'O'){
                            System.err.println("Opção já preenchida");
                            continue;
                        } else {
                        posicao[0][0] = simbolo;
                        break;
                        }
                    case "2":
                        if (posicao[0][1] == 'X' || posicao[0][1] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[0][1] = simbolo;
                            break;
                        }
                    case "3":
                        if (posicao[0][2] == 'X' || posicao[0][2] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[0][2] = simbolo;
                            break;
                        }
                    case "4":
                        if (posicao[1][0] == 'X' || posicao[1][0] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[1][0] = simbolo;
                            break;
                        }
                    case "5":
                        if (posicao[1][1] == 'X' || posicao[1][1] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[1][1] = simbolo;
                            break;
                        }
                    case "6":
                        if (posicao[1][2] == 'X' || posicao[1][2] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[1][2] = simbolo;
                            break;
                        }
                    case "7":
                        if (posicao[2][0] == 'X' || posicao[2][0] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[2][0] = simbolo;
                            break;
                        }
                    case "8":
                        if (posicao[2][1] == 'X' || posicao[2][1] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[2][1] = simbolo;
                            break;
                        }
                    case "9":
                        if (posicao[2][2] == 'X' || posicao[2][2] == 'O') {
                            System.err.println("Opção já preenchida");
                            continue;

                        } else {
                            posicao[2][2] = simbolo;
                            break;
                        }
                    default:
                        break;
                }
                break;
            } else {
                System.err.println("Opção incorreta, tente novamente");
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
                    verificaVencedor = String.valueOf(posicao[0][0]) + String.valueOf(posicao[0][1]) + String.valueOf(posicao[0][2]);
                    break;
                case 1:
                    verificaVencedor = String.valueOf(posicao[1][0]) + String.valueOf(posicao[1][1]) + String.valueOf(posicao[1][2]);
                    break;
                case 2:
                    verificaVencedor = String.valueOf(posicao[2][0]) + String.valueOf(posicao[2][1]) + String.valueOf(posicao[2][2]);
                    break;
                case 3:
                    verificaVencedor = String.valueOf(posicao[0][0]) + String.valueOf(posicao[1][0]) + String.valueOf(posicao[2][0]);
                    break;
                case 4:
                    verificaVencedor = String.valueOf(posicao[0][1]) + String.valueOf(posicao[1][1]) + String.valueOf(posicao[2][1]);
                    break;
                case 5:
                    verificaVencedor = String.valueOf(posicao[0][2]) + String.valueOf(posicao[1][2]) + String.valueOf(posicao[2][2]);
                    break;
                case 6:
                    verificaVencedor = String.valueOf(posicao[0][0]) + String.valueOf(posicao[1][1]) + String.valueOf(posicao[2][2]);
                    break;
                case 7:
                    verificaVencedor = String.valueOf(posicao[2][0]) + String.valueOf(posicao[1][1]) + String.valueOf(posicao[0][2]);
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

import java.util.Scanner;

class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo(int linha, int coluna, int passo) {
        this.linha = linha;
        this.coluna = coluna;
        this.passo = passo;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void mostrarPosicaoAtual() {
        System.out.println("Posição atual do robô: (" + linha + ", " + coluna + ")");
    }

    public void andarFrente() {
        if (linha + passo < 20) {
            linha += passo;
        } else {
            System.out.println("O robô não pode ultrapassar a sala.");
        }
    }

    public void andarTras() {
        if (linha - passo >= 0) {
            linha -= passo;
        } else {
            System.out.println("O robô não pode ultrapassar a sala.");
        }
    }

    public void andarDireita() {
        if (coluna + passo < 40) {
            coluna += passo;
        } else {
            System.out.println("O robô não pode ultrapassar a sala.");
        }
    }

    public void andarEsquerda() {
        if (coluna - passo >= 0) {
            coluna -= passo;
        } else {
            System.out.println("O robô não pode ultrapassar a sala.");
        }
    }
}

public class SalaRobo {
    private static final int LINHAS = 20;
    private static final int COLUNAS = 40;

    public static void main(String[] args) {
        Robo r1 = new Robo(0, 0, 1);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarSala(r1);
            r1.mostrarPosicaoAtual();
            System.out.println("Escolha uma ação:");
            System.out.println("1 - Andar para Frente");
            System.out.println("2 - Andar para Trás");
            System.out.println("3 - Andar para Direita");
            System.out.println("4 - Andar para Esquerda");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    r1.andarFrente();
                    break;
                case 2:
                    r1.andarTras();
                    break;
                case 3:
                    r1.andarDireita();
                    break;
                case 4:
                    r1.andarEsquerda();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void mostrarSala(Robo robo) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (i == robo.getLinha() && j == robo.getColuna()) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
package ArenaDosHerois;

import java.util.Scanner;
public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Personagem mago = new Mago(" Mago");
        Personagem gigante = new Gigante(" Gigante");
        Personagem guerreiro = new Guerreiro(" Guerreiro");
        Personagem arqueiro = new Arqueiro(" Arqueiro");

        Personagem[] personagems = { mago, gigante, guerreiro, arqueiro };
        Tabuleiro tabuleiro = new Tabuleiro(personagems, 10);

        tabuleiro.iniciarJogo();

        while (!tabuleiro.checarVencedor()) {
            for (Personagem p : personagems) {
                if (p.getVida() > 0) {
                    System.out.println(p.getNome() + ": (1) Atacar ou (2) Mover?");
                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        System.out.println("Escolha um oponente para atacar: ");

                        for (int i = 0; i < personagems.length; i++) {
                            if (personagems[1] != p && personagems[i].getVida() > 0) {
                                System.out.println(i + ":" + personagems[i].getNome());
                            }
                        }

                        int oponenteEscolhido;
                        while (true) {
                            oponenteEscolhido = scanner.nextInt();
                            if (oponenteEscolhido >= 0 && oponenteEscolhido < personagems.length
                                    && personagems [oponenteEscolhido] != p
                                    && personagems [oponenteEscolhido].getVida() > 0) {
                                break;        
                            } else {
                                System.out.println(" Escolha invalida, tente novamente. ");
                            }
                        }
                        p.atacar(personagems[oponenteEscolhido]);
                    } else {
                        System.out.println(" Escolha uma nova posição (0 a 9): ");
                        int novaPosicao = scanner.nextInt();
                        tabuleiro.movimentarPerssonagem(p, novaPosicao);
                    }
                }
            }
        }
    }
}

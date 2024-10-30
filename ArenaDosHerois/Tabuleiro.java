package ArenaDosHerois;

public class Tabuleiro {
    private Personagem[] personagems;
    private int tamanho;

    public Tabuleiro(Personagem[] personagems, int tamanho) {
        this.personagems = personagems;
        this.tamanho = tamanho;
    }
    public void iniciarJogo() {
        System.out.println("Iniciando o jogo!");
        for (int i = 0; i< personagems.length; i++) {
            personagems[i].mover(i * 2);
        }
        exibirTabuleiro();
    }

    public void exibirTabuleiro() {
        System.out.println("\nPosições no Tabuleiro");
        for (Personagem p : personagems) {
            if (p.getVida()> 0) {
                System.out.println(p.getNome() + "está na posição" + p.getPosicao() + "com" + p.getVida() + "de vida,");
            }
        }
        System.out.println();
    }
    public void movimentarPerssonagem(Personagem p , int novaPosicao) {
        if (novaPosicao < 0 || novaPosicao >= tamanho) {
            System.out.println("Movimento inválido! Fora dos limites do tabuleiro.");
        } else {
            p.mover(novaPosicao);
            exibirTabuleiro();
        }
    }

    public boolean checarVencedor() {
        int vivos = 0;
        Personagem vencedor = null;
        for (Personagem p : personagems) {
            if (p.getVida() > 0) {
                vivos++;
                vencedor = p;
            }
        }
        if (vivos == 1) {
            System.out.println("O vencedor é" + vencedor.getNome() + "!");
            return true;
        }
        return false;
    }
    
}

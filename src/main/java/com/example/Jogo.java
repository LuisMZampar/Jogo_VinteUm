package com.example;

public class Jogo {
    
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();
    protected Monte monte = new Monte();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCarta(Jogador jogador){
        if(jogador.parou()) return null;

        var carta = monte.virar();
        jogador.receberCarta(carta);

        return carta;
    }

    public boolean acabou(){
        var jogadoresPararam = jogador.parou() && computador.parou();
        var AlguemEstourou = jogador.getPontos() > 21 || computador.getPontos() > 21;

        return jogadoresPararam || AlguemEstourou;
    }
    
    public String resultado(){
        var jogadorGanhou = jogador.getPontos() <= 21 && 
                            (jogador.getPontos() > computador.getPontos() ||
                            computador.getPontos() > 21);

        var empatou = jogador.getPontos() == computador.getPontos() ||
                      jogador.getPontos() > 21 && computador.getPontos() > 21;

        if(jogadorGanhou) return "Você ganhou";
        if(empatou) return "Empatou";
        return "Você perdeu";
     }
    

}

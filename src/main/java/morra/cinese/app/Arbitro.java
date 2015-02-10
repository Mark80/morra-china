package morra.cinese.app;

import morra.cinese.app.giocate.Giocata;
import morra.cinese.app.rules.Rule;

public class Arbitro {

    private Rule rules;

    public  Arbitro(Rule rules) {
        this.rules = rules;
    }

    public  Arbitro() {}


    public Player theWinnerIs(Partita partita) {
        Player uno = partita.primoGiocatore();
        Player due = partita.secondoGiocatore();
        Player vincitore = rules.getWinner(uno,due);
        return  vincitore;
    }



}
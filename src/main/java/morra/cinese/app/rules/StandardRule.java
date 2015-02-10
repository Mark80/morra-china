package morra.cinese.app.rules;

import morra.cinese.app.Nessuno;
import morra.cinese.app.Player;
import morra.cinese.app.giocate.Giocata;

/**
 * Created by tosini on 09/02/15.
 */
public class StandardRule implements  Rule {

    public Player getWinner(Player uno, Player due) {
        Giocata giocataUno = uno.ultimaGiocata();
        Giocata giocataDue = due.ultimaGiocata();
        Player vincitore;
        if (isStessaGiocata(giocataUno, giocataDue)){
            vincitore =   Nessuno.getNessuno();
        }else {
            if (giocataUno.vinceSu(giocataDue)) {
                vincitore = uno;
            } else {
                vincitore = due;
            }
        }
        return vincitore;
    }

    private boolean isStessaGiocata(Giocata giocataUno, Giocata giocataDue) {
        return !giocataUno.vinceSu( giocataDue) && !giocataDue.vinceSu(giocataUno);
    }

}

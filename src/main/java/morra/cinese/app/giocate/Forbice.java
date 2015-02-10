package morra.cinese.app.giocate;

/**
 * Created by tosini on 09/02/15.
 */
public class Forbice implements Giocata {


    @Override
    public boolean vinceSu(Giocata other) {
        boolean result = false;
        if (other instanceof Carta || other instanceof Nessuna) {
            result = true;
        }
        return result;
    }
}


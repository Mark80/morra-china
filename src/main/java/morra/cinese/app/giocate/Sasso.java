package morra.cinese.app.giocate;

/**
 * Created by tosini on 09/02/15.
 */
public class Sasso implements Giocata {


    @Override
    public boolean vinceSu(Giocata other) {
        boolean result = false;

        if (other instanceof Forbice || other instanceof Nessuna) {
            result = true;
        }
        return result;
    }
}


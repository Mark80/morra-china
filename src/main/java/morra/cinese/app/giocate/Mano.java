
package morra.cinese.app.giocate;

public enum Mano {

    CARTA,
    FORBICE,
    SASSO,
    NESSUNA;


    private Mano vinceSu;

    static {
        CARTA.vinceSu = SASSO;
        SASSO.vinceSu = FORBICE;
        FORBICE.vinceSu = CARTA;
    }


    public Mano getVinceSu() {
        return vinceSu;
    }

}
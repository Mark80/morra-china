package morra.cinese.app.rules;

import morra.cinese.app.Player;


/**
 * Created by tosini on 09/02/15.
 */
public interface Rule {

    public Player getWinner(Player uno, Player due);
}

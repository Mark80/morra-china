
package morra.cinese.app;

import  morra.cinese.app.giocate.*;

public class Arbitro{
	
	private static Player nessuno= Nessuno.getNessuno();


  public static Player theWinnerIs(Partita partita) {
  	Player uno =  partita.primoGiocatore();
  	Player due =  partita.secondoGiocatore();	
    if( uno == nessuno  && due != nessuno) return due;
    if( uno != nessuno  && due == nessuno) return uno;
    if( uno == nessuno  && due == nessuno) return nessuno;
    
  	Mano giocataUno = uno.ultimaGiocata();
  	Mano giocataDue = due.ultimaGiocata();
    if(giocataUno == giocataDue) return Nessuno.getNessuno();
  	if(giocataUno.getVinceSu()==giocataDue || giocataDue == Mano.NESSUNA) return uno;
  	else return due;
  }


}
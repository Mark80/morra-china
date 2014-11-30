
package morra.cinese.app;


public class Partita{

 private Player[] giocatori = new Player[]{
	 Nessuno.getNessuno(),Nessuno.getNessuno()	 
 };
 private int numeroGiocatori = 0;
 


 public void addGiocatore(Player player){
 	try {
 	giocatori[numeroGiocatori] = player;
 	numeroGiocatori++;
 	} catch (ArrayIndexOutOfBoundsException ex){
 		throw new ArrayIndexOutOfBoundsException("Una partita può avere al massimo due giocatore");
 	}
 	
 }


public Player primoGiocatore() {
	return giocatori[0];
}


public Player secondoGiocatore() {
	return giocatori[1];
}
 

} 
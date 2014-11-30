
package morra.cinese.app;

import morra.cinese.app.giocate.Mano;


public class Player{


  private final String nome ;
  private Mano giocata;

  public Player(String nome){
  	if(nome==null) throw new IllegalArgumentException("Non sono ammessi giocatori anonimi!!!!");
    this.nome = nome;

  }

  public void partecipa(Partita partita){
     partita.addGiocatore(this);
  }

  public String getNome(){
    return this.nome;
  }

  public void gioca(Mano mano){    
     this.giocata= mano;
  }

  public Mano ultimaGiocata(){
  	return giocata;
  }

}
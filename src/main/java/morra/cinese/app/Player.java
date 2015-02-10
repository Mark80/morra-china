
package morra.cinese.app;

import morra.cinese.app.giocate.*;


public class Player{


  private final String nome ;
  private Giocata giocata = new Nessuna();

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
  public void giocaCarta(){
    this.giocata= new Carta();
  }
  public void giocaSasso(){this.giocata= new Sasso();}
  public void giocaForbice(){
    this.giocata= new Forbice();
  }
  public Giocata ultimaGiocata(){
  	return giocata;
  }

}
package morra.cinese.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import morra.cinese.app.rules.StandardRule;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test
 */
public class TestMorra {


   private static final Player NESSUNO = Nessuno.getNessuno();
   private Player uno;
   private Player due;
   private Player tre;


   @Before
   public void setUp(){
      uno =new Player("Marco");
      due = new Player("Paola");
   }


   @Test 
   public void esistonoIGiocatoriConNomi(){  
    Player uno =new Player("Nome");
    assertNotNull(uno);
   }

   @Test(expected=IllegalArgumentException.class) 
   public void nonEsistonoGiocatoriSenzaNomi(){  
    Player uno =new Player(null);
    assertNotNull(uno);
   }


   @Test
   public void siPossonoOrganizzarePartite(){
   Partita partita = new Partita();
   assertNotNull(partita);
   }

   @Test
   public void unGiocatorePuoPartecipareAdUnaPartita(){
      Partita partita = new Partita();
      uno.partecipa(partita);
      Player giocatore=partita.primoGiocatore();
      assertTrue(uno == giocatore);

   }

   @Test
   public void dueGiocatoriPossonoPartecipareAdUnaPartita(){
      Partita partita = creaPartitaConPartecipanti();
      Player giocatoreUno=partita.primoGiocatore();
      Player giocatoreDue=partita.secondoGiocatore();
      assertTrue(uno == giocatoreUno);
      assertTrue(due == giocatoreDue);

   }

   @Test(expected=ArrayIndexOutOfBoundsException.class) 
   public void treGiocatoriNonPossonoPartecipareAdUnaPartita(){
      tre = new Player("Seba");
      Partita partita = creaPartitaConPartecipanti();
      tre.partecipa(partita);
   }



   @Test
   public void laCartaBatteIlSasso(){
      Partita partita = creaPartitaConPartecipanti();
      uno.giocaSasso();
      due.giocaCarta();
      Player winner = getVincitore(partita);
      assertTrue(winner == due);
   }


   @Test
   public void laForbiceBatteLaCarta(){
      Partita partita = creaPartitaConPartecipanti();
      uno.giocaForbice();
      due.giocaCarta();
      Player winner = getVincitore(partita);
     assertTrue(winner == uno);
   }

   @Test
   public void ilSaddoBatteLaforbice(){
      Partita partita = creaPartitaConPartecipanti();
      uno.giocaForbice();
      due.giocaSasso();
      Player winner = getVincitore(partita);
      assertTrue(winner == due);
   }


   @Test
   public void ilSassoPareggiaConIlSasso(){
      Partita partita = creaPartitaConPartecipanti();
      uno.giocaSasso();
      due.giocaSasso();
      Player winner = getVincitore(partita);
      assertTrue(winner ==  NESSUNO);
   }


   @Test
   public void inUnaPartitaconUnGiocatoreVinceQuelGiocatore(){
      Partita partita = new Partita();
      uno.partecipa(partita);
      uno.giocaSasso();
     Player winner = getVincitore(partita);
      assertTrue(winner ==  uno);
   }

   @Test
   public void inUnaPartitaconUnGiocatoreVinceSuUnGiocatoreCheNonFaGiocata(){
      Partita partita = creaPartitaConPartecipanti();
      uno.giocaSasso();
      Player winner = getVincitore(partita);
      assertTrue(winner == uno);
   }


   private Player getVincitore(Partita partita) {
      Arbitro arbitro = new Arbitro(new StandardRule());
      return arbitro.theWinnerIs(partita);
   }

   private Partita creaPartitaConPartecipanti() {
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      return partita;
   }

}

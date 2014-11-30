package morra.cinese.app;

import static morra.cinese.app.giocate.Mano.CARTA;
import static morra.cinese.app.giocate.Mano.FORBICE;
import static morra.cinese.app.giocate.Mano.SASSO;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Unit test
 */
public class TestMorra {


   private static final Player NESSUNO = Nessuno.getNessuno();

@Test 
   public void possoCreareUnaGiocata(){   
    assertNotNull(FORBICE);
    assertNotNull(SASSO);
    assertNotNull(CARTA);
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
   public void unGiocatorePuoFareGiocate(){
    Player uno =new Player("Marco");
    uno.gioca(FORBICE);
    assertTrue(FORBICE == uno.ultimaGiocata());
    uno.gioca(SASSO);
    assertTrue(SASSO == uno.ultimaGiocata());
    uno.gioca(CARTA);
    assertTrue(CARTA == uno.ultimaGiocata());
   }


   @Test
   public void siPossonoOrganizzarePartite(){
   Partita partita = new Partita();
   assertNotNull(partita);
   }

   @Test
   public void unGiocatorePuoPartecipareAdUnaPartita(){   
      Player uno =new Player("Marco");
      Partita partita = new Partita();
      uno.partecipa(partita);
      Player giocatore=partita.primoGiocatore();
      assertTrue(uno == giocatore);

   }

   @Test
   public void dueGiocatoriPossonoPartecipareAdUnaPartita(){   
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      Player giocatoreUno=partita.primoGiocatore();
      Player giocatoreDue=partita.secondoGiocatore();
      assertTrue(uno == giocatoreUno);
      assertTrue(due == giocatoreDue);

   }

   @Test(expected=ArrayIndexOutOfBoundsException.class) 
   public void treGiocatoriNonPossonoPartecipareAdUnaPartita(){   
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Player tre =new Player("Seba");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      tre.partecipa(partita);
   }



   @Test
   public void laCartaBatteIlSasso(){
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      uno.gioca(SASSO);
      due.gioca(CARTA);
      Player winner = Arbitro.theWinnerIs(partita);
      assertTrue(winner == due);
   }


   @Test
   public void laForbiceBatteLaCarta(){
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      uno.gioca(FORBICE);
      due.gioca(CARTA);
      Player winner = Arbitro.theWinnerIs(partita);
      assertTrue(winner == uno);
   }

   @Test
   public void ilSaddoBatteLaforbice(){
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      uno.gioca(FORBICE);
      due.gioca(SASSO);
      Player winner = Arbitro.theWinnerIs(partita);
      assertTrue(winner == due);
   }

  @Test
   public void ilSassoPareggiaConIlSasso(){
      Player uno =new Player("Marco");
      Player due =new Player("Paola");
      Partita partita = new Partita();
      uno.partecipa(partita);
      due.partecipa(partita);
      uno.gioca(SASSO);
      due.gioca(SASSO);
      Player winner = Arbitro.theWinnerIs(partita);
      assertTrue(winner ==  NESSUNO);
   }

  @Test
   public void inUnaPartitaconUnGiocatoreVinceQuelGiocatore(){
      Player uno =new Player("Marco");
      Partita partita = new Partita();
      uno.partecipa(partita);
      uno.gioca(SASSO);
      Player winner = Arbitro.theWinnerIs(partita);
      assertTrue(winner ==  uno);
   }
   


}

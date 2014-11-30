
package morra.cinese.app;


 final class Nessuno extends Player {

   private static Player nessuno= new Nessuno(); 

   private Nessuno(){     
     super("Nessuno");
   }  

   public static Player getNessuno(){
     return nessuno;

   }


} 
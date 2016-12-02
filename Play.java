import java.util.*;

public class Play
{
   public static void main(String[] args)
   {
      Player player = new Player("John");
      player.addThreePotions();
      //picks up starting weapon, keep in final
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.setWeapon(0,0);
      //picks up more weapons for testing purposes, do not keep in final
      
      
      Story story = new Story();
      Prompt prompt = new Prompt(story);
      Map map1 = new Map("Moon 1", 1);
      int result = 0;
      prompt.enterArea(map1, map1.getCurrentArea(), player);
      System.out.println("\n\nWelcome to Lunar Centrism");
      System.out.println("Your name is John, you're an ex-cop who now deals with information brokers and acts as a vigilante for the innocent.\nOrbiting this world there are three moons, Justice, Sentry, and Powerhouse.");
      System.out.println("These moons are essentially the governing bodies of the Planet. You spend your days collecting information, and selling it.");
      System.out.println("\nYou wake up in your living quarters and remembered you have to talk to Adam at his coffee shop east of here.");
      prompt.menu(map1, player);
         
         
   }
   
}
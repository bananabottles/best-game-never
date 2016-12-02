import java.util.*;

public class Play
{
   public static void main(String[] args)
   {
      Player player = new Player("Tom");
      player.addThreePotions();
      //picks up starting weapon, keep in final
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      //picks up more weapons for testing purposes, do not keep in final
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      
      player.setWeapon(0,0); //setting weapon slots
      player.setWeapon(1,0);
      player.setWeapon(2,0);
      player.setWeapon(3,0);
      
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));

      player.setArmor(0,0);
      player.setArmor(1,0);
      
      Story story = new Story();
      Prompt prompt = new Prompt(story);
      Map map1 = new Map("Moon 1", 1);
      int result = 0;
      prompt.enterArea(map1, map1.getCurrentArea(), player);
      System.out.println("Welcome to Lunar Centrism");
      System.out.println("Your name is John, you're an ex-cop who now deals with information brokers and acts as a vigilante for the innocent.\nOn th'is world there are three moons, Justice, Sentry, and Powerhouse.");
      System.out.println("These moons are essentially the governing bodies of the Planet. You spend your days collecting information, and selling it.");
      
      prompt.menu(map1, player);
         
         
   }
   
}
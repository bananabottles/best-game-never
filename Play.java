import java.util.*;

public class Play
{
   public static void main(String[] args)
   {
      Player player = new Player("Tom");
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
      
      player.setWeapon1(0); //setting weapon slots
      player.setWeapon2(0);
      player.setWeapon3(0);
      player.setWeapon4(0);
      
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.setArmor1(0);
      player.setArmor2(0);
      
      Prompt prompt = new Prompt();
      Map map1 = new Map("Moon 1", 1);
      int result = 0;
      prompt.enterArea(map1.getCurrentArea(), player);

      prompt.menu(map1, player);
         
         
   }
   
}
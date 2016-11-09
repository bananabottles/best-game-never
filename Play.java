import java.util.*;

public class Play
{
   public static void main(String[] args)
   {
      Player player = new Player("Tom");
      player.pickUpWeapon(new Weapon(player.getLvl(), 'C'));
      player.setWeapon1(0);
      
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.pickUpArmor(new Armor(player.getLvl(), 'C'));
      player.setArmor1(0);
      player.setArmor2(0);
      
      Prompt prompt = new Prompt();
      Map map1 = new Map("Moon 1", 1);
      int result = 0;
      prompt.enterArea(map1.getCurrentArea(), player);
      
      do
      {
      
         result = prompt.menu(map1, player);
         
         
      }while(result == 0);
         
         
   }
   
}
import java.util.*;

public class Prompt
{
   private Scanner keyboard = new Scanner(System.in);
   private int direction;
   private int choice;
   Combat combat = new Combat();
   Player p1;
   Random rand = new Random();
   
   public Prompt()
   {
   }
   /**
   this runs when a player enters an area to show the player their location and to determine whether or not combat occurs and what level of combat it would be
   
   */
   
   public void enterArea(Area a, Player p)
   {
      p1 = p;
      System.out.println("You just entered: " + a.getName());
      int num = rand.nextInt(100);
      if(num < a.getCombatChance() || a.getReturnFight() == true) //need to make a chance for combat, and a difficulty indicator instead of this
      {
         combat.runCombat(p, a, a.getCombatDifficulty());
      }
      else
      {
         System.out.println("There are no hostiles here right now");
      }
      
   }
   /**
   provides a menu for the player when the code of the area they are currently in is finished and they are allowed to proceed to a new area
   
   */   
   public void menu(Map map, Player p)
   {
      p1 = p;
      boolean exit = false;
      do
      {
         System.out.println("Enter a number for an action:\n1 - Travel\n2 - Inventory\n3 - Skills\n4 - Options\n5 - Exit");
         choice = keyboard.nextInt();
         switch(choice)
         {
            case 1:
               travel(map);  //takes the player to the travel menu which shows them their options for travel
               break;
            case 2:
               inventory(p); //opens the inventory, allowing the player to view equipped gear, to view stored gear, and to equip and unequip gear
               break;
            case 3:  //is going to show the player their stats most likely, and is where they get upgrade points to upgrade a stat when they level up
            case 4:  //options will provide a save function and an exit function at least
            case 5:  //exit will be in options, so this is just for testing, do not keep for final but may replace with a new option
               System.out.println("Goodbye");
               exit = true;
               break;
            default:
               System.out.println("Error in menu input");
               break;
         }
      }while(exit == false);
   }
   
   /**
   Gives the player the option to travel, to different areas in the map.
   uses the move functions in the class Map and the local function enterArea after an area is chosen
   */   
   public void travel(Map map)
   {
      System.out.println(map.getCurrentArea().getDescription());
      System.out.println("\nEnter 1, 2, 3 or 4 to travel North, South, East, and West Respectively:");
      direction = keyboard.nextInt();
      switch(direction)
      {
         case 1:
            map.moveNorth();
            break;
         case 2:
            map.moveSouth();
            break;
         case 3:
            map.moveEast();
            break;
         case 4:
            map.moveWest();
            break;
         default:
            System.out.println("Error, invalid input");
            break;
      }
      enterArea(map.getCurrentArea(), p1);
   }
   /**
   Displays the user's inventory (should be weapons and armor, plus any items and currency if we include those
   */
   public void inventory(Player p)
   {
      System.out.println("\nInventory\n" + "Weapons\n" + p.getWeaponInventory());
   }
}
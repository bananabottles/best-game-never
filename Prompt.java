import java.util.*;

public class Prompt
{
   private Scanner keyboard = new Scanner(System.in);
   private int direction;
   private int choice;
   private int info;
   Combat combat = new Combat();
   Player p1;
   Random rand = new Random();
   private Story story;
   
   public Prompt(Story s)
   {
      story = s;
   }
   /**
   this runs when a player enters an area to show the player their location and to determine whether or not combat occurs and what level of combat it would be
   
   */
   
   public void enterArea(Map map, Area a, Player p)
   {
      int combatResult = 0;
      p1 = p;
      System.out.println("You just entered: " + a.getName());
      
      if(a.getIsHealingArea())
      {
         p.restoreHealth();
      }
      
      story.loadStory(a, p);
      int num = rand.nextInt(100);
      if(num < a.getCombatChance() || a.getReturnFight() == true) //need to make a chance for combat, and a difficulty indicator instead of this
      {
         combatResult = combat.runCombat(p, a, a.getCombatDifficulty());
      }
      else if(a.hasBoss() == true && a.getDefeat() == false)
      {
         combatResult = combat.runBossFight(p, a);
      }
      else
      {
         System.out.println("There are no hostiles here right now");
      }
      
      switch(combatResult)
      {
         case 0: //you defeated the enemy
            break;
         case 1: //you ran
            run(map);
            break;
         case 2: //you died
            map.moveBack();
            break;
         default:
            System.out.println("Error in combat result");
            break;
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
         System.out.println("Enter a number for an action:\n1 - Travel\n2 - Inventory\n3 - Skills " + p.getPoint() + "\n4 - Mission\n5 - Options");
         choice = keyboard.nextInt();
         switch(choice)
         {
            case 1:
               travel(map);  //takes the player to the travel menu which shows them their options for travel
               break;
            case 2:
               inventory(p); //opens the inventory, allowing the player to view equipped gear, to view stored gear, and to equip and unequip gear
               break;
            case 3: 
               vueSkills(p); //is going to show the player their stats most likely, and is where they get upgrade points to upgrade a stat when they level up
               break;
            case 4: 
               mission(p);
               break;
                   //options will provide a save function and an exit function at least
            case 5:  
               exit = options(p, map);
               break;
               //exit will be in options, so this is just for testing, do not keep for final but may replace with a new option
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
   private void travel(Map map)
   {
      boolean move = false;
      System.out.println(map.getCurrentArea().getDescription());
      System.out.println(map.getTravelOptions(story.getCurrentStep()));
      System.out.println("\nEnter 1, 2, 3 or 4 to travel North, South, East, and West Respectively:");
      direction = keyboard.nextInt();
      switch(direction)
      {
         case 1:
            move = map.moveNorth(story.getCurrentStep());
            break;
         case 2:
            move = map.moveSouth(story.getCurrentStep());
            break;
         case 3:
            move = map.moveEast(story.getCurrentStep());
            break;
         case 4:
            move = map.moveWest(story.getCurrentStep());
            break;
         default:
            System.out.println("Error, invalid input");
            break;
      }
      if(move)
      {
         enterArea(map, map.getCurrentArea(), p1);
      }
   }
   /**
   Displays the user's inventory (should be weapons and armor, plus any items and currency if we include those
   */
   private void inventory(Player p)
   {
      System.out.println("\nInventory\n" + "Weapons\n" + p.getWeaponInventory() + "Armor\n" + p.getArmorInventory());
      System.out.println("Would you like to equiped a new weapon? 1.(Y)    2.(N)");
      int yana = keyboard.nextInt();
      
      switch(yana)
      {
      case(1):
         System.out.println("Choose a slot for the new weapon?\n" + p.getWeaponsEquipped() + "\n5 - Return");
         int which = keyboard.nextInt();
         if(which >= 1 && which <= 4)
         {
            System.out.println("Which weapon would you like to use?\n" + p.getWeaponInventory() + "\n" + (p.getWeaponInventorySize() + 1) + "-Return");
            int whichwep = keyboard.nextInt();
            if(whichwep >= 1 && whichwep <= p.getWeaponInventorySize())
            {
               switch(which)
               {
                  case(1):
                     p1.setWeapon(which - 1, whichwep -1);
                     break; 
                  case(2):
                     p1.setWeapon(which - 1, whichwep -1);
                     break;
                  case(3):
                     p1.setWeapon(which - 1, whichwep -1);
                     break;
                  case(4):
                     p1.setWeapon(which - 1, whichwep -1);
                     break;
                  default:
                     break;
               }
            }
         }
         break;
         
      case(2):
         break;
      }
      
   }
   
   public void vueSkills(Player p)
   {
      //Displays your skills
      System.out.println("Your stats are " + p.getStats());
        
        //Skill point System
      if(p.getPoint() >= 1)
      {
         System.out.println("You have " + p.getPoint() + " skill point(s) pick a stat to increase \n 1.Attack   2. Defense  3. Health   4. Agility");
         info = keyboard.nextInt();
         switch(info)
         {
            case 1:
               p.addAtt(.1);
               p.usedPoint(1);
               break;
            case 2:
               p.addDef(.1);
               p.usedPoint(1);
               break;
            case 3:
               p.addMaxHp(10);
               p.usedPoint(1);
               break;
            case 4:
               p.addAgi(.1);
               p.usedPoint(1);
               break;      
         }   
      }//End of Skill point System
   }
   
   private void mission(Player p)
   {
      System.out.println("You are on mission " + story.getCurrentMission() + " (mission " + story.getCurrentStep() + ")");
   }
   
   private boolean options(Player p, Map map)
   {
      System.out.println("1-Save\n2-Load Checkpoint\n3-Quit Game");
      choice = keyboard.nextInt();
      boolean quit = false;
      switch(choice)
      {
         case 1:
            System.out.println("Game Saved");
            break;
         case 2:
            System.out.println("Loading Checkpoint");
            break;
         case 3:
            quit = true;
            break;
         default:
            System.out.println("Bad input");
            break;
      }
      return quit;
   }
            
   private void run(Map map)
   {
      enterArea(map, map.getPreviousArea(), p1);
   }
   
   private void died(Map map)
   {
    }
}

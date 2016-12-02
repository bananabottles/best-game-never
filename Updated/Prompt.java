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
   private boolean gameStart = true;           // this variable is used in method enterArea to determine whether text should be displayed
   
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
      
      if(gameStart == false)  // starts off as true, making sure the text isn't displayed at the very beginning of the game where only the intro should display
      {
         System.out.println("You just entered: " + a.getName());
         System.out.println(map.getCurrentArea().getDescription() + "\n");
      }
      
      gameStart = false;      // changes to false and stays false throughout the rest of the game
      
      if(a.getIsHealingArea())
      {
         p.restoreHealth();
      }
      
      story.loadStory(a, p);
      int num = rand.nextInt(100);
      if(num < a.getCombatChance() && a.hasBoss() == false || a.getReturnFight() == true) //need to make a chance for combat, and a difficulty indicator instead of this
      {
         combatResult = combat.runCombat(p, a, a.getCombatDifficulty());
      }
      else if(a.hasBoss() == true && a.getDefeat() == false)
      {
         combatResult = combat.runBossFight(p, a);
      }
      else if(a.getCombatChance() > 0)
      {
         System.out.println("There are no hostiles here right now");
      }
      
      switch(combatResult)
      {
         case 0: //you defeated the enemy
            a.setReturnFight(false);
            break;
         case 1: //you ran
            map.enterPreviousArea();
            enterArea(map, map.getCurrentArea(), p1);
            break;
         case 2: //you died
            map.moveBack();
            System.out.println("You were knocked unconscious and woke up back in your quarters fully rested.");
            p1.restoreHealth();
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
               travel(map, p);  //takes the player to the travel menu which shows them their options for travel
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
   private void travel(Map map, Player p)
   {
      boolean move = false;
      
      System.out.println(map.getTravelOptions(story.getCurrentStep()) + "5 - Return to Menu");
      System.out.println("\nEnter 1, 2, 3, 4, or 5 to travel North, South, East, West, and Return to Menu Respectively:");
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
         case 5:
            menu(map, p);
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
      System.out.println("\nInventory\n1 - View Weapons\n2 - View Armor\n3 - View Equipped\n4 - Use potion (You have " + p.getPotionNum() + ")\n5 - Return to Menu");// + p.getWeaponInventory() + "Armor\n" + p.getArmorInventory());
      int category = keyboard.nextInt();
      int armorInv = 1;
      int weaponInv = 1;
      int which2 = 1;
      if(category == 1)
      {
         System.out.println("Weapons in bag: " + p.getWeaponInventory());
         
         if(p.getWeaponInventorySize() == 0)
            System.out.println("You have no weapons in your bag.\n");
         
         System.out.println("Enter # of weapon to equip, or " + (p.getWeaponInventorySize() + 1) + " to return to menu.");
         weaponInv = keyboard.nextInt();
         if(weaponInv > 0 && weaponInv <= p.getWeaponInventorySize())
         {
            System.out.println("Choose a slot for the new weapon?\n" + p.getWeaponsEquipped() + "\n5 - Return");
            which2 = keyboard.nextInt();
            if(which2 > 0 && which2 < 5)
            {
               p.setWeapon(which2 - 1, weaponInv - 1);
               System.out.println("Weapon was equipped");
            }
         }
      }
      else if(category == 2)
      {
         System.out.println("Armor in bag: " + p.getArmorInventory());
         
         if(p.getArmorInventorySize() == 0)
            System.out.println("You have no armor in your bag.\n");
         
         System.out.println("Enter # of armor to equip, or " + (p.getArmorInventorySize() + 1) + " to return to menu.");
         armorInv = keyboard.nextInt();
         if(armorInv > 0 && armorInv <= p.getArmorInventorySize())
         {
            System.out.println("Choose a slot for the new armor?\n" + p.getArmorEquipped() + "\n3 - Return");
            which2 = keyboard.nextInt();
            if(which2 > 0 && which2 < 3)
            {
               p.setArmor(which2 - 1, armorInv - 1);
               System.out.println("Armor was equipped");
            }
         }
      }
      else if(category == 3)
      {
         System.out.println("Weapons:\n" + p.getWeaponsEquipped() + "\n\nArmors:\n" + p.getArmorEquipped() + "\n");
      }
      else if(category == 4)
      {
         p.usePotion();
      
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
      System.out.println("Mission " + story.getCurrentStep() + "\n" + story.getCurrentMission());
   }
   
   private boolean options(Player p, Map map)
   {
      System.out.println("1 - Save\n2 - Load Checkpoint\n3 - User Guide\n4 - Exit");
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
            System.out.println("1 - Exploration\n2 - Equipping and viewing weapons and armor\n3 - Using health potions\n4 - Using skill points\n5 - Combat\n6 - Exit");
            int help = keyboard.nextInt();
            switch(help)
            {
               case 1:
                  System.out.println("Most of the areas are locked at the start of the game, and the only way to unlock new areas to explore is to\nprogress through the story. There are multiple kinds of areas including safe areas, story areas, regular\ncombat areas, hard combat areas, and boss combat areas. Safe areas heal you back to full health. Story areas\ngenerally do not have combat except for boss areas.");
                  break;
               case 2:
                  System.out.println("To equip a weapon or armor, enter the inventory menu and select weapon or armor. You will be shown your inventory\nthat is not equipped. Enter the number that is next to the gear that you want to equip, and then you will be\nshown your current load out. Enter the number of the slot to equip the gear to, and if there was something\nalready equipped there, it will be put into your inventory and the new gear will take its place.");
                  break;
               case 3:
                  System.out.println("You collect health potions while fighting enemies. You can use them in the inventory menu by selecting to use a\npotion, or you can use them during combat while fighting tougher opponents.");
                  break;
               case 4:
                  System.out.println("Every time you level up, you gain a skill point. You can use these skill points to increase your stats such as\nattack power, defense power, maximum health, and agility.");
                  break;
               case 5:
                  System.out.println("The combat system consists of your attacking the enemy with your chosen weapon, and then the enemy attacking back.\nYour attacks will always hit the enemy, but the enemy may miss his attack depending on the enemy's agility stat\ncompared to yours. Every time you attack, it factors in your attack power and damage of the weapon, and your weapon's\ndurability decreases for every time you use it until it reaches zero and breaks. When the enemy attacks, it factors\nin the enemy's attack damage and your defense stat and armor rating. Between turns you may also use a health potion,\nor run. Running from battle is only possible agains common and hard enemies, not bosses. Running results in a %100\nchance to encounter an enemy in that specific area when you return to it. Defeating an enemy provides experience based\non your level and the enemy's difficulty rating. Defeating regular enemies has a chance to drop a weapon or armor, as\nwell as health potions. Defeating a boss will always drop a legendary weapon and three health potions.");
                  break;
               case 6:
                  break;
               default:
                  System.out.println("Error in help");
                  break;
            }
            break;
         case 4:
            quit = true;
            System.exit(0);
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
}

import java.util.Scanner;
import java.util.Random;

public class Combat
{
   
   // playerStats and enemyStats
   
   Scanner keyboard = new Scanner(System.in);
   private Player p1;
   private Enemy e1;
   private Random rand = new Random();
   private Weapon pickUpW = null;
   private Armor pickUpA = null;
   
   public Combat()
   {
   }
   
   public void runCombat(Player p, Area a, int difficulty) //int difficulty)
   {
      p1 = p;
      e1 = new Enemy(p.getLvl(), a.getCombatDifficulty());
      int number;
      boolean stay;
      System.out.println("Entering combat with: " + e1.getName());
      do
      {
         System.out.println("Enemy HP: " + e1.getHealth());
         System.out.println("What do yo want to do?\n1-Attack\n2-Items\n3-Run");
         number = keyboard.nextInt(); //your choice of what to do
         stay = select(number); //will return true for everything except run
      }while(stay == true && e1.isDead() == false);
      
      if(stay == true && e1.isDead() == true)
      {
         System.out.println("Your defeated " + e1.getName());
         System.out.print("EXP: " + p1.getExp() + "/" + p1.getExpToLevel() + " -> ");
         p1.addExp(e1.giveExp());
         System.out.print("" + p1.getExp() + "/" + p1.getExpToLevel() + "\n");
         
         int val = rand.nextInt(100);
         if (val <= 40)
         {
         //Drop Weapon 
         pickUpW = new Weapon(p1.getLvl(), e1.getEnemyRank());
         p1.pickUpWeapon(pickUpW);
         System.out.println("You just got a " + pickUpW.details());
         }
         else if (val <= 50)
         {
            pickUpA = new Armor(p1.getLvl(), e1.getEnemyRank());
            p1.pickUpArmor(pickUpA);
            System.out.println("You just got a " + pickUpA.armorInfo());
         }
        
         
         //give player experience which should be a variable unique for each enemy depending on their difficulty and level
         a.setReturnFight(false);
      }
      else
      {
         System.out.println("You decided to run.");
         System.out.println("An enemy will be waiting for your return");
         a.setReturnFight(true);
         
         //if player runs from battle, current area should have 100% chance of spawning enemy for when player returns
         //player should be returned to previous area or to a safe area (we need to decide)
      }
   }
   
   public void runBossFight(Player p, Area a) //int difficulty)
   {
      p1 = p;
      e1 = a.getBossEnemy();
      int number;
      boolean stay = true;
      System.out.println("Entering Boss Fight against: " + e1.getName());
      do
      {
         System.out.println("Enemy HP: " + e1.getHealth());
         System.out.println("What do yo want to do?\n1-Attack\n2-Items");
         number = keyboard.nextInt(); //your choice of what to do
         if(number == 3)
         {
            System.out.println("You cannot run from a boss fight");
         }
         else
         {
            stay = select(number); //will return true for everything except run
         }
      }while(stay == true && e1.isDead() == false);
      
      if(stay == true && e1.isDead() == true)
      {
         System.out.println("You defeated " + e1.getName());
         System.out.print("EXP: " + p1.getExp() + "/" + p1.getExpToLevel() + " -> ");
         p1.addExp(e1.giveExp());
         System.out.print("" + p1.getExp() + "/" + p1.getExpToLevel() + "\n");
         a.setDefeat(true);
         
         //Drop Weapon 
         pickUpW = a.getBossEnemy().getWeaponDrop();
         p1.pickUpWeapon(pickUpW);
         System.out.println("You just got a " + pickUpW.details());
         
        
         
         //give player experience which should be a variable unique for each enemy depending on their difficulty and level
         a.setReturnFight(false);
      }
      else
      {
         System.out.println("Error, player should not be able to run from enemy");
      }
   }

   
   private boolean select(int option)
   {
      switch(option)
      {
         case 1:
            System.out.println(p1.getWeaponsEquipped());
            attack(keyboard.nextInt());
            return true;
         case 2:
           // item();
            return true;
         case 3:
           // return run();
           return false;
         default:
            System.out.println("Error in select()");
            return true;
      }   
   }
   //Damage calculations   
   private void attack(int w)
   {
      e1.hurt(p1.attack(w));//Enemy takes dmg
      
      if(e1.isDead() == false)
      {  if (e1.getAgi() > p1.getAgi())//If the enemy has better aim than the player evasion
         {
            p1.hurt(e1.getDamage());//Player takes dmg
         }
         
         else if (p1.getAgi() > e1.getAgi())
            {
               int eva = rand.nextInt(100);
                  if(eva < 25)
                     {
                        System.out.println("Enemy missed! ");//Enemy misses attack
                     }
                  else
                     {
                        p1.hurt(e1.getDamage());//Player takes dmg
                     }   
                     
            }
      }
   }
   
}
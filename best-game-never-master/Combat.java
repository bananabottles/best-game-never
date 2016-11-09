import java.util.Scanner;

public class Combat
{
   
   // playerStats and enemyStats
   
   Scanner keyboard = new Scanner(System.in);
   Player p1;
   Enemy e1;
   
   public Combat()
   {
   }
   
   public void runCombat(Player p, Area a) //int difficulty)
   {
      p1 = p;
      e1 = new Enemy(p.getLvl());
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
         //give player experience which should be a variable unique for each enemy depending on their difficulty and level
         a.setReturnFight(false);
      }
      else
      {
         System.out.println("An enemy will be waiting for your return");
         a.setReturnFight(true);
         //if player runs from battle, current area should have 100% chance of spawning enemy for when player returns
         //player should be returned to previous area or to a safe area (we need to decide)
      }
   }
   
   private boolean select(int option)
   {
      switch(option)
      {
         case 1:
            System.out.println(p1.getWeapons());
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
      
   private void attack(int w)
   {
      e1.hurt(p1.attack(w));
      if(e1.isDead() == false)
      {
         p1.hurt(e1.getDamage());
      }
   }
   
}
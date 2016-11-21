import java.util.Random;

public class Enemy
{

   private String eName = "Skeleton Archer";

   private double att = 1.0;
   private double def = 1.0;
   private double maxhp = 50.0;
   private double temphp = 50.0;
   private double agi = 1.0;
   private double cr = 1.0;
   private boolean die = false;
   private double damage = 10.0;
   private int exp = 40; //how much base exp is given to player
   
   private Random rand = new Random();
   
   public Enemy()
   {
   
   }
   
   public Enemy(int pl)  //pl is player level
   {
      int probability = rand.nextInt(100);
      
      if(probability < 95)
      {
         makeCommonEnemy(pl);
      }
      else
      {
         makeHardEnemy(pl);
      }
   }
   
   public Enemy(int pl, int enemyType)
   {
      int n = 0;
      switch(enemyType)
      {
         case 1:  //change every combatD value in the area constructors in the Map class to a value between 1 and 5 so we can change this case back to 1
            System.out.println("Case 1");
            makeCommonEnemy(pl);
            System.out.println("Made enemy");
            break;
         case 2:
            makeHardEnemy(pl);
            break;
         case 3:
            n = rand.nextInt(100);
            if(n < 95)
               makeCommonEnemy(pl);
            else
               makeHardEnemy(pl);
            break;
         case 4:
            n = rand.nextInt(100);
            if(n < 25)
               makeCommonEnemy(pl);
            else
               makeHardEnemy(pl);
            break;
         case 5:
            System.out.println("Boss Coming");  //boss should have been constructed with Boss class in the parameters of the Area constructor, so each boss is unique to its area
            break;
         default:
            System.out.println("Error in Enemy constructor w/ difficulty" + enemyType);
            break;
      }
      //exp *= 2;
   }
   
   
   
   private void makeCommonEnemy(int plevel)
   {
      maxhp = 20 + (double)(plevel * (rand.nextInt(5) + 4)) * 0.4;
      damage = 5 + (double)(plevel * (2 + rand.nextInt(4))) * 0.3;
      temphp = maxhp;
      exp = 40 +(5 * plevel);
      System.out.println("Common enemy made");
   }
   
   private void makeHardEnemy(int plevel)
   {
      maxhp = 40 + (double)(plevel * (7 + rand.nextInt(5))) * 0.5;
      damage = 7 + (double)(plevel * (3 + rand.nextInt(4))) * 0.3;
      temphp = maxhp;
      exp = 80 + (5 * plevel);
      System.out.println("Hard enemy made");
   }
   
   //returns the damage with the attack modifier
   public double getDamage()
   {
      return damage * att;
   }

   public String getName()
   {
      return eName;
   }
   //used by Combat when the enemy dies so the player gets experience for it
   public int giveExp()
   {
      return exp;
   }
   
   public void setMaxhp(double hp)
   {
      maxhp = hp;
   }
   
   public void setTemphp(double hp)
   {
      temphp = hp;
   }
   
   public void setDamage(double d)
   {
      damage = d;
   }
   public void setName(String n)
   {
      eName = n;
   }
   
   public double getTemphp()
   {
      return temphp;
   }
   
   public double getMaxhp()
   {
      return maxhp;
   }
   
   public void setExp(int ex)
   {
      exp = ex;
   }
   
   public void hurt(double s) //s is the attack damage being done by the player
   {
      showHealth();
      temphp -= s; //hurts the enemy by the amount s
      System.out.println("You deal " + (int)s + " damage");
      showHealth();
      if(temphp <= 0) //enemy dies when health reaches zero 
      {
         System.out.println("Enemy is dead");
         die = true;
      }      
      
   }
   //used to check if this enemy character is dead, used in the combat class
   public boolean isDead()
   {
      return die;
   }
   
   //prints the enemy's name with his health
   public void showHealth()
   {  
      double health;
      if(temphp < 0)
      {
         health = 0;
      }
      else
      {
         health = temphp;
      }
      
      System.out.println(eName + " has " + (int)health + "/" + (int)maxhp + " HP");
   }
   //returns health as a string that looks like 90/100 if you have 90 out of 100 hp
   public String getHealth()
   {
      return "" + (int)temphp + "/" + (int)maxhp;
   }
   
   public String toString()
   {
      return "enemy\nHealth: " + temphp + "/" + maxhp + "\nDamage = " + damage;
   }
}
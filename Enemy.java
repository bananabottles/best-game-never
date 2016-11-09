import java.util.Random;

public class Enemy
{

   private String eName = "Pergert";

   private double att = 1.0;
   private double def = 1.0;
   private double maxhp = 50.0;
   private double temphp = 50.0;
   private double agi = 1.0;
   private double cr = 1.0;
   private boolean die = false;
   private double damage = 10.0;
   private int exp = 40;
   
   private Random rand = new Random();
   
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
   
   public Enemy(int pl, char enemyType)
   {
      switch(enemyType)
      {
         case 'C':
            makeCommonEnemy(pl);
            break;
         case 'H':
            makeHardEnemy(pl);
            break;
         default:
            System.out.println("Error in Enemy constructor w/ difficulty");
            break;
      }
   }
   
   
   
   private void makeCommonEnemy(int plevel)
   {
      maxhp = 20 + (double)(plevel * (rand.nextInt(5) + 4)) * 0.4;
      damage = 5 + (double)(plevel * (2 + rand.nextInt(4))) * 0.5;
      temphp = maxhp;
      exp = 40 +(10 * plevel);
   }
   
   private void makeHardEnemy(int plevel)
   {
      maxhp = 40 + (double)(plevel * (7 + rand.nextInt(5))) * 0.5;
      damage = 8 + (double)(plevel * (4 + rand.nextInt(4))) * 0.5;
      temphp = maxhp;
      exp = 80 + (15 * plevel);
   }
   
   
   public double getDamage()
   {
      return damage * att;
   }
   /*
   public double defend()
   {
      return temphp * def;
   }
   */
   public String getName()
   {
      return eName;
   }
   
   public int giveExp()
   {
      return exp;
   }
   
   public void hurt(double s)
   {
      showHealth();
      temphp -= s;
      System.out.println("You deal " + s + " damage");
      showHealth();
      if(temphp < 0)
      {
         System.out.println("Enemy is dead");
         die = true;
      }      
      
   }
   
   public boolean isDead()
   {
      return die;
   }
   
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
      
      System.out.println(eName + " has " + health + "/" + maxhp + " HP");
   }
   
   public String getHealth()
   {
      return "" + temphp + "/" + maxhp;
   }
   
   public String toString()
   {
      return "enemy\nHealth: " + temphp + "/" + maxhp + "\nDamage = " + damage;
   }
}
import java.util.Random;

public class Enemy
{

   private String eName = "enemy";

   private double att = 1.0;
   private double def = 1.0;
   private double hp = 50.0;
   private double agi = 1.0;
   private double cr = 1.0;
   
   private double damage = 10.0;
   
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
   
   
   
   
   private void makeCommonEnemy(int plevel)
   {
      hp = 20 + (double)(plevel * (rand.nextInt(5) + 4)) * 0.4;
      damage = 5 + (double)(plevel * (2 + rand.nextInt(4))) * 0.5;
   }
   
   private void makeHardEnemy(int plevel)
   {
      hp = 40 + (double)(plevel * (7 + rand.nextInt(5))) * 0.5;
      damage = 8 + (double)(plevel * (4 + rand.nextInt(4))) * 0.5;
   }
   
   
   public double attack()
   {
      return dmg * att;
   }
   
   public double defend()
   {
      return hp * def;
   }
   
   public String toString()
   {
      return "enemy\nHealth = " + hp + "\nDamage = " + damage;
   }
}
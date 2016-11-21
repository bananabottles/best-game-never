import java.util.Random;

public class Boss extends Enemy
{
   private Weapon weapon = null;
   private Random rand = new Random();
   private int number = 0;
   
   public Boss(int num)
   {
      super();
   }
   
   public void updateBoss(int playerLevel)
   {
      super.setMaxhp(60 + (double)(playerLevel * (7 + rand.nextInt(5))) * 0.5);
      super.setDamage(10 + (double)(playerLevel * (4 + rand.nextInt(4))) * 0.3);
      super.setTemphp(super.getMaxhp());
      super.setExp(80 + (15 * playerLevel));
      if(number == 1)
      {
         super.setName("Pregnart");
      }
      else if(number == 2)
      {
         super.setName("Borkur");
      }
      else if(number == 3)
      {
         super.setName("Ragnok");
      }
      else if(number == 4)
      {
         super.setName("Seba");
      }

      
   }


}
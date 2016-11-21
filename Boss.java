import java.util.Random;

public class Boss extends Enemy
{
   private Weapon weapon = null;
   private Random rand = new Random();
   
   public Boss()
   {
      super();
   }
   
   public void updateBoss(String name, Weapon w, int playerLevel)
   {
      super.setMaxhp(60 + (double)(playerLevel * (7 + rand.nextInt(5))) * 0.5);
      super.setDamage(10 + (double)(playerLevel * (4 + rand.nextInt(4))) * 0.3);
      super.setTemphp(super.getMaxhp());
      super.setExp(80 + (15 * playerLevel));
   }


}
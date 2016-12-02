import java.util.Random;

public class Boss extends Enemy
{
   private Weapon weapon = null;
   private Random rand = new Random();
   private boolean defeated = false;
   
   public Boss()
   {
      super();
   }
   
   public void updateBoss(String name, int playerLevel)
   {
      super.setName(name);
      super.setMaxhp(60 + (double)(playerLevel * (7 + rand.nextInt(5))) * 0.5);
      super.setDamage(10 + (double)(playerLevel * (4 + rand.nextInt(4))) * 0.3);
      super.setTemphp(super.getMaxhp());
      super.setExp(80 + (15 * playerLevel));
      weapon = new Weapon(playerLevel, 'B');
   }
   
   public Weapon getWeaponDrop()
   {
      return weapon;
   }
   public void setDefeated(Boolean b)
   {
      defeated = b;
   } 
   
   public boolean getDefeated()
   {
      return defeated;
   }

}
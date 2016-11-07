import java.util.Random;

public class Weapon extends Gear
{
   
   private double damage = 10;
   
   private Random rand = new Random();
   
   public Weapon(int playerLevel, char difficulty) //difficulty is what difficulty the enemy was that you defeated, harder the enemy, the more likely you get rarer gear
   {
      super(playerLevel);
   
      double a = rand.nextDouble();
      double common = 0.7; 
      double rare = 0.9; //this is not a percentage. Rare is made if the random number from 0.0 to 0.9 is 0.7 or 0.8. Legendary is spawned if it is 0.9
      
      switch(difficulty)
      {
         case 'C':
            common = 0.7;
            rare = 0.9;
            break;
         case 'H':
            common = 0.3;
            rare = 0.8;
            break;
         case 'B':
            common = 0.0;
            rare = 0.5;
            break;
      }
      
      String wName = "";
      int nameNum = rand.nextInt(4);
      
      switch(nameNum)
      {
         case 0:
            wName = "Katana";
            break;
         case 1:
            wName = "Spear";
            break;
         case 2:
            wName = "Axe";
            break;
         case 3:
            wName = "Mace";
            break;
         default:
            wName = "error";
            break;
      }
      
      super.setItemName(wName);
      
      if(a < common)
      {
         makeCommon(playerLevel);
      }
      else if(a < rare)
      {
         makeRare(playerLevel);
      }
      else
      {
         makeLegend(playerLevel);
      }
   }
   
   
   private void makeCommon(int pl)
   {
      super.setRarity("Common");
      damage = (rand.nextDouble() / 2.0) + 7.0 + ((double)pl * 0.5);
      
   }
   
   private void makeRare(int pl)
   {
      super.setRarity("Rare");
      damage = (rand.nextDouble() / 2.0) + 7.5 + ((double)pl * 0.7);
   }
   
   
   private void makeLegend(int pl)
   {
      super.setRarity("Legend");
      damage = (rand.nextDouble() / 2.0) + 8.5 + pl;
   }
   
   public String toString()
   {
      return "Weapon\nName: " + super.getItemName() + "\nDamage: " + damage + "\nWeight: " + super.getWeight() + "\nRarity: " + super.getRarity() + "\n";
   }
}
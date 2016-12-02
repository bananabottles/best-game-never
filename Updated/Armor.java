import java.util.Random;

public class Armor extends Gear
{
   private double armor = 10;
   private int slot = 1;
   
   private Random rand = new Random();
   
   public Armor(int playerLevel, char difficulty) //difficulty is what difficulty the enemy was that you defeated, harder the enemy, the more likely you get rarer gear
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
      int nameNum = rand.nextInt(9);
      
      switch(nameNum)
      {
         case 0:
            wName = "Cow Hide";
            break;
         case 1:
            wName = "Ballistic Weave";
            break;
         case 2:
            wName = "Light-weight nylon";
            break;
         case 3:
            wName = "Flak";
            break;
         case 4:
            wName = "Carbon Threaded";
            break;
         case 5:
            wName = "Ceramic Platting";
            break;
         case 6:
            wName = "Kevlar Jacket";
            break;
         case 7:
            wName = "Tin Foil Patched Suit";
            break;
         case 8:
            wName = "Track Suit with Sketchers Z-Strap Light Up Edition";
            break;                      
         default:
            wName = "error in armor";
            break;
      }
      
      super.setItemName(wName);
      
      int slot = rand.nextInt(2) + 1;
      
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
      armor = (rand.nextDouble() / 2.0) + ((double)pl * 0.1);
      
   }
   
   private void makeRare(int pl)
   {
      super.setRarity("Rare");
      armor = (rand.nextDouble() / 2.0) + ((double)pl * 0.2);
   }
   
   
   private void makeLegend(int pl)
   {
      super.setRarity("Legend");
      armor = (rand.nextDouble() / 2.0) + ((double)pl * 0.5);
   }
   
   public double getArmor()
   {
      return armor;
   }
   
   public String armorInfo()
   {
      return "Name: " + super.getItemName() + " Armor: " + armor + " Weight: " + super.getWeight() + " Rarity: " + super.getRarity() + " Slot: " + slot;
   }
}
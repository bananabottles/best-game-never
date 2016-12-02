import java.util.Random;

public class Weapon extends Gear
{
   
   private double damage = 10;
   private Random rand = new Random();
   private int durability = 100;
   
   public Weapon(int playerLevel, char difficulty) //difficulty is what difficulty the enemy was that you defeated, harder the enemy, the more likely you get rarer gear
   {
      super(playerLevel);
   
      double a = rand.nextDouble();
      double common = 0.7; 
      double rare = 0.9; //this is not a percentage. Rare is made if the random number from 0.0 to 0.9 is 0.7 or 0.8. Legendary is spawned if it is 0.9
      
      switch(difficulty)
      {
         case 'C':
            common = 0.9;
            rare = 100.0;
            break;
         case 'H':
            common = 0.4;
            rare = 100.0;
            break;
         case 'B':
            common = 0.0;
            rare = 0.0;
            break;
      }
      
      
      int nameNum = rand.nextInt(61);
      
      switch(nameNum)
      {
         case 0:
            super.setItemName("M4A1");
            break;
         case 1:
            super.setItemName("Tar-21");
            break;
         case 2:
            super.setItemName("UMP-4");
            break;
         case 3:
            super.setItemName("MP5-K");
            break;
         case 4:
            super.setItemName("Vector-45");
            break;
         case 5:
            super.setItemName("P-90");
            break;
         case 6:
            super.setItemName("ACR");
            break;
         case 7:
            super.setItemName("AK-47");
            break;
         case 8:
            super.setItemName("AK74U");
            break;
         case 9:
            super.setItemName("FAMAS");
            break;
         case 10:
            super.setItemName("F2000");
            break;
         case 11:
            super.setItemName("INTERVENTION");
            break;
         case 12:
            super.setItemName("WA2000");
            break;
         case 13:
            super.setItemName("L86 LSW");
            break;   
         case 14:
            super.setItemName("EBR");
            break;
         case 15:
            super.setItemName("BARRET.50cal");
            break;
         case 16:
            super.setItemName("Dragonav");
            break;
         case 17:
            super.setItemName("M240");
            break;
         case 18:
            super.setItemName("RPD");
            break;
         case 19:
            super.setItemName("M60");
            break;
         case 20:
            super.setItemName("USP.45");
            break;
         case 21:
            super.setItemName("M1911");
            break;
         case 22:
            super.setItemName("M9");
            break;
         case 23:
            super.setItemName("M93");
            break;
         case 24:
            super.setItemName("PP2000");
            break;
         case 25:
            super.setItemName("MAGNUM .44");
            break;
         case 26:
            super.setItemName("M14");
            break;
         case 27:
            super.setItemName("UZI");
            break;
         case 28:
            super.setItemName("AUG BHAR");
            break;
         case 29:
            super.setItemName("M1014");
            break;
         case 30:
            super.setItemName("SAGA");
            break;
         case 31:
            super.setItemName("USAS");
            break;
         case 32:
            super.setItemName("AA-12");
            break;  
         case 33:
            super.setItemName("SPAZ-12");
            break;
         case 34:
            super.setItemName("SKORPION");
            break;
         case 35:
            super.setItemName("M40A3");
            break;
         case 36:
            super.setItemName("R700");
            break;
         case 37:
            super.setItemName("DESERT EAGLE");
            break;
         case 38:
            super.setItemName("M416");
            break;
         case 39:
            super.setItemName("M249 SAW");
            break;
         case 40:
            super.setItemName("MOSIN NAGANT");
            break;
         case 41:
            super.setItemName("PPSH");
            break;
         case 42:
            super.setItemName("SCAR-H");
            break;
         case 43:
            super.setItemName("SCAR-L");
            break;
         case 44:
            super.setItemName("MP-44");
            break;
         case 45:
            super.setItemName("AN-94");//
            break;
         case 46:
            super.setItemName("MG36");
            break;
         case 47:
            super.setItemName("G36C");
            break;
         case 48:
            super.setItemName("XM8");
            break;
         case 49:
            super.setItemName("G3");
            break;
         case 50:
            super.setItemName("M21");
            break;
         case 51:
            super.setItemName("AS-VAL");
            break;
         case 52:
            super.setItemName("FAL");
            break;  
         case 53:
            super.setItemName("GLOCK 18");//
            break;
         case 54:
            super.setItemName("MP443");
            break;
         case 55:
            super.setItemName("P226");
            break;
         case 56:
            super.setItemName("MP40");
            break;
         case 57:
            super.setItemName("SKS");
            break;
         case 58:
            super.setItemName("TYPE-100");
            break;
         case 59:
            super.setItemName("PKM");
            break;
         case 60:
            super.setItemName("AEK");
            break;                                                                                
         default:
            super.setItemName("error");
            break;
      }
      
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
      damage = (rand.nextDouble() / 2.0) + 8.0 + ((double)pl * 0.7);
   }
   
   
   private void makeLegend(int pl)
   {
      super.setRarity("Legend");
      damage = (rand.nextDouble() / 2.0) + 10.5 + pl;
   }
   
   public double getDamage()
   {
      return damage;
   }
   
   public int getDurability()
   {
      return durability;
   }
   
   public void reduceDurability()
   {
      durability -= 4;
   }
   
   public String details()
   {
      return "" + super.getItemName() + ": Damage-" + (int)damage + " Durability-" + durability + "/100 Weight-" + super.getWeight() + " Rarity- " + super.getRarity();
   }
   
   
   
   public String toString()
   {
      return "Weapon\nName: " + super.getItemName() + "\nDamage: " + damage + "\nWeight: " + super.getWeight() + "\nRarity: " + super.getRarity() + "\n";
   }
   
   
}
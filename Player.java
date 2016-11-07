

public class Player
{
   
   private String pName = "Hero";
   
   ArrayList<Weapon> weapons = new ArrayList<Weapon>();
   ArrayList<Armor> armors = new ArrayList<Armor>();
   
   Weapon equippedWeapon;
   Armor equippedArmor;
   
   //stats
   private double att = 1.0;
   private double def = 1.0;
   private double hp = 100.0;
   private double agi = 1.0;
   private double cr = 1.0;
   private int lvl = 1;
   private int nextLvlExp = 100;
   private int totalExp = 0;
   
   //construct player with name
   public Player(String namae)
   {
      name = namae;
   }
   
   //accessor methods
   public double getAtt()
   {
      return att;
   }
   
   public double getDef()
   {
      return def;
   }
   
   public double getHp()
   {
      return hp;
   }
   
   public double getAgi()
   {
      return agi;
   }
   
   public double getCr()
   {
      return cr;
   }
   
   public int getLvl()
   {
      return lvl;
   }
   
   public int getExp()
   {
      return totalExp;
   }
   
   //mutator methods
   public void addAtt(double attack)
   {
      att += attack;
   }
   
   public void addDef(double defense)
   {
      def += defense;
   }
   
   public void addHp(double health)
   {
      hp += health;
   }
   
   public void addAgi(double agility)
   {
      agi += agility;
   }
   
   public void levelUp()
   {
      lvl++;
   }
   
   public void addExp(int experience)
   {
      totalExp += experience;
      while(totalExp >= nextLvlExp)
      {
         lvl++;
         nextLvlExp += 100+((lvl-1)*(25));
      }
   }
   

   public double attack()
   {
      return equippedWeapon.getDmg() * att;
   }
   
   public double defend()
   {
      return equippedArmor.getBlock() * def;
   }
   
   
   public void pickUpWeapon(Weapon a)
   {
      weapons.add(a);
   }
   
   public void pickUpArmor(Armor b)
   {
      armors.add(b);
   }
   
   
     

}  
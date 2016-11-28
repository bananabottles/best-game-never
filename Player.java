import java.util.ArrayList;

public class Player
{
   
   private String pName = "Hero";
   
   ArrayList<Weapon> weapons = new ArrayList<Weapon>();
   ArrayList<Armor> armors = new ArrayList<Armor>();
   
   Weapon[] weaponall = new Weapon[4];
   
   Armor[] armorall = new Armor[2];
   
   //stats
   private double att = 1.0;
   private double def = 1.0;
   private double maxhp = 100.0;
   private double temphp = 100.0;
   private double agi = .3;
   private double cr = 1.0;
   private int lvl = 1;
   private int nextLvlExp = 100;
   private int totalExp = 0;
   private int point = 1;
   private int usedpoint = 0;
   
   //construct player with name
   public Player(String namae)
   {
      pName = namae;
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
   
   public double getTempHp()
   {
      return temphp;
   }
   
   public double getMaxHp()
   {
      return maxhp;
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
   
   public int getExpToLevel()
   {
      return nextLvlExp;
   }
   
   public int getPoint()
   {
      return point;
   }
   
   public void usedPoint(int poi)
      {  
         usedpoint = poi;
         point = point - usedpoint;  
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
   
   public void addTempHp(double health)
   {
      temphp += health;
   }
   
   public void addMaxHp(double health)
   {
      maxhp += health;
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
         point++;
         nextLvlExp += 100+((lvl-1)*(25));
         System.out.println("You leveled up! You are now level " + lvl + "You also gained a skill point!");
      }
   }
   public String getStats()
      {
         String stats = ("Your level is: " + lvl + " HP: " + maxhp + " Attack: " + att + " Defense: " + def + " Agility: " + agi);
           return (stats);
      }
   

   public double attack(int slot)
   {
      double value = 0;
      if (slot > 0 && slot < 5)
         {  
            if(weaponall[slot -1] != null)
               { 
                  value = weaponall[slot -1].getDamage() * att;
               }
            
         }
           
      return value;
   }
   
   public void hurt(double s)
   {
      double difference = temphp;
      double armorhp = temphp * (def + armorall[0].getArmor() + armorall[1].getArmor());
      temphp = ((armorhp - s)/ armorhp) * temphp;
      difference = difference - temphp;
      System.out.println("Enemy dealt " + (int)difference + " damage\nYour Health: " + (int)temphp + "/" + (int)maxhp);
   }
   
   public void pickUpWeapon(Weapon a)
   {
      weapons.add(a);
   }
   
   public void pickUpArmor(Armor b)
   {
      armors.add(b);
   }
   
   public void setWeapon(int weaponToUnequip, int weaponToEquip)
   {
      if(weaponall[weaponToUnequip] == null && weapons.size() > weaponToEquip)
      {
         weaponall[weaponToUnequip] = weapons.get(weaponToEquip);
         weapons.remove(weaponToEquip);
      }
      else if(weapons.size() >= weaponToEquip)
      {
         weapons.add(weaponall[weaponToUnequip]);
         weaponall[weaponToUnequip] = weapons.get(weaponToEquip);
         weapons.remove(weaponToEquip);
      }
      else
      {
         System.out.println("Error, cannot set weapon ");
      }
   }
   
     
   public void setArmor(int armorToUnequip, int armorToEqup)
   {
      if(armorall[armorToUnequip] == null && armors.size() >= armorToEqup)
      {
         armorall[armorToUnequip] = armors.get(armorToEqup);
         armors.remove(armorToEqup);
      }
      else if(armors.size() >= armorToEqup)
      {
         armors.add(armorall[armorToUnequip]);
         armorall[armorToUnequip] = armors.get(armorToEqup);
         armors.remove(armorToEqup);
      }
      else
      {
         System.out.println("Error, cannot set armor ");
      }
   }
   
   public String getWeaponsEquipped()
   {
      String one = "";
      if(weaponall[0] != null)
      {
         one = "1-" + weaponall[0].getItemName() + " Damage: " + (int)weaponall[0].getDamage();
      }
      String two = "";
      if(weaponall[1] != null)
      {
         two = "\n2-" + weaponall[1].getItemName() + " Damage: " + (int)weaponall[1].getDamage();
      }
      String three = "";
      if(weaponall[2] != null)
      {
         three = "\n3-" + weaponall[2].getItemName() + " Damage: " + (int)weaponall[2].getDamage();
      }
      String four = "";
      if(weaponall[3] != null)
      {
         four = "\n4-" + weaponall[3].getItemName() + " Damage: " + (int)weaponall[3].getDamage();
      }
      return one + two + three + four;
   }
   
   public String getWeaponInventory()
   {
      String list = "";
      int loop = weapons.size();
      for(int i = 0; i < loop; i++)
      {
         list += "" + (i + 1) + "-- " + weapons.get(i).details() + "\n";
      }
      return list;
   }
   
   public String getArmorInventory()
   {
      String list = "";
      int loop = armors.size();
      for(int i = 0; i < loop; i++)
      {
         list += "" + (i + 1) + "-- " + armors.get(i).armorInfo() + "\n";
      }
      return list;
   }
   
   public String getArmorEquipped()
   {
      String one = "";
      if(armorall[1] != null)
      {
         one = "1-" + armorall[0].getItemName() + " Armor: " + (double)armorall[0].getArmor();
      }
      String two = "";
      if(armorall[1] != null)
      {
         two = "\n2-" + armorall[1].getItemName() + " Armor: " + (double)armorall[1].getArmor();
      }
      return one + two;
   }

}  
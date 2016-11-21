import java.util.ArrayList;

public class Player
{
   
   private String pName = "Hero";
   
   ArrayList<Weapon> weapons = new ArrayList<Weapon>();
   ArrayList<Armor> armors = new ArrayList<Armor>();
   
   Weapon weapon1;
   Weapon weapon2;
   Weapon weapon3;
   Weapon weapon4;
   Armor armor1;
   Armor armor2;
   
   //stats
   private double att = 1.0;
   private double def = 1.0;
   private double maxhp = 100.0;
   private double temphp = 100.0;
   private double agi = 1.0;
   private double cr = 1.0;
   private int lvl = 1;
   private int nextLvlExp = 100;
   private int totalExp = 0;
   
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
         nextLvlExp += 100+((lvl-1)*(25));
         System.out.println("You leveled up! You are now level " + lvl);
      }
   }
   

   public double attack(int slot)
   {
      double value = 0;
      switch(slot)
      {
         case 1:
            value = weapon1.getDamage() * att;
            break;
         case 2:
            value = weapon2.getDamage() * att;
            break;
         case 3:
            value = weapon3.getDamage() * att;
            break;
         case 4:
            value = weapon4.getDamage() * att;
            break;
         default:
            System.out.println("error in player - attack()");
            break;
      }
      
      return value;
   }
   /*
   public double defend()
   {
      return (armor1.getArmor() + armor2.getArmor()) * def;
   }
   */
   
   public void hurt(double s)
   {
      double difference = temphp;
      double armorhp = temphp * (def + armor1.getArmor() + armor1.getArmor());
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
   
   public void setWeapon1(int weaponIndex)
   {
      if(weapon1 == null && weapons.size() > weaponIndex)
      {
         weapon1 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else if(weapons.size() >= weaponIndex)
      {
         weapons.add(weapon1);
         weapon1 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else
      {
         System.out.println("Error, cannot set weapon 1");
      }
   }
   
   public void setWeapon2(int weaponIndex)
   {
      if(weapon2 == null && weapons.size() > weaponIndex)
      {
         weapon2 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else if(weapons.size() >= weaponIndex)
      {
         weapons.add(weapon2);
         weapon2 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else
      {
         System.out.println("Error, cannot set weapon 2");
      }
   }
   
   public void setWeapon3(int weaponIndex)
   {
      if(weapon3 == null && weapons.size() > weaponIndex)
      {
         weapon3 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else if(weapons.size() >= weaponIndex)
      {
         weapons.add(weapon3);
         weapon3 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else
      {
         System.out.println("Error, cannot set weapon 3");
      }
   }
   
   public void setWeapon4(int weaponIndex)
   {
      if(weapon4 == null && weapons.size() > weaponIndex)
      {
         weapon4 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else if(weapons.size() >= weaponIndex)
      {
         weapons.add(weapon4);
         weapon4 = weapons.get(weaponIndex);
         weapons.remove(weaponIndex);
      }
      else
      {
         System.out.println("Error, cannot set weapon 4");
      }
   }
   
   public void setArmor1(int armorIndex)
   {
      if(armor1 == null && armors.size() >= armorIndex)
      {
         armor1 = armors.get(armorIndex);
         armors.remove(armorIndex);
      }
      else if(armors.size() >= armorIndex)
      {
         armors.add(armor1);
         armor1 = armors.get(armorIndex);
         armors.remove(armorIndex);
      }
      else
      {
         System.out.println("Error, cannot set armor 1");
      }
   }
   
   public void setArmor2(int armorIndex)
   {
      if(armor2 == null && armors.size() >= armorIndex)
      {
         armor2 = armors.get(armorIndex);
         armors.remove(armorIndex);
      }
      else if(armors.size() >= armorIndex)
      {
         armors.add(armor2);
         armor2 = armors.get(armorIndex);
         armors.remove(armorIndex);
      }
      else
      {
         System.out.println("Error, cannot set armor 2");
      }
   }
   
   public String getWeaponsEquipped()
   {
      String one = "1-" + weapon1.getItemName() + " Damage: " + (int)weapon1.getDamage();
      String two = "";
      if(weapon2 != null)
      {
         two = "\n2-" + weapon2.getItemName() + " Damage: " + (int)weapon2.getDamage();
      }
      String three = "";
      if(weapon3 != null)
      {
         three = "\n3-" + weapon3.getItemName() + " Damage: " + (int)weapon3.getDamage();
      }
      String four = "";
      if(weapon4 != null)
      {
         four = "\n4-" + weapon4.getItemName() + " Damage: " + (int)weapon4.getDamage();
      }
      return one + two + three + four;
   }
   
   public String getWeaponInventory()
   {
      String list = "";
      int loop = weapons.size();
      for(int i = 0; i < loop; i++)
      {
         list += "" + i + "-- " + weapons.get(i).details() + "\n";
      }
      return list;
      
   }
   public String getArmorInventory()
   {
      String list = "";
      int loop = armors.size();
      for(int i = 0; i < loop; i++)
      {
         list += "" + i + "-- " + armors.get(i).details() + "\n";
      }
      return list;
   }

}  
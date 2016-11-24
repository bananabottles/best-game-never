

public class Area
{
   private String areaName = "";
   private String areaDescription = "";
   private int row = 0;
   private int column = 0;   
   private int combatChance = 0;
   private int combatDifficulty = 0;
   private boolean returnFight = false;
   private Boss bossEnemy = null;
   private int openStep = 0;
   private char subStep = 'a';
   private boolean defeated = false;
   /*
   0 - combat
   1 - easy bias
   2 - hard bias
   3 - legendary bias
   4 - easy only
   5 - hard only
   6 - legendary only
   */
   
   public Area()
   {
   }
   
   public Area(int r, int c, int combatC, int combatD, Boss boss, int open, String name, String descr)
   {
      row = r;
      column = c;
      areaName = name;
      areaDescription = descr;
      combatChance = combatC;
      combatDifficulty = combatD;
      bossEnemy = boss;
      openStep = open;
      
   }
   
   public String getName()
   {
      return areaName;
   }
   
   public String getDescription()
   {
      return areaDescription;
   }
   
   public int getRow()
   {
      return row;
   }
   
   public int getColumn()
   {
      return column;
   }
   
   public char getSubStep()
   {
      return subStep;
   }
   
   public boolean getDefeat()
   {
      return defeated;
   }
   
   public int getOpenStep()
   {
      return openStep;
   }
   
   public int getCombatChance() // number between 0 and 99, enter 30 for a 30% chance
   {
      return combatChance;
   }
   
   public int getCombatDifficulty() //1-Common only, 2-Hard only,3-Common more likely than hard, 4-hard more likely than common, 5-Boss
   {
      return combatDifficulty;
   }
   
   public boolean getReturnFight()
   {
      return returnFight;
   }
   
   public Boss getBossEnemy()
   {
      return bossEnemy;
   }
   
   public boolean hasBoss()
   {
      if(bossEnemy == null)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   public void setDefeat(boolean b)
   {
      defeated = b;
   }
   
   public void setAreaName(String name)
   {
      areaName = name;
   }
   
   public void setAreaDescription(String descr)
   {
      areaDescription = descr;
   }
   
   public void setLocaiton(int r, int c)
   {
      row = r;
      column = c;
   }
   
   public void setReturnFight(boolean b)
   {
      returnFight = b;
   }
}
   
   
   
   
   
   
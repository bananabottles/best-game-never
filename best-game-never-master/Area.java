

public class Area
{
   private String areaName = "";
   private String areaDescription = "";
   private int row = 0;
   private int column = 0;   
   private int combatLevel = 0;  //need to split this into two variables, one for combat chance, and one for combat difficulty
   private boolean returnFight = false;
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
   
   //Parameter from LoadMap1
   public Area(int r, int c, int combat, String name, String descr)
   {
      row = r;
      column = c;
      areaName = name;
      areaDescription = descr;
      combatLevel = combat;
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
   
   public int getCombat()
   {
      return combatLevel;
   }
   
   public boolean getReturnFight()
   {
      return returnFight;
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
   
   
   
   
   
   
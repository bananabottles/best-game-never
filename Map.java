

public class Map
{
   private String mapName = "";
   private Area[][] coordinate = new Area[5][5];  //makes a 2d array of areas with coordinates
   private Area currentArea = null;
   private int newIndex = 0;  //increments for each area added to create coordinates for each area
   private Area previousArea = null;
   private Area nextArea = null;
   private Area startingAreaMap1 = null;
   private Area startingAreaMap2 = null;
   private Area startingAreaMap3 = null;
   //private Area startingAreaMap4 = null;
   private int mapLoaded = 0;
   public Map(String name)
   {
      mapName = name;
   }
   
   public Map(String name, int load)
   {
      mapName = name;
      switch(load)
      {
         case 1:
            loadMap1();
            mapLoaded = 1;
            break;
         case 2:
            loadMap2();
            mapLoaded = 2;
            break;
         case 3:
            loadMap3();
            mapLoaded = 3;
            break;
         default:
            System.out.println("Error: cannot load map " + load);
            break;
      }
   }
   
   public void addNullArea()
   {
      int j = newIndex % 5;
      int i = newIndex / 5;
      if(i < 5 && j < 5)
      {
         coordinate[i][j] = null;
      }
      else
      {
         System.out.println("Map Full, cannot add more Areas");
      }
      newIndex++;
   }
   
   private void addNewArea(Area a)
   {
      int j = newIndex % 5;  //indicates the column of each area
      int i = newIndex / 5;  //indicates the rows
      if(i < 5 && j < 5)
      {
         coordinate[i][j] = a;
      }
      else
      {
         System.out.println("Map Full, cannot add more Areas");
      }
      newIndex++;
   }
   
   public boolean moveNorth(int step)
   {
      boolean move = false;
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(row < 4 && coordinate[row+1][column].getOpenStep() <= step) //Story is organized into steps, and each area is set to open at a specific step
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row + 1][column];
         move = true;
      }
      else
      {
         System.out.println("unable to travel North");
      }
      return move;
   }
   
   public boolean moveSouth(int step)
   {
      boolean move = false;
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(row > 0 && coordinate[row-1][column].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row - 1][column];
         move = true;
      }
      else
      {
         System.out.println("unable to travel South");
      }
      return move;
   }
   
   public boolean moveEast(int step)
   {
      boolean move = false;
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(column < 4 && coordinate[row][column+1].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row][column + 1];
         move = true;
      }
      else
      {
         System.out.println("unable to travel East");
      }
      return move;
   }
   
   public boolean moveWest(int step)
   {
      boolean move = false;
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(column > 0 && coordinate[row][column-1].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row][column - 1];
         move = true;
      }
      else
      {
         System.out.println("unable to travel West");
      }
      return move;
   }
   
   public void moveBack()
   {
      switch(mapLoaded)
      {
         case 1:
            currentArea = startingAreaMap1;
            break;
         case 2:
            currentArea = startingAreaMap2;
            break;
         case 3:
            currentArea = startingAreaMap3;
            break;
         default:
            System.out.println("Error in dying");
            break;
      }
   }
   
   public void setCurrentArea(int r, int c)
   {
      currentArea = coordinate[r][c];
   }
   
   public Area getCurrentArea()
   {
      return currentArea;
   }
   
   public Area getPreviousArea()
   {
      return previousArea;
   }
   
   public String getTravelOptions(int step)
   {
      String options = "";
      
      if(currentArea.getRow() + 1 <= 4)
      {
         if(step >= coordinate[currentArea.getRow() + 1][currentArea.getColumn()].getOpenStep())
         {
            options += "1 - North: " + coordinate[currentArea.getRow() + 1][currentArea.getColumn()].getName() + "\n";
         }
         else
         {
            options += "1 - North: " + coordinate[currentArea.getRow() + 1][currentArea.getColumn()].getName() + " (locked)\n";
         }
      }
      else
      {
         options += "1 - North: This path is blocked\n";
      }
      
      
      if(currentArea.getRow() - 1 >= 0)
      {
         if(step >= coordinate[currentArea.getRow() - 1][currentArea.getColumn()].getOpenStep())
         {
            options += "2 - South: " + coordinate[currentArea.getRow() - 1][currentArea.getColumn()].getName() + "\n";
         }
         else
         {
            options += "2 - South: " + coordinate[currentArea.getRow() - 1][currentArea.getColumn()].getName() + " (locked)\n";
         }
      }
      else
      {
         options += "2 - South: This path is blocked\n";
      }
      
      
      if(currentArea.getColumn() + 1 <= 4)
      {
         if(step >= coordinate[currentArea.getRow()][currentArea.getColumn() + 1].getOpenStep())
         {
            options += "3 - East: " + coordinate[currentArea.getRow()][currentArea.getColumn() + 1].getName() + "\n";
         }
         else
         {
            options += "3 - East: " + coordinate[currentArea.getRow()][currentArea.getColumn() + 1].getName() + " (locked)\n";
         }
      }
      else
      {
         options += "3 - East: This path is blocked\n";
      }
      
      
      if(currentArea.getColumn() - 1 >= 0)
      {
         if(step >= coordinate[currentArea.getRow()][currentArea.getColumn() - 1].getOpenStep())
         {
            options += "4 - West: " + coordinate[currentArea.getRow()][currentArea.getColumn() - 1].getName() + "\n";
         }
         else
         {
            options += "4 - West: " + coordinate[currentArea.getRow()][currentArea.getColumn() - 1].getName() + " (locked)\n";
         }
      }
      else
      {
         options += "4 - West: This path is blocked\n";
      }
      
      return options;
      
   }
   
   
   
   private void loadMap1()
   {
//row one
      //new Area( row#, column#, combatChance#, typeOfCombat#, bossObject, openStep#, Name string, description string with options for travel
      Area Shore = new Area(0, 0, 0, 1, null, 1, "Rocky Shore", "You find a rocky outcropping on the shore that gets progressively harder to maneuver.");
      addNewArea(Shore);  //adds a new area to coordinate[][] which is the array of areas that makes up the map
      
      Area Start = new Area(0, 1, 0, 1, null, 1, "Starting area", "You are at a campsite on the beach.");
      startingAreaMap1 = Start;
      addNewArea(Start);
      setCurrentArea(0,1);
      
      Area Ship = new Area(0, 2, 0, 1, null, 1, "Shipwreck", "You find the remains of a ship on the beach.");
      addNewArea(Ship);
      
      Area Geyser = new Area(0, 3, 100, 1, null, 1, "Geyser", "You arrive at a geyser that sprays refreshing water into the air.");
      addNewArea(Geyser);
      
      Area Outlet = new Area(0, 4, 100, 1, null, 3, "River Outlet", "You get to the mouth of the river.");
      addNewArea(Outlet);
      
//row two
      Area Cabin = new Area(1, 0, 100, 1, null, 3, "Deserted Cabin", "(description here).");
      addNewArea(Cabin);
      
      Area Forest = new Area(1, 1, 100, 1, null, 2, "Clearing in the Forest", "(description here).");
      addNewArea(Forest);
      
      Area Gravel = new Area(1, 2, 100, 1, null, 3, "Gravel Path", "(description here).");
      addNewArea(Gravel);
      
      Area Thorns = new Area(1, 3, 100, 1, null, 3, "Thorny Woods", "(description here).");
      addNewArea(Thorns);
      
      Area Bank = new Area(1, 4, 100, 1, null, 3, "River Bank", "(description here).");
      addNewArea(Bank);
      
      
//row three
      Area Well = new Area(2, 0, 100, 1, null, 3, "Water Well", "(description here).");
      addNewArea(Well);
      
      Area Lake = new Area(2, 1, 0, 1, null, 2, "Lake of Health", "(description here).");
      Lake.setHealingArea();
      addNewArea(Lake);
      
      Area Field = new Area(2, 2, 0, 1, new Boss(), 2, "Field of Tall Grass", "(description here).");
      addNewArea(Field);
      
      Area Dark = new Area(2, 3, 100, 2, null, 3, "Dark Path", "(description here).");
      addNewArea(Dark);
      
      Area Bridge = new Area(2, 4, 100, 1, null, 3, "Broken Bridge", "(description here).");
      addNewArea(Bridge);

//row 4      
      Area Farm = new Area(3, 0, 100, 1, null, 3, "Abandoned Farm", "You find the remains of a ship on the beach.");
      addNewArea(Farm);
      
      Area Crater = new Area(3, 1, 100, 1, null, 3, "Crater", "You find the remains of a ship on the beach.");
      addNewArea(Crater);
      
      Area Staircase = new Area(3, 2, 100, 1, null, 3, "Stone Staircase", "You find the remains of a ship on the beach.");
      addNewArea(Staircase);
      
      Area Watchtower = new Area(3, 3, 100, 1, null, 3, "Watchtower", "You find the remains of a ship on the beach.");
      addNewArea(Watchtower);
      
      Area Dam = new Area(3, 4, 100, 1, null, 3, "River Dam", "You find the remains of a ship on the beach.");
      addNewArea(Dam);

//row 5
      Area Cave = new Area(4, 0, 100, 1, null, 3, "Cave", "You find the remains of a ship on the beach.");
      addNewArea(Cave);
      
      Area Wall = new Area(4, 1, 100, 1, null, 3, "Castle Wall", "You find the remains of a ship on the beach.");
      addNewArea(Wall);
      
      Area Entrance = new Area(4, 2, 100, 1, null, 3, "Castle Entrance", "You find the remains of a ship on the beach.");
      addNewArea(Entrance);
      
      Area Village = new Area(4, 3, 100, 1, null, 3, "Village", "You find the remains of a ship on the beach.");
      addNewArea(Village);
      
      Area Resivior = new Area(4, 4, 100, 1, null, 3, "Resivior Bank", "You find the remains of a ship on the beach.");
      addNewArea(Resivior);

   }
   
   private void loadMap2()
   {
   
   }
   
   private void loadMap3()
   {
   
   }
   
   
}

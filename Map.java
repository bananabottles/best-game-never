


public class Map
{
   private String mapName = "";
   private Area[][] coordinate = new Area[5][5];  //makes a 2d array of areas with coordinates
   private Area currentArea = null;
   private int newIndex = 0;  //increments for each area added to create coordinates for each area
   private Area previousArea = null;
   private Area nextArea = null;
   
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
            break;
         case 2:
            loadMap2();
            break;
         case 3:
            loadMap3();
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
   
   public void moveNorth(int step)
   {
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(row < 4 && coordinate[row+1][column].getOpenStep() <= step) //Story is organized into steps, and each area is set to open at a specific step
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row + 1][column];
      }
      else
      {
         System.out.println("unable to travel North");
      }
   }
   
   public void moveSouth(int step)
   {
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(row > 0 && coordinate[row-1][column].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row - 1][column];
      }
      else
      {
         System.out.println("unable to travel South");
      }
   }
   
   public void moveEast(int step)
   {
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(column < 4 && coordinate[row][column+1].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row][column + 1];
      }
      else
      {
         System.out.println("unable to travel East");
      }
   }
   
   public void moveWest(int step)
   {
      int row = currentArea.getRow();
      int column = currentArea.getColumn();
      if(column > 0 && coordinate[row][column-1].getOpenStep() <= step)
      {
         previousArea = coordinate[row][column];
         currentArea = coordinate[row][column - 1];
      }
      else
      {
         System.out.println("unable to travel West");
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
   
   private void loadMap1()
   {
//row one
      //new Area( row#, column#, combatChance#, typeOfCombat#, bossObject, openStep#, Name string, description string with options for travel
      Area Shore = new Area(0, 0, 0, 1, null, 1, "Rocky Shore", "You find a rocky outcropping on the shore that gets progressively harder to maneuver.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Shore);  //adds a new area to coordinate[][] which is the array of areas that makes up the map
      
      Area Start = new Area(0, 1, 0, 1, null, 1, "Starting area", "You are at a campsite on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Shipwreck\nWest - Rocky Shore");
      addNewArea(Start);
      setCurrentArea(0,1);
      
      Area Ship = new Area(0, 2, 0, 1, null, 1, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Geyser\nWest - Beach Campsite");
      addNewArea(Ship);
      
      Area Geyser = new Area(0, 3, 100, 1, null, 1, "Geyser", "You arrive at a geyser that sprays refreshing water into the air.\nNorth - Cliffside\nSouth - Ocean\nEast - River Outlet\nWest - Shipwreck");
      addNewArea(Geyser);
      
      Area Outlet = new Area(0, 4, 100, 1, null, 3, "River Outlet", "You get to the mouth of the river.\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Outlet);
      
//row two
      Area Cabin = new Area(1, 0, 100, 1, null, 3, "Deserted Cabin", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Cabin);
      
      Area Forest = new Area(1, 1, 100, 1, null, 2, "Clearing in the Forest", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Forest);
      
      Area Gravel = new Area(1, 2, 100, 1, null, 3, "Gravel Path", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Gravel);
      
      Area Thorns = new Area(1, 3, 100, 1, null, 3, "Thorny Woods", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Thorns);
      
      Area Bank = new Area(1, 4, 100, 1, null, 3, "River Bank", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Bank);
      
      
//row three
      Area Well = new Area(2, 0, 100, 1, null, 3, "Water Well", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Well);
      
      Area Lake = new Area(2, 1, 0, 1, null, 2, "Lake of Health", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Lake);
      
      Area Field = new Area(2, 2, 0, 1, null, 3, "Field of Tall Grass", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Field);
      
      Area Dark = new Area(2, 3, 100, 2, null, 3, "Dark Path", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Dark);
      
      Area Bridge = new Area(2, 4, 100, 1, null, 3, "Broken Bridge", "(description here).\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      addNewArea(Bridge);

//row 4      
      Area Farm = new Area(3, 0, 100, 1, null, 3, "Abandoned Farm", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Farm);
      
      Area Crater = new Area(3, 1, 100, 1, null, 3, "Crater", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Crater);
      
      Area Staircase = new Area(3, 2, 100, 1, null, 3, "Stone Staircase", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Staircase);
      
      Area Watchtower = new Area(3, 3, 100, 1, null, 3, "Watchtower", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Watchtower);
      
      Area Dam = new Area(3, 4, 100, 1, null, 3, "River Dam", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Dam);

//row 5
      Area Cave = new Area(4, 0, 100, 1, null, 3, "Cave", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Cave);
      
      Area Wall = new Area(4, 1, 100, 1, null, 3, "Castle Wall", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Wall);
      
      Area Entrance = new Area(4, 2, 100, 1, null, 3, "Castle Entrance", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Entrance);
      
      Area Village = new Area(4, 3, 100, 1, null, 3, "Village", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Village);
      
      Area Resivior = new Area(4, 4, 100, 1, null, 3, "Resivior Bank", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      addNewArea(Resivior);

   }
   
   private void loadMap2()
   {
   
   }
   
   private void loadMap3()
   {
   
   }
   
   
}


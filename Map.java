

public class Map
{
   private String mapName = "";
   private Area[][] coordinate = new Area[5][5];   //makes a 2d array of areas with coordinates which functions as the map
   private Area currentArea = null;                //which area you are in at any given moment
   private int newIndex = 0;                       //increments for each area added to create coordinates for each area
   private Area previousArea = null;               //previous area you were in, used when running from battle
   private Area nextArea = null;
   private Area startingAreaMap1 = null;           //the starting area for map 1, used for the death function which sends you back to the starting area
   private Area startingAreaMap2 = null;
   private Area startingAreaMap3 = null;
   //private Area startingAreaMap4 = null;
   private int mapLoaded = 0;                      //stores the number of the map that has been loaded in each instance of Map, used for knowing which starting area to revert back to at death
   
   /**
   
   @param name    name of map
   @param load    used to pick which map to load, uses private method to load areas into the map
   */   
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
   //used to add a null area
   public void addNullArea()
   {
      int j = newIndex % 5;   //sets the first dimension in the array
      int i = newIndex / 5;   //sets the second dimension in the array
      if(i < 5 && j < 5)
      {
         coordinate[i][j] = null;   //sets the area location to null
      }
      else
      {
         System.out.println("Map Full, cannot add more Areas");
      }
      newIndex++;
   }
   //adds areas, works the same as above method but passes a parameter
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
      Area Shore = new Area(0, 0, 0, 1, null, 1, "Balcony", "You glance into the sky and see the three moons.");
      addNewArea(Shore);  //adds a new area to coordinate[][] which is the array of areas that makes up the map
      
      Area Start = new Area(0, 1, 0, 1, null, 1, "John's apartment", "A apartment studio located in the center of the city.\nJohn works, eats, sleeps, and does everything else here.");
      startingAreaMap1 = Start;  //sets this area as the designated starting area
      addNewArea(Start);
      setCurrentArea(0,1);
      
      Area Ship = new Area(0, 2, 0, 1, null, 1, "Adam's Coffee Shop", "A whole in the wall coffee shop known for its scones and coffee, it seems more like a bar than a coffee shop.");
      addNewArea(Ship);
      
      Area Geyser = new Area(0, 3, 100, 1, null, 1, "Abbey Road", "The main road within the slums full of merchants, theives, fortune tellers, and anyone else trying to make quick cash.");
      addNewArea(Geyser);
      
      Area Outlet = new Area(0, 4, 0, 1, null, 1, "Quartz Headquarters", "Quartz agency is a run down building located inside the slums, it is where all of the information brokers\nhave gathered and exchange valuable information.");
      addNewArea(Outlet);
      
//row two
      Area Cabin = new Area(1, 0, 0, 1, null, 3, "Seating area", "This is where John likes to unwind and stare upon the city.");
      addNewArea(Cabin);
      
      Area Forest = new Area(1, 1, 0, 1, null, 2, "Garden Plaza", "A high end plaza located in the higher district, where the busy and rich can relax.");
      addNewArea(Forest);
      
      Area Gravel = new Area(1, 2, 0, 1, null, 4, "Coffee shop basement", "Underground Adam keeps all of his equipment for spying.");
      addNewArea(Gravel);
      
      Area Thorns = new Area(1, 3, 100, 1, null, 3, "Abbey Alley", "Popular hang out shady people and getting cheap watches, and LOTS of mugging.");
      addNewArea(Thorns);
      
      Area Bank = new Area(1, 4, 0, 1, null, 4, "Head Quarters Bathroom", "Bathroom with a strange door.");
      addNewArea(Bank);
      
      
//row three
      Area Well = new Area(2, 0, 0, 1, null, 4, "Bar Lounge", "A place to meet exciting young people who drink and occasionally dance.");
      addNewArea(Well);
      
      Area Lake = new Area(2, 1, 0, 1, new Boss(), 4, "VIP section", "International Drug Smuggler Daily rates this spot 10/10 for quality seats and quality drinks.");
      addNewArea(Lake);
      
      Area Field = new Area(2, 2, 0, 1, null, 5, "Gypsy Medical Center", "Recover from your injuries.");
      addNewArea(Field);
      
      Area Dark = new Area(2, 3, 25, 2, null, 5, "Dark Path", "Where the Gypsies gather their medical supplies.");
      addNewArea(Dark);
      
      Area Bridge = new Area(2, 4, 10, 1, null, 5, "Gambling pit", "Illegal gambling, smoke filled rooms, smell of wine, and cheap perfume.");
      addNewArea(Bridge);

//row 4      
      Area Farm = new Area(3, 0, 100, 1, null, 6, "Burger Joint", "You find the remains of a ship on the beach.");
      addNewArea(Farm);
      
      Area Crater = new Area(3, 1, 100, 1, null, 6, "Water Fountain", "You find the remains of a ship on the beach.");
      addNewArea(Crater);
      
      Area Staircase = new Area(3, 2, 100, 1, null, 6, "Arby's", "You find the remains of a ship on the beach.");
      addNewArea(Staircase);
      
      Area Watchtower = new Area(3, 3, 100, 1, null, 6, "Watchtower", "You find the remains of a ship on the beach.");
      addNewArea(Watchtower);
      
      Area Dam = new Area(3, 4, 100, 1, null, 6, "River Dam", "You find the remains of a ship on the beach.");
      addNewArea(Dam);

//row 5
      Area Cave = new Area(4, 0, 100, 1, null, 6, "Cave", "You find the remains of a ship on the beach.");
      addNewArea(Cave);
      
      Area Wall = new Area(4, 1, 100, 1, null, 6, "Castle Wall", "You find the remains of a ship on the beach.");
      addNewArea(Wall);
      
      Area Entrance = new Area(4, 2, 100, 1, null, 6, "Castle Entrance", "You find the remains of a ship on the beach.");
      addNewArea(Entrance);
      
      Area Village = new Area(4, 3, 100, 1, null, 6, "Village", "You find the remains of a ship on the beach.");
      addNewArea(Village);
      
      Area Resivior = new Area(4, 4, 100, 1, null, 6, "Resivior Bank", "You find the remains of a ship on the beach.");
      addNewArea(Resivior);

   }
   
   private void loadMap2()
   {
   
   }
   
   private void loadMap3()
   {
   
   }
   
   
}

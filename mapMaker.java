import java.util.Scanner;


public class mapMaker
{
   
   public void loadMap1(Map map)
   {
      
      Area Shore = new Area(0, 0, "Rocky Shore", "You find a rocky outcropping on the shore that gets progressively harder to maneuver.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map.addNewArea(Shore);
      
      Area Start = new Area(0, 1, "Starting area", "You are at a campsite on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Shipwreck\nWest - Rocky Shore");
      map.addNewArea(Start);
      map.setCurrentArea(0,1);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - River Outlet\nWest - Beach Campsite");
      map.addNewArea(Ship);
      
      Area Geyser = new Area(0, 3, "Geyser", "You arrive at a geyser that sprays refreshing water into the air.\nNorth - Cliffside\nSouth - Ocean\nEast - River Outlet\nWest - Shipwreck");
      map.addNewArea(Geyser);
      
      Area Outlet = new Area(0, 4, "River Outlet", "You get to the mouth of the river.\nNorth - River Bank\nSouth - Ocean\nEast - River\nWest - Geyser");
      map.addNewArea(Outlet);
      
      
      /*
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      
      Area Ship = new Area(0, 2, "Shipwreck", "You find the remains of a ship on the beach.\nNorth - Forest\nSouth - Ocean\nEast - Beach Campsite\nWest - River Outlet");
      map1.addNewArea(Ship);
      */
   }
}
import java.util.*;

public class Prompt
{
   private Scanner keyboard = new Scanner(System.in);
   private int direction;
   private int choice;
   Combat combat = new Combat();
   Player p1;
   
   public Prompt()
   {
   }
   
   public void enterArea(Area a, Player p)
   {
      p1 = p;
      //Pull name of Area
      System.out.println("You just entered: " + a.getName());
      
      if(a.getCombat() > 0 || a.getReturnFight() == true) //need to make a chance for combat, and a difficulty indicator instead of this
      {
         combat.runCombat(p, a);
         
      }
      //Load Story Method get 
      
   }
   public int menu(Map map, Player p)
   {
      p1 = p;
      int exit = 0;
      System.out.println("Enter a number for an action:\n1 - Travel\n2 - Inventory\n3 - Skills\n4 - Exit");
      choice = keyboard.nextInt();
      switch(choice)
      {
         case 1:
            travel(map);
            break;
         case 2:
         case 3:
         case 4:
            System.out.println("Goodbye");
            return 1;
         default:
            System.out.println("Error in menu input");
            break;
      }
      return 0;
   }
   
   public void travel(Map map)
   {
      System.out.println(map.getCurrentArea().getDescription());
      System.out.println("\nEnter 1, 2, 3 or 4 to travel North, South, East, and West Respectively:");
      direction = keyboard.nextInt();
      switch(direction)
      {
         case 1:
            map.moveNorth();
            break;
         case 2:
            map.moveSouth();
            break;
         case 3:
            map.moveEast();
            break;
         case 4:
            map.moveWest();
            break;
         default:
            System.out.println("Error, invalid input");
            break;
      }
      enterArea(map.getCurrentArea(), p1);
   }
}
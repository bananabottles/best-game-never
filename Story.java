

public class Story
{
   
   private int currentStep = 1;
   
   public Story()
   {
   
   }
   
   public void loadStory(Area a, Player p)
   {
      
      if(a.getName().equals("Shipwreck") && currentStep == 1)
      {
         System.out.println("Go east to the geyser to face");
      }
      else if(a.getName().equals("Geyser") && currentStep == 1)
      {
         System.out.println("A creature runs at you, prepare to defend yourself");
         currentStep++;
      }
      else if(a.getName().equals("Lake of Health") && currentStep == 2)
      {
         System.out.println("This lake heals you to full health");
         currentStep++;
      }
      if (a.getName().equals("River Outlet") && currentStep == 3)
      {
      }
      
   
   }
   
   public int getCurrentStep()
   {
      return currentStep;
   }
   
   
}
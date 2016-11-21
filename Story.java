

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
         System.out.println("I was chased down the beach by a small creature, it seems they like the geyser");
      }
      else if(a.getName().equals("Geyser") && currentStep == 1)
      {
         System.out.println("A creature runs at you, prepare to defend yourself");
         currentStep++;
      }
         
   
   }
   
   public int getCurrentStep()
   {
      return currentStep;
   }
   
   
}
import java.util.Scanner;

public class Story
{
   
   Scanner input = new Scanner(System.in);
   private int currentStep = 1;
   int number;
   
   
   public Story()
   {
   
   }
   
   public void loadStory(Area a, Player p)
   {
      if(a.getName().equals("Adam's Coffee Shop") && currentStep == 1)
      {
         System.out.println("Adam: Headquarters called, they have information for you. I'd head there before someone takes your lead.");
      }
      else if(a.getName().equals("Abbey Road") && currentStep == 1)
      {
         System.out.println("An intoxicated bum runs at you, prepare to defend yourself.");
         
      }
       else if(a.getName().equals("Quartz Headquarters") && currentStep == 1)
      {
         System.out.println("You see a woman begging for someone to listen to her, however you choose to check your post box for new leads.");
         currentStep++;//Current step = 2
        
      }
       else if(a.getName().equals("John's apartment") && currentStep == 2)
      {
         System.out.println("You go over the information, and decide to review the information. You seek a coffee to aid your endeavor.");
         currentStep++;//Current Step = 3
         
      }
      else if(a.getName().equals("Adam's Coffee Shop") && currentStep == 3)
      {
         System.out.println("As you sit down waiting on your scone and coffee a young woman approaches you.\nLiv: I understand that you are an information broker. I have information pertaining to a coup within our government.\nI am the Daughter of Izar, the head of Justice. I can offer you money if you can aid me in learning more about\nwhen the coup plans to attack.");
         System.out.println("You should head toward Garden Plaza, its just north of your apartment.");
      }
      else if(a.getName().equals("Garden Plaza") && currentStep == 3)
      {
         System.out.println("You go and meet with an old friend: Axel\n You are suspicious of what Liv told you.\nAxel: Hello John, What would you like to talk about?");
         System.out.println("1. How have you been?.\n2. Status of the relationship between the moons.");
         number = input.nextInt();
         if(number == 1)
            {
               System.out.println("Never better, looks like I'll be receiving a large settlement after those rebels destroyed my shop.");
               System.out.println("I don't think they liked the fact that I was dealing with Sentry, before my shop was burnt down Sentry was ordering large quanties of ammunition.\nI think that the rebels know something we do not.");

            }
         else if(number == 2)
            {
               System.out.println("I don't think they're doing too good, before my shop was burnt down Sentry was ordering large quanties of ammunition.\nPersonally I did not think much about it, but it does raise some suspicion.");
            }
         currentStep++;//Current Step = 4
      }
       else if(a.getName().equals("VIP section") && currentStep == 4)
      {
         System.out.println("Ayo Johhny boy, still in the game huh? You know you locked up my boy when you double crossed me.");
         System.out.println("Let's see how you feel when your blood gets spilled.");
         currentStep++;
         a.getBossEnemy().updateBoss("Kenny-sama",p.getLvl());
      }
       else if(a.getName().equals("Gypsy Medical Center") && currentStep == 5)
      {
         System.out.println("Liv: John you're badly hurt you should rest!");
         System.out.println("John: hgnnnnn...bleh");
      }
      
         
   
   }
   
   public int getCurrentStep()
   {
      return currentStep;
   }
   
   public String getCurrentMission()
   {
      String missionName = "";
      switch(currentStep)
      {
         case 1:
            missionName = "Go to headquarters";
            break;
         case 2:
            missionName = "Review leads at home";
            break;
         case 3:
            missionName = "Follow the lead";
            break;
         case 4:
            missionName = "First Boss Fight";
            break;
         case 5:
            missionName = "Get to the Medical Center";
            break;
         default:
            System.out.println("Error in mission");
            break;
      }
            
      return missionName;
   }
   
   
}
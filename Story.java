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
         System.out.println("You see a woman begging for someone to listen to her, however, you choose to check your post box for new leads.");
         currentStep++;//Current step = 2
        
      }
       else if(a.getName().equals("John's apartment") && currentStep == 2)
      {
         System.out.println("You go over the information, and decide to review the information. You seek a coffee to aid your endeavor.");
         currentStep++;//Current Step = 3
         
      }
      else if(a.getName().equals("Adam's Coffee Shop") && currentStep == 3)
      {
         System.out.println("As you sit down waiting on your scone and coffee a young woman approaches you.\nLiv: I understand that you are an information broker. I have information pretaining to a coup within our government.\nI am the Daughter of Izar the head of the Justice. I can offer you money if you can help aid me in learning more about\nwhen the coup plans to attack.");
         System.out.println("You should head toward Garden Plaza, its just north of your apartment.");
      }
      else if(a.getName().equals("Garden Plaza") && currentStep == 3)
      {
         System.out.println("You go and meet with an old friend Axel\n You are suspicious of what Liv told you.\nAxel: Hello John, What would you like to talk about?");
         System.out.println("1. How have you been?.\n2. Status of the relationship between the moons.");
         number = input.nextInt();
         if(number == 1)
            {
               System.out.println("Never better, looks like I'll be recieving a large settlement after those rebels destroyed my shop.");
               System.out.println("I don't think they liked the fact that I was dealing with Sentry, before my shop was burnt down Sentry was ordering large quanties of ammunition.\nI think that the rebels know something we do not.");

            }
         else if(number == 2)
            {
               System.out.println("I don't think they're doing to good, before my shop was burnt down Sentry was ordering large quanties of ammunition.\nPersonally I did not think much about it, but it does raise some suspicion.");
            }
         currentStep++;//Current Step = 4
      }
       else if(a.getName().equals("VIP Section") && currentStep == 4)
      {
         System.out.println("John: Let's try to get out back. I need some fresh air.");
         System.out.println("Liv: That's a good idea, lets go!");
         
         
      }
       else if(a.getName().equals("Gypsy Medical Center") && currentStep == 4)
      {
         System.out.println("Liv: John you're badly hurt you should rest!");
         System.out.println("John: I'll just use some of my potions, no point in waisting time \nBesides we need to get to the");
         p.addThreePotions();

      }
      else if(a.getName().equals("Gambling pit") && currentStep == 4)
      {
         System.out.println("Gypsy Peddler: Wanna play craps for Skooma?");
         System.out.println("John: I only play craps for pinks");
         currentStep++;//CurrentStep = 5
      }
      else if(a.getName().equals("Sickle Street") && currentStep == 5)
      {
         System.out.println("John: I used to know a man that lived here, had a crooked eye but, was a sharp shot.");
         System.out.println("Liv: My father has a crooked eye, unfortunately he can't see without his mother's monicle.");
         
      }
      else if(a.getName().equals("8 Mile Road") && currentStep == 5)
      {
         
         System.out.println("Random Traveler: Ho Traveler, have you seen a wee man about ye' high? Lost him at the New Lyfe Bar after the 13 shots challenge.");
         System.out.println("John: Not since last november when I took a trip in the meadows to geocache.");
         System.out.println("Liv: I believe I saw him underneath a tree in the Plaza back north!");
         System.out.println("Random Traveler: Much obliged Ma'am, I'll be hitting the ole' dusty trail now. Later Pardner.");
         currentStep++;//CurrentStep = 6
      }
      else if(a.getName().equals("Road to redemption") && currentStep == 6)
      {
         System.out.println("John: Liv we have to make a decision, are we going to go in guns blazing or take the safer but longer route?");
         System.out.println("Liv: The decision is ultimately up to you john. I am but a follower.");
         System.out.println("John: If we go to the east we can sneak up to Kenny's lair and attack him by surprise.\nIf we choose to go south we will surely encounter an abundance of guards willing to lose their life for a raise.");
      }
      else if(a.getName().equals("Axel's House") && currentStep == 6)
      {
         System.out.println("Axel: My good friend John, what brings you here?");
          System.out.println("John: We have learned that Kenny is planning on launching a coup on the Moon Justice. We seek to put and end to his evil doing!");
           System.out.println("Axel: I owe the Lord Izar of Moon Justice a favor, might I aid you on your conquest?");
            System.out.println("John: Ride or Die brother.");
      }
      
      else if(a.getName().equals("Mason Road") && currentStep == 6)
      {
         System.out.println("John: Liv it's about to get bloody, I think you should stay behind.\nLiv: John I like the pain and I grown found of this M60.");
          System.out.println("John: Lock and load, this slops about to get slippery with blood.");
           System.out.println("Look on the bright side - tomorrow you'll be feeding hundreds of hungry cats!- Harley Quinn");
         currentStep++;//CurrentStep = 7;
      }
      else if(a.getName().equals("Final boss lair air vents") && currentStep == 6)
      {
         System.out.println("Axel: These air vents were not designed for crawling but soon enough we should reach a safe room to drop down into.");
         System.out.println("Liv: We'll drop in on the party.");
         System.out.println("John: It's like that one movie Wedding Crashers with Vince Vaughn.");
         System.out.println("Axel: I don't think thats even remotely close.");
         System.out.println("John: Oh well, can't count your chickens if the egg came first.");
         System.out.println("Liv: Right!");
         currentStep += 2;
      }
      else if(a.getName().equals("Death Valley") && currentStep == 7)
      {
         System.out.println("John: My palms are sweaty, shot that mans knees off already.");
         System.out.println("Liv: His brains blown looking like spaghetti.");
         System.out.println("John: Only on the surface does it get hot and heavy.");
         System.out.println("Dying Security Guard: Mmm bars.");
         currentStep++;
      }
       else if(a.getName().equals("Kenny's Lair") && currentStep == 8)
      {
         System.out.println("You just couldn't help yourself John, after all they've done to us!?\nWhile they live their lives full of luxuries we have to feed from the table cloth.");
         System.out.println("I always thought you would betray your own kind and for what? Some girl?\nI won't waste my breath, Goodbye John, may you find piece in the next life.");
         a.getBossEnemy().updateBoss("Kenny-sama",p.getLvl());
         currentStep++;
      }
       else if(a.getName().equals("Ruins of Man") && currentStep == 9)
      {
         System.out.println("Liv you have saved my fathers life, Thank You.");
         System.out.println("Game Over!");
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
            missionName = "Go to Adam's Coffee shop, then pursue Garden Plaza.";
            break;
         case 4:
            missionName = "Head off to the bar to find out about the coup.";
            break;
         case 5:
            missionName = "Head west and get to 8 mile road, which is past sickle road.";
            break;
         case 6:
            missionName = "Continue south and make a decision.";
            break;
         case 7:
            missionName = "Gear up for the and make sure you have potions ready.";
            break;
         case 8:
            missionName = "Kill Kenny.";
            break;




         default:
            System.out.println("Error in mission");
            break;
      }
            
      return missionName;
   }
   
   
}
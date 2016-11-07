import java.util.*;

public class Play
{
   public static void main(String[] args)
   {
      Prompt prompt = new Prompt();
      Map map1 = new Map("Moon 1", 1);
      int result = 0;
      prompt.enterArea(map1.getCurrentArea());
      
      do
      {
      
         result = prompt.menu(map1);
         
         
      }while(result == 0);
         
         
   }
   
}
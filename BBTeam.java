/** 
 *@author- Roshan Koirala 
 *@since-April 7, 2014
 *A test program called BBTeam that processes information from a file about a basketball team by making calls to the BBPlayer class
 */   



/** 
 *Imports all the required classes from library
 */
import java.io.*;
import java.util.*;
import javax.swing.*;


public class BBTeam
{
/** 
 *@exception IOException On input error.
 *@see IOException
 */
   public static void main(String[] args)throws IOException
   {
      
/**
 *Use of JFile Chooser class to chosse the file from user's computer
 *Use of File class to input file 
 *Use of scanner class to scan the input file
 */     
      JFileChooser browse = new JFileChooser(".");
      browse.showOpenDialog(null);
      File document = browse.getSelectedFile();
      Scanner reader = new Scanner(document);

/**
 *Creating a object called player for BBPlayer class
 *Initializing the object value to null
 *Use of scanner object to take a line from the file and take each word from the line
 */      
      BBPlayer player = null;
      
      while(reader.hasNextLine())
      {
         String line = reader.nextLine();
         
         Scanner linescan = new Scanner(line);
         Scanner wordscan = new Scanner(line);
         
         int count=0;
         String opcode=wordscan.next();
 
 /**
  *Using switch statement to check the opcode which is the first word of the sentence
  *Used another scanner object and a count variable to count the number of letter of first sentence
  *Depending upon the opcode, called various method of BBPlayer class to process the information about a basketball team
  */
    
         switch(opcode)
         {
/**
 *The opcode draft adds the player to the team,displaying a message that the player has been added with the player ID
 */          
            case "draft":
                  
               while(linescan.hasNext())
               {
                  linescan.next();
                  count++;
               }
               
               if (count<4)
               {
               
                  String firstname = wordscan.next();
                  String lastname = wordscan.next();
                  player  = new BBPlayer(firstname, lastname);
                  System.out.println("\nWelcome, "+firstname+" "+lastname+"! You have been added to the Basketball team, and assigned a player ID.");
                  
               }
               if (count ==4) 
               {
                  String firstname = wordscan.next();
                  String middlename = wordscan.next();
                  String lastname = wordscan.next();
                  player  = new BBPlayer(firstname, middlename,lastname);
                  System.out.println("\nWelcome, "+firstname+" "+middlename+" "+lastname+"! You have been added to the Basketball team, and assigned a player ID.");
               }
               break;
/**
 *The opcode ft records the free throw attempts
 */               
            case "ft":               
               int freethrowattempt= wordscan.nextInt();
               if( freethrowattempt == 1)
               {
                  player.recordFreeThrow(true);
               }
               if(freethrowattempt ==0)
               {
                  player.recordFreeThrow(false);
               }
               break;
/**
 *The opcode fg records the field goal attempt
 */               
            case "fg":               
               int fieldgoalattempt = wordscan.nextInt();
               player.recordFieldGoal(fieldgoalattempt);
               break;
/**
 *The opcode id displays the player id
 */               
            case "id":
               System.out.println("Your player's ID is "+player.getPlayerNumber());
               break;
/**
 *The opcode points displays the total player points
 */              
            case "points":
               System.out.println("The total points scored by you is "+ player.getPlayerPoints());
               break;
 /**
 *The opcode avg displays the free throws average
 */              
            case "avg":
               System.out.printf("Your free throw average is %.4f \n",player.getFreeThrowAvg());
               break;
 /**
 *The opcode stats displays the player's info and stats
 */              
            case "stats":
               System.out.println("\n"+player.toString());
               break;
 /**
 *The opcode count displays how many palyers have been drafted
 */             
            case "count":
               System.out.println("\n"+BBPlayer.numberOfPlayers()+" players have been drafted to the Basketball Team.");
               break;
/**
 *The opcode score displays the total number of points scored by the team
 */               
            case "score":
               System.out.println("\nThe total number of points scored by the team is "+ BBPlayer.teamPoints());
               break; 
               
         }
         
      }
   }
}/* End of class */
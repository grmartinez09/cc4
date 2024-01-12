import java.util.Scanner; /* for input on options of code */

public class satSchedule { 
    public static void main(String[] args) { /* entry point for program and is the first method that gets executed when a Java application starts*/
   System.out.println ("My Saturday Schedule");
   
   System.out.println ("7:30AM-8:50AM - Go to class in CC4: Data Structures and Algorithm in room M303"
                        + "\n" + "8:50AM-9:10AM - Choose a place/cafe to eat and work at and go there"); /* "\n - new line" */
   
   Scanner resto = new Scanner(System.in); /* input */
   System.out.println ("a. Starbucks "
                        +"b. Mcdo "
                        +"c. Jollibee "
                        +"d. Zentea "
                        +"e. SM ");
                        
    String restoChoice = ""; /* variable name */
     
    while (restoChoice.equals("")) { /* loop for choice */
         System.out.println ("Where to eat? ");
         String opResto = resto.nextLine(); /*nextLine - returns line that was skipped */
         
         if (opResto.equals("a")) { /* condition// equals - equivalent value/input*/
             restoChoice = "Starbucks";
         } else if (opResto.equals("b")) {
             restoChoice = "Mcdo";
         } else if (opResto.equals("c")) {
             restoChoice = "Jollibee";
         } else if (opResto.equals("d")) {
             restoChoice = "Zentea";
         } else if (opResto.equals("e")) {
             System.out.println("SM is still closed, try another restaurant."); /* invalid input */
         } else {
             System.out.print("Invalid input.");
         }
     }
     
    resto.close(); /* closes scanner */
    
     System.out.printf ("9:10AM-9:20AM - Order food and drinks at %s", restoChoice, "counter, then find a table."); /* formatted string */
     System.out.println("9:20AM-9:30AM - Take out laptop from bag and turn on. Wait for ordered food to be served."
                        + "\n" + "9:30AM-11:10AM - Log in and start working on my projects, tasks, and emails to send while eating/drinking"
                        + "\n" + "11:10AM - 11:15AM - Create and send EOD report and log out from work."
                        + "\n" + "11:15AM - 11:30AM - Go back to school"
                        + "\n" + "11:30AM - 12:50PM - Go to class in TECHNO 100: Technopreneurship in room U402"
                        + "\n" + "12:50PM- 2:10PM - Stay in roonm U402 for class in CC8: Introduction to Statistical Method"
                        + "\n" + "2:10PM - Go home to continue work for as long as needed");
    }
}
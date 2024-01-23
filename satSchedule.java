import java.util.Scanner; /* for input on options of code */

public class satSchedule { 
    public static int ctr = 0; /*counter */
    public static void main(String[] args) { /* entry point for program and is the first method that gets executed when a Java application starts*/
   System.out.println ("My Saturday Schedule"); ctr++;
   
   System.out.println ("7:30AM-8:50AM - Go to class in CC4: Data Structures and Algorithm in room M303"); ctr++;
   System.out.println("8:50AM-9:00AM - Go to the nearest cafe/restaurant"); ctr++;/* "\n - new line" */
   
   Scanner resto = new Scanner(System.in); ctr++;/* input */
   System.out.println ("a. Starbucks "
                        +"b. Mcdo "
                        +"c. Jollibee "
                        +"d. Zentea "
                        +"e. SM "); ctr++;
                        
    String restoChoice = ""; ctr++; 
    int foodServe = 0; ctr++;  /* variable name */
    ctr++;
    for (;restoChoice.equals("");) {ctr++; ctr++;  /* loop for choice */
         System.out.println ("Where to eat? "); ctr++; 
         String opResto = resto.nextLine(); ctr++;  /*nextLine - returns line that was skipped */

         if (opResto.equals("a")) { /* condition// equals - equivalent value/input*/
             restoChoice = "Starbucks"; ctr++;
             foodServe = 15; ctr++;
         } else if (opResto.equals("b")) {
             restoChoice = "Mcdo"; ctr++;
             foodServe = 16; ctr++;
         } else if (opResto.equals("c")) {
             restoChoice = "Jollibee"; ctr++;
             foodServe = 10; ctr++;
         } else if (opResto.equals("d")) {
             restoChoice = "Zentea"; ctr++;
             foodServe = 13; ctr++;
         } else if (opResto.equals("e")) {
             System.out.println("SM is still closed, try another restaurant."); ctr++; /* invalid input */
         } else {
             System.out.print("Invalid input. "); ctr++;
         }
         if (!restoChoice.equals("")) {
            resto.close(); ctr++;
         }
     }
     
     System.out.printf ("9:10AM-9:20AM - Order food and drinks at %s", restoChoice, "counter, then find a table."); ctr++; /* formatted string */
     System.out.println("\n9:20AM-9:30AM - Take out laptop from bag and turn on. Wait for ordered food to be served.");ctr++;

     for (int i = 0; i < foodServe; i++){ctr++;ctr++;
        System.out.print("#");ctr++;
     }

     System.out.println("\n9:30AM-11:10AM - Log in and start working on my projects, tasks, and emails to send while eating/drinking");ctr++;
     System.out.println("11:10AM - 11:15AM - Create and send EOD report and log out from work.");ctr++;
     System.out.println("11:15AM - 11:30AM - Go back to school");ctr++;
     System.out.println("11:30AM - 12:50PM - Go to class in TECHNO 100: Technopreneurship in room U402");ctr++;
     System.out.println("12:50PM- 2:10PM - Stay in roonm U402 for class in CC8: Introduction to Statistical Method");ctr++;
     System.out.println("2:10PM - Go home to continue work for as long as needed");ctr++;
     System.out.println(ctr);
    }
}
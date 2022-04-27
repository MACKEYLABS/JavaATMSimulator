import java.util.Scanner; //calling scanner class for user input
 
 public class Account { //setting public class to Account
   private int accountID; //access modifier to set int accountID to be used
   private double initialBalance; //using private access modifier to set double balance
   public Account(int accountID){ //setting int accountID as constructor 
	   this.accountID = accountID; //setting constructor to accountID to be called later
	   this.initialBalance = 100.00; //setting constructor to accountID to be called later
   }
   public void setBalance(double newBalance) {
       initialBalance = newBalance;
   }

   public void setID(int newID) {
       accountID = newID;
   }

   public double getBalance() { //setting getBalance to public double to be called later in code
       return initialBalance; //once called it will return initialBalance
   }

   public int getID() { //setting public access getID 
       return accountID; //to return accountID when called
   }

   public double withDraw(double withdrawAmount) { //setting withDraw to new double withdrawAmount
       return initialBalance = initialBalance - withdrawAmount; //to return value from balance when withdrawing money
   }

   public double deposit(double depositAmount) {//setting deposit to new depositAmount
       return initialBalance = initialBalance + depositAmount; //return the answer from this formula when called
   }
   public static void menuDisplay() { //setting menuDisplay to be shown when called
       System.out.println("ATM Options: (1) Balance (2) Withdraw (3) Deposit (4) Exit"); //printing to console 
   }
 
   public static void main(String[] args) { //main method

      Account[] accounts = new Account[9]; //setting accounts to be created
      for (int i = 0; i < accounts.length; ++i) { //setting for loop increment operator
         accounts[i] = new Account(i); //setting increment operator to add to i
      }
      Scanner scnr = new Scanner(System.in); //calling scanner class to accept user input
      System.out.print("What is your account number? "); //asking user for account number
      int enteredID; //creating enteredID as int
      
      do { //setting do while loop for true condition to commence 
         enteredID = scnr.nextInt(); //storing userinput into enteredID
         if (enteredID <= 9 && enteredID >=0 && enteredID == accounts[enteredID].getID()) { 
        	 //above is if statement for accounts 0 - 9 created
        	 System.out.println("Welcome Account Holder " + enteredID + "!"); 
        	 //after user inputs account number for 0 through 9 it prints to console
             
         
            
             do { //secondary do while loop for true statement 
            	 menuDisplay(); //prin to screen menu display
            	 System.out.print("Please select transaction: "); //print to console
                 int transactionNum = scnr.nextInt(); //storing user input for transactionNum
                 scnr.nextLine(); //storing user input into nextline
                 if (transactionNum <= 0 || transactionNum >= 5){ //if statement for wrong user input
                	 System.out.println("Invalid option, Please try again!"); //print to console 
                 }
                 
                 switch(transactionNum) { //switch statement for transactionNum, set to 4 cases
                  case 1: //1st case
                      System.out.printf("Your current balance is: $%.2f%n" , accounts[enteredID].getBalance());
                      //print to console statement above and set to two decimal spots
                      break;//break after completing case
                  case 2: //second case for switch statement
                      System.out.print("Enter amount to withdraw: "); //print to screen 
                      int withdrawAmount = scnr.nextInt(); //storing withdraw amount to user input
                      accounts[enteredID].withDraw(withdrawAmount); //storing enteredID into accounts and summoning withDraw amount formula
                      System.out.printf("%nSuccess! Your new balance is $%.2f%n" , accounts[enteredID].getBalance());
                      break; //exit switch 
                  case 3: //third case
                      System.out.print("Enter amount to deposit: "); //printing to console 
                      int depositAmount = scnr.nextInt(); //storing input for depositAmount
                      accounts[enteredID].deposit(depositAmount); //for enteredID calling depositAmount for deposit
                      System.out.printf("Success! Your new balance is $%.2f%n" , accounts[enteredID].getBalance());
                      break; //exiting switch case
                      
                  case 4:
                      System.out.println("Sign off."); //print to console 
                      System.out.println("Thank you for using our ATM. Please come back soon."); //print to console
                      Account.main(args); //restart main method if condition met
                      break; //exit switch case
                 }
             } while (true);//complete do while while loop is true
            
          }
          else{ //else statement inserted if invalid number is entered for account number
              System.out.println("Invalid account number. Please try again.");
              System.out.print("What is your account number? ");
          }
      }while(true); //completing do while loop if condition is true
      }
  }

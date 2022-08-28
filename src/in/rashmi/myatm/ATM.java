package in.rashmi.myatm;
import java.util.Scanner;
import in.rashmi.exception.InSufficientBalanceException;
import in.rashmi.exception.InvalidAmountException;
//import in.rashmi.service.*;
import in.rashmi.user.Bank;
	
	public class ATM 
	{
		public static void main(String args[]) throws InstantiationException, IllegalAccessException
	    {
			String bankName,nextOption;
	        double amount = 0.0;
	        int option=0;
	        Scanner sc = new Scanner(System.in);

	        outer:while(true)
	        {
	            System.out.println("Enter ATM card (Bank Name) : ");
	            bankName ="in.rashmi.service."+sc.next();
	            try
	            {
	                Bank bank = (Bank)Class.forName(bankName).getDeclaredConstructor().newInstance();

					inner:while(true)
	                {
	                    System.out.println("\n*****Choose Option*****");
	                    System.out.println("\n 1. Deposite");    
	                    System.out.println("\n 2. Withdraw");      
	                    System.out.println("\n 3. Balance Enquiry");       
	                    System.out.println( "\n 4. Exit");      
	                    System.out.println("\nEnter your choice: ");
						option =sc.nextInt();
	                            try
	                            {
	                                switch(option)
	                                {
	                                    case 1: 
	                                            System.out.println("Enter amount to deposit : ");
	                                            amount = sc.nextDouble();
	                                            bank.deposit(amount);
	                                            System.out.println(amount+ "Rs is deposited to your account");
	                                            break;


	                                    case 2:
	                                            System.out.println("Enter amount to withdraw : ");
	                                            amount = sc.nextDouble();
	                                            System.out.println("Collect Rs. "+bank.withdraw(amount)+ "cash..");
	                                            break;


	                                    case 3:
	                                    		bank.checkBalance();
	                                            break;
	                                    case 4:        	
	                                    		break inner;
	                                    default :
	                                            System.out.println("\n\t\t\tInvalid choice!");
												System.out.println("\n\t\t\tPlease try again...");
	                                            break;

	                
	                                }  //switch statement completed

	                                System.out.println("Do you want to continue (Press Y for Yes and N for No) : ");
	                                
	                                nextOption = sc.next();
	                                if(nextOption.equalsIgnoreCase("N"))
									{
	                                System.out.println("Thank You for using ATM Machine!");
	                                break outer;
									}
	                            }//Inner try

	                            catch(InvalidAmountException e)
	                            {
	                                System.out.println(e.getMessage());
	                            }

	                            catch(InSufficientBalanceException e)
	                            {
	                                System.out.println(e.getMessage());
	                            }

	                            catch(Exception e)
	                            {
	                                System.out.println(e.getMessage());
	                            }

	                }
	            }//outer try block

	            catch(ClassNotFoundException e)
	            {
					System.out.println("\nERROR: Entered bank is not found..");
					System.out.println("Please try again..\n\n");
	               // System.out.println(e.getMessage());
	            }

	            catch(Exception e)
	            {
	                System.out.println(e.getMessage());
	            }
	        }
			sc.close();
	    }
	}




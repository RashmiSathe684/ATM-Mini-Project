package in.rashmi.service;

import in.rashmi.exception.InSufficientBalanceException;
import in.rashmi.exception.InvalidAmountException;
import in.rashmi.user.Bank;
public class SBI implements Bank
{
	private double balance=0.0;
    public void deposit(double amt) throws InvalidAmountException
    {
        if (balance <= 0)
        {
            throw new InvalidAmountException("Invalid Amount : Amount should be greater than 0");
        }
        else
        {
            this.balance = this.balance + amt;
        }
    }

    public double withdraw(double amt) throws InSufficientBalanceException, InvalidAmountException
    {
        if(amt<=0)
        {
            throw new InvalidAmountException("Invalid Amount : Amount should be greater than zero");
        }
        else if(amt > balance)
        {
            throw new InSufficientBalanceException("Insufficient Balance");
        }
        balance = balance - amt;
        return amt;
    }
    public void checkBalance() 
    {

        System.out.println("Balance Rs:  "+balance);
    }

}

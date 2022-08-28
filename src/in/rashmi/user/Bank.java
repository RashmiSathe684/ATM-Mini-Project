package in.rashmi.user;

import in.rashmi.exception.InSufficientBalanceException;
import in.rashmi.exception.InvalidAmountException;
public interface Bank 
{
	    public void deposit (double amt) throws InvalidAmountException;
	    public double withdraw (double amt) throws InSufficientBalanceException, InvalidAmountException;	
	    public void checkBalance();
}

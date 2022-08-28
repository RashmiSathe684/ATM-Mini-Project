package in.rashmi.exception;

public class InSufficientBalanceException extends Exception
{

	private static final long serialVersionUID = 1L;

	public InSufficientBalanceException()
	{
		super();
	}
	
	public InSufficientBalanceException(String msg)
	{
		super(msg);
	}
}
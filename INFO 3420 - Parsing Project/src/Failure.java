
public class Failure extends ProdResult
{
	
	public Failure(String endString)
	{
		super(endString);
	}
	
	public boolean isSuccess()
	{
		return false;
	}
	
	

}

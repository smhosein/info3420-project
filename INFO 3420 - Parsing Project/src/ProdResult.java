
// Encapsulates the result of parsing some string 
public abstract class ProdResult
{
	private String endString;
	
	public ProdResult(String endString)
	{
		this.endString = endString;
	}
	
	public abstract boolean isSuccess();
	
	
	public String getEndGroup() {
		return endString;
	}
}

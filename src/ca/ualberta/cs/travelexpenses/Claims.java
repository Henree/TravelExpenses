package ca.ualberta.cs.travelexpenses;

public class Claims 
{
	
	private String Name;
	private String Start;
	private String Finish;

	public Claims(String Name, String Start, String Finish) 
	{
		// TODO Auto-generated constructor stub
		this.Name = Name;
		this.Start = Start;
		this.Finish = Finish;
	}
	public String getName()
	{
		return this.Name;
	}
	public String getDateRange()
	{
		return this.Start + "to" + this.Finish;
	}
	
	public String toString()
	{
		return getName();
	}

}

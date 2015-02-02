package ca.ualberta.cs.travelexpenses;

public class Expenses {

	private String Name;
	private String Date;
	private String Category;
	private double Cost;
	private String Currency;
	private String Detail;
	
	public Expenses(String Name, String Date, String Category,
			double Cost, String Currency, String Detail) {
		// TODO Auto-generated constructor stub
		this.Name = Name;
		this.Date = Date;
		this.Category = Category;
		this.Cost = Cost;
		this.Currency = Currency;
		this.Detail = Detail;
		
	}
	public String getName()
	{
		return this.Name;
	}
	public String getDate()
	{
		return this.Date;
	}
	public String getCategory()
	{
		return this.Category;
	}
	public double getCost()
	{
		return this.Cost;
	}
	public String getCurrency()
	{
		return this.Currency;
	}
	public String getDetail()
	{
		return this.Detail;
	}
}

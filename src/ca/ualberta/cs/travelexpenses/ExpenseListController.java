package ca.ualberta.cs.travelexpenses;

public class ExpenseListController 
{
	private static ExpenseList expenselist = null;
	static public ExpenseList getExpenseList()
	{
		if(expenselist == null)
		{
			expenselist = new ExpenseList();
		}
		return expenselist;
	}
	public void addExpense(Expenses expense) 
	{
		// TODO Auto-generated method stub
		getExpenseList().addExpense(expense);
	}

}

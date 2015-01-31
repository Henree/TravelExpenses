package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;
import java.util.Collection;

public class ExpenseList 
{
	
	protected ArrayList<Expenses> expenseList;
	
	public ExpenseList()
	{
		expenseList = new ArrayList<Expenses>();
	}
	
	public Collection<Expenses> getExpense()
	{
		return expenseList;
	}
	
	public void addExpense(Expenses expense)
	{
		expenseList.add(expense);
	}
	
	public void deleteExpense(Expenses expense)
	{
		expenseList.remove(expense);
	}
	
	public boolean contains(Expenses expense)
	{
		return expenseList.contains(expense);
	}
}

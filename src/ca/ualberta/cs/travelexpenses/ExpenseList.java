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
	
	public void addExpense(Expenses expenses)
	{
		expenseList.add(expenses);
	}
	

	public void deleteExpense(Expenses expenses)
	{
		expenseList.remove(expenses);
	}
	
	public boolean contains(Expenses expenses)
	{
		return expenseList.contains(expenses);
	}
}

package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import ca.ualberta.cs.travelexpenses.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddExpenseActivity extends Activity {

	static EditText Date;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addexpense);
		Date = (EditText) findViewById(R.id.ExpenseDate);
		set_on_click();
	}
	

	public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{

	    inflater.inflate(R.layout.addexpense, container, false);
	    ListView listview = (ListView) findViewById(R.id.ExpenseList);
		Collection<Expenses> expenses = ExpenseListController.getExpenseList().getExpense(); 
		ArrayList list = new ArrayList<Expenses>(expenses);
		ArrayAdapter<Expenses> expenseAdapter = new ArrayAdapter<Expenses>
				(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(expenseAdapter);
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_expense, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void set_on_click() {
		Date.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDatePickerDialog(v);
			}
			});
	}
	
	
	public void showDatePickerDialog(View v) 
	{
		
	    DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getFragmentManager(), "datePicker");
	}
	
/* Retrieved January 30,2015 from 
 * 	http://developer.android.com/guide/topics/ui/controls/pickers.html
 */
	public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener 
    {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) 
		{
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
		}

	public void onDateSet(DatePicker view, int year, int month, int day) 
	{
		// Do something with the date chosen by the user
		Date.setText((month+1) + "/" + day + "/" + year);
		}

    }

	public void addExpense(View view)
	{
		Toast.makeText(this, "New Expense Made", Toast.LENGTH_SHORT).show();
		ExpenseListController el = new ExpenseListController();
		EditText textView = (EditText) findViewById(R.id.ExpenseCustomName);
		EditText textView2 = (EditText) findViewById(R.id.ExpenseDate);
		EditText textView3 = (EditText) findViewById(R.id.ExpenseCat);
		EditText textView4 = (EditText) findViewById(R.id.ExpenseCost);
		EditText textView5 = (EditText) findViewById(R.id.ExpenseCurrency);
		EditText textView6 = (EditText) findViewById(R.id.ExpenseDetail);
		String costView = textView4.getText().toString();
		el.addExpense(new Expenses(textView.getText().toString(), textView2.getText().toString(), 
					textView3.getText().toString(), Double.parseDouble(costView),
					textView5.getText().toString(), textView6.getText().toString()));
		
		Intent intent = new Intent(AddExpenseActivity.this, CurrentClaimActivity.class);
		startActivity(intent);
		finish();
	}
}


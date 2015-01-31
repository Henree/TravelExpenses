package ca.ualberta.cs.travelexpenses;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddClaimActivity extends FragmentActivity {

	static EditText StartDate;
	static EditText FinishDate;
	static EditText Name;
	public static boolean IsStart = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addclaim);
		StartDate = (EditText) findViewById(R.id.ClaimStartDate);
		FinishDate = (EditText) findViewById(R.id.ClaimFinishDate);
		Name = (EditText) findViewById(R.id.addClaimName);
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		setContentView(R.layout.addclaim);
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
	
	
	public void showDatePickerDialog(View v) 
	{
		if (v == StartDate)
		{
			IsStart = true;
		}	
		
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
		if (IsStart)
			{
		StartDate.setText((month+1) + "/" + day + "/" + year);
			}
		else
			{
			FinishDate.setText((month+1) + "/" + day + "/" + year);
			}
		}

}
}
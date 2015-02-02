package ca.ualberta.cs.travelexpenses;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddClaimActivity extends FragmentActivity 
{

	private static EditText StartDateEdit;
	private static EditText EndDateEdit;
	private static boolean Start;
 
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
		
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.addclaim);
		 
		 StartDateEdit = (EditText) findViewById(R.id.ClaimStartDate);
		 EndDateEdit = (EditText) findViewById(R.id.ClaimFinishDate);
		 
		 set_on_click();
	}
	//Method to show listview
	public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
	    inflater.inflate(R.layout.addexpense, container, false);
	    ListView listview = (ListView) findViewById(R.id.ExpenseList);
		Collection<Claims> claims = ClaimListController.getClaimsList().getClaimList(); 
		ArrayList list = new ArrayList<Claims>(claims);
		ArrayAdapter<Claims> claimAdapter = new ArrayAdapter<Claims>
				(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(claimAdapter);
	}
 
	//Retrieved on January 30,2015 from http://developer.android.com/guide/topics/ui/controls/pickers.html
	public void showTruitonDatePickerDialog(View v) {
		
		if (v == StartDateEdit) {
			Start = true;
		} else {
			Start = false;
		}
		
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
 
	public static class DatePickerFragment extends DialogFragment
    				implements DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			// Do something with the date chosen by the user
			if (Start) {
				StartDateEdit.setText((month + 1) + "/" + day + "/" + year);
			} else {
				EndDateEdit.setText((month + 1) + "/" + day + "/" + year);
			}
		}
	}
	
	private void set_on_click() {
		StartDateEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTruitonDatePickerDialog(v);
			}
			});
		EndDateEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTruitonDatePickerDialog(v);
			}
			});
	}
	public void addClaims(View view)
	{
		Toast.makeText(this, "New Claim Made", Toast.LENGTH_SHORT).show();
		ClaimListController cl = new ClaimListController();
		EditText textView = (EditText) findViewById(R.id.AddClaimName);
		EditText textView2 = (EditText) findViewById(R.id.ClaimStartDate);
		EditText textView3 = (EditText) findViewById(R.id.ClaimFinishDate);
		cl.addClaim(new Claims(textView.getText().toString(),
				textView2.getText().toString(), textView3.getText().toString()));
		Intent intent = new Intent(AddClaimActivity.this, CurrentClaimActivity.class);
		startActivity(intent);
		finish();
		
		
	}
}

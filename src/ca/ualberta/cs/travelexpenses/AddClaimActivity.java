package ca.ualberta.cs.travelexpenses;

import android.os.Bundle;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
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
				StartDateEdit.setText(day + "/" + (month + 1) + "/" + year);
			} else {
				EndDateEdit.setText(day + "/" + (month + 1) + "/" + year);
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
		EditText textView = (EditText) findViewById(R.id.addClaimName);
		EditText textView2 = (EditText) findViewById(R.id.ClaimStartDate);
		EditText textView3 = (EditText) findViewById(R.id.ClaimFinishDate);
		cl.addClaim(new Claims(textView.getText().toString(),
				textView2.getText().toString(), textView3.getText().toString()));
		Intent intent = new Intent(AddClaimActivity.this, CurrentClaimActivity.class);
		startActivity(intent);
	}
}

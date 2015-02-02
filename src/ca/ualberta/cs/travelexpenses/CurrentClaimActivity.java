package ca.ualberta.cs.travelexpenses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CurrentClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currentclaim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.current_claim, menu);
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
	public void MainScreen(MenuItem menu)
	{
		Toast.makeText(this, "Going to Main screen", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(CurrentClaimActivity.this, MainActivity.class);
		startActivity(intent);
	}
	
	public void newexpense(View view)
	{
		Toast.makeText(this, "going to expense", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(CurrentClaimActivity.this, AddExpenseActivity.class);
		startActivity(intent);
	}
}

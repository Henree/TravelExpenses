/*
 Copyright 2015 Henry Ha

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
/*
 This android application is an app that keeps track of your travel claims and expenses
 */
/*Retrieved on January 26,2015 from https://www.youtube.com/watch?v=VKVYUXNuDDg&feature=youtu.be
 * 
 */

package ca.ualberta.cs.travelexpenses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static Claims claim;
	//public ListView lv1;
	//public ClaimsList cl = new ClaimsList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/*Method to show listview
	public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
	    /*inflater.inflate(R.layout.addexpense, container, false);
	    ListView listview = (ListView) findViewById(R.id.ClaimsList);
		Collection<Claims> claims = ClaimListController.getClaimsList().getClaimList(); 
		ArrayList list = new ArrayList<Claims>(claims);
		ArrayAdapter<Claims> claimAdapter = new ArrayAdapter<Claims>
				(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(claimAdapter);
		
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void CurrentClaimScreen(MenuItem menu)
	{
		Toast.makeText(this, "Going to Current Claim screen", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, CurrentClaimActivity.class);
		startActivity(intent);
	}
	
	public void addclaimbutton(View view)
	{
		Toast.makeText(this, "Going to claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
		startActivity(intent);
	}
	
	
}

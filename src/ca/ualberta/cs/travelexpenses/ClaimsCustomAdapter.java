package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClaimsCustomAdapter extends BaseAdapter 
{
	/*
	 * Retrieved from http://www.androidhive.info/2012/02/android-custom-listview-with-image-and-text/
	 * Feburary 1, 2015
	 */
	private static ArrayList<Claims> ClaimsList;
	private LayoutInflater mInflater;

	public ClaimsCustomAdapter(Context context, ArrayList<Claims> Claimslist) {
		ClaimsList = Claimslist;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return ClaimsList.size();
	}

	public Object getItem(int position) {
		return ClaimsList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.customadapterlayout, null);
			holder = new ViewHolder();
			holder.claim = (TextView) convertView.findViewById(R.id.ClaimName);
			holder.date = (TextView) convertView.findViewById(R.id.DateRange);
			holder.status = (TextView) convertView.findViewById(R.id.Status);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.claim.setText(ClaimsList.get(position).getName());
		holder.date.setText(ClaimsList.get(position).getDateRange());
		holder.status.setText(ClaimsList.get(position).toStatus());
		
		return convertView;
	}

	static class ViewHolder {
		TextView claim;
		TextView date;
		TextView status;
	}
}


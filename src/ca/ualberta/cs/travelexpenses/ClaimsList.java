package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimsList 
{
	
	protected ArrayList<Claims> claimsList;
	protected ArrayList<ClaimsListener> listeners;
	
	public ClaimsList()
	{
		claimsList = new ArrayList<Claims>();
		listeners = new ArrayList<ClaimsListener>();
	}
	
	public Collection<Claims> getClaims()
	{
		return claimsList;
	}
	
	public void addClaims(Claims claims)
	{
		claimsList.add(claims);
		notifyListeners();
	}

	private void notifyListeners() 
	{
		// TODO Auto-generated method stub
		for (ClaimsListener listener : listeners)
		{
			listener.update();
		}
	}
	public void addListener(ClaimsListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(ClaimsListener l)
	{
		listeners.remove(l);
	}
	
	public void deleteClaims(Claims claims)
	{
		claimsList.remove(claims);
	}
	
	public boolean contains(Claims claims)
	{
		return claimsList.contains(claims);
	}
	
}

package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimsList 
{
	
	protected ArrayList<Claims> claimsList;
	
	public ClaimsList()
	{
		claimsList = new ArrayList<Claims>();
	}
	
	public Collection<Claims> getClaims()
	{
		return claimsList;
	}
	
	public void addClaims(Claims claims)
	{
		claimsList.add(claims);
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

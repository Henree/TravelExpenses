package ca.ualberta.cs.travelexpenses;

import java.util.ArrayList;

public class ClaimsList 
{
	protected static ArrayList<Claims> claimsList;
	
	public ArrayList<Claims> getClaimList() {
		if (claimsList == null) {
			claimsList = new ArrayList<Claims>();
		}
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

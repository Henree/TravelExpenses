package ca.ualberta.cs.travelexpenses;

public class ClaimListController 
{
	private static ClaimsList claimsList = null;
	
	static public ClaimsList getClaimsList()
	{
		if (claimsList == null)
		{
			claimsList = new ClaimsList();
		}
		return claimsList;
	}

	public void addClaim(Claims claims) {
		// TODO Auto-generated method stub
		getClaimsList().addClaims(claims);
	}
}

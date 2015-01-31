package ca.ualberta.cs.travelexpenses;

public class ClaimListController 
{
	private static ClaimsList claimList = null;
	
	static public ClaimsList getClaimsList()
	{
		if (claimList == null)
		{
			claimList = new ClaimsList();
		}
		return claimList;
	}

	public void addClaim(Claims claims) {
		// TODO Auto-generated method stub
		getClaimsList().addClaims(claims);
	}
}

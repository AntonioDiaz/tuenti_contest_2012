package challenge01;

public enum EdgeType {
	VERTICAL(300),
	HORIZONTAL(200),
	DIAGONAL(350);
	
	EdgeType (int myCost){
		this.edgeCost = myCost;
	}
	
	private int edgeCost;

	public int getEdgeCost() {
		return edgeCost;
	}

	public void setEdgeCost(int edgeCost) {
		this.edgeCost = edgeCost;
	}

	public static EdgeType convertEdgeType(char myChar){
		EdgeType myConversion = null;
		switch (myChar) {
		case 'H':
			myConversion = HORIZONTAL;
			break;
		case 'V':
			myConversion = VERTICAL;
			break;
		case 'D':
			myConversion = DIAGONAL;
			break;
		}
		return myConversion;
	}

}
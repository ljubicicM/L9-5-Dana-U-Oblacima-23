package com.example.L9Project.Player;

public class Player {
	private String name;
	private String lastName;
	private String position;
	private int gamesPlayed=0; //broj odigranih utakmica
	private float FTM; //Free Throw Made
	private float FTA; //Free Throw Attempted
	private float TwoPM; //Two Points Made
	private float TwoPA; //Two Points Attempted
	private float ThreePM; //Three Points Made
	private float ThreePA; //Three Points Attempted
	private float REB; //Rebounds
	private float BLK; //Blocks
	private float AST; //Assists
	private float STL; //Steals
	private float TOV; //Turnovers
	private float FTProcentage; //Free Throw Percentage
	private float TwoPProcentage; //Two Points Percentage
	private float ThreePProcentage; //Three Points Percentage
	private float PTS; //Points
	private float VAL; //Valorization
	private float EFGProcentage; //Effective Field Goal Percentage
	private float TSPRocentage; //True Shooting Percentage
	private float HASTProcentage; //Hollinger Assist Ratio
	
	public Player(String Name,String LastName,String Position, float fTM, float fTA, float twoPM, float twoPA, float threePM, float threePA,
			float rEB, float bLK, float aST, float sTL, float tOV) {
		
		super();
		name = Name;
		lastName = LastName;
		position=Position;
		FTM = fTM;
		FTA = fTA;
		TwoPM = twoPM;
		TwoPA = twoPA;
		ThreePM = threePM;
		ThreePA = threePA;
		REB = rEB;
		BLK = bLK;
		AST = aST;
		STL = sTL;
		TOV = tOV;
		
		gamesPlayed++;
	}
	
	public void AddStats(float fTM, float fTA, float twoPM, float twoPA, float threePM, float threePA,
			float rEB, float bLK, float aST, float sTL, float tOV)  {
		
		FTM += fTM;
		FTA += fTA;
		TwoPM += twoPM;
		TwoPA += twoPA;
		ThreePM += threePM;
		ThreePA += threePA;
		REB += rEB;
		BLK += bLK;
		AST += aST;
		STL += sTL;
		TOV += tOV;
		
		gamesPlayed++;
	}
	
	public void calculatePlayer() {
		FTM /= gamesPlayed;
		FTA /= gamesPlayed;
		TwoPM /= gamesPlayed;
		TwoPA /= gamesPlayed;
		ThreePM /= gamesPlayed;
		ThreePA /= gamesPlayed;
		REB /= gamesPlayed;
		BLK /= gamesPlayed;
		AST /= gamesPlayed;
		STL /= gamesPlayed;
		TOV /= gamesPlayed;
		FTProcentage = (FTM/FTA*100);
		TwoPProcentage = (TwoPM/TwoPA*100);
		ThreePProcentage = (ThreePM/TwoPA*100);
		PTS = FTM + 2*TwoPM + 3*ThreePM;
		VAL = (FTM + 2*TwoPM + 3*ThreePM + REB + BLK + AST + STL) - 
				(FTA-FTM + TwoPA-TwoPM + ThreePA-ThreePM + TOV);
		EFGProcentage = (TwoPM + ThreePM + (1/2) * ThreePM) / (TwoPA + ThreePA) * 100;
		TSPRocentage = PTS / (2 * (TwoPA + ThreePA + (19/40) * FTA)) * 100;
		HASTProcentage = AST / (TwoPA + ThreePA + (19/40) * FTA + AST + TOV) * 100;
	}
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	@Override
	public String toString() {
		return "{\n"
				+ "\n"
				+ "\"playerName\": \" " + name + " " + lastName +"\",\n"
				+ "\"gamesPlayed\": " + gamesPlayed + ",\n"
				+ "\"traditional\": {\n"
				+ "\"freeThrows\": {\n"
				+ "\"attempts\": " + FTA + ",\n"
				+ "\"made\": " + FTM + ",\n"
				+ "\"shootingPercentage\": " + FTProcentage + "\n"
				+ "},\n"
				+ "\"twoPoints\": {\n"
				+ "\"attempts\": " + TwoPA + ",\n"
				+ "\"made\": " + TwoPM + ",\n"
				+ "\"shootingPercentage\": " + TwoPProcentage + "\n"
				+ "},\n"
				+ "\"threePoints\": {\n"
				+ "\"attempts\": " + ThreePA + ",\n"
				+ "\"made\": " + ThreePM + ",\n"
				+ "\"shootingPercentage\": " + ThreePProcentage + "\n"
				+ "},\n"
				+ "\"points\": " + PTS + ",\n"
				+ "\"rebounds\": " + REB + ",\n"
				+ "\"blocks\": " + BLK + ",\n"
				+ "\"assists\": " + AST + ",\n"
				+ "\"steals\": " + STL + ",\n"
				+ "\"turnovers\": " + TOV + "\n"
				+ "},\n"
				+ "\"advanced\": {\n"
				+ "\"valorization\": " + VAL + ",\n"
				+ "\"effectiveFieldGoalPercentage\": " + EFGProcentage + ",\n"
				+ "\"trueShootingPercentage\": " + TSPRocentage + ",\n"
				+ "\"hollingerAssistRatio\": " + HASTProcentage + "\n"
				+ "}\n"
				+ "}";
	}
	
	
	
}

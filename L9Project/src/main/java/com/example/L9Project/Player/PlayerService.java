package com.example.L9Project.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {
	private ArrayList<Player> list;

	public PlayerService(ArrayList<Player> list) {
		super();
		this.list = list;
	}

	public PlayerService() {
		super();
		this.list = new ArrayList<Player>();
		loadPlayers();
		calculateAllPlayers();
	}
	
	public void addPlayer(Player player) {
		list.add(player);
	}
	public void loadPlayers() {
		String delimiter = ",";
	    try {
	         File file = new File("src/main/resources/L9HomeworkChallengePlayersInput.csv");
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] tempArr;
	         br.readLine();
	         while((line = br.readLine()) != null) {
	            tempArr = line.split(delimiter);
	            String[] tempName = tempArr[0].split(" ");
	            int indexIgraca = playerExists(tempName[0], tempName[1]);
	            String pos = tempArr[1];
	            float FTM = Float.parseFloat(tempArr[2]);
	            float FTA = Float.parseFloat(tempArr[3]);
	            float TwoPM = Float.parseFloat(tempArr[4]);
	            float TwoPA = Float.parseFloat(tempArr[5]);
	            float ThreePM = Float.parseFloat(tempArr[6]);
	            float ThreePA = Float.parseFloat(tempArr[7]);
	            float REB = Float.parseFloat(tempArr[8]);
	            float BLK = Float.parseFloat(tempArr[9]);
	            float AST = Float.parseFloat(tempArr[10]);
	            float STL = Float.parseFloat(tempArr[11]);
	            float TOV = Float.parseFloat(tempArr[12]);
	            if(indexIgraca!=-1) { 
	            	list.get(0).AddStats(FTM,FTA,TwoPM,TwoPA,
	            			ThreePM,ThreePA,REB,BLK,AST,STL,TOV);
	            }else {
	            	addPlayer(new Player(tempName[0],tempName[1],
	            			pos,FTM,FTA,TwoPM,TwoPA,ThreePM,ThreePA,
	            			REB,BLK,AST,STL,TOV));
	            }
	         }
	         br.close();
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
	}
	
	public int playerExists(String name, String lastName) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name) && list.get(i).getLastName().equals(lastName)) {
				return i;
			}
		}
		return -1;
	}
	
	public void calculateAllPlayers() {
		for(int i=0;i<list.size();i++) {
			list.get(i).calculatePlayer();
		}
	}
	@Autowired
	public Player returnPlayer(String fullName) {
		for(int i=0;i<list.size();i++) {
			String fName = list.get(i).getName() + list.get(i).getLastName();
			if(fName.equals(fullName)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	
}

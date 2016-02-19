package model;


public class Lair 
{
	private int numberOfMonsters;
	private String monsterType;
	
	public Lair()
	{
		this.numberOfMonsters = 2;
		this.monsterType = "Goblin";
	}
	
	public Lair(int numberOfMonsters, String monsterType)
	{
		
	}
	
	public String toString()
	{
		String entityDescription = "This lair has " + numberOfMonsters + " monster(s), and they are " + monsterType + "'s";
		
		return entityDescription;
	}

	public int getNumberOfMonsters() {
		return numberOfMonsters;
	}

	public void setNumberOfMonsters(int numberOfMonsters) {
		this.numberOfMonsters = numberOfMonsters;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
}

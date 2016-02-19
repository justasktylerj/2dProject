package controller;

import java.util.Scanner;
import model.Lair;
import view.Frame2d;
import view.Panel2d;

public class Controller2d 
{
	private Frame2d baseFrame;
	private Panel2d basePanel;
	private Lair [][] myLairs;
	
	public Controller2d(Panel2d basePanel)
	{
		myLairs= new Lair[4][4];
		setupArray();
		baseFrame = new Frame2d(this);
	}
	
	public void start()
	{
		
	}
	
	private void setupArray()
	{
		for(int row = 0; row < myLairs.length; row++)
		{
			for(int col = 0; col < myLairs[0].length; col++)
			{
				myLairs[row][col] = new Lair();
				if(col % 2 == 0)
				{
					myLairs[row][col].setNumberOfMonsters(col + 5);
				}
				else
				{
					myLairs[row][col].setMonsterType("goblin");
				}
			}
			
		}
	}
	
	public Lair [][] getMyLairs()
	{
		return myLairs;
	}

}

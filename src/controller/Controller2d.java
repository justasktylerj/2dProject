package controller;

import java.util.Scanner;

import view.Frame2d;
import view.Panel2d;

public class Controller2d 
{
	private Frame2d baseFrame;
	private Panel2d basePanel;
	public int row;
	public int col;
	public String[][] entity = null;
	
	public Controller2d(Panel2d basePanel)
	{
		baseFrame = new Frame2d(this);
	}
	
	public void start()
	{
		row = 0;
		col = 0;
		fillPattern1();
		setEntity(entity);
	}
	
	public void setEntity(String[][] entity)
	  {
	    this.entity = entity;
	  }
	
//	  public void print()
//	  {
//	    for (int row = 0; row < entity.length; row++)
//	    {
//	      for (int col = 0; col < entity[0].length; col++)
//	      {
//	        System.out.print( entity[row][col] + " " );
//	      }
//	      System.out.println();
//	    }
//	    System.out.println();
//	  }
	  
	  
	
	
	  public void fillPattern1()
	  {
	    String[][] entity = {
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	    		{ "", "", "", "", "", "", "", "" },
	   		};
	  }

}

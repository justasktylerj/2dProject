package model;

import java.util.Scanner;

public class Dice 
{
	private String[][] entity = null;
	public String creature;

	  
	  public void setEntity(String[][] entity)
	  {
	    this.entity = entity;
	  }
	
	  public void print()
	  {
	    for (int row = 0; row < entity.length; row++)
	    {
	      for (int col = 0; col < entity[0].length; col++)
	      {
	        System.out.print( entity[row][col] + " " );
	      }
	      System.out.println();
	    }
	    System.out.println();
	  }
	  
	  public void fillPattern1()
	  {
	    String[][] entity = {
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	    		{ "*", "*", "*", "*", "*", "*", "*", "*" },
	   		};
	  }
	
//	  public void setValue()
//	  {
//		  entity[row][col] = creature.nextString();
//	  }
//	  
//	  public String getValue()
//	  {
//		  return entity[row][col]; 
//	  }
}

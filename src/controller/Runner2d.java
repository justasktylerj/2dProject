package controller;

import view.Panel2d;
import controller.Controller2d;

public class Runner2d 
{
	public static void main (String [] args)
	{
		Controller2d myController = new Controller2d(null);
		myController.start();
	}
}

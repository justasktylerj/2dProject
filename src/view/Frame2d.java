package view;

import javax.swing.JFrame;
import controller.Controller2d;

public class Frame2d extends JFrame
{
	private Controller2d baseController;
	private Panel2d basePanel;
	
	public Frame2d(Controller2d baseController)
	{
		this.baseController = baseController;
		basePanel = new Panel2d(baseController);
		
		setupFrame();
	}
	

	private void setupFrame()
	{
		this.setContentPane(basePanel);  //installs the panel in the frame
		this.setSize(400,400);
		this.setTitle("Arrays!"); // find a good size for app
		this.setResizable(false); //can't change size of window
		this.setVisible(true);  //must be last line of setupFrame
	}
	
	public Controller2d getBaseController()
	{
		return baseController;
	}
}

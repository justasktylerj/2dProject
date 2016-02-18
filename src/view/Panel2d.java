package view;

import java.awt.Color;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Controller2d;

public class Panel2d extends JPanel
{
	private Controller2d baseController;
	private JButton submitButton;
	private JButton getButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JTextField nRow;
	private JTextArea entityArea;
	private JTextField nCol;
	private String line;
	
	public String userText;
	
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("set button");
		getButton = new JButton("get button");
		firstTextField = new JTextField("words can be type here", 20);
		entityArea = new JTextArea(10,30);
		typingField = new JTextField("asda");
		nRow = new JTextField("8");
		nCol = new JTextField("8");
		line = "";
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(firstTextField);
		this.add(nRow);
		this.add(nCol);
		this.add(entityArea);
		this.add(submitButton);
		this.add(getButton);
		typingField.setToolTipText("Type here for the chatbot");
		entityArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -25, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -2, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, entityArea, -103, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, entityArea, -40, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nRow, 0, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, nRow, 6, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, nCol, 0, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, nCol, 6, SpringLayout.EAST, nRow);
		baseLayout.putConstraint(SpringLayout.NORTH, getButton, 0, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, getButton, 6, SpringLayout.EAST, submitButton);
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int row = Integer.parseInt(nRow.getText());
				int col = Integer.parseInt(nRow.getText());
				String userText = firstTextField.getText(); 
				setValue();
				baseController.setEntity(baseController.entity);
				firstTextField.setText("");
				printOut();
			}
		});
		
		getButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int row = Integer.parseInt(nRow.getText());
				int col = Integer.parseInt(nRow.getText());
				getValue();
			}
		});
	
	}

	public void printOut()
	{
		for (int row = 0; row < baseController.entity.length; row++)
		    {
		      for (int col = 0; col < baseController.entity[0].length; col++)
		      {
		        line = line + ( baseController.entity[row][col] + " " );
		      }
		      entityArea.append(line);
		      line = "";
    	    }   
	}
	
	  public void setValue()
	  {
		  baseController.entity[baseController.row][baseController.col] = userText;
		  baseController.setEntity(baseController.entity);
	  }
	  
	  public String getValue()
	  {
		  return baseController.entity[baseController.row][baseController.col]; 
	  }
}

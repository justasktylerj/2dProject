package view;

import java.awt.Color;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Controller2d;

public class Panel2d extends JPanel
{
	private Controller2d baseController;
	private JButton submitButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JTextField nRow;
	private JTextArea entityArea;
	private JTextField nCol;
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("click the button");
		firstTextField = new JTextField("words can be type here", 20);
		entityArea = new JTextArea(10,30);
		typingField = new JTextField("asda");
		nRow = new JTextField("8");
		nCol = new JTextField("8");
		
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
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int row = nRow.getText();
				
				String userText = firstTextField.getText(); 
				firstTextField.setText("");
//				entityArea.append(String[][] entity); 
			}
		});
	}
	
}

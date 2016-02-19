package view;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import controller.Controller2d;

public class Panel2d extends JPanel
{
	private Controller2d baseController;
	private SpringLayout baseLayout;
	private JTextField nRow;
	private JTextField nCol;
	private JTextField editField;
	private JLabel currentLair;
	private JButton changeButton;
	private JButton displayButton;
	private JTable lairTable;
	
	
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		changeButton = new JButton("change the indicated lair");
		displayButton = new JButton("display the indicated lair");
		editField = new JTextField(20);

		nRow = new JTextField(5);
		nCol = new JTextField(5);
		currentLair = new JLabel("the current lair");
		
		setupTable();
		setupPanel();
		setupLayout();
		setupListeners();
	}
/**
 * Helper method to load information from the mel into the GUI as a 2d array
 */
	private void setupTable()
	{
		String [] columnHeaders = {"Column 0", "Column 1", "Column 2", "Column 3"};
		DefaultTableModel tableModel = new DefaultTableModel(baseController.getMyLairs(), columnHeaders);
		lairTable = new JTable(tableModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(editField);
		this.add(nRow);
		this.add(nCol);
		this.add(lairTable);
		this.add(changeButton);
		this.add(displayButton);
		this.add(currentLair);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, changeButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, changeButton, 0, SpringLayout.NORTH, displayButton);
		baseLayout.putConstraint(SpringLayout.WEST, displayButton, 0, SpringLayout.WEST, editField);
		baseLayout.putConstraint(SpringLayout.SOUTH, displayButton, -6, SpringLayout.NORTH, editField);
		baseLayout.putConstraint(SpringLayout.SOUTH, editField, -12, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, editField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nRow, 0, SpringLayout.NORTH, editField);
		baseLayout.putConstraint(SpringLayout.WEST, nRow, 12, SpringLayout.EAST, editField);
		baseLayout.putConstraint(SpringLayout.NORTH, nCol, 0, SpringLayout.NORTH, editField);
		baseLayout.putConstraint(SpringLayout.WEST, nCol, 6, SpringLayout.EAST, nRow);
		baseLayout.putConstraint(SpringLayout.NORTH, currentLair, 6, SpringLayout.SOUTH, lairTable);
		baseLayout.putConstraint(SpringLayout.EAST, currentLair, -10, SpringLayout.EAST, lairTable);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		displayButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
	
	}
	
}

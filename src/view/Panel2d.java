package view;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Lair;
import controller.Controller2d;

public class Panel2d extends JPanel
{
	private Controller2d baseController;
	private SpringLayout baseLayout;
	private JTextField nRow;
	private JTextField nCol;
	private JTextField editFieldNumber;
	private JTextField editFieldType;
	private JLabel currentLair;
	private JLabel thisLair;
	private JLabel hasLair;
	private JLabel endLair;
	private JButton changeButton;
	private JButton displayButton;
	private JTable lairTable;
	private int rowGet;
	private int colGet;
	public String newType;
	public int newNumber;
//	public Lair newLair;
	
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		changeButton = new JButton("change the indicated lair");
		displayButton = new JButton("display the indicated lair");
		editFieldType = new JTextField(5);
		editFieldNumber = new JTextField(5);
		nRow = new JTextField(5);
		nCol = new JTextField(5);	
		currentLair = new JLabel("the current lair");
		thisLair = new JLabel("This lair has ");
		hasLair = new JLabel(" monster(s), and they are ");
		endLair = new JLabel("'s.");
		rowGet = 0;
		colGet = 0;
		newType = "";
		newNumber = 0;
		
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
		baseLayout.putConstraint(SpringLayout.NORTH, lairTable, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lairTable, -259, SpringLayout.NORTH, changeButton);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(editFieldType);
		this.add(editFieldNumber);
		this.add(nRow);
		this.add(nCol);
		this.add(lairTable);
		this.add(changeButton);
		this.add(displayButton);
		this.add(currentLair);
		this.add(thisLair);
		this.add(hasLair);
		this.add(endLair);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, lairTable, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, lairTable, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, changeButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, displayButton, 0, SpringLayout.NORTH, changeButton);
		baseLayout.putConstraint(SpringLayout.WEST, displayButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nCol, 4, SpringLayout.SOUTH, editFieldNumber);
		baseLayout.putConstraint(SpringLayout.NORTH, nRow, 0, SpringLayout.NORTH, nCol);
		baseLayout.putConstraint(SpringLayout.EAST, nRow, -25, SpringLayout.WEST, nCol);
		baseLayout.putConstraint(SpringLayout.EAST, nCol, -10, SpringLayout.EAST, editFieldNumber);
		baseLayout.putConstraint(SpringLayout.WEST, thisLair, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, thisLair, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, editFieldType, -6, SpringLayout.NORTH, thisLair);
		baseLayout.putConstraint(SpringLayout.WEST, editFieldType, 6, SpringLayout.EAST, thisLair);
		baseLayout.putConstraint(SpringLayout.NORTH, endLair, 6, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.WEST, endLair, 2, SpringLayout.EAST, editFieldNumber);
		baseLayout.putConstraint(SpringLayout.NORTH, changeButton, 187, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, editFieldNumber, 0, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.NORTH, currentLair, 10, SpringLayout.SOUTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.WEST, currentLair, 30, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, editFieldNumber, 3, SpringLayout.EAST, hasLair);
		baseLayout.putConstraint(SpringLayout.NORTH, hasLair, 6, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.WEST, hasLair, 6, SpringLayout.EAST, editFieldType);
		
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				rowGet = Integer.parseInt(nRow.getText());
				colGet = Integer.parseInt(nCol.getText());
//				newType = editFieldType(getText); 
//				baseController.myLairs[rowGet][colGet] = ;
			}
		});
		
		displayButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				rowGet = Integer.parseInt(nRow.getText());
				colGet = Integer.parseInt(nCol.getText());
				newType = baseController.myLairs[rowGet][colGet].getMonsterType();
				editFieldType.setText(newType);
				newNumber = baseController.myLairs[rowGet][colGet].getNumberOfMonsters();
				editFieldNumber.setText(newNumber);
				
				
			}
		});
	
	}
	
}

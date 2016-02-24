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
	private String newNumberString;
	public Lair newLair;
	public int changeNumber;
	public String changeType;
	
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		changeButton = new JButton("change the indicated lair");		
		displayButton = new JButton("display the indicated lair");
		editFieldType = new JTextField(5);
		editFieldNumber = new JTextField(3);		
		nRow = new JTextField(5);
		nCol = new JTextField(5);
		currentLair = new JLabel("Current Lair:  ,  ");
		thisLair = new JLabel("This lair has ");				
		hasLair = new JLabel(" monster(s), and they are ");		
		endLair = new JLabel("'s.");			
		rowGet = 0;
		colGet = 0;
		newType = "";
		newNumber = 0;
		newNumberString = "";
		changeNumber = 0;
		changeType = "";
		
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
		baseLayout.putConstraint(SpringLayout.WEST, lairTable, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, lairTable, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lairTable, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, lairTable, -10, SpringLayout.EAST, this);
		//Table
		baseLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, displayButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, displayButton, -6, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.NORTH, editFieldType, 0, SpringLayout.NORTH, editFieldNumber);
		baseLayout.putConstraint(SpringLayout.SOUTH, nRow, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, nRow, -179, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nCol, 0, SpringLayout.NORTH, nRow);
		baseLayout.putConstraint(SpringLayout.WEST, nCol, 26, SpringLayout.EAST, nRow);
		baseLayout.putConstraint(SpringLayout.NORTH, currentLair, 6, SpringLayout.NORTH, nRow);
		baseLayout.putConstraint(SpringLayout.WEST, currentLair, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, editFieldType, 1, SpringLayout.EAST, hasLair);
		baseLayout.putConstraint(SpringLayout.EAST, editFieldNumber, -6, SpringLayout.WEST, hasLair);
		baseLayout.putConstraint(SpringLayout.NORTH, endLair, 6, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.WEST, endLair, 6, SpringLayout.EAST, editFieldType);
		baseLayout.putConstraint(SpringLayout.SOUTH, changeButton, -78, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, editFieldNumber, 6, SpringLayout.SOUTH, changeButton);
		baseLayout.putConstraint(SpringLayout.NORTH, thisLair, 6, SpringLayout.NORTH, editFieldType);
		baseLayout.putConstraint(SpringLayout.EAST, thisLair, -6, SpringLayout.WEST, editFieldNumber);
		baseLayout.putConstraint(SpringLayout.WEST, hasLair, 171, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, hasLair, -12, SpringLayout.NORTH, nRow);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				rowGet = Integer.parseInt(nRow.getText());
				colGet = Integer.parseInt(nCol.getText());
				changeNumber = Integer.parseInt(editFieldNumber.getText());
				baseController.myLairs[rowGet][colGet].setNumberOfMonsters(changeNumber);
				changeType = editFieldType.getText();
				baseController.myLairs[rowGet][colGet].setMonsterType(changeType);
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
				newNumberString = Integer.toString(newNumber);
				editFieldNumber.setText(newNumberString);
				currentLair.setText("Current Lair: " + rowGet + ", " + colGet);
				
			}
		});
	
	}
	
}

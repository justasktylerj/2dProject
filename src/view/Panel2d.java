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
	private JLabel promptLabel;
	private JTextArea chatArea;
	private JCheckBox check;
	
	public Panel2d(Controller2d baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("click the button");
		firstTextField = new JTextField("words can be type here", 20);
		chatArea = new JTextArea(10,30);
		promptLabel = new JLabel("Chat with me");
		typingField = new JTextField("asda");
		check = new JCheckBox("Orange", false);
		
		setupPanel();
//		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(firstTextField);
		this.add(chatArea);
		this.add(submitButton);
		this.add(check);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot");
		chatArea.setEnabled(false);
		
		
	}
	
	private void setupListeners()
	{
	
	}
	
}

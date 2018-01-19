
/*
 * Created on Eiar 5767
 * update Tamuz 5771
 * @author levian
 * for Student
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Demo2DForStu
{
 	public static void main(String[] args) 
	{
		JFrame myFrame=new JFrame("Demo2DStu תשע''ב");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel2DForStu mainPanel=new MainPanel2DForStu();
		JToolBar jTB=new BuildUI2DForStu(mainPanel,"Option");
		myFrame.add(jTB,BorderLayout.PAGE_START);
		myFrame.add(mainPanel,BorderLayout.CENTER);
		myFrame.pack();
		myFrame.setSize(700,700);
		myFrame.setLocation(150,20);
		myFrame.setVisible(true);
	}
}

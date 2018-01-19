/*
 * Created on Eiar 5767
 * update on Tamuz 5769
 * @author levian
 * for Student
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JToolBar;



public class Demo3DForStu
{
	
 	public static void main(String[] args) 
	{
		JFrame myFrame=new JFrame("Project3D for Student");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MainPanel3DForStu mainPanel=new MainPanel3DForStu();
		JToolBar jTB=new BiuldAndShowGUIStu(mainPanel,"Option");
	    mainPanel.setOpaque(true);
	    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
	    mainPanel.setPreferredSize(new Dimension(d.width,d.height));
		myFrame.add(jTB,BorderLayout.PAGE_START);
		myFrame.add(mainPanel,BorderLayout.CENTER);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}

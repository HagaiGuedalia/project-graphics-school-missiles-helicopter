import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MiniMainPanel extends JPanel
{
	Matrix3DForStu mabat=new Matrix3DForStu();
	Matrix3DForStu mati=new Matrix3DForStu();
	Hellicopter matos;
	ArrayList<Missile> tList=new ArrayList<>();
    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
	MainPanel3DForStu mP;
	AffineTransform aT;
   	int i=5;
   	int j=0;

	public MiniMainPanel(MainPanel3DForStu mP)
	{

		super();
		this.mP=mP;
		//System.out.print(d.height);      // at school  -  width 1280    height 960
		setBounds(d.width-310, 0, 300, 300);
		//setBounds(950, 0, 300, 300);
	   	setBackground(Color.WHITE);
	   	aT=new AffineTransform();
       	setOpaque(false);
	   	aT.scale(0.5,0.5);
	//   	aT.translate(7825, 400);
	// 	aT.translate(4950,700);
	// 	aT.translate(d.width*(249/64),700);
	
	//	aT.translate(2550,-0);
		aT.translate(d.width/0.8, d.height/19.2);
	//   	aT.translate(1600,-0);
	   	
	  // 	aT.translate(d.width+5905, 400);
	   	

	}


	public void paintComponent(Graphics page)	
	{

//
		super.paintComponent(page);
		Graphics2D g2d=(Graphics2D)page;
		g2d.drawArc(5+(10*i), 5+(10*i), 290-(2*10*i), 290-(2*10*i), 0, 360);
		j++;
		if(j==2)
		{
			i=(i+5-1)%5 ;
			j=0;
		}
		g2d.setTransform(aT);
		mP.mabatHellicopter.mullMat();
		mP.mabatHellicopter.fromPointToGuf();
		mP.mabatHellicopter.convertAndShow(g2d);
		
		synchronized (mP.object) 
		{
			for (Missile miss : mP.mabatMissileList) {
				if(miss.exists){
					miss.mullMat();
					miss.fromPointToGuf();
					miss.convertAndShow(g2d);
				}
			}
		}

//		for (Comparable trapez : mP.trapezimmabatFormmP) 
//		{
//			if (trapez instanceof Trapez) 
//			{
//				
//				((Trapez) trapez).fromPointToGuf();
//				((Trapez) trapez).convertAndShow(g2d);
//			}
//			if (trapez instanceof Matos) 
//			{
//				((Matos) trapez).frompointguf();
//				((Matos) trapez).convertAndShow(g2d);
//			}
//		}
	
	}
	



}




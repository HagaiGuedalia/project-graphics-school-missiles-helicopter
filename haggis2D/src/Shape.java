import java.awt.Color;
import java.awt.Graphics;


public class Shape {
	double xReal[];//={10,10,30,100,150};
	double yReal[];//={20,100,130,120,20};
	int numOfPoints = 15;
	int xInt[]=new int[numOfPoints];
	int yInt[]=new int[numOfPoints];
	
	public Shape(){
		xReal=new double[numOfPoints];
		yReal=new double[numOfPoints];
		xInt=new int[numOfPoints];
		yInt=new int[numOfPoints];
	}
	
	public void convert()
	{
		for(int i=0;i<numOfPoints;i++)
		{
			xInt[i]=(int)xReal[i];
			yInt[i]=(int)yReal[i];
		}
	}

	public void buildShape(double x, double y){
//		xReal[0]=x; 		yReal[0]=y+10;		
//		xReal[1]=x+10; 		yReal[1]=y+10;		
//		xReal[2]=x+20;		yReal[2]=y+50;
		
		xReal[0]=x+70;      yReal[0]=y+50;
		xReal[1]=x+170;		yReal[1]=y+50;		
		xReal[2]=x+190;		yReal[2]=y+60;		
		xReal[3]=x+200; 	yReal[3]=y+80;		
		xReal[4]=x+210; 	yReal[4]=y+90;		
		xReal[5]=x+180;		yReal[5]=y+100;		
		xReal[6]=x+100;		yReal[6]=y+100;		
		xReal[7]=x+70;		yReal[7]=y+70;
		
//		xReal[10]=x+20; 	yReal[10]=y+60;		
//		xReal[11]=x+10; 	yReal[11]=y+80;		
//		xReal[12]=x;		yReal[12]=y+80;		
//		xReal[13]=x+10;		yReal[13]=y+50;		
//		xReal[14]=x;		yReal[14]=y+30;		

	}
	public void convertAndShow (Graphics page)
	{
		convert();
	   	page.setColor(Color.RED);
	    page.drawPolygon(xInt,yInt,8);
		page.setColor(Color.BLUE);
	    page.fillPolygon(xInt,yInt,8);
	}
	
	
	public void mullMat(Matrix2DForStu mat){
		mat.mullAllPoints(xReal,yReal,numOfPoints);
	}
	
	





}

import java.awt.Color;
import java.awt.Graphics;


public class CopyOfShape {
	double xReal[];//={10,10,30,100,150};
	double yReal[];//={20,100,130,120,20};
	int numOfPoints = 5;
	int xInt[]=new int[numOfPoints];
	int yInt[]=new int[numOfPoints];
	
	public CopyOfShape(){
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
		xReal[0]=x; 		yReal[0]=y;
		xReal[1]=x;			yReal[1]=y+80;
		xReal[2]=x+20;		yReal[2]=y+110;
		xReal[3]=x+90;		yReal[3]=y+100;
		xReal[4]=x+140; 	yReal[4]=y;

	}
	public void convertAndShow (Graphics page)
	{
		convert();
	   	page.setColor(Color.RED);
	    page.drawPolygon(xInt,yInt,5);
		page.setColor(Color.BLUE);
	    page.fillPolygon(xInt,yInt,5);
	}
	
	
	public void mullMat(Matrix2DForStu mat){
		mat.mullAllPoints(xReal,yReal,numOfPoints);
	}
	
	





}

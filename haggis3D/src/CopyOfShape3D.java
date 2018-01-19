import java.awt.Color;
import java.awt.Graphics;


public class CopyOfShape3D {
	double xReal[];//={10,10,30,100,150};
	double yReal[];//={20,100,130,120,20};
	double zReal[];
	
	double xGuf[][];
	double yGuf[][];
	double zGuf[][];
	
	int numOfPoints = 5;
	int mish = numOfPoints+2;
	int xInt[];
	int yInt[];
	
	public CopyOfShape3D(){
		xReal=new double[numOfPoints*2];
		yReal=new double[numOfPoints*2];
		zReal=new double[numOfPoints*2];
		
		xGuf=new double[mish][numOfPoints];
		yGuf=new double[mish][numOfPoints];
		zGuf=new double[mish][numOfPoints];
		
		xInt=new int[numOfPoints];
		yInt=new int[numOfPoints];
	}
	

	public void buildShape(double x, double y, double z, double dz){
		xReal[0]=x; 		yReal[0]=y;			zReal[0]=z;
		xReal[1]=x+140; 	yReal[1]=y;			zReal[1]=z;
		xReal[2]=x+90;		yReal[2]=y+100;		zReal[2]=z;
		xReal[3]=x+20;		yReal[3]=y+110;		zReal[3]=z;
		xReal[4]=x;			yReal[4]=y+80;		zReal[4]=z;
		
		
		xReal[5]=x; 		yReal[5]=y;			zReal[5]=z+dz;
		xReal[6]=x+140; 	yReal[6]=y;			zReal[6]=z+dz;
		xReal[7]=x+90;		yReal[7]=y+100;		zReal[7]=z+dz;
		xReal[8]=x+20;		yReal[8]=y+110;		zReal[8]=z+dz;
		xReal[9]=x;			yReal[9]=y+80;		zReal[9]=z+dz;

	}
	
	public void fromPointToGuf(){
		xGuf[0][0]=xReal[0];	yGuf[0][0]=yReal[0];	zGuf[0][0]=zReal[0];
		xGuf[0][1]=xReal[1];	yGuf[0][1]=yReal[1];	zGuf[0][1]=zReal[1];
		xGuf[0][2]=xReal[2];	yGuf[0][2]=yReal[2];	zGuf[0][2]=zReal[2];
		xGuf[0][3]=xReal[3];	yGuf[0][3]=yReal[3];	zGuf[0][3]=zReal[3];
		xGuf[0][4]=xReal[4];	yGuf[0][4]=yReal[4];	zGuf[0][4]=zReal[4];
		
		xGuf[1][0]=xReal[9];	yGuf[1][0]=yReal[9];	zGuf[1][0]=zReal[9];
		xGuf[1][1]=xReal[8];	yGuf[1][1]=yReal[8];	zGuf[1][1]=zReal[8];
		xGuf[1][2]=xReal[7];	yGuf[1][2]=yReal[7];	zGuf[1][2]=zReal[7];
		xGuf[1][3]=xReal[6];	yGuf[1][3]=yReal[6];	zGuf[1][3]=zReal[6];
		xGuf[1][4]=xReal[5];	yGuf[1][4]=yReal[5];	zGuf[1][4]=zReal[5];
		
		xGuf[2][0]=xReal[0];	yGuf[2][0]=yReal[0];	zGuf[2][0]=zReal[0];
		xGuf[2][1]=xReal[5];	yGuf[2][1]=yReal[5];	zGuf[2][1]=zReal[5];
		xGuf[2][2]=xReal[6];	yGuf[2][2]=yReal[6];	zGuf[2][2]=zReal[6];
		xGuf[2][3]=xReal[1];	yGuf[2][3]=yReal[1];	zGuf[2][3]=zReal[1];
		
		xGuf[3][0]=xReal[1];	yGuf[3][0]=yReal[1];	zGuf[3][0]=zReal[1];
		xGuf[3][1]=xReal[6];	yGuf[3][1]=yReal[6];	zGuf[3][1]=zReal[6];
		xGuf[3][2]=xReal[7];	yGuf[3][2]=yReal[7];	zGuf[3][2]=zReal[7];
		xGuf[3][3]=xReal[2];	yGuf[3][3]=yReal[2];	zGuf[3][3]=zReal[2];
		
		xGuf[4][0]=xReal[2];	yGuf[4][0]=yReal[2];	zGuf[4][0]=zReal[2];
		xGuf[4][1]=xReal[7];	yGuf[4][1]=yReal[7];	zGuf[4][1]=zReal[7];
		xGuf[4][2]=xReal[8];	yGuf[4][2]=yReal[8];	zGuf[4][2]=zReal[8];
		xGuf[4][3]=xReal[3];	yGuf[4][3]=yReal[3];	zGuf[4][3]=zReal[3];
		
		xGuf[5][0]=xReal[3];	yGuf[5][0]=yReal[3];	zGuf[5][0]=zReal[3];
		xGuf[5][1]=xReal[8];	yGuf[5][1]=yReal[8];	zGuf[5][1]=zReal[8];
		xGuf[5][2]=xReal[9];	yGuf[5][2]=yReal[9];	zGuf[5][2]=zReal[9];
		xGuf[5][3]=xReal[4];	yGuf[5][3]=yReal[4];	zGuf[5][3]=zReal[4];
		
		xGuf[6][0]=xReal[4];	yGuf[6][0]=yReal[4];	zGuf[6][0]=zReal[4];
		xGuf[6][1]=xReal[9];	yGuf[6][1]=yReal[9];	zGuf[6][1]=zReal[9];
		xGuf[6][2]=xReal[5];	yGuf[6][2]=yReal[5];	zGuf[6][2]=zReal[5];
		xGuf[6][3]=xReal[0];	yGuf[6][3]=yReal[0];	zGuf[6][3]=zReal[0];
	}
	
	public boolean check(int x1, int y1, int x2, int y2, int x3, int y3){
		return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2) > 0;
	}
	
	
	public void convert(double[] xr,  double[] yr, int size)
	{
		for(int i=0;i<size;i++)
		{
			xInt[i]=(int)xr[i];
			yInt[i]=(int)yr[i];
		}
	}
	public void convertAndShow (Graphics page)
	{
		for (int i = 0; i < 2; i++) 
		{
			convert(xGuf[i], yGuf[i], numOfPoints);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(Color.BLUE);
				page.fillPolygon(xInt, yInt, numOfPoints);
				page.setColor(Color.BLACK);
				page.drawPolygon(xInt, yInt, numOfPoints);
			}
		}
		
		for (int i = 2; i < mish; i++) 
		{
				convert(xGuf[i], yGuf[i], 4);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(Color.RED);
				page.fillPolygon(xInt,yInt,4);
				page.setColor(Color.BLACK);
				page.drawPolygon(xInt,yInt,4);
			}
			
		}
	}
	
	
	
	public void mullMat(Matrix3DForStu mat){
		mat.mullAllPoints(xReal,yReal,zReal, numOfPoints*2);
	}
	
	





}

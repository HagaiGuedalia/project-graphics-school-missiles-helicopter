import java.awt.Color;
import java.awt.Graphics;


public class Shape3D {
	double xReal[];
	double yReal[];
	double zReal[];
	
	double xGuf[][];
	double yGuf[][];
	double zGuf[][];
	
	int numOfPoints = 4;
	int mish = numOfPoints*2+1;
	int xInt[];
	int yInt[];
	private Point3D magoz;
	
	public Shape3D(Point3D magoz)
	{
		this.magoz=magoz;
		xReal=new double[numOfPoints*2+1];
		yReal=new double[numOfPoints*2+1];
		zReal=new double[numOfPoints*2+1];
		
		xGuf=new double[mish][numOfPoints];
		yGuf=new double[mish][numOfPoints];
		zGuf=new double[mish][numOfPoints];
		
		xInt=new int[numOfPoints];
		yInt=new int[numOfPoints];
	}
	

	public void buildShape(double x, double y, double z, double dz)
	{
		xReal[0]=x; 		yReal[0]=y;			zReal[0]=z;
		xReal[1]=x+dz; 		yReal[1]=y;			zReal[1]=z;
		xReal[2]=x+dz;		yReal[2]=y+dz;		zReal[2]=z;
		xReal[3]=x;			yReal[3]=y+dz;		zReal[3]=z;
		
		
		xReal[4]=x; 		yReal[4]=y;			zReal[4]=z+dz;
		xReal[5]=x+dz; 		yReal[5]=y;			zReal[5]=z+dz;
		xReal[6]=x+dz;		yReal[6]=y+dz;		zReal[6]=z+dz;
		xReal[7]=x;			yReal[7]=y+dz;		zReal[7]=z+dz;
		
		xReal[8]=x+dz/2;	yReal[8]=y+dz+dz/2;		zReal[8]=z+(dz/2);
		//xReal[8]=x+dz+dz/2;	yReal[8]=y+dz/2;	zReal[8]=z+(dz/2);
	}
	
	public void fromPointToGuf(){
		//front square
		xGuf[0][0]=xReal[0];	yGuf[0][0]=yReal[0];	zGuf[0][0]=zReal[0];
		xGuf[0][1]=xReal[1];	yGuf[0][1]=yReal[1];	zGuf[0][1]=zReal[1];
		xGuf[0][2]=xReal[2];	yGuf[0][2]=yReal[2];	zGuf[0][2]=zReal[2];
		xGuf[0][3]=xReal[3];	yGuf[0][3]=yReal[3];	zGuf[0][3]=zReal[3];
		
		//back square               build counter clockwise
		xGuf[1][0]=xReal[7];	yGuf[1][0]=yReal[7];	zGuf[1][0]=zReal[7];
		xGuf[1][1]=xReal[6];	yGuf[1][1]=yReal[6];	zGuf[1][1]=zReal[6];
		xGuf[1][2]=xReal[5];	yGuf[1][2]=yReal[5];	zGuf[1][2]=zReal[5];
		xGuf[1][3]=xReal[4];	yGuf[1][3]=yReal[4];	zGuf[1][3]=zReal[4];
		
		//top square
		xGuf[2][0]=xReal[0];	yGuf[2][0]=yReal[0];	zGuf[2][0]=zReal[0];
		xGuf[2][1]=xReal[4];	yGuf[2][1]=yReal[4];	zGuf[2][1]=zReal[4];
		xGuf[2][2]=xReal[5];	yGuf[2][2]=yReal[5];	zGuf[2][2]=zReal[5];
		xGuf[2][3]=xReal[1];	yGuf[2][3]=yReal[1];	zGuf[2][3]=zReal[1];
		
		//right square
		xGuf[3][0]=xReal[1];	yGuf[3][0]=yReal[1];	zGuf[3][0]=zReal[1];
		xGuf[3][1]=xReal[5];	yGuf[3][1]=yReal[5];	zGuf[3][1]=zReal[5];
		xGuf[3][2]=xReal[6];	yGuf[3][2]=yReal[6];	zGuf[3][2]=zReal[6];
		xGuf[3][3]=xReal[2];	yGuf[3][3]=yReal[2];	zGuf[3][3]=zReal[2];
		
		//left square
		xGuf[4][0]=xReal[3];	yGuf[4][0]=yReal[3];	zGuf[4][0]=zReal[3];
		xGuf[4][1]=xReal[7];	yGuf[4][1]=yReal[7];	zGuf[4][1]=zReal[7];
		xGuf[4][2]=xReal[4];	yGuf[4][2]=yReal[4];	zGuf[4][2]=zReal[4];
		xGuf[4][3]=xReal[0];	yGuf[4][3]=yReal[0];	zGuf[4][3]=zReal[0];
		
		//front tri
		xGuf[5][0]=xReal[3];	yGuf[5][0]=yReal[3];	zGuf[5][0]=zReal[3];
		xGuf[5][1]=xReal[2];	yGuf[5][1]=yReal[2];	zGuf[5][1]=zReal[2];
		xGuf[5][2]=xReal[8];	yGuf[5][2]=yReal[8];	zGuf[5][2]=zReal[8];
		
		//right tri
		xGuf[6][0]=xReal[2];	yGuf[6][0]=yReal[2];	zGuf[6][0]=zReal[2];
		xGuf[6][1]=xReal[6];	yGuf[6][1]=yReal[6];	zGuf[6][1]=zReal[6];
		xGuf[6][2]=xReal[8];	yGuf[6][2]=yReal[8];	zGuf[6][2]=zReal[8];
		
		//back tri                  build counter clockwise
		xGuf[7][0]=xReal[6];	yGuf[7][0]=yReal[6];	zGuf[7][0]=zReal[6];
		xGuf[7][1]=xReal[7];	yGuf[7][1]=yReal[7];	zGuf[7][1]=zReal[7];
		xGuf[7][2]=xReal[8];	yGuf[7][2]=yReal[8];	zGuf[7][2]=zReal[8];
		
		//left tri
		xGuf[8][0]=xReal[7];	yGuf[8][0]=yReal[7];	zGuf[8][0]=zReal[7];
		xGuf[8][1]=xReal[3];	yGuf[8][1]=yReal[3];	zGuf[8][1]=zReal[3];
		xGuf[8][2]=xReal[8];	yGuf[8][2]=yReal[8];	zGuf[8][2]=zReal[8];
		
	}
	
	public boolean check(int x1, int y1, int x2, int y2, int x3, int y3){
		return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2) > 0;
	}
	
	
	public void convert(double[] xr,  double[] yr,double[] zr, int size)
	{
		for(int i=0;i<size;i++)
		{
			xInt[i]=(int)(xr[i]*(magoz.z/(magoz.z+zr[i]))+magoz.x);
			yInt[i]=(int)(yr[i]*(magoz.z/(magoz.z+zr[i]))+magoz.y);
		}
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
		for (int i = 0; i < 5; i++) 
		{
			convert(xGuf[i], yGuf[i],zGuf[i], 4);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(Color.BLUE);
				page.fillPolygon(xInt, yInt, 4);
				page.setColor(Color.BLACK);
				page.drawPolygon(xInt, yInt, 4);
			}
		}
		
		for (int i = 5; i < 9; i++) 
		{
				convert(xGuf[i], yGuf[i], zGuf[i], 3);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(Color.RED);
				page.fillPolygon(xInt,yInt,3);
				page.setColor(Color.BLACK);
				page.drawPolygon(xInt,yInt,3);
			}
			
		}
	}
	
	
	
	public void mullMat(Matrix3DForStu mat){
		mat.mullAllPoints(xReal,yReal,zReal, numOfPoints*2+1);
	}
	
	





}

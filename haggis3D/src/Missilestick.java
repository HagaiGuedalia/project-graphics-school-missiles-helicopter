import java.awt.Color;
import java.awt.Graphics;


public class Missilestick {
	double xReal[];//={10,10,30,100,150};
	double yReal[];//={20,100,130,120,20};
	double zReal[];
	
	double xGuf[][];
	double yGuf[][];
	double zGuf[][];
	
	int numOfPoints = 4;
	int mish = numOfPoints+2;
	int xInt[];
	int yInt[];
	private Point3D magoz;
	
	public Missilestick(Point3D magoz){
		this.magoz=magoz;
		xReal=new double[numOfPoints*2];
		yReal=new double[numOfPoints*2];
		zReal=new double[numOfPoints*2];
		
		xGuf=new double[mish][numOfPoints];
		yGuf=new double[mish][numOfPoints];
		zGuf=new double[mish][numOfPoints];
		
		xInt=new int[numOfPoints];
		yInt=new int[numOfPoints];
	}
	

	public void buildShape(double x, double y, double z, double dz)
	{
		xReal[0]=x; 			yReal[0]=y;					zReal[0]=z;
		xReal[1]=x+dz*0.4;		yReal[1]=y;					zReal[1]=z;
		xReal[2]=x+dz;			yReal[2]=y+dz*0.6;			zReal[2]=z;
		xReal[3]=x+dz*0.4;		yReal[3]=y+dz*0.6;			zReal[3]=z;
		
		xReal[4]=x; 			yReal[4]=y;					zReal[4]=z+dz*0.1;
		xReal[5]=x+dz*0.4;		yReal[5]=y;					zReal[5]=z+dz*0.1;
		xReal[6]=x+dz;			yReal[6]=y+dz*0.6;			zReal[6]=z+dz*0.1;
		xReal[7]=x+dz*0.4;		yReal[7]=y+dz*0.6;			zReal[7]=z+dz*0.1;

	}
	
	public void copy(Missilestick other){
		for (int j = 0; j < xReal.length; j++) {
			xReal[j]=other.xReal[j];
			yReal[j]=other.yReal[j];
			zReal[j]=other.zReal[j];	
		}
	}
	
	public void fromPointToGuf(){
				
		for (int i = 0; i < numOfPoints; i++)
		{
			xGuf[0][i] = xReal[i];	yGuf[0][i] = yReal[i];	zGuf[0][i] = zReal[i];
			xGuf[1][i] = xReal[numOfPoints*2-1-i];	yGuf[1][i] = yReal[numOfPoints*2-1-i];	zGuf[1][i] = zReal[numOfPoints*2-1-i];
		}
		
		for (int i = 2; i < numOfPoints+1; i++) {
			xGuf[i][0] = xReal[i-2];				yGuf[i][0] = yReal[i-2];				zGuf[i][0] = zReal[i-2];
			xGuf[i][1] = xReal[i-2+numOfPoints];	yGuf[i][1] = yReal[i-2+numOfPoints];	zGuf[i][1] = zReal[i-2+numOfPoints];
			xGuf[i][2] = xReal[i-2+numOfPoints+1];	yGuf[i][2] = yReal[i-2+numOfPoints+1];	zGuf[i][2] = zReal[i-2+numOfPoints+1];
			xGuf[i][3] = xReal[i-2+1];				yGuf[i][3] = yReal[i-2+1];				zGuf[i][3] = zReal[i-2+1];
		}
		
		xGuf[mish-1][0] = xReal[numOfPoints-1];				yGuf[mish-1][0] = yReal[numOfPoints-1];				zGuf[mish-1][0] = zReal[numOfPoints-1];
		xGuf[mish-1][1] = xReal[numOfPoints*2-1];			yGuf[mish-1][1] = yReal[numOfPoints*2-1];			zGuf[mish-1][1] = zReal[numOfPoints*2-1];
		xGuf[mish-1][2] = xReal[numOfPoints];				yGuf[mish-1][2] = yReal[numOfPoints];				zGuf[mish-1][2] = zReal[numOfPoints];
		xGuf[mish-1][3] = xReal[0];							yGuf[mish-1][3] = yReal[0];							zGuf[mish-1][3] = zReal[0];
		
	
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
	Color color;
	public void color(Color color){
		this.color=color; 
	}

	
	
	public void convertAndShow (Graphics page)
	{
		for (int i = 0; i < 2; i++) 
		{
			convert(xGuf[i], yGuf[i], zGuf[i], numOfPoints);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(color);
				page.fillPolygon(xInt, yInt, numOfPoints);
				page.setColor(color);
				page.drawPolygon(xInt, yInt, numOfPoints);
			}
		}
		
		for (int i = 2; i < mish; i++) 
		{
				convert(xGuf[i], yGuf[i],zGuf[i], 4);
			if (check(xInt[0], yInt[0], xInt[1], yInt[1], xInt[2], yInt[2])) 
			{
				page.setColor(Color.GRAY);
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

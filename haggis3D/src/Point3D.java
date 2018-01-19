/*
 * Created on 17/12/2006
 */

/**
 * @author לויאן
 */
public class Point3D 
{
	@Override
	public String toString() 
	{
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	double x,y,z;
	
	public Point3D()
	{
		x=y=z=0;
	}
	public Point3D(double aX,double aY,double aZ)
	{
		x= aX;
		y= aY;
		z= aZ;
	}
	public void setXYZ(double aX,double aY,double aZ)
	{
		x= aX;
		y= aY;
		z= aZ;
	}
	public void mullMat(Matrix3DForStu m)
	{
		double xTemp,yTemp,zTemp;
		xTemp=x; yTemp= y; zTemp=z;
		x=xTemp*m.mat[0][0] + yTemp*m.mat[1][0] + zTemp*m.mat[2][0] + 1*m.mat[3][0]; 
		y=xTemp*m.mat[0][1] + yTemp*m.mat[1][1] + zTemp*m.mat[2][1] + 1*m.mat[3][1]; 
		z=xTemp*m.mat[0][2] + yTemp*m.mat[1][2] + zTemp*m.mat[2][2] + 1*m.mat[3][2]; 
	}

	public void computeABC(Point3D p1,Point3D p2,Point3D p3)
	{
		x=p1.y*(p2.z-p3.z)+p2.y*(p3.z-p1.z)+p3.y*(p1.z-p2.z);
		y=p1.z*(p2.x-p3.x)+p2.z*(p3.x-p1.x)+p3.z*(p1.x-p2.x);
		z=p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y);
	}

}

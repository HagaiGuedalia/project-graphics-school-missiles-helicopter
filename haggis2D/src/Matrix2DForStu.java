
/*
 * Created on Tamuz 5769
 * @author levian
 * for Student
 */
class Matrix2DForStu
{
	private final int size=3;
	private double  mat[][];

	public Matrix2DForStu()
	{
		mat=new double[size][size];
		setIdentity();
	}
	
	public void setIdentity()
	{
		mat[0][0]=1.0;  mat[0][1]=0.0;  mat[0][2]=0.0;
		mat[1][0]=0.0;  mat[1][1]=1.0;  mat[1][2]=0.0;
		mat[2][0]=0.0;  mat[2][1]=0.0;  mat[2][2]=1.0;
	}
	
	public void setMatMove(double dx,double dy)
	{
		mat[0][0]=1.0;  mat[0][1]=0.0;  mat[0][2]=0.0;
		mat[1][0]=0.0;  mat[1][1]=1.0;  mat[1][2]=0.0;
		mat[2][0]= dx;  mat[2][1]= dy;  mat[2][2]=1.0;
	}
	
	public void setMatRotate(double teta)
	{
		mat[0][0]=Math.cos(teta); 	mat[0][1]=Math.sin(teta);  	mat[0][2]=0.0;
		mat[1][0]=-Math.sin(teta);  mat[1][1]=Math.cos(teta);  	mat[1][2]=0.0;
		mat[2][0]= 0.0;  			mat[2][1]= 0.0;  			mat[2][2]=1.0;
	}
	
	public void setMatRotateFix(double fixX, double fixY, double teta)
	{
		mat[0][0]= Math.cos(teta);  mat[0][1]= Math.sin(teta);  mat[0][2]=0.0;
		mat[1][0]= -Math.sin(teta);  mat[1][1]=Math.cos(teta);  mat[1][2]=0.0;
		mat[2][0]=(1-Math.cos(teta))*fixX+fixY*Math.sin(teta);  mat[2][1]= (1-Math.cos(teta))*fixY-fixX*Math.sin(teta);  mat[2][2]=1.0;
	}
	
	public void setMatScale(double fixX, double fixY, double sx, double sy)
	{
		mat[0][0]= sx;  		mat[0][1]= 0.0;			mat[0][2]=0.0;
		mat[1][0]= 0.0;  		mat[1][1]= sy;  		mat[1][2]=0.0;
		mat[2][0]= (1-sx)*fixX; mat[2][1]= (1-sy)*fixY; mat[2][2]=1.0;
	}
	

	public void mullMatMat(Matrix2DForStu aMat)
	{
		Matrix2DForStu temp=new Matrix2DForStu();
		for (int i= 0; i<size;i++)
			for (int j=0; j<size;j++)
			{
				temp.mat[i][j]=0;
				for (int k=0;k<size;k++)
					temp.mat[i][j] += mat[i][k] * aMat.mat[k][j];
			}
		mat=temp.mat;
	}
	
	public void mullAllPoints(double xr[], double yr[], int aNum)
	{
		double xTemp,yTemp;
		for(int i=0;i<aNum;i++)
		{
			xTemp=xr[i] ; yTemp = yr[i];
			xr[i]=xTemp*mat[0][0] + yTemp*mat[1][0] + 1*mat[2][0]; 
			yr[i]=xTemp*mat[0][1] + yTemp*mat[1][1] + 1*mat[2][1]; 
		}
		
	}	
}

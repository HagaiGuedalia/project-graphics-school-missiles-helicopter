/*
 * Created on Eiar 5767
 * upDate     Tamuz 5769
 * @author levian
 * for Student
 */
public class Matrix3DForStu 
{
	final int size=4;
	double mat[][];

	public Matrix3DForStu()
	{
		mat=new double[size][size];
		setIdentity();
	}
	
	public void setIdentity()
	{
		mat[0][0]=1.0;  mat[0][1]=0.0;  mat[0][2]=0.0; mat[0][3]=0.0;
		mat[1][0]=0.0;  mat[1][1]=1.0;  mat[1][2]=0.0; mat[1][3]=0.0;
		mat[2][0]=0.0;  mat[2][1]=0.0;  mat[2][2]=1.0; mat[2][3]=0.0;
		mat[3][0]=0.0;  mat[3][1]=0.0;  mat[3][2]=0.0; mat[3][3]=1.0;
	}
	
	public void setMatMove(double dx,double dy,double dz)
	{
		mat[0][0]=1.0;  mat[0][1]=0.0;  mat[0][2]=0.0; mat[0][3]=0.0;
		mat[1][0]=0.0;  mat[1][1]=1.0;  mat[1][2]=0.0; mat[1][3]=0.0;
		mat[2][0]=0.0;  mat[2][1]=0.0;  mat[2][2]=1.0; mat[2][3]=0.0;
		mat[3][0]=dx;   mat[3][1]=dy;   mat[3][2]=dz;  mat[3][3]=1.0;
	}
	
	public void setMatRotateX(double teta)
	{
		mat[0][0]=1.0;				mat[0][1]=0.0;				mat[0][2]=0.0; 				mat[0][3]=0.0;
		mat[1][0]=0.0;				mat[1][1]=Math.cos(teta); 	mat[1][2]=Math.sin(teta);  	mat[1][3]=0.0;
		mat[2][0]=0.0;				mat[2][1]=-Math.sin(teta);  mat[2][2]=Math.cos(teta);  	mat[2][3]=0.0;
		mat[3][0]=0.0;  			mat[3][1]= 0.0;  			mat[3][2]=0.0;				mat[3][3]=1.0;
	}
	public void setMatRotateY(double teta)
	{
		mat[0][0]=Math.cos(teta);	mat[0][1]=0.0;				mat[0][2]=Math.sin(teta);	mat[0][3]=0.0;
		mat[1][0]=0.0;				mat[1][1]=1.0;			 	mat[1][2]=0.0; 			 	mat[1][3]=0.0;
		mat[2][0]=-Math.sin(teta);	mat[2][1]=0.0;  			mat[2][2]=Math.cos(teta);  	mat[2][3]=0.0;
		mat[3][0]=0.0;  			mat[3][1]=0.0;  			mat[3][2]=0.0;				mat[3][3]=1.0;
	}
	public void setMatRotateZ(double teta)
	{
		mat[0][0]=Math.cos(teta);	mat[0][1]=Math.sin(teta);	mat[0][2]=0.0;				mat[0][3]=0.0;
		mat[1][0]=-Math.sin(teta);	mat[1][1]=Math.cos(teta);	mat[1][2]=0.0; 			 	mat[1][3]=0.0;
		mat[2][0]=0.0;				mat[2][1]=0.0;  			mat[2][2]=1.0;  			mat[2][3]=0.0;
		mat[3][0]=0.0;  			mat[3][1]=0.0;  			mat[3][2]=0.0;				mat[3][3]=1.0;
	}
	
	public void setMatScale(double fixX, double fixY,double fixZ, double sx, double sy, double sz)
	{
		mat[0][0]= sx;  		mat[0][1]= 0.0;			mat[0][2]=0.0;			mat[0][3]=0.0;
		mat[1][0]= 0.0;  		mat[1][1]= sy;  		mat[1][2]=0.0;			mat[1][3]=0.0;
		mat[2][0]= 0.0;  		mat[2][1]= 0.0;  		mat[2][2]=sz;			mat[2][3]=0.0;
		mat[3][0]= (1-sx)*fixX; mat[3][1]= (1-sy)*fixY;	mat[3][2]=(1-sz)*fixZ; 	mat[3][3]=1.0;
	}
	
	public void setMatRotateFixX(double zf, double yf, double teta)
	{
		mat[0][0]=1.0;				mat[0][1]=0.0;				mat[0][2]=0.0; 				mat[0][3]=0.0;
		mat[1][0]=0.0;				mat[1][1]=Math.cos(teta); 	mat[1][2]=Math.sin(teta);  	mat[1][3]=0.0;
		mat[2][0]=0.0;				mat[2][1]=-Math.sin(teta);  mat[2][2]=Math.cos(teta);  	mat[2][3]=0.0;
		mat[3][0]=0.0; 		mat[3][1]=-yf*Math.cos(teta)+zf*Math.sin(teta)+yf;  	 mat[3][2]=-yf*Math.sin(teta)-zf*Math.cos(teta)+zf;		mat[3][3]=1.0;
	}
	public void setMatRotateFixY(double xf, double zf, double teta)
	{

		mat[0][0]=Math.cos(teta);								mat[0][1]=0.0;				mat[0][2]=Math.sin(teta);	mat[0][3]=0.0;
		mat[1][0]=0.0;											mat[1][1]=1.0;			 	mat[1][2]=0.0; 			 	mat[1][3]=0.0;
		mat[2][0]=-Math.sin(teta);								mat[2][1]=0.0;  			mat[2][2]=Math.cos(teta);  	mat[2][3]=0.0;
		mat[3][0]=-xf*Math.cos(teta)+zf*Math.sin(teta)+xf;  	mat[3][1]=0.0;		  		mat[3][2]=-xf*Math.sin(teta)-zf*Math.cos(teta)+zf;				mat[3][3]=1.0;
	}
	public void setMatRotateFixZ(double xf, double yf, double teta)
	{
		mat[0][0]=Math.cos(teta);	mat[0][1]=Math.sin(teta);	mat[0][2]=0.0;				mat[0][3]=0.0;
		mat[1][0]=-Math.sin(teta);	mat[1][1]=Math.cos(teta);	mat[1][2]=0.0; 			 	mat[1][3]=0.0;
		mat[2][0]=0.0;				mat[2][1]=0.0;  			mat[2][2]=1.0;  			mat[2][3]=0.0;
		mat[3][0]=-xf*Math.cos(teta)+yf*Math.sin(teta)+xf;  	mat[3][1]=-xf*Math.sin(teta)-yf*Math.cos(teta)+yf;  		mat[3][2]=0.0;				mat[3][3]=1.0;
	}

	public void setMatRotateAxis(double x1, double y1,double z1,
			                     double x2, double y2,double z2,
			                                       double teta)
	{
		Matrix3DForStu m1= new Matrix3DForStu();
		double a,b,c,d,l;
		
	    a = x2-x1; b = y2-y1; c = z2-z1;
	    l = (float) Math.sqrt(a*a+b*b+c*c);
	    a = a/l;   b = b/l;   c = c/l;
	    d = (float) Math.sqrt(b*b+c*c);

	    
	    if (d == 0)
	      //; 
	     this.setMatRotateFixX(y1, z1, teta);
	    else
	    {
	      setMatMove(-x1,-y1,-z1);

          m1.setIdentity();                     // x axis
	      m1.mat[1][1] = c/d;  m1.mat[1][2] = b/d;
	      m1.mat[2][1] = -b/d; m1.mat[2][2] = c/d;
	      mullMatMat(m1);

	      m1.setIdentity();                     // y axis
	      m1.mat[0][0] = d;  m1.mat[0][2] = a;
	      m1.mat[2][0] = -a; m1.mat[2][2] = d;
	      mullMatMat(m1);

	      m1.setMatRotateZ(teta);               // Z axis
	      mullMatMat(m1);

          m1.setIdentity();                     // y axis
	      m1.mat[0][0] = d;  m1.mat[0][2] = -a;
	      m1.mat[2][0] = a; m1.mat[2][2] = d;
	      mullMatMat(m1);


          m1.setIdentity();                     // x axis
	      m1.mat[1][1] = c/d;  m1.mat[1][2] = -b/d;
	      m1.mat[2][1] = b/d;  m1.mat[2][2] = c/d;
	      mullMatMat(m1);

	      m1.setMatMove(x1,y1,z1);
	      mullMatMat(m1);
	    }

		
	}
	
	public void setMatRotateAxisUp(double x1, double y1,double z1,
			double x2, double y2,double z2,
			double teta)
	{
		Matrix3DForStu m1= new Matrix3DForStu();
		double a,b,c,d,l;

		a = x2-x1; b = y2-y1; c = z2-z1;
		l = (float) Math.sqrt(a*a+b*b+c*c);
		a = a/l;   b = b/l;   c = c/l;
		d = (float) Math.sqrt(b*b+c*c);

		if (d == 0)
			//; 
			this.setMatRotateFixX(y1, z1, teta);
		else
		{
			setMatMove(-x1,-y1,-z1);

			m1.setIdentity();                     // x axis
			m1.mat[1][1] = c/d;  m1.mat[1][2] = b/d;
			m1.mat[2][1] = -b/d; m1.mat[2][2] = c/d;
			mullMatMat(m1);

			m1.setIdentity();                     // y axis              make this a z axis
			m1.mat[0][0] = d;  m1.mat[0][2] = a;
			m1.mat[2][0] = -a; m1.mat[2][2] = d;
			mullMatMat(m1);

			m1.setMatRotateY(teta);               // Z axis              is this a y axis?
			mullMatMat(m1);

			m1.setIdentity();                     // y axis              make this a z axis
			m1.mat[0][0] = d;  m1.mat[0][2] = -a;
			m1.mat[2][0] = a; m1.mat[2][2] = d;
			mullMatMat(m1);


			m1.setIdentity();                     // x axis
			m1.mat[1][1] = c/d;  m1.mat[1][2] = -b/d;
			m1.mat[2][1] = b/d;  m1.mat[2][2] = c/d;
			mullMatMat(m1);

			m1.setMatMove(x1,y1,z1);
			mullMatMat(m1);
		}


	}


//	public void setMatRotateAxisUp(double x1, double y1,double z1,
//            double x2, double y2,double z2,
//                              double teta)
//{
//Matrix3DForStu m1= new Matrix3DForStu();
//double a,b,c,d,l;
//
//a = x2-x1; b = y2-y1; c = z2-z1;
//l = (float) Math.sqrt(a*a+b*b+c*c);
//a = a/l;   b = b/l;   c = c/l;
//d = (float) Math.sqrt(b*b+c*c);
//
//if (d == 0)
////; 
//this.setMatRotateFixY(y1, z1, teta);
//else
//{
//setMatMove(-x1,-y1,-z1);
//
//m1.setIdentity();                     // x axis
//m1.mat[1][1] = c/d;  m1.mat[1][2] = b/d;
//m1.mat[2][1] = -b/d; m1.mat[2][2] = c/d;
//mullMatMat(m1);
//
//m1.setIdentity();                     // y axis
//m1.mat[0][0] = d;  m1.mat[0][2] = a;
//m1.mat[2][0] = -a; m1.mat[2][2] = d;
//mullMatMat(m1);
//
//m1.setMatRotateX(teta);               // Z axis
//mullMatMat(m1);
//
//m1.setIdentity();                     // y axis
//m1.mat[0][0] = d;  m1.mat[0][2] = -a;
//m1.mat[2][0] = a; m1.mat[2][2] = d;
//mullMatMat(m1);
//
//
//m1.setIdentity();                     // x axis
//m1.mat[1][1] = c/d;  m1.mat[1][2] = -b/d;
//m1.mat[2][1] = b/d;  m1.mat[2][2] = c/d;
//mullMatMat(m1);
//
//m1.setMatMove(x1,y1,z1);
//mullMatMat(m1);
//}
//
//
//}
	public void mullMatMat(Matrix3DForStu aMat)
	{
		Matrix3DForStu temp=new Matrix3DForStu();
		for (int i= 0; i<size;i++)
			for (int j=0; j<size;j++)
			{
				temp.mat[i][j]=0;
				for (int k=0;k<size;k++)
					temp.mat[i][j] += mat[i][k] * aMat.mat[k][j];
			}
		mat=temp.mat;
	}
	
	public void mullAllPoints(double xr[], double yr[],double zr[], int aNum)
	{
		double xTemp,yTemp,zTemp;
		for(int i=0;i<aNum;i++)
		{
			xTemp=xr[i]; yTemp= yr[i]; zTemp=zr[i];
			xr[i]=xTemp*mat[0][0] + yTemp*mat[1][0] + zTemp*mat[2][0] + 1*mat[3][0]; 
			yr[i]=xTemp*mat[0][1] + yTemp*mat[1][1] + zTemp*mat[2][1] + 1*mat[3][1]; 
			zr[i]=xTemp*mat[0][2] + yTemp*mat[1][2] + zTemp*mat[2][2] + 1*mat[3][2]; 
		}
		
	}
	


}

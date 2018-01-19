import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Stack;



public class Missile extends Thread
{
	MainPanel3DForStu myPanel;

	MissileBody missilebody;
	Missilestick missilestick1;
	Missilestick missilestick2;
	Missilestick missilestick3;
	Missilestick missilestick4;
	
	Matrix3DForStu matiMissile;
	
	Color color;
	Point3D pmT, pmB, pmF, pW;
	double wSmall, pwx, pwy, pwz;
	double randomRange, speed, sum;
	int gasTank, currentGas, callibrate;
	
	Random rand;
	double randomAccuracy;
	int randomDirection;
	
	public Missile(Point3D magoz, MainPanel3DForStu myPanel) 
	{
		super();
		this.myPanel= myPanel;
		 missilebody=new MissileBody(magoz);
		 missilestick1=new Missilestick(magoz);
		 missilestick2=new Missilestick(magoz);
		 missilestick3=new Missilestick(magoz);
		 missilestick4=new Missilestick(magoz);
		
		 matiMissile=new Matrix3DForStu();
		 
		 pmB = new Point3D();
		 pmT = new Point3D();
		 pmF = new Point3D();
		 pW = new Point3D();
		 rand = new Random();
		
	}

//	public void buildShape(double x, double y, double z, double dz, Matrix3DForStu mati)	
//	{
//		
//		 pmB = new Point3D();
//		 pmT = new Point3D();
//		 pmF = new Point3D();
//		 pW = new Point3D();
//		 rand = new Random();
//		
//		//missilebody.buildShape(x-dz/2, y, z-dz/2, dz);
//		 missilebody.color=color;
//		missilebody.buildShape(x, y, z, dz);
//		
//		
//		missilestick1.color=Color.black;
//		missilestick1.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
//		mati.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI/4);
//		missilestick1.mullMat(mati);
//		
//		missilestick2.color=Color.blue;
//		missilestick2.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
//		mati.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  -Math.PI/4);
//		missilestick2.mullMat(mati);
//		mati.setMatMove(0.0, 0.0, dz);
//		missilestick2.mullMat(mati);
//		
//		missilestick3.color=Color.red;
//		missilestick3.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
//		mati.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI+Math.PI/4);
//		missilestick3.mullMat(mati);
//		mati.setMatMove(0.0, dz, dz);
//		missilestick3.mullMat(mati);
//		
//		missilestick4.color=Color.cyan;
//		missilestick4.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
//		mati.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI-Math.PI/4);
//		missilestick4.mullMat(mati);
//		mati.setMatMove(0.0, dz, 0.0);
//		missilestick4.mullMat(mati);
//		
//		//pmT.setXYZ(1, 1, 1);
//		pmT.setXYZ(missilebody.xReal[0], missilebody.yReal[1], missilebody.zReal[8]);
//		pmF.setXYZ(missilebody.xReal[8], missilebody.yReal[8], missilebody.zReal[8]);
//		pmB.setXYZ(missilebody.xReal[0], missilebody.yReal[0], missilebody.zReal[8]);
//		
//		pwx=pW.x;
//		pwy=pW.y;
//		pwz=pW.z;
//		
//	}
	public void buildShape(double x, double y, double z, double dz, double length, double randomRange, double speed, int callibrate)	
	{
		
		
		//missilebody.buildShape(x-dz/2, y, z-dz/2, dz);
		 missilebody.color=color;
		missilebody.buildShape(x, y, z, dz, length);
		
		missilestick1.color=Color.black;
		missilestick1.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI/4);
		missilestick1.mullMat(matiMissile);
		
		missilestick2.color=Color.blue;
		missilestick2.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  -Math.PI/4);
		missilestick2.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, 0.0, dz);
		missilestick2.mullMat(matiMissile);
		
		missilestick3.color=Color.red;
		missilestick3.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI+Math.PI/4);
		missilestick3.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, dz, dz);
		missilestick3.mullMat(matiMissile);
		
		missilestick4.color=Color.cyan;
		missilestick4.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI-Math.PI/4);
		missilestick4.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, dz, 0.0);
		missilestick4.mullMat(matiMissile);
		
		
		//pmT.setXYZ(1, 1, 1);
		pmT.setXYZ(missilebody.xReal[0], missilebody.yReal[1], missilebody.zReal[8]);
		pmF.setXYZ(missilebody.xReal[8], missilebody.yReal[8], missilebody.zReal[8]);
		pmB.setXYZ(missilebody.xReal[0], missilebody.yReal[0], missilebody.zReal[8]);
		pW.setXYZ((myPanel.hellicopter.p1.x+myPanel.hellicopter.p2.x)/2-(pmF.x), (myPanel.hellicopter.p1.y+myPanel.hellicopter.p2.y)/2-(pmF.y), (myPanel.hellicopter.p1.z+myPanel.hellicopter.p2.z)/2-(pmF.z));	

		
		pwx=0;
		pwy=0;
		pwz=0;
		

		this.randomRange=randomRange;
		this.speed=speed;
		this.callibrate=callibrate;
	}
	
	public void buildShape(double x, double y, double z, double dz, double length)	
	{
		
		
		//missilebody.buildShape(x-dz/2, y, z-dz/2, dz);
		 missilebody.color=color;
		missilebody.buildShape(x, y, z, dz, length);
		
		missilestick1.color=Color.black;
		missilestick1.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI/4);
		missilestick1.mullMat(matiMissile);
		
		missilestick2.color=Color.blue;
		missilestick2.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  -Math.PI/4);
		missilestick2.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, 0.0, dz);
		missilestick2.mullMat(matiMissile);
		
		missilestick3.color=Color.red;
		missilestick3.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI+Math.PI/4);
		missilestick3.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, dz, dz);
		missilestick3.mullMat(matiMissile);
		
		missilestick4.color=Color.cyan;
		missilestick4.buildShape(x-dz/3, y-(dz/2), (z-(dz/5)/2), dz);
		matiMissile.setMatRotateFixX((z-(dz/5)/2/2),  (y-(dz/2))+dz*0.6,  Math.PI-Math.PI/4);
		missilestick4.mullMat(matiMissile);
		matiMissile.setMatMove(0.0, dz, 0.0);
		missilestick4.mullMat(matiMissile);
		
		
		//pmT.setXYZ(1, 1, 1);
		pmT.setXYZ(missilebody.xReal[0], missilebody.yReal[1], missilebody.zReal[8]);
		pmF.setXYZ(missilebody.xReal[8], missilebody.yReal[8], missilebody.zReal[8]);
		pmB.setXYZ(missilebody.xReal[0], missilebody.yReal[0], missilebody.zReal[8]);
		pW.setXYZ((myPanel.hellicopter.p1.x+myPanel.hellicopter.p2.x)/2-(pmF.x), (myPanel.hellicopter.p1.y+myPanel.hellicopter.p2.y)/2-(pmF.y), (myPanel.hellicopter.p1.z+myPanel.hellicopter.p2.z)/2-(pmF.z));	
		
		pwx=0;
		pwy=0;
		pwz=0;
	
	}
	
	
	public void rangeSpeedCallibrate(double randomRange, double speed, int callibrate){
		this.randomRange=randomRange;
		this.speed=speed;
		this.callibrate=callibrate;
	}
	
	public void calcDistanceW()
	{
		pW.setXYZ((myPanel.hellicopter.p1.x+myPanel.hellicopter.p2.x)/2-(pmF.x), (myPanel.hellicopter.p1.y+myPanel.hellicopter.p2.y)/2-(pmF.y), (myPanel.hellicopter.p1.z+myPanel.hellicopter.p2.z)/2-(pmF.z));
	}
	public void calcSum()
	{
		sum = Math.abs(pW.x) + Math.abs(pW.y) +Math.abs(pW.z);
	}
	public void calcDirection(int tik) 
	{
		
		if(currentGas <= gasTank/4 )
		{
			if(speed == 50)
				speed = 30;
		}
		if(currentGas <= gasTank/5 )
		{
			if(speed == 30)
				speed = 20;
		}
		
		if(currentGas <= 0)
		{
				speed = 0;
		}
		
		if(tik % callibrate ==0 )
		{
			
			randomAccuracy = 1 - randomRange + (1+randomRange - (1-randomRange)) * rand.nextDouble();
			randomDirection = (rand.nextInt(3) + 1);
			//System.out.println("random " + randomDirection);

			if(randomDirection==1)
				pwx=pW.x/sum*speed*randomDirection;	
			else 
				pwx=pW.x/sum*speed;
			
			if(randomDirection==2)
				pwy=pW.y/sum*speed*randomDirection;
			else 
				pwy=pW.y/sum*speed;

			if(randomDirection==3)
				pwz=pW.z/sum*speed*randomDirection;
			else 
				pwz=pW.z/sum*speed;

			
		}
		
		
	}	
	public boolean ifHit()
	{
		return (Math.abs(pW.x) <=myPanel.deathDistance && Math.abs(pW.y) <=myPanel.deathDistance && Math.abs(pW.z) <=myPanel.deathDistance);
	}
	public boolean isHIt(double deathDistance)
	{
	   	return (Math.abs(pW.x) <=deathDistance && Math.abs(pW.y) <=deathDistance && Math.abs(pW.z) <=deathDistance );

	}

	public void fromPointToGuf()
	{
		missilebody.fromPointToGuf();
		missilestick1.fromPointToGuf();
		missilestick2.fromPointToGuf();
		missilestick3.fromPointToGuf();
		missilestick4.fromPointToGuf();

	}
	
	Stack<Missilestick> stack = new Stack<Missilestick>();
	
//	public boolean sameSide(int i, int j) {
//		if 
//	}

	public void convertAndShow (Graphics page)
	{
		if(missilestick1.zReal[0] < missilebody.zReal[1])  //stick1 closer than body
		{
			if(missilestick2.zReal[0] < missilebody.zReal[5]) //and stick2 closer than body
			{
				missilestick3.convertAndShow(page);
				missilestick4.convertAndShow(page);
				missilebody.convertAndShow(page);
				missilestick1.convertAndShow(page);
				missilestick2.convertAndShow(page);
			}else{
				missilestick3.convertAndShow(page);          //and stick4 closer than body
				missilestick2.convertAndShow(page);
				missilebody.convertAndShow(page);
				missilestick4.convertAndShow(page);
				missilestick1.convertAndShow(page);
			}
		}else if (missilestick3.zReal[0] < missilebody.zReal[4])  //stick3 closer than body
		{
			if(missilestick2.zReal[0] < missilebody.zReal[5]) //and stick2 closer than body
			{
				missilestick1.convertAndShow(page);
				missilestick4.convertAndShow(page);
				missilebody.convertAndShow(page);
				missilestick3.convertAndShow(page);
				missilestick2.convertAndShow(page);
			}else{
				missilestick1.convertAndShow(page);          //and stick4 closer than body
				missilestick2.convertAndShow(page);
				missilebody.convertAndShow(page);
				missilestick3.convertAndShow(page);
				missilestick4.convertAndShow(page);
			}
			
		}else{
			missilestick4.convertAndShow(page);          //and stick4 closer than body
			missilebody.convertAndShow(page);
			missilestick2.convertAndShow(page);
			missilestick3.convertAndShow(page);
			missilestick1.convertAndShow(page);
		}
		
		
		


	}
	
    public void copy(Missile other)
    {
    	missilebody.copy(other.missilebody);
    	missilestick1.copy(other.missilestick1);
    	missilestick2.copy(other.missilestick2);
    	missilestick3.copy(other.missilestick3);
    	missilestick4.copy(other.missilestick4);
    	
 	
    }

	public void mullMat(){
		missilebody.mullMat(matiMissile);
		missilestick1.mullMat(matiMissile);
		missilestick2.mullMat(matiMissile);
		missilestick3.mullMat(matiMissile);
		missilestick4.mullMat(matiMissile);

		pmB.mullMat(matiMissile);
		pmT.mullMat(matiMissile);
		pmF.mullMat(matiMissile);
		pW.mullMat(matiMissile);
		
	}

	






}
/*
 * Created on Eiar 5767
 * update Av 5768
 * @author levian
 * for me
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

//fix - calcvec, distance and death 

// remove missiles after they die
//send to teacher: send the zipped file
public class MainPanel3DForStu extends JPanel
{
		Thread thread;
		Matrix3DForStu matiProp=new Matrix3DForStu();
		Matrix3DForStu mati=new Matrix3DForStu();
		
		Point3D p00, magoz;
		double wSmall;
		double deathDistance=60;
		
		Object object=new Object();
		
		
		Hellicopter hellicopter, mabatHellicopter;
		Sevivon sevivon;
		Missile missile;
		Font myFont=new Font("tahoma",Font.LAYOUT_LEFT_TO_RIGHT,15);
		Font death=new Font("tahoma",Font.LAYOUT_LEFT_TO_RIGHT,90);
		int minutes = 0;
		int miliSeconds = 0;
		int seconds = 0;
		Sevivon sevivon2;
		
		int crashtime=0;
		
		ArrayList<Missile>  missileList= new ArrayList<Missile>();  
		ArrayList<Missile>  mabatMissileList= new ArrayList<Missile>();  
		int amountOfMissiles = 0;

		
		int helliWidth = 70;
		MiniMainPanel miniPanel;

		
		public MainPanel3DForStu()
		{
			super();
			setLayout(null);
			miniPanel=new MiniMainPanel(this);
			miniPanel.setVisible(true);
			add(miniPanel);
			
			
		   	setBackground(Color.WHITE);
		   	biuldElem();
		}
		
		public void paintComponent (Graphics page)
		{
			super.paintComponent(page);
			page.setFont(myFont);
//			basis.convertAndShow(page);//,depth,prespctivCenter,perspectiv);
	
			page.drawString("Helli :  "+hellicopter.p1,550,100);
			page.drawString("tik  "+tik,550,130);
			
			if(crashtime>0)
			{
				page.drawString("crash", 50,550);
				crashtime--;
			}
				
	
			synchronized (object) 
			{
				for (Missile miss : missileList)
				{	
					if (miss.exists)
					{  
						page.drawString("distance "+miss.missileNum+"- "+(int) miss.sum,50,50*miss.missileNum*2);
						page.drawString("gas "+miss.missileNum+"- "+(int)miss.currentGas, 50, 20+50*miss.missileNum*2);
						page.drawString("speed "+miss.missileNum+"- "+(int)miss.speed  , 50, 40+50*miss.missileNum*2);

						int xInt=(int)(miss.pmMc.x*(magoz.z/(magoz.z+miss.pmMc.z))+magoz.x);
						int yInt=(int)(miss.pmMc.y*(magoz.z/(magoz.z+miss.pmMc.z))+magoz.y);
						page.drawString(""+miss.missileNum, xInt, yInt-10);

					}else{
						page.drawString("wait "+miss.missileNum+"- "+miss.waitTime,50, 60+50*miss.missileNum*2);
					}
				}
			}

			page.drawString("time  "+minutes,300,50);
			page.drawString(":"+(seconds<10?  "0":"")+seconds,345,50);
			page.drawString(":"+(miliSeconds<10?  "0":"")+miliSeconds,365,50);

//
//			sevivon.fromPointToGuf();
//			sevivon.convertAndShow(page);
//			
//			sevivon2.fromPointToGuf();
//			sevivon2.convertAndShow(page);
//			
			hellicopter.fromPointToGuf();
			hellicopter.convertAndShow(page);
			
			
			synchronized (object) 
			{
				for (Missile miss : missileList) 
				{
					if (miss.exists){ 
						miss.fromPointToGuf();
						miss.convertAndShow(page);
					}
				}
			}
			synchronized (object) 
			{
				int ii=0;
				for (Missile miss : mabatMissileList) 
				{
					if (miss.exists){ 
						miss.copy(missileList.get(ii++));  
						miss.matiMissile.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
						miss.mullMat();
					}
				}
			}
			

			synchronized (object) 
			{
				for (Missile miss : missileList) 
				{
					if (miss.exists)
					{ 
						if(miss.ifHit())
						{
							page.setFont(death);
							page.drawString("you blew up, bummer",50,550);
						}
						for (Missile miss2 : missileList) 
						{
							if (miss2.exists)
							{
								if(miss.missileNum!=miss2.missileNum){
									if(miss2.ifCrash(miss))
									{
										if(tik>50)
										{										
											crashtime=50;
											//crash=true;
											miss.exists=false;
											miss2.exists=false;
										}
									}
								}
								
							}
						}
					}
					

				}
				
			}
			

			//check between missile/helli
//			if (hellicopter.helliStick.zReal[0]<missile.missilebody.zReal[0]) 
//			{
//				missile.convertAndShow(page);
//				hellicopter.convertAndShow(page);
//			}
//			else{
//			
//				hellicopter.convertAndShow(page);
//				missile.convertAndShow(page);
//			}
			
			mabatHellicopter.copy(hellicopter);
			//mabatHellicopter.mat0i=mabatHellicopter.matiRotate;
			//miniPanel.mati.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
			mabatHellicopter.mati.setMatMove(p00.x-mabatHellicopter.phCenter.x, p00.y-mabatHellicopter.phCenter.y, p00.z-mabatHellicopter.phCenter.z);
			mabatHellicopter.matiRotate.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
			//			miniPanel.repaint();
			
			
		}
		
		public void fastMissile(Missile fastM, double x, double y, double z)
		{
			fastM.color = Color.black;
			//fastM.buildShape(x, y, z, helliWidth/2.5, helliWidth/5,  matiFastMissile);
		}

		public void biuldElem()
		{
			p00 = new Point3D();
			magoz = new Point3D();
			
			p00.setXYZ(0, 0, 10000);
			
		    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
			
			magoz.setXYZ(d.getWidth()/2, d.getHeight()/3, 5000);
			
			hellicopter= new Hellicopter(magoz, this);
			mabatHellicopter= new Hellicopter(magoz, this);
	
			hellicopter.buildShape(p00.x, p00.y, p00.z, helliWidth);
			
			addMissile1(p00.x-1100, p00.y-500, p00.z);
			//addFastMissile(p00.x-1100, p00.y+500, p00.z);
			addNormalMissile(p00.x-1100, p00.y, p00.z);
			
//			sevivon=new Sevivon(magoz);
//			sevivon2=new Sevivon(magoz);
//		
//			sevivon.buildShape(miss.pmMl.x, miss.pmMc.y, miss.pmMc.z, 50);
//			sevivon.buildShape(200, 200, 200, 200);
//
//			sevivon2.buildShape(miss.pmMr.x,  miss.pmF.y, miss.pmF.z, 10);

			synchronized (object) 
			{
				for (Missile miss : mabatMissileList) {
					miss.matiMissile.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
				}
			}			
		}
		
		//add: missile depth
		public void addMissile(double x, double y, double z, double width, int changeWidth, int gasTank, double randomRange, int speed, int callibrate, int waitSet) 
		{
			amountOfMissiles++;
			
			missile = new Missile(magoz, this);
			//missile.exists=true;
			missile.existsTime = 0*amountOfMissiles;
			int minSpeed=32, maxSpeed=70;
			missile.color= new Color((int) 255/(maxSpeed-minSpeed)*(speed-minSpeed), 50, 150);
			missile.gasTank = gasTank;
			missile.currentGas = missile.gasTank;
			missile.waitSet=waitSet;
			missile.missileNum=amountOfMissiles;
			missile.buildShape(x, y, z, width+callibrate/6, gasTank/20, randomRange, speed, callibrate);
			missileList.add(missile);
			   
			missile = new Missile(magoz, this);
			missile.existsTime = 300*amountOfMissiles;
			//missile.exists=true;
			missile.color= new Color((int) 255/(maxSpeed-minSpeed)*(speed-minSpeed), 50, 150);
			missile.gasTank = gasTank;
			missile.currentGas = missile.gasTank;
			missile.waitSet=waitSet;
			missile.missileNum=amountOfMissiles;
			missile.buildShape(x, y, z, width, changeWidth, randomRange, speed, callibrate);
			mabatMissileList.add(missile);

			//mabatMissileList.add(missile);
		}
		public double calcVec(Point3D t) 
		{
			return Math.sqrt(t.x*t.x+t.y*t.y+t.z+t.z);
		}
		public void addMissile1(double x, double y, double z) 
		{	
			addMissile(x, y, z, helliWidth/2.5, 0, 1000, 0.2, 32, 40, 400);
		}
		
		public void addNormalMissile(double x, double y, double z) 
		{		
			addMissile(x, y, z, helliWidth/2.5, 0, 500, 0.6, 50, 60, 300);
		}
	
		public void addFastMissile(double x, double y, double z) 
		{
			addMissile(x, y, z, helliWidth/2.5, 20, 900, 0.7, 70, 80, 200);
		}
		
			
		public void move(double d, double e, double f)
		{
			hellicopter.mati.setMatMove(d,e,f);
			prepareToShowAndRepaint();
		}
		public void move(int d, int e, int f)
		{
			hellicopter.mati.setMatMove(d,e,f);
			prepareToShowAndRepaint();
		}
		public void rotateXFix(double dy, double dz, double teta)
		{
			//hellicopter.mati.setMatRotateFixX(dy,dz,teta);
			hellicopter.matiRotate.setMatRotateFixX(dy,dz,teta);
			prepareToShowAndRepaint();
		}
		public void rotateYFix(double dx, double dz, double teta)
		{
			//hellicopter.mati.setMatRotateFixY(dx, dz,teta);
			hellicopter.matiRotate.setMatRotateFixY(dx, dz,teta);
			prepareToShowAndRepaint();
		}
		public void rotateZFix(double dx, double dy, double teta)
		{
			//hellicopter.mati.setMatRotateFixZ(dx,dy,teta);
			hellicopter.matiRotate.setMatRotateFixZ(dx,dy,teta);
			prepareToShowAndRepaint();
		}
		public void rotateAxis( double x1, double y1,double z1,
                				double x2, double y2,double z2,
                					double teta)
		{
			//hellicopter.mati.setMatRotateAxis(x1, y1, z1, x2, y2, z2, teta);
			hellicopter.matiRotate.setMatRotateAxis(x1, y1, z1, x2, y2, z2, teta);
			prepareToShowAndRepaint();
		}
		public void rotateAxisUp( double x1, double y1,double z1,
								  double x2, double y2,double z2,
								  	double teta)
		{
							//Doesn't work, ask him how to change axis so it will spin up and down
			//hellicopter.mati.setMatRotateAxisUp(x1, y1, z1, x2, y2, z2, teta);
			hellicopter.matiRotate.setMatRotateAxisUp(x1, y1, z1, x2, y2, z2, teta);
			prepareToShowAndRepaint();
			
		}
		public void scale(double dx, double dy, double dz, double sx, double sy, double sz)
		{
			hellicopter.mati.setMatScale(dx, dy, dz, sx, sy, sz);
			prepareToShowAndRepaint();
		}
		
		public void moveLeft() 
		{
			hellicopter.phC.setXYZ(hellicopter.phB.x+1.25*(hellicopter.phF.x-hellicopter.phB.x), hellicopter.phB.y+1.25*(hellicopter.phF.y-hellicopter.phB.y), hellicopter.phB.z+1.25*(hellicopter.phF.z-hellicopter.phB.z));			
			move(-(hellicopter.phC.x-hellicopter.phF.x), -(hellicopter.phC.y-hellicopter.phF.y), -(hellicopter.phC.z-hellicopter.phF.z));
		}
		public void moveRight() 
		{
			hellicopter.phC.setXYZ(hellicopter.phB.x+1.25*(hellicopter.phF.x-hellicopter.phB.x), hellicopter.phB.y+1.25*(hellicopter.phF.y-hellicopter.phB.y), hellicopter.phB.z+1.25*(hellicopter.phF.z-hellicopter.phB.z));
			move(hellicopter.phC.x-hellicopter.phF.x, hellicopter.phC.y-hellicopter.phF.y, hellicopter.phC.z-hellicopter.phF.z);
		}
		public void rotateXFixUp() 
		{
			rotateXFix(hellicopter.p1.z, hellicopter.p1.y ,Math.PI/10);
		}
		
		public void rotateXFixDown() 
		{
			rotateXFix(hellicopter.p1.z,hellicopter.p1.y,-Math.PI/10);
		}
		public void moveUp() 
		{
			move(0,-50,0);
		}
		public void moveDown() 
		{
			move(0,50,0);
		}
		public void rotateYFixLeft() 
		{
			rotateYFix(hellicopter.p1.x, hellicopter.p1.z,Math.PI/10);
		}
		public void rotateYFixRight() 
		{
			rotateYFix(hellicopter.p1.x, hellicopter.p1.z,-Math.PI/10);
		}
		public void moveForward() 
		{
			move(0,0,-150);
		}
		public void moveBackward() 
		{
			move(0,0,150);
		}
		public void rotateZFixClock() 
		{
			rotateZFix(hellicopter.p1.x, hellicopter.p1.y,Math.PI/10);
		}
		public void rotateZFixQounter() 
		{
			rotateZFix(hellicopter.p1.x, hellicopter.p1.y,-Math.PI/10);
		}
		public void bigger() 
		{
			scale(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, 1.1, 1.1, 1.1);
		}
		public void smaller() 
		{
			scale(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, 0.9, 0.9, 0.9);
		}
		public void rotateAxisLeft(){
			
			rotateAxis(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, hellicopter.p2.x, hellicopter.p2.y, hellicopter.p2.z, -Math.PI/20);
		}
		public void rotateAxisRight(){
			rotateAxis(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, hellicopter.p2.x, hellicopter.p2.y, hellicopter.p2.z, Math.PI/20);
		}
		
		public void rotateAxisUp(){
			//doesnt work
			rotateAxisUp(hellicopter.helliStick.xReal[3], hellicopter.helliStick.yReal[3], hellicopter.helliStick.zReal[3], hellicopter.hellibody.xReal[7], hellicopter.hellibody.yReal[7], hellicopter.hellibody.zReal[7], Math.PI/20);
		}
		
		
		
//		public void rotateYFix(double dx, double dz, double teta, Matrix3DForStu matrix)
//		{
//			matrix.setMatRotateFixX(dx,dz,teta);
//			prepareToShowAndRepaint();
//		}
//		public void rotateAxisLeft(Matrix3DForStu matrix, int x){
//			if(x==1)
//				rotateAxis(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z, -Math.PI/20, matrix);
//			if(x==2)
//				rotateAxis(pmB.x, pmB.y, pmB.z, pmT.x, pmT.y, pmT.z, -Math.PI/20, matrix);
//
//		}
//		public void rotateAxisRight(Matrix3DForStu matrix, int x){
//			if(x==1)
//			{
//				rotateAxis(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z, Math.PI/10, matrix);
//			}
//				//rotateYFix(p00.x, p00.z,Math.PI/20, matrix);
//			if(x==2)
//				rotateYFix(p00.x, p00.z, Math.PI/20, matrix);
//				//rotateAxis(pmB.x, pmB.y, pmB.z, pmT.x, pmT.y, pmT.z, Math.PI/20, matrix);
//
//		}
		public void explosion() {
			scale(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, 3.5, 3.5, 3.5);
			
		}
//		public void calcCos(Missile miss, double x1, double y1,double z1,
//				double x2, double y2,double z2)
		public void calcCos(Missile miss, Point3D missC, Point3D helliC, Point3D missR, Point3D missL)
		{

			double top, bottom, sizeH, sizeM;
			top = missC.x*helliC.x + missC.y*helliC.y + missC.z*helliC.z;
			sizeM = Math.sqrt(missC.x*missC.x + missC.y*missC.y + missC.z*missC.z);
			sizeH = Math.sqrt(helliC.x*helliC.x + helliC.y*helliC.y + helliC.z*helliC.z);
			bottom = sizeH*sizeM;
			miss.matiMissile.setMatRotateAxis(missR.x, missR.y, missR.z, missL.x, missL.y, missL.z, Math.acos(top/bottom));

//			double a,b,c,l,d;
//			a = x2-x1; b = y2-y1; c = z2-z1;
//			l = (float) Math.sqrt(a*a+b*b+c*c);
//			a = a/l;   b = b/l;   c = c/l;
//			d = (float) Math.sqrt(b*b+c*c);
			
		}
		
		public void rotateMissile(Missile miss){
			calcCos(miss, miss.pmMc, hellicopter.phCenter, miss.pmMr, miss.pmMl);
		}
		
		
		public void moveAni(char ch){
			switch(ch)
			{
			case 'j':
				rotateAxisLeft() ;
//				rotateAxisLeft(matiMissile, 2) ;
				prepareToShowAndRepaint();
				break;

			case 'l':
				rotateAxisRight() ;
//				rotateAxisRight(matiMissile, 1) ;
				prepareToShowAndRepaint();
				break;

			case 'i':
				//rotateAxisUp();
				rotateXFixUp() ;
				prepareToShowAndRepaint();
				break;

			case 'k':
				rotateXFixDown() ;
				prepareToShowAndRepaint();
				break;
				
			case 'q':
				synchronized (object) 
				{
					for (Missile miss : missileList) 					
					{
						if (miss.exists)
						{ 
							miss.matiMissile.setMatRotateAxis(miss.pmMc.x, miss.pmMc.y, miss.pmMc.z,miss.pmF.x, miss.pmF.y, miss.pmF.z, Math.PI/20);
							//miss.mullMat();
							//miss.matiMissile.setIdentity();
						}
					}
				}	

				
//				hellicopter.matiRotate.setMatRotateFixX(hellicopter.hellibody.zReal[3], hellicopter.hellibody.yReal[3],Math.PI/20);
//				synchronized (object) 
//				{
//					for (Missile miss : missileList) 					
//					{
//						 if (miss.exists)
//						 { 
//							 miss.matiMissile.setMatRotateFixX(hellicopter.hellibody.zReal[3], hellicopter.hellibody.yReal[3],Math.PI/20);
//							 miss.currentGas++;
//						 }
//					}
//				}
				
//				synchronized (object) 
//				{
//					for (Missile miss : missileList) 					
//					{
//						 if (miss.exists)
//						 { 
//							 //moveAllMissiles(miss.pwx * 1.6, miss.pwy * 1.6, miss.pwz * 1.6, miss);
//							 
//							 //calcCos(miss, miss.pmMc, hellicopter.phCenter, miss.pmMr, miss.pmMl);
//							//miss.matiMissile.setMatRotateAxis(miss.pmF.x, miss.pmF.y, miss.pmF.z, miss.pmF.x-10, miss.pmF.y-0.00001, miss.pmF.z, Math.PI/10); //rotate missile vertically !!
//
//						 }
//					}
//				}	
				//explosion();
				prepareToShowAndRepaint();

				
//				hellicopter.mati.setIdentity();
//				matiMissile.setMatRotateFixZ(p00.x, p00.y, Math.PI/50);
//				prepareToShowAndRepaint();
//				matiMissile.setIdentity();
				break;

				
			case 'r':
			//	hellicopter.mati.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
				hellicopter.matiRotate.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
				synchronized (object) 
				{
					for (Missile miss : missileList) 					
					{
						 if (miss.exists)
						 { 
							 miss.matiMissile.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
							 miss.currentGas++;
						 }
					}
				}
				
//				for (Missile miss : mabatMissileList) 					
//				{
//					miss.matiMissile.setIdentity();
//				}
				tik--;
				prepareToShowAndRepaint();
				hellicopter.mati.setIdentity();
				
				break;

			default:
				break;
			}
		}

		
		
		public void spinProp(){
			matiProp.setMatRotateAxis(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, hellicopter.p2.x, hellicopter.p2.y, hellicopter.p2.z, Math.PI/10);
			hellicopter.spinProp1(matiProp);
			prepareToShowAndRepaintprop();
		}
		
		
		
		
		public void rotateXFixUp(double teta) 
		{
			rotateXFix(hellicopter.p1.z, hellicopter.p1.y ,teta);
		}
		public void rotateZFixQounter(double teta) 
		{
			rotateZFix(hellicopter.p1.x, hellicopter.p1.y,teta);
		}
		public void rotateAxisRight(double teta){
			rotateAxis(hellicopter.p1.x, hellicopter.p1.y, hellicopter.p1.z, hellicopter.p2.x, hellicopter.p2.y, hellicopter.p2.z, teta);
		}
		public void moveMissile(double d, double e, double f, Missile missile)
		{
			
			missile.matiMissile.setMatMove(d, e, f);
			prepareToShowAndRepaint();
		}
		
		public void moveAllMissiles(double d, double e, double f, Missile missile)
		{
			missile.matiMissile.setMatMove(d, e, f);
			prepareToShowAndRepaint();
			
		}
		
//		public void moveFastMissile(double d, double e, double f)
//		{
//			matiFastMissile.setMatMove(d, e, f);
//			prepareToShowAndRepaint();
//		}
		
		Matrix3DForStu matrix;
		
		public void rotateAxis( double x1, double y1,double z1,
				double x2, double y2,double z2,
				double teta, Matrix3DForStu matrix)
		{
			matrix.setMatRotateAxis(x1, y1, z1, x2, y2, z2, teta);
			prepareToShowAndRepaint();
		}
		
		
		
	    public void startAnimaition()
	    {
	    	if (thread==null)
	    	{
			   thread= new Animation3DForStu(this);
	    	}
	    }
	    public void suspendAnimation()
	    {
	    	thread.suspend();
	   	}
	    
	    public void resumeAnimation()
	    {
	    	thread.resume();
	    }
	    	
	    
	    public void stopAnimation()
	    {
			hellicopter.mati.setIdentity();
			thread.stop();
			thread=null;
	    }

	    boolean isDead = false;

	    public boolean isHIt()
	    {
	    	boolean hit = false;
	    	synchronized (object) 
			{
	    		for (Missile miss : missileList) 
	    		{	
	    			if (miss.exists)
	    			{ 
	    				if(miss.isHIt(deathDistance))
	    					hit=true;
	    			}
	    		}
			}
	    	return hit;
	    	//return (Math.abs(missile.pW.x) <=deathDistance && Math.abs(missile.pW.y) <=deathDistance && Math.abs(missile.pW.z) <=deathDistance );

	    }
	    
	    
	    
	    
	    
	    
	    
	    int tik = 0;
			
		public void prepareToShowAndRepaint()
		{
			// Time
			miliSeconds++;
			if(miliSeconds==100)
			{
				seconds++;
				miliSeconds=0;
				if(seconds==60)
				{
					minutes++;
					seconds=0;
				}
			}
	

//			sevivon.mullMat(mati);
//			sevivon2.mullMat(mati);
			
//			if(tik % 600  == 0)
//			{
//				addFastMissile(hellicopter.p1.x+500, hellicopter.p1.y+500, hellicopter.p1.z+500);
//			}
//			else if(tik % 200  == 0)
//			{
//				addNormalMissile(hellicopter.p1.x+500, hellicopter.p1.y+500, hellicopter.p1.z+500);
//			}
			
			synchronized (object) 
			{
				for (Missile miss : missileList) 
				{
					if(miss.existsTime==tik)
						miss.exists=true;
					if (miss.exists)
					{
						
						miss.calcDistanceW();
						miss.calcSum();
						miss.calcDirection(tik);
						miss.mullMat();
					}
				}
				
			}
			
			hellicopter.mullMat();
			
			//could add a function that changes mabat - miss.setExists(true/false)
			synchronized (object) 
			{
				for (Missile miss : missileList) 
				{	
					if (miss.exists){ 
						for (Missile mMiss : mabatMissileList)
						{ 
							if (miss.missileNum==mMiss.missileNum)
								mMiss.exists=true;
						}
					}
					else{
						for (Missile mMiss : mabatMissileList)
						{ 
							if (miss.missileNum==mMiss.missileNum)
								mMiss.exists=false;
						}
					}
				}
			}

			
			/*
			*
			*	penalize missile for turning, take off a bit of speed
			*	
			*/
			
			
			
			synchronized (object) 
			{
//				for (Missile miss : mabatMissileList)
//				{ 
//					if (miss.currentGas == 0) {
//						miss.exists=false;
//					}
//				}
				for (Missile miss : missileList)
				{ 
					if (miss.exists)
					{
						if (miss.currentGas == 20) {
							miss.matiMissile.setMatMove(0, 10, 0);
							miss.mullMat();
						}
						if(miss.currentGas>0)
							miss.currentGas--;
						if (miss.currentGas == 0) {
//							miss.matiMissile.setMatScale(
//									missile.missilebody.xReal[8],
//									missile.missilebody.yReal[8],
//									missile.missilebody.zReal[8], 0.5, 0.5, 0.5);
//							miss.mullMat();
							//missileList.remove(1);
							miss.exists=false;
							
								
						}

					}else
					{ 
						miss.waitTime--;
						if(miss.waitTime==0)
						{
							miss.currentGas=miss.gasTank;
							miss.speed=miss.origSpeed;
							miss.waitTime=miss.waitSet;
							miss.exists=true;

						}
					}
				}
				
			}
			tik++;
			
//			synchronized (object) 
//			{
//				for (Missile miss : missileList) 
//				{
//					if (miss.exists)
//					{ 
//						if(miss.currentGas>0)
//						miss.currentGas--;
//					}
//				}
//			}
//			pwx=pW.x/sum*speed;
//			pwy=pW.y/sum*speed;
//			pwz=pW.z/sum*speed;
			
//			pwx/=wSmall;
//			pwy/=wSmall;
//			pwz/=wSmall;
	

			
			repaint();
	    	hellicopter.mati.setIdentity();
	    	hellicopter.matiRotate.setIdentity();
	    	//for all missiles
	    	synchronized (object) 
	    	{
	    		for (Missile miss : missileList) 
	    		{ 
	    			if (miss.exists){ 	
	    				miss.matiMissile.setIdentity();
	    			}
	    		}
	    	}
	    	
  	
		}
		
		
		public void prepareToShowAndRepaintprop()
		{
			hellicopter.spinProp1(matiProp);
			repaint();
		}

		
}



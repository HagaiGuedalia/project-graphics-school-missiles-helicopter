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

// remove missiles after they die

public class MainPanel3DForStu extends JPanel
{
		Thread thread;
		Matrix3DForStu matiProp=new Matrix3DForStu();
		Matrix3DForStu matiFastMissile=new Matrix3DForStu();
	
		
		Point3D p00, p3, magoz, pfmT, pfmB, pfmF, pfW;
		double wSmall;
		double pfwx, pfwy, pfwz;
		double deathDistance=76;
		
		
		
		
		Hellicopter hellicopter, mabatHellicopter;
		Sevivon sevivon;
		Missile missile;
		Missile fastMissile;
		Font myFont=new Font("tahoma",Font.LAYOUT_LEFT_TO_RIGHT,15);
		Font death=new Font("tahoma",Font.LAYOUT_LEFT_TO_RIGHT,90);
		int minutes = 0;
		int miliSeconds = 0;
		int seconds = 0;
		Sevivon sevivon2;
		
		ArrayList<Missile>  missileList= new ArrayList<Missile>();  
		ArrayList<Missile>  mabatMissileList= new ArrayList<Missile>();  
		
		
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
			
			

			//missile.pW.setXYZ((p1.x+p2.x)/2-(missile.pmF.x), (p1.y+p2.y)/2-(missile.pmF.y), (p1.z+p2.z)/2-(missile.pmF.z));
//			
//			page.drawString("pmF.x  "+missile.pmF.x,10,50);
//			page.drawString("pwx  "+missile.pwx,250,100);
//			page.drawString("pwy  "+missile.pwy,250,130);
//			page.drawString("pwz  "+missile.pwz,250,160);
			
			page.drawString("Helli :  "+hellicopter.p1,550,100);
			page.drawString("tik  "+tik,550,130);
			page.drawString("pfwz  "+pfwz,550,160);
			
//			page.drawString("pW.x  "+missile.pW.x,50,100);
//			page.drawString("pW.y  "+missile.pW.y,50,130);
//			page.drawString("pW.z  "+missile.pW.z,50,160);
			
			for (Missile miss : missileList) 
			{	
				if(miss.currentGas <= miss.gasTank/4)
					page.drawString("gas < "+miss.gasTank/4,50,230);
			}
			

//			page.drawString("gasTank  "+ missile.gasTank,50,190);
//			page.drawString("gas  "+ missile.currentGas,50,210);

			page.drawString("time  "+minutes,300,50);
			page.drawString("        :"+seconds,305,50);
			page.drawString("           :"+miliSeconds,315,50);


			sevivon.fromPointToGuf();
			sevivon.convertAndShow(page);
			
			sevivon2.fromPointToGuf();
			sevivon2.convertAndShow(page);
			
			hellicopter.fromPointToGuf();
			hellicopter.convertAndShow(page);
			
			
			int ii=0;
			for (Missile miss : missileList) 
			{
			     miss.fromPointToGuf();
			     miss.convertAndShow(page);
			}
			for (Missile miss : mabatMissileList) 
			{
			   miss.copy(missileList.get(ii++));  
			   miss.matiMissile.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
			   miss.mullMat();
			}
			
			
			
			fastMissile.fromPointToGuf();
			fastMissile.convertAndShow(page);

			
			for (Missile miss : missileList) 
			{	
				if(miss.ifHit())
				{
					page.setFont(death);
					page.drawString("you blew up, bummer",50,550);
					
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
		//	mabatHellicopter.mat0i=mabatHellicopter.matiRotate;
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
			p3 = new Point3D();
			
			pfmB = new Point3D();
			pfmT = new Point3D();
			pfmF = new Point3D();
			pfW = new Point3D();

			magoz = new Point3D();		
//			p00.setXYZ(475, 300, 3000);
			p00.setXYZ(0, 0, 10000);
			

		    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
			
			
			magoz.setXYZ(d.getWidth()/2, d.getHeight()/3, 5000);
			
			
			hellicopter= new Hellicopter(magoz, this);
			mabatHellicopter= new Hellicopter(magoz, this);

			hellicopter.p1.setXYZ(p00.x, p00.y, p00.z);
			hellicopter.p2.setXYZ(p00.x, p00.y+150, p00.z);
			hellicopter.phB.setXYZ(p00.x-70*2.85/2-70/2+helliWidth*0.28, p00.y+helliWidth*1.2, p00.z);
			hellicopter.phF.setXYZ(p00.x-70*2.85/2-70/2+helliWidth*2.9, p00.y+helliWidth*1.2, p00.z);
			hellicopter.phC.setXYZ(hellicopter.phB.x+1.25*(hellicopter.phF.x-hellicopter.phB.x), hellicopter.phB.y+1.25*(hellicopter.phF.y-hellicopter.phB.y), hellicopter.phB.z+1.25*(hellicopter.phF.z-hellicopter.phB.z));
			hellicopter.phCenter.setXYZ((hellicopter.p1.x+hellicopter.p2.x)/2, (hellicopter.p1.y+hellicopter.p2.y)/2, (hellicopter.p1.z+hellicopter.p2.z)/2);
			
			fastMissile = new Missile(magoz, this);

			sevivon=new Sevivon(magoz);
			sevivon2=new Sevivon(magoz);
			
		//	sevivon.buildShape(pmT.x+2.5*35, pmT.y, pmT.z, 10);
			//sevivon2.buildShape(pmF.x,  pmF.y, pmF.z, 10);
			//sevivon.buildShape(p00.x-70*2.85/2-70/2+70*0.28, p00.y, p00.z, 100);
		
			hellicopter.buildShape(p00.x, p00.y, p00.z, helliWidth);
			
			//addNormalMissile(p00.x-900, p00.y+500, p00.z+1000);
			addFastMissile(p00.x+900, p00.y-500, p00.z-1000);
			//addNormalMissile(p00.x+900, p00.y-500, p00.z-1000);


			
//			missile = new Missile(magoz, this);
//			missile.color= Color.red;
//			missile.gasTank = 500;
//			missile.currentGas = missile.gasTank;
//			missile.buildShape(p00.x-900, p00.y-500, p00.z+1000, helliWidth/2.5, 0);
//			missile.rangeSpeedCallibrate(0.6, 50, 60);
//			mabatMissileList.add(missile);

			for (Missile miss : mabatMissileList) {
				miss.matiMissile.setMatRotateFixX(hellicopter.p1.z, hellicopter.p1.y, Math.PI/2);
			}

	
			
		}

		public void addMissile(double x, double y, double z, double width, Color color, int changeWidth, int gasTank, double randomRange, double speed, int callibrate) 
		{
			missile = new Missile(magoz, this);
			missile.color= color;
			missile.buildShape(x, y, z, width, changeWidth, randomRange, speed, callibrate);
			missile.gasTank = gasTank;
			missile.currentGas = missile.gasTank;
			missileList.add(missile);
			   
			missile = new Missile(magoz, this);
			missile.color= color;
			missile.buildShape(x, y, z, width, changeWidth, randomRange, speed, callibrate);
			missile.gasTank = gasTank;
			missile.currentGas = missile.gasTank;
			mabatMissileList.add(missile);

			//mabatMissileList.add(missile);
			
		}

		
		public void addNormalMissile(double x, double y, double z) 
		{
			addMissile(x, y, z, helliWidth/2.5, Color.gray, 0, 500, 0.6, 30, 60);
		}
	
		public void addFastMissile(double x, double y, double z) 
		{
			addMissile(x, y, z, helliWidth/2.5, Color.black, 20, 900, 0.7, 70, 80);
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
//				zTeta=Math.tan( ((p1.z+p2.z)/2-(pfmF.z))/((p1.x+p2.x)/2-(pfmF.x)) );
//				yTeta=Math.tan( ((p1.y+p2.y)/2-(pfmF.y))/((p1.x+p2.x)/2-(pfmF.x)) );
//
//				
//				matiMissile.setMatRotateFixZ(pmF.x, pmF.y ,zTeta);
//				prepareToShowAndRepaint();
//
//				matiMissile.setMatRotateFixY(pmF.x, pmF.z ,yTeta);
//
				explosion();
				prepareToShowAndRepaint();

				
//				hellicopter.mati.setIdentity();
//				matiMissile.setMatRotateFixZ(p00.x, p00.y, Math.PI/50);
//				prepareToShowAndRepaint();
//				matiMissile.setIdentity();
				break;

				
			case 'r':
			//	hellicopter.mati.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
				hellicopter.matiRotate.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
				for (Missile miss : missileList) 					
				{
					miss.matiMissile.setMatRotateFixY(hellicopter.hellibody.xReal[3], hellicopter.hellibody.zReal[3],Math.PI/20);
				}
//				for (Missile miss : mabatMissileList) 					
//				{
//					miss.matiMissile.setIdentity();
//				}
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
	    	for (Missile miss : missileList) 
			{	
	    		if(miss.isHIt(deathDistance))
	    			hit=true;
			}
	    	return hit;
	    	//return (Math.abs(missile.pW.x) <=deathDistance && Math.abs(missile.pW.y) <=deathDistance && Math.abs(missile.pW.z) <=deathDistance );

	    }
	    
	    int tik =0;
		double fastSum;
		double xTeta;
		double yTeta;
		double zTeta;

		
		
	    
		public void prepareToShowAndRepaint()
		{
//			sevivon.mullMat(mati);
//			sevivon2.mullMat(mati);
			
			if(tik % 300  == 0)
			{
				addNormalMissile(hellicopter.p1.x+500, hellicopter.p1.y+500, hellicopter.p1.z+500);
			}
			
			hellicopter.mullMat();
			
			for (Missile miss : missileList) 
			{	
			     miss.mullMat();	
			}

			
			
//			if(pW.x != 0)
//			{
//				if(pW.y != 0)
//				{
//					if(pW.z != 0)
//					{  // if none equal 0
//						wSmall=Math.min(Math.min (Math.abs(pW.x), Math.abs(pW.y)), Math.abs(pW.z));
//
//					}else{         // if only z equal 0
//						wSmall=Math.min(Math.abs(pW.x), Math.abs(pW.y));
//					}
//				}else{
//					if(pW.z != 0){  // if only y equal 0
//						wSmall=Math.min(Math.abs(pW.x), Math.abs(pW.z));
//					}else{         // if y and z equal 0
//						wSmall=pW.x;
//					}
//				}
//			}else{
//				if(pW.y != 0){
//					if(pW.z != 0){ // if only x equals 0
//						wSmall=Math.min(Math.abs(pW.y), Math.abs(pW.z));
//					}else{         //if x and z equal 0
//						wSmall = pW.y;
//					}
//				}else{             // if x and y equal 0 
//					if(pW.z != 0)
//						wSmall = pW.z;
//				}
//			}
			
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
			
			miliSeconds++;
			
			
			
			fastMissile.randomRange = 0.6;
			fastMissile.speed = 90;
			
			Random rand = new Random();

			
			
			//double  randomAccuracy = (rand.nextInt(20) + 90)/100;
			
			
			

//			double randomAccuracy;
//			int randomDirection;
			double fastrandomAccuracy;
			int fastrandomDirection;
			
			//missile.pW.setXYZ((p1.x+p2.x)/2-(missile.pmF.x), (p1.y+p2.y)/2-(missile.pmF.y), (p1.z+p2.z)/2-(missile.pmF.z));
			
			
			for (Missile miss : missileList) 
			{
				miss.calcDistanceW();
				miss.calcSum();
				miss.calcDirection(tik);
			}
			
			
			fastSum = Math.abs(pfW.x) + Math.abs(pfW.y) +Math.abs(pfW.z);

			
			/*
			* gas!!
			* 
			*  you can also add a random in so it wont know exact direction
			*  
			*		for different missile you can play with different variables; 	speed, accuracy, update frequency		    maybe 2 good 1 bad ||  1 good 2 bad  || 3 bad
			*			faster missile updates less,   
			*					
			*
			*	also penalize missile for turning, take off a bit of speed
			*	
			
			*
			*/
			
			
			
			for (Missile miss : missileList) 
			{
				if(miss.currentGas==20)
				{
					miss.matiMissile.setMatMove(0, 10, 0);
					miss.mullMat();
				}
				if(miss.currentGas==0)
				{
					miss.matiMissile.setMatScale(missile.missilebody.xReal[8], missile.missilebody.yReal[8], missile.missilebody.zReal[8], 0.5, 0.5, 0.5);
					miss.mullMat();
//					missileList.remove(miss);             
				}
			}

			tik++;
			
			
			for (Missile miss : missileList) 
			{
				if(miss.currentGas>0)
					miss.currentGas--;
			}
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
	    	for (Missile miss : missileList) 
			{	
			     miss.matiMissile.setIdentity();
			}
	    	
  	
		}
		
		
		public void prepareToShowAndRepaintprop()
		{
			hellicopter.spinProp1(matiProp);
			repaint();
		}

		
	}



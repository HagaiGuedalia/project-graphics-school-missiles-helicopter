import java.awt.Font;

/*
 * Created on Eiar 5767
 * @author levian
 * for Student
 */

public class Animation3DForStu extends Thread
{
	MainPanel3DForStu myPanel;

	public Animation3DForStu(MainPanel3DForStu myPanel)
	{
		this.myPanel=myPanel;
		setDaemon(true);
		start();
	}
	

	public void run()
	{
		double missileSpeed=1.6;
		double helliSpeed=1.26;

		int i;
		myPanel.hellicopter.mati.setIdentity();
		
		while(true){
			
			if(myPanel.isHIt())
			{
				//myPanel.explosion();
				myPanel.stopAnimation();
			}
			myPanel.spinProp();
			
					myPanel.hellicopter.mati.setIdentity();
					//for all missiles
					for (Missile miss : myPanel.missileList) {
						miss.matiMissile.setIdentity();
					}
			//myPanel.mati.setMatMove(10, 0, 0);
//			myPanel.phC.setXYZ(myPanel.phB.x+1.25*(myPanel.phF.x-myPanel.phB.x),
//					myPanel.phB.y+1.25*(myPanel.phF.y-myPanel.phB.y), myPanel.phB.z+1.25*(myPanel.phF.z-myPanel.phB.z));
			
			myPanel.hellicopter.phC.setXYZ(myPanel.hellicopter.phB.x+helliSpeed*(myPanel.hellicopter.phF.x-myPanel.hellicopter.phB.x), myPanel.hellicopter.phB.y+helliSpeed*(myPanel.hellicopter.phF.y-myPanel.hellicopter.phB.y), myPanel.hellicopter.phB.z+helliSpeed*(myPanel.hellicopter.phF.z-myPanel.hellicopter.phB.z));
			myPanel.move(myPanel.hellicopter.phC.x-myPanel.hellicopter.phF.x, myPanel.hellicopter.phC.y-myPanel.hellicopter.phF.y, myPanel.hellicopter.phC.z-myPanel.hellicopter.phF.z);
			
			//for all missiles
			for (Missile miss : myPanel.missileList) 
			{
				myPanel.moveAllMissiles(miss.pwx*missileSpeed, miss.pwy*missileSpeed, miss.pwz*missileSpeed, miss);
			}
			//myPanel.moveFastMissile(myPanel.pfwx*missileSpeed, myPanel.pfwy*missileSpeed, -myPanel.pfwz*missileSpeed);

	//		myPanel.moveMissile(myPanel.pwx*0.1, myPanel.pwy*0, myPanel.pwz*0);
						
			
						
			myPanel.prepareToShowAndRepaint();
			
			try
			{
			sleep(50);
			} catch(InterruptedException  e){}
		
			
			//myPanel.rotateXFix(p00.y, p00.z, teta);
			myPanel.prepareToShowAndRepaint();
			try
			{
			sleep(50);
			} catch(InterruptedException  e){}
		
		
		
		}
		
		
//		for (i=0;i<5;i++)
//		{
//			myPanel.rotateXFixUp(Math.PI/20);
//			myPanel.spinProp();
//			myPanel.prepareToShowAndRepaint();
//			try
//			{
//				sleep(200);
//			} catch(InterruptedException  e){}
//		
//		}
//		
		
//		while(true){
//			//myPanel.move(1, 0, 0);
//		//	myPanel.spinProp();
//			myPanel.prepareToShowAndRepaint();
//			try
//			{
//				sleep(200);
//			} catch(InterruptedException  e){}
//		}
		
		
//		while (true)
//		{
//			for (i=0;i<5;i++)
//				{
//					myPanel.rotateXFixUp(Math.PI/20);
//					myPanel.spinProp();
//					myPanel.prepareToShowAndRepaint();
//					try
//					{
//						sleep(200);
//					} catch(InterruptedException  e){}
//				
//				}
//			for (i=0;i<45;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.move(5,0,0);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			
//			for (i=0;i<5;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.rotateAxisRight(Math.PI/20);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<43;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.move(0,5,0);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<5;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.rotateAxisRight(Math.PI/20);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<90;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.move(-5,0,0);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<5;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.rotateAxisRight(Math.PI/20);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<45;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.move(0,-5,0);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<5;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.rotateAxisRight(Math.PI/20);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			for (i=0;i<45;i++)
//			{
//				
//				myPanel.spinProp();
//				myPanel.move(5,0,0);
//				myPanel.prepareToShowAndRepaint();
//				try
//				{
//					sleep(20);
//				} catch(InterruptedException  e){}
//			
//			}
//			
//		}
	}
	
}

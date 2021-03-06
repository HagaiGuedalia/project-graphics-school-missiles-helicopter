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
		double helliSpeed=1.7; // 1.26
		double missileSpeed=helliSpeed*2; //1.6     *1.26

		int i;
		myPanel.hellicopter.mati.setIdentity();
		
		while(true){
			
			if(myPanel.isHIt())
			{
				//myPanel.explosion();
				
				myPanel.stopAnimation();
			}
			myPanel.spinProp();
			myPanel.hellicopter.mullMat();
					myPanel.hellicopter.mati.setIdentity();
					//for all missiles
					synchronized (myPanel.object) 
					{
						for (Missile miss : myPanel.missileList) {
							if(miss.exists){
								miss.matiMissile.setIdentity();
								
							}
						}
					}
			//myPanel.mati.setMatMove(10, 0, 0);
//			myPanel.phC.setXYZ(myPanel.phB.x+1.25*(myPanel.phF.x-myPanel.phB.x),
//					myPanel.phB.y+1.25*(myPanel.phF.y-myPanel.phB.y), myPanel.phB.z+1.25*(myPanel.phF.z-myPanel.phB.z));
			
			myPanel.hellicopter.phC.setXYZ(myPanel.hellicopter.phB.x+helliSpeed*(myPanel.hellicopter.phF.x-myPanel.hellicopter.phB.x), myPanel.hellicopter.phB.y+helliSpeed*(myPanel.hellicopter.phF.y-myPanel.hellicopter.phB.y), myPanel.hellicopter.phB.z+helliSpeed*(myPanel.hellicopter.phF.z-myPanel.hellicopter.phB.z));
			myPanel.move(myPanel.hellicopter.phC.x-myPanel.hellicopter.phF.x, myPanel.hellicopter.phC.y-myPanel.hellicopter.phF.y, myPanel.hellicopter.phC.z-myPanel.hellicopter.phF.z);
			
			synchronized (myPanel.object) 
			{
				//for all missiles
				for (Missile miss : myPanel.missileList){
					if(miss.exists){
					myPanel.moveAllMissiles(miss.pwx * missileSpeed, miss.pwy
							* missileSpeed, miss.pwz * missileSpeed, miss);
					//myPanel.rotateMissile(miss);
					miss.mullMat();
//					miss.matiMissile.setMatRotateAxis(miss.pmMc.x, miss.pmMc.y, miss.pmMc.z,miss.pmF.x, miss.pmF.y, miss.pmF.z, Math.PI/10);
					miss.matiMissile.setMatRotateAxis(miss.pmMc.x, miss.pmMc.y, miss.pmMc.z,miss.pmF.x, miss.pmF.y, miss.pmF.z+0.0001, Math.PI/20);
					miss.mullMat();

					}
				}
			}
			

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
		
		

	}
	
}


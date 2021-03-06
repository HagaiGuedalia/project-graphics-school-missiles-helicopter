import java.awt.Graphics;



public class Hellicopter implements Comparable
{
	HelliBody hellibody;
	HelliTail hellitail;
	HelliStick helliStick;
	
	HelliProp helliprop1;
	HelliProp helliprop2;
	HelliProp helliprop3;
	HelliProp helliprop4;

	Matrix3DForStu mati; 

	MainPanel3DForStu mP;

	Point3D p1, p2, p3, phF, phB, phC, phCenter;

	public Hellicopter(Point3D magoz, MainPanel3DForStu myPanel) 
	{
		super();
		 hellibody=new HelliBody(magoz);
		 hellitail=new HelliTail(magoz);
		
		 helliStick=new HelliStick(magoz);
		 helliprop1=new HelliProp(magoz);
		 helliprop2=new HelliProp(magoz);
		 helliprop3=new HelliProp(magoz);
		 helliprop4=new HelliProp(magoz);
		 
		 mati=new Matrix3DForStu(); 
		 
		 p1 = new Point3D();
		 p2 = new Point3D();
		 phF = new Point3D();
		 phB = new Point3D();
		 phC = new Point3D();
		 phCenter = new Point3D();

		 mP= myPanel;
	}

	public void spinProp1(Matrix3DForStu matiProp) 
	{
		helliprop1.mullMat(matiProp);
		helliprop2.mullMat(matiProp);
		helliprop3.mullMat(matiProp);
		helliprop4.mullMat(matiProp);
		helliStick.mullMat(matiProp);
	}



	public void buildShape(double x, double y, double z, double dz)	
	{
		
		hellibody.buildShape(x-dz*2.85/2-dz/2, y, z-dz/2, dz);
		
		hellitail.buildShape(x-dz*2.85/2-dz/2, y, z-dz/2+dz/3, dz);
		
		
		
		helliStick.buildShape(x-dz/5/2, y+dz/2, (z-(dz/5)/2), dz/5);
		
		
		helliprop1.buildShape(x-dz/5/2, y+dz/2, (z-(dz/5)/2), dz/5);
		mati.setMatMove(dz/5, 0.0, 0.0);
		helliprop1.mullMat(mati);
		
		helliprop2.buildShape(x, y+dz/2, (z-(dz/5)/2)-dz/5/2, dz/5);
		mati.setMatRotateFixY(x, (z-(dz/5)/2), -Math.PI/2);
		helliprop2.mullMat(mati);
		
		helliprop3.buildShape(x+dz/5/2, y+dz/2, (z-(dz/5)/2), dz/5);
		mati.setMatMove(0.0, 0.0, -dz/5);
		helliprop3.mullMat(mati);
		mati.setMatRotateFixY(x, (z-(dz/5)/2), -Math.PI/2*2);
		helliprop3.mullMat(mati);
		
		helliprop4.buildShape(x, y+dz/2, (z-(dz/5)/2)+dz/5/2, dz/5);
		mati.setMatMove(dz/5, 0.0, -dz/5);
		helliprop4.mullMat(mati);
		mati.setMatRotateFixY(x, (z-(dz/5)/2), -Math.PI/2*3);
		helliprop4.mullMat(mati);
		
		//helliprop1.buildShape(x, y+dz*0.42, (z-(dz/5)/2), dz/5);
		
		

		 p1.setXYZ(mP.p00.x, mP.p00.y, mP.p00.z);
		 p2.setXYZ(mP.p00.x, mP.p00.y+150, mP.p00.z);
		 phB.setXYZ(mP.p00.x-70*2.85/2-70/2+mP.helliWidth*0.28, mP.p00.y+mP.helliWidth*1.2, mP.p00.z);
		 phF.setXYZ(mP.p00.x-70*2.85/2-70/2+mP.helliWidth*2.9, mP.p00.y+mP.helliWidth*1.2, mP.p00.z);
		 phC.setXYZ( phB.x+1.25*( phF.x- phB.x),  phB.y+1.25*( phF.y- phB.y),  phB.z+1.25*( phF.z- phB.z));
		 phCenter.setXYZ(( p1.x+ p2.x)/2, ( p1.y+ p2.y)/2, ( p1.z+ p2.z)/2);
	
	}




	public void fromPointToGuf()
	{
		hellibody.fromPointToGuf();
		hellitail.fromPointToGuf();
		helliStick.fromPointToGuf();
		helliprop1.fromPointToGuf();
		helliprop2.fromPointToGuf();
		helliprop3.fromPointToGuf();
		helliprop4.fromPointToGuf();

	}

	public void convertAndShow (Graphics page)
	{	
		
		
		if (helliStick.zReal[3]<helliStick.zReal[0]) 
		{
			propConvertAndShow(page);
			bodyConvertAndShow(page);

		}
		else{
			bodyConvertAndShow(page);
			propConvertAndShow(page);
			
		}
	}
	
	
	public void bodyConvertAndShow (Graphics page)
	{	
		
		if (hellitail.zReal[0]<hellibody.zReal[0]) 
		{
			hellibody.convertAndShow(page);
			hellitail.convertAndShow(page);
		}
		else{

			hellitail.convertAndShow(page);
			hellibody.convertAndShow(page);

		}

	}
	
	public void propConvertAndShow (Graphics page)
	{	
		
		if (helliStick.zReal[2]<helliprop1.zReal[0]) 
		{
			helliprop1.convertAndShow(page);
			helliprop2.convertAndShow(page);
			helliprop3.convertAndShow(page);
			helliprop4.convertAndShow(page);
			helliStick.convertAndShow(page);
		}
		else{

			helliStick.convertAndShow(page);
			helliprop1.convertAndShow(page);
			helliprop2.convertAndShow(page);
			helliprop3.convertAndShow(page);
			helliprop4.convertAndShow(page);

		}

	}
	
	public void copy(Hellicopter other)
    {
		hellibody.copy(other.hellibody);
    	helliStick.copy(other.helliStick);
    	hellitail.copy(other.hellitail);

    	helliprop1.copy(other.helliprop1);
    	helliprop2.copy(other.helliprop2);
    	helliprop3.copy(other.helliprop3);
    	helliprop4.copy(other.helliprop4);
    	
    	
    }
	
	
	
	public void mullMat(){
		hellibody.mullMat(mati);
		helliStick.mullMat(mati);
		hellitail.mullMat(mati);

		helliprop1.mullMat(mati);
		helliprop2.mullMat(mati);
		helliprop3.mullMat(mati);
		helliprop4.mullMat(mati);

		p1.mullMat(mati);
		p2.mullMat(mati);
		phB.mullMat(mati);
		phF.mullMat(mati);
		phC.mullMat(mati);
		phCenter.mullMat(mati);
	}	
		
	public double getMaxZ() 
	{
		double maxZ=hellibody.zReal[0];
		for (int i = 0; i < hellibody.zReal.length; i++) {
			if (hellibody.zReal[i]>maxZ)
				maxZ=hellibody.zReal[i];
		}		
		return maxZ;
	}

	@Override
	public int compareTo(Object other) 
	{
		if (other instanceof Missile)
		{
			if(getMaxZ()>((Missile)other).getMaxZ())
				return -1;
			else 
				return 1;
		}
		if (other instanceof Hellicopter)
		{
			if(getMaxZ()>((Hellicopter)other).getMaxZ())
				return -1;
			else 
				return 1;
		}
		
		return 0;
	}	




}
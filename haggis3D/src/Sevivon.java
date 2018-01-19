import java.awt.Graphics;



public class Sevivon
{
	Shape3D shape;
	Stick stick;
	

	public Sevivon(Point3D magoz) 
	{
		super();
		 shape=new Shape3D(magoz);
		 stick=new Stick(magoz);
	}

	public void buildShape(double x, double y, double z, double dz)	
	{
		shape.buildShape(x-dz/2, y, z-dz/2, dz);
		stick.buildShape(x-(dz/5)/2, y-(dz/5), (z-(dz/5)/2), (dz/5));
	}
	

	public void fromPointToGuf()
	{
		shape.fromPointToGuf();
		stick.fromPointToGuf();

	}

	public void convertAndShow (Graphics page)
	{
		if (stick.zReal[0]<stick.zReal[3]) 
		{
			shape.convertAndShow(page);
			stick.convertAndShow(page);
		}
		else{

			stick.convertAndShow(page);
			shape.convertAndShow(page);

		}

	}
	public void mullMat(Matrix3DForStu mati){
		shape.mullMat(mati);
		stick.mullMat(mati);
		
	}






}
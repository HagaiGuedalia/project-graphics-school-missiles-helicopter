/*
 * Created on Eiar 5767
 * update Tamuz 5771
 * @author levian
 * for Student
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class MainPanel2DForStu extends JPanel
{
	
	Thread thread;
//	Shape shape;
	Matrix2DForStu mati=new Matrix2DForStu();
	Matrix2DForStu mati1=new Matrix2DForStu();

	
	Shape arrShape[] = new Shape[1];
	
	
	public MainPanel2DForStu()
	{
		super();
	   	setBackground(Color.WHITE);
	   	
	   	
	   	for(int i=0; i<1; i++){
	   		arrShape[i]=new Shape();
		   	arrShape[i].buildShape(20+(i%4)*175, 20+(i/4)*200);
	   	}
	   	
	   	
	   
	   
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		for (Shape shape : arrShape) {
			shape.convertAndShow(page);
		}
		
		
	}
	
	
	public void move(int dx, int dy)
	{
		mati.setMatMove(dx,dy);
		mati1.setMatMove(dx,dy);
		prepareToShowAndRepaint();
	}
	
	public void rotate(double d)
	{
		mati.setMatRotate(d);
		mati1.setMatRotate(d);
		prepareToShowAndRepaint();
	}
	
	public void fix(double dx, double dy, double d){
		mati.setMatRotateFix(dx,dy,d);
		mati1.setMatRotateFix(dx,dy,d);
		prepareToShowAndRepaint();
		
	}
	public void scale(double dx, double dy, double sx, double sy){
		mati.setMatScale(dx,dy,sx, sy);
		mati1.setMatScale(dx,dy,sx, sy);
		prepareToShowAndRepaint();
		
	}
	
	
	public void moveLeft()
	{
		move(-20,0);
	}

	public void moveRight()
	{
		move(20,0);
	}
	public void moveUp()
	{
		move(0,-20);
	}
	public void moveDown()
	{
		move(0,20);
	}
	public void moveUpRight()
	{
		move(20,-20);
	}
	public void moveUpLeft()
	{
		move(-20,-20);
	}
	public void moveDownRight()
	{
		move(20,20);
	}
	public void moveDownleft()
	{
		move(-20,20);
	}
	
	public void RotateRight()
	{
		rotate(Math.PI/10);
	}
	
	public void RotateLeft()
	{
		rotate(-Math.PI/10);
	}
	
	public void RotateFixLeft()
	{
		fix(arrShape[1].xReal[0], arrShape[1].yReal[0], -Math.PI/10);
	}
	public void RotateFixRight()
	{
		fix(shape.xReal[0], shape.yReal[0], Math.PI/10);
	}
	public void smaller()
	{
		scale(shape.xReal[0], shape.yReal[0], 0.9, 0.9);
	}
	public void bigger()
	{
		scale(shape.xReal[0], shape.yReal[0], 1.1, 1.1);
	}
	
	
	
	
	
	public void run()
	{
		if (thread==null)
		  thread= new AnimationStu(this);
	}
	
	public void pause()
	{
		thread.suspend();
	}

	public void cont()
	{
		thread.resume();
	}

	public void stop()
	{
		mati.setIdentity();
		thread.stop();
		
		thread=null;
	}


	
	
	public void prepareToShowAndRepaint()
	{
		for (Shape shape : arrShape) {
			shape.mullMat(mati);
		}
		
		repaint();
	}
}

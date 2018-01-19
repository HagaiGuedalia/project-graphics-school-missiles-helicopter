/*
 * Created on Eiar 5767
 * update Tamuz 5771
 * @author levian
 * for Student
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

class BuildUI2DForStu extends JToolBar implements ActionListener
{
	MainPanel2DForStu mP;
	JButton up,down,left,right,rotateLeft,rotateRight;
	JButton rotateFixLeft,rotateFixRight;
	JButton upLeft,upRight,downLeft,downRight;
	JButton bigger,smaller;
	JButton run,pause,stop;
	
	enum state{READY,RUN, PAUSE, STOP}
    state matsav;

    public BuildUI2DForStu(MainPanel2DForStu m,String name)
	{
		super(name);
		mP=m;
		matsav=state.READY;
		left= new JButton(new ImageIcon("images/left.GIF"));
		left.setToolTipText("left (X axis)");
		left.addActionListener(this);
		add(left);

		right= new JButton(new ImageIcon("images/right.GIF"));
		right.addActionListener(this);
		right.setToolTipText("right (X axis)");
		add(right);
    
		up= new JButton(new ImageIcon("images/up.GIF"));
		right.setToolTipText("up (Y axis)");
		up.addActionListener(this);
		add(up);

		down= new JButton(new ImageIcon("images/down.GIF"));
		right.setToolTipText("dwon (Y axis)");
		down.addActionListener(this);
		add(down);

		rotateLeft= new JButton(new ImageIcon("images/rotateLeft.GIF"));
		rotateLeft.setToolTipText("rotate left");
		rotateLeft.addActionListener(this);
		add(rotateLeft);

		rotateRight= new JButton(new ImageIcon("images/rotateRight.GIF"));
		rotateRight.setToolTipText("rotate right");
		rotateRight.addActionListener(this);
		add(rotateRight);

		rotateFixLeft= new JButton(new ImageIcon("images/rotateFixLeft.GIF"));
		rotateFixLeft.addActionListener(this);
		add(rotateFixLeft);

		rotateFixRight= new JButton(new ImageIcon("images/rotateFixRight.GIF"));
		rotateFixRight.addActionListener(this);
		add(rotateFixRight);

		upLeft= new JButton(new ImageIcon("images/upLeft.GIF"));
		upLeft.addActionListener(this);
		add(upLeft);
		
		upRight= new JButton(new ImageIcon("images/upRight.GIF"));
		upRight.addActionListener(this);
		add(upRight);
				
		downLeft= new JButton(new ImageIcon("images/downLeft.GIF"));
		downLeft.addActionListener(this);
		add(downLeft);
		
		downRight= new JButton(new ImageIcon("images/downRight.GIF"));
		downRight.addActionListener(this);
		add(downRight);
				
		bigger= new JButton(new ImageIcon("images/bigger.GIF"));
		bigger.addActionListener(this);
		add(bigger);
				
		smaller= new JButton(new ImageIcon("images/smaller.GIF"));
		smaller.addActionListener(this);
		add(smaller);
				
		run= new JButton("Run");
		run.addActionListener(this);
		add(run);

		pause= new JButton("   Pause  ");
		pause.addActionListener(this);
		add(pause);

		stop= new JButton("Stop");
		stop.addActionListener(this);
		add(stop);
		
		pause.setEnabled(false);
		stop.setEnabled(false);
	}
	
	public void actionPerformed (ActionEvent event)
	{
		JButton now=(JButton)event.getSource();

		if (now==left)
			mP.moveLeft();
		else if (now==right)
			mP.moveRight();
		else if (now==up)
			mP.moveUp();
		else if (now==down)
			mP.moveDown();
		else if (now==upLeft)
			mP.moveUpLeft();
		else if (now==upRight)
			mP.moveUpRight();
		else if (now==downRight)
			mP.moveDownRight();
		else if (now==downLeft)
			mP.moveDownleft();
		else if (now==rotateLeft)
			mP.RotateLeft();
		else if (now==rotateRight)
			mP.RotateRight();
		else if (now==rotateFixLeft)
			mP.RotateFixLeft();
		else if (now==rotateFixRight)
			mP.RotateFixRight();
		else if (now==smaller)
			mP.smaller();
		else if (now==bigger)
			mP.bigger();
		
		else if (now==run)
		{
			matsav=state.RUN;
			run.setEnabled(false);
			pause.setEnabled(true);
			stop.setEnabled(true);
			mP.run();
		}
		else if (now==pause && matsav==state.RUN)
		{
			matsav=state.PAUSE;
			pause.setText("Continue");
			mP.pause();
		}
		else if (now==pause && matsav==state.PAUSE)
		{
			matsav=state.RUN;
			pause.setText("  Pause ");
			mP.cont();
		}
		else if (now==stop)
		{
			matsav=state.READY;
			run.setEnabled(true);
			pause.setText("   Pause  ");
			pause.setEnabled(false);
			stop.setEnabled(false);
			mP.stop();
		}
	}
}

/*
 * Created on Eiar 5767
 * update Tamuz 5769
 * @author levian
 * for Student
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class BiuldAndShowGUIStu extends JToolBar implements ActionListener ,KeyListener
{
	MainPanel3DForStu mP;

	JButton left,right,rotateXFixUp,rotateXFixDown;

	JButton up,down,rotateYFixLeft,rotateYFixRight;

	JButton forward,backward,rotateZFixFor,rotateZFixBack;
	
	JButton rotateAxisLeft,rotateAxisRight;

	JButton bigger,smaller;

	JButton run,pause,stop;

    enum state{READEY,RUN, PAUSE, STOP}
    state matsav;

    public BiuldAndShowGUIStu(MainPanel3DForStu m,String name)
	{
		super(name);
		mP=m;

		left= new JButton(new ImageIcon("images/left.GIF"));
		left.setToolTipText("left (X axis) 'a' ");
		left.addActionListener(this);
		left.addKeyListener( this);
		add(left);

		right= new JButton(new ImageIcon("images/right.GIF"));
		right.addActionListener(this);
		right.setToolTipText("right (X axis) 'd'");
		right.addKeyListener( this);
		add(right);

		rotateXFixUp= new JButton(new ImageIcon("images/rotateFixXup.GIF"));
		rotateXFixUp.addActionListener(this);
		rotateXFixUp.setToolTipText("Rotate Fix up  (X axis) 'z'");
		rotateXFixUp.addKeyListener( this);
		add(rotateXFixUp);

		rotateXFixDown= new JButton(new ImageIcon("images/rotateFixXdoun.GIF"));
		rotateXFixDown.addActionListener(this);
		rotateXFixDown.setToolTipText("Rotate Fix down (X axis) 'x'");
		rotateXFixDown.addKeyListener( this);
		add(rotateXFixDown);

		addSeparator() ;
   
		up= new JButton(new ImageIcon("images/up.GIF"));
		up.addActionListener(this);
		up.setToolTipText("up  (Y axis) 'w'");
		up.addKeyListener( this);
		add(up);

		down= new JButton(new ImageIcon("images/down.GIF"));
		down.addActionListener(this);
		down.setToolTipText("right (Y axis) 's'");
		down.addKeyListener( this);
		add(down);

		rotateYFixLeft= new JButton(new ImageIcon("images/rotateFixYLeft.GIF"));
		rotateYFixLeft.addActionListener(this);
		rotateYFixLeft.setToolTipText("Rotate Fix left (Y axis)  'c'");
		rotateYFixLeft.addKeyListener(this);
		add(rotateYFixLeft);

		rotateYFixRight= new JButton(new ImageIcon("images/rotateFixYRight.GIF"));
		rotateYFixRight.addActionListener(this);
		rotateYFixRight.setToolTipText("Rotate Fix right ( axis) 'v'");
		rotateYFixRight.addKeyListener( this);
		add(rotateYFixRight);
				
		addSeparator() ;

		forward= new JButton(new ImageIcon("images/Forword.GIF"));
		forward.addActionListener(this);
		forward.setToolTipText(" forward  (z axis) 'g'");
		forward.addKeyListener( this);
		add(forward);

		backward= new JButton(new ImageIcon("images/Back.GIF"));
		backward.addActionListener(this);
		backward.setToolTipText("backward (z axis) 'h'");
		backward.addKeyListener( this);
		add(backward);

		rotateZFixBack= new JButton(new ImageIcon("images/rotateFixLeft.GIF"));
		rotateZFixBack.addActionListener(this);
		rotateZFixBack.setToolTipText("Rotate Fix right (Z axis) 'n'");
		rotateZFixBack.addKeyListener( this);
		add(rotateZFixBack);

		rotateZFixFor= new JButton(new ImageIcon("images/rotateFixRight.GIF"));
		rotateZFixFor.addActionListener(this);
		rotateZFixFor.setToolTipText("Rotate Fix left (Z axis)  'b'");
		rotateZFixFor.addKeyListener( this);
		add(rotateZFixFor);

		
		addSeparator() ;

		rotateAxisLeft= new JButton(new ImageIcon("images/rotateAxisLeft.GIF"));
		rotateAxisLeft.addActionListener(this);
		rotateAxisLeft.setToolTipText("Rotate axis right ( two points) 'm'");
		rotateAxisLeft.addKeyListener( this);
		add(rotateAxisLeft);
		
		rotateAxisRight= new JButton(new ImageIcon("images/rotateAxisRight.GIF"));
		rotateAxisRight.addActionListener(this);
		rotateAxisRight.setToolTipText("Rotate axis left ( two points) ','");
		rotateAxisRight.addKeyListener( this);
		add(rotateAxisRight);
				
		addSeparator() ;
		
		bigger= new JButton(new ImageIcon("images/bigger.GIF"));;
		bigger.addActionListener(this);
		bigger.setToolTipText(" bigger 'o'");
		bigger.addKeyListener( this);
		add(bigger);
		
		smaller= new JButton(new ImageIcon("images/smaller.GIF"));;
		smaller.addActionListener(this);
		smaller.setToolTipText(" smaller 'p'");
		smaller.addKeyListener( this);
		add(smaller);

		addSeparator() ;

		run= new JButton("Run");
		run.addActionListener(this);
		add(run); 

		pause= new JButton("Pause");
		pause.addActionListener(this);
		pause.setEnabled(false);
		add(pause); 

		stop= new JButton("Stop");
		stop.addActionListener(this);
		stop.setEnabled(false);
		add(stop); 
		

	}
	
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		switch (ch)
		{
		case 'a':
			left.doClick() ;
			break;

		case 'd':
			right.doClick() ;
            break;
            
		case 'z':
			rotateXFixUp.doClick() ;
			break;

		case 'x':
			rotateXFixDown.doClick() ;
			break;

		case 'w':
			up.doClick() ;
			break;

		case 's':
			down.doClick() ;
            break;
            
		case 'c':
			rotateYFixLeft.doClick() ;
			break;

		case 'v':
			rotateYFixRight.doClick() ;
			break;

		case 'g':
			forward.doClick() ;
			break;

		case 'h':
			backward.doClick() ;
            break;
            
		case 'b':
			rotateZFixFor.doClick() ;
			break;

		case 'n':
			rotateZFixBack.doClick() ;
			break;

		case 'm':
			rotateAxisLeft.doClick() ;
			break;

		case ',':
			rotateAxisRight.doClick() ;
			break;

		case 'o':
			bigger.doClick() ;
			break;

		case 'p':
			smaller.doClick() ;
			break;
		//	
		case 'j':
			mP.moveAni('j');
			break;

		case 'l':
			mP.moveAni('l');
			break;
			
		case 'i':
			mP.moveAni('i');
			break;

		case 'k':
			mP.moveAni('k');
			break;

		case 'r':
			mP.moveAni('r');
			break;
		
		case 'q':
			mP.moveAni('q');
			break;
			
		default:
			break;
		}
	}
	

	public void actionPerformed (ActionEvent event)
	{
		JButton now=(JButton)event.getSource();

		if (now==left)
			 mP.moveLeft();
		else if (now==right)
			mP.moveRight();
		else if (now==rotateXFixUp)
			mP.rotateXFixUp();
		else if (now==rotateXFixDown)
			mP.rotateXFixDown();
		else if (now==up)
			mP.moveUp();
		else if (now==down)
			mP.moveDown();
		else if (now==rotateYFixLeft)
			mP.rotateYFixLeft();
		else if (now==rotateYFixRight)
			mP.rotateYFixRight();
		else if (now==forward)
			mP.moveForward();
		else if (now==backward)
			mP.moveBackward();
		else if (now==rotateZFixFor)
			mP.rotateZFixClock();
		else if (now==rotateZFixBack)
			mP.rotateZFixQounter();
		else if (now==rotateAxisLeft)
			mP.rotateAxisLeft();
		else if (now==rotateAxisRight)
			mP.rotateAxisRight();
		
		else if (now==bigger)
			mP.bigger();
		else if (now==smaller)
			mP.smaller();
		
		
		else if (now==run)
		{
			matsav=state.RUN;
			run.setEnabled(false);
			pause.setEnabled(true);
			stop.setEnabled(true);
			mP.startAnimaition();
		}
		else if (now==pause && matsav==state.RUN)
		{
			matsav=state.PAUSE;
			pause.setText("continue");
			mP.suspendAnimation();
		}
		else if (now==pause && matsav==state.PAUSE)
		{
			matsav=state.RUN;
			pause.setText("  pause ");
			mP.resumeAnimation();
		}
		else if (now==stop)
		{
			matsav=state.READEY;
			run.setEnabled(true);
			pause.setText("  pause ");
			pause.setEnabled(false);
			stop.setEnabled(false);
			mP.stopAnimation();
		}
	}

	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	
	
}

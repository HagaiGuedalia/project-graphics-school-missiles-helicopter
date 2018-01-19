/*
 * Created on Eiar 5767
 * update Tamuz 5769
 * @author levian
 */

public class AnimationStu extends Thread 
{
	MainPanel2DForStu myPanel;

	public AnimationStu(MainPanel2DForStu myPanel)
	{
		this.myPanel=myPanel;
		setDaemon(true);
		start();
	}
	
	public void run()
	{
		int i;
		for (;;)
		{
			myPanel.moveRight();
			for (i=0;i<25;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(20);
				} catch(InterruptedException  e){}
			}
			myPanel.moveDown();
			for (i=0;i<23;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
			}
			myPanel.fix((myPanel.shape.xReal[2]+myPanel.shape.xReal[4])/2, (myPanel.shape.yReal[2]+myPanel.shape.yReal[4])/2, -Math.PI/10);
			for (i=0;i<59;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(10);
				} catch(InterruptedException  e){}
			}
			for(i=0;i<12;i++)
			{
				myPanel.moveUpLeft();
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}

				
				myPanel.fix((myPanel.shape.xReal[2]+myPanel.shape.xReal[4])/2, (myPanel.shape.yReal[2]+myPanel.shape.yReal[4])/2, -Math.PI/10);
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
				
				
				myPanel.scale(myPanel.shape.xReal[0], myPanel.shape.yReal[0], 1.01, 1.01);
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
								
			}
			
			myPanel.fix((myPanel.shape.xReal[2]+myPanel.shape.xReal[4])/2, (myPanel.shape.yReal[2]+myPanel.shape.yReal[4])/2, Math.PI/10);
			for (i=0;i<3;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
			}
			myPanel.moveLeft();
			for (i=0;i<0;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
			}
			myPanel.moveDown();
			for (i=0;i<0;i++)
			{
				myPanel.prepareToShowAndRepaint();
				try
				{
					sleep(30);
				} catch(InterruptedException  e){}
			}
			//break;
		}
		
	}

	private Object i(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}

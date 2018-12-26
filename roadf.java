import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class roadf extends JApplet implements KeyListener,Runnable,ActionListener
{
	Random ar = new Random();
	
	Icon topimg = new ImageIcon("top.gif");
	JLabel top = new JLabel(topimg);
	/*Icon midtopimg = new ImageIcon("midtop.gif");
	JLabel midtop = new JLabel(midtopimg);
	Icon scoreimg = new ImageIcon("score.gif");
	JLabel score = new JLabel(scoreimg);
	Icon pauseimg = new ImageIcon("pause.gif");
	JLabel pause = new JLabel(pauseimg);
	Icon levelimg = new ImageIcon("level.gif");
	JLabel level = new JLabel(levelimg);
	Icon deveimg = new ImageIcon("developer.gif");
	JLabel developer = new JLabel(deveimg);*/
	Icon botimg = new ImageIcon("bot.gif");
	JLabel bottom = new JLabel(botimg);
	
	Icon uimg = new ImageIcon("u.jpg");
	JButton u = new JButton(uimg);
	
	
	Icon mikimg = new ImageIcon("mike.jpg");
	JLabel mike[];
	Icon mojimg = new ImageIcon("mojo.jpg");
	JLabel mojo = new JLabel(mojimg);
	Icon oshimg = new ImageIcon("osho.jpg");
	JLabel osho = new JLabel(oshimg);
	
	JPanel p1 = new JPanel();
	
	char hitmiss;
	int x = 108;
	int y = 350;
	int w = 36;
	int h = 50;
	
	int mx = 108;
	int my = 0;
	int mw = 36;
	int mh = 50;
	int mx2 = 150;
	int my2 = -200;
	int mw2 = 36;
	int mh2 = 50;
	
	int level = 1;
	
	Thread th = new Thread(this);
	
	int levelcola = 255;
	int levelcolb = 255;
	int levelcolc = 255;
	
	int scrs=0;
	int scheck = 0;
	
	int chance = 3;
	
	JLabel lev = new JLabel("Level : "+level);
	JLabel scr = new JLabel("Score : "+scrs);
	JLabel ch = new JLabel("Chances : "+chance);
	
	int speed = 1000;
	
	
	JButton dev1 = new JButton("MAKER ?");
	JButton rules = new JButton("RULES");
	
	public void run()
	{
		int leveldude = 0;
		while ( true )
		{
			checkl();
			levelal1();
		}
	}
	
	public void checkl()
	{
		if ( scrs == (scheck + 10))
		{
			level++;
			
			do
			{
			levelcola = ar.nextInt(levelcola);
			levelcolb = ar.nextInt(levelcolb);
			levelcolc = ar.nextInt(levelcolc);
			}while(levelcola < 0 && levelcola > 255 || levelcolb < 0 && levelcolb > 255 || levelcolc < 0 && levelcolc > 255 );
			
			
			lev.setForeground(new Color(levelcola,levelcolb,levelcolc));
			scr.setForeground(new Color(levelcola,levelcolb,levelcolc));
			lev.setText("Level : "+(level));
			scheck=scheck+5;
			speed = speed - 100;
			int cfg = 1;
			while ( cfg == 1 )
			{
			if ( mike[0].getIcon() == mikimg )
			{
				mike[0].setIcon(mojimg);
				mike[1].setIcon(mojimg);
				break;
			}
			if ( mike[0].getIcon() == mojimg )
			{
				mike[0].setIcon(oshimg);
				mike[1].setIcon(oshimg);
				break;
			}
			if ( mike[0].getIcon() == oshimg )
			{
				mike[0].setIcon(mikimg);
				mike[1].setIcon(mikimg);
				break;
			}
			}
			
		}
	}
	
	public void levelal1()
	{
		if ( my == 350 )
		{
			mike[0].setBounds(108,my,mw,mh);
			hitmiss = checkCol();
			if ( hitmiss == 'h' )
			{
				//sleepdoz(100);
				//my = 0;
				//mike[0].setBounds(108,my,mw,mh);
			}
			else
			{
				sleepdoz(100);
				my = 0;
				mike[0].setBounds(108,my,mw,mh);
			}
		}
		mike[0].setBounds(108,my,mw,mh);
		sleepdoz(speed);
		my = my + 50;
		
		if ( my2 == 350 )
		{
			mike[1].setBounds(150,my2,mw2,mh2);
			hitmiss = checkCol();
			if ( hitmiss == 'h' )
			{
				//sleepdoz(100);
				//my2 = 0;
				//mike[1].setBounds(150,my2,mw2,mh2);
			}
			else
			{
				sleepdoz(100);
				my2 = 0;
				mike[1].setBounds(150,my2,mw2,mh2);
			}
		}
		mike[1].setBounds(150,my2,mw2,mh2);
		if ( my2 >= 0 )
		{
			sleepdoz(speed);
		}
		my2 = my2 + 50;
		
	}
	
	public char checkCol()
	{
		if ( mike[0].getY() == y && mike[0].getX() == x || mike[1].getY() == y && mike[1].getX() == x )
		{
			chance--;
			if ( chance == 0 )
			{
				JOptionPane.showMessageDialog(null,"YOUR CHANCES ARE OVER" + "\n" + "RESTARTING GAME !");
				restart();
			}
			else
			{
			ch.setText("");
			ch.setText("Chances : "+chance);
			JOptionPane.showMessageDialog(null,"HIT");
			restartch();
			}
			return 'h';
		}
		else
		{
			scr.setText("");
			scr.setText("Score : "+(++scrs));
			return 'm';
		}
	}
	
	
	public void sleepdoz(int howmuch)
	{
		try
		{
			th.sleep(howmuch);
		}catch(Exception e){}
	}
	
	public void mikearr()
	{
		mike = new JLabel[2];
			
		for(int ctr=0;ctr<2;ctr++)
		{
			mike[ctr] = new JLabel(mikimg);
		}
	}
	
	public void restartch()
	{
		
			mx = 108;
			my = 0;
			mw = 36;
			mh = 50;
			mx2 = 150;
			my2 = -200;
			mw2 = 36;
			mh2 = 50;
			mike[0].setBounds(mx,my,mh,mw);
			mike[1].setBounds(mx2,my2,mh2,mw2);
			
			//scrs = 0;
			//level = 1;
		
	}
	
	public void restart()
	{
		
			mx = 108;
			my = 0;
			mw = 36;
			mh = 50;
			mx2 = 150;
			my2 = -200;
			mw2 = 36;
			mh2 = 50;
			mike[0].setBounds(mx,my,mh,mw);
			mike[1].setBounds(mx2,my2,mh2,mw2);
			mike[0].setIcon(mikimg);
			mike[1].setIcon(mikimg);
			
			level=1;
			lev.setText("");
			lev.setText("Level : "+level);
			scrs=0;
			scr.setText("");
			scr.setText("Score : "+scrs);
			
			chance=3;
			ch.setText("");
			ch.setText("Chances : "+chance);
			
			levelcola=0;
			levelcolb=0;
			levelcolc=0;
			lev.setForeground(new Color(levelcola,levelcolb,levelcolc));
			scr.setForeground(new Color(levelcola,levelcolb,levelcolc));
			
			speed=1000;
	}
	
	public void init()
	{
		getContentPane().add(p1);
		
		p1.setBackground(new Color(levelcola,levelcolb,levelcolc));
		
		p1.add(top);
		/*p1.add(midtop);
		p1.add(score);
		p1.add(pause);
		p1.add(level);
		p1.add(developer);*/
		p1.add(bottom);
		p1.add(u);
		p1.add(lev);
		p1.add(scr);
		p1.add(ch);
		p1.add(dev1);
		p1.add(rules);
		
		p1.setLayout(null);
		
		top.setBounds(0,0,94,72);
		/*midtop.setBounds(0,72,94,38);
		score.setBounds(0,110,94,21);
		pause.setBounds(0,131,94,21);
		level.setBounds(0,152,94,22);
		developer.setBounds(0,174,94,22);*/
		bottom.setBounds(0,72,94,204);
		lev.setBounds(0,286,94,20);
		scr.setBounds(0,306,94,20);
		ch.setBounds(0,326,94,20);
		dev1.setBounds(0,346,94,20);
		rules.setBounds(0,366,94,20);
		
		dev1.addActionListener(this);
		rules.addActionListener(this);
		
		
		u.setBounds(x,y,w,h);
		mikearr();
		p1.add(mike[0]);
		mike[0].setBounds(108,my,mw,mh);
		p1.add(mike[1]);
		mike[1].setBounds(150,my2,mw2,mh2);
		
		
		u.setBorderPainted(false);
		u.addKeyListener(this);
		u.setFocusPainted(true);
		
		
		
		th.start();
	}
	
	public void keyTyped(KeyEvent e)
	{
		if (e.getKeyChar() == ' ')
		{
				if ( x == 108 )
				{
					x=150;
					u.setBounds(x,y,w,h);
				}
				else
				{
					x = 108;
					u.setBounds(x,y,w,h);
				}
		}
	}
	public void keyPressed(KeyEvent e)
	{}
	public void keyReleased(KeyEvent e)
	{}
	
	public void setg()
	{
		u.requestFocus();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == rules)
		{
			th.suspend();
			JOptionPane.showMessageDialog(null,"THE ORANGE PLANE ON THE LOWER CORNER IS YOU"+"\n"+"MOJO,OSHO AND MIKE ARE THE OPPONENTS"+"\n"+"CLICK ON THE 'SPACEBAR' KEY"+"\n"+"YOU WILL SEE THAT THE ORANGE PLANE WILL MOVE"+"\n"+"JUST KEEP DODGING THE OPPONENTS"+"\n"+"KEEP INCREASING YOUR SCORE AND LEVELS"+"\n"+"REMEBER THIS GAME IS NEVER ENDING .. "+"\n"+"YOU WILL KEEP GETTING NEWER LEVELS EVERY TIME YOU CROSS 10 POINTS"+"\n"+"\n"+"ENJOY !!!!!");
			setg();
			th.resume();
		}
		if (e.getSource() == dev1)
		{
			th.suspend();
			JOptionPane.showMessageDialog(null,"NEVILLE MEHTA"+"\n"+"NIIT"+"\n"+"neville2150895@hotmail.com");
			setg();
			th.resume();
		}
	}
}

//<applet code="roadf.java" height=400 width=196></applet>
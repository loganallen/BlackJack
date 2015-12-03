import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Table extends JFrame implements MouseListener
{
	private BufferedImage buffered;
	private ArrayList<Card> deck;
	private Font font = new Font("Serif", Font.PLAIN, 50);
	private Font fontd = new Font("Serif", Font.PLAIN, 40);
	private Font f = new Font("Ariel", Font.BOLD, 100);
	private Font font2 = new Font("Serif", Font.PLAIN, 50);
	private Font font3 = new Font("Serif", Font.BOLD, 35);
	private int sum=0;
	private int sum2=0;
	private Image coinImage;
	private Image treasureImage;
	private Image suitsImage;
	private Image saucerImage;
	private Image feltImage;
	int m1=0;
	int m2=0;
	private int c,d,dy;
	private int card1,card2,card3,card4,card5;
	private int dealer1,dealer2,dealer3,dealer4,dealer5;
	boolean deal1 = false;
	boolean deal2 = false;
	boolean deal3 = false;
	boolean dealHit1 = false;
	boolean dealHit2 = false;
	boolean dealHit3 = false;
	boolean draw = false;
	boolean win = false;
	boolean lose = false;
	boolean blackjack = false;
	boolean reveal = false;
	boolean betting = true;
	boolean play;
	private boolean deal;
	private Graphics windowTemp;
	private int hit = 0;
	private int dd = 0;
	private int bj = -30;
	private int bust = -30;
	private int score = 75;
	private int tie = -30;
	private int w = -30;
	private int l = -30;
	private int gm = -30;
	private int bet;
	private int a,b;
	private int col;
	private int height;
	
	
	private Color green = new Color(0,180,0);

	public Table()
	{
		//sets bar name!! so cool
		super("BlackJack");
		addMouseListener(this);
		
		deck = new ArrayList<Card>();
		coinImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/coin.png"));
		treasureImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/treasure.png"));
		suitsImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/suits.png"));
		saucerImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/saucer.png"));
		feltImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/table.png"));
		
		this.play=false;
		this.bet=5;
		
		this.card1 = (int)(Math.random()*52);
		this.card2 = (int)(Math.random()*52);
		while(card2==card1)
		{
			card2 = (int)(Math.random()*52);
		}
		this.card3 = (int)(Math.random()*52);
		while(card3==card1||card3==card2)
		{
			card3 = (int)(Math.random()*52);
		}
		this.card4 = (int)(Math.random()*52);
		while(card4==card1||card4==card2||card4==card3)
		{
			card4 = (int)(Math.random()*52);
		}
		this.card5 = (int)(Math.random()*52);
		while(card5==card1||card5==card2||card5==card3||card5==card4)
		{
			card5 = (int)(Math.random()*52);
		}
		
		this.dealer1 = (int)(Math.random()*52);
		this.dealer2 = (int)(Math.random()*52);
		while(dealer2==dealer1)
		{
			dealer2 = (int)(Math.random()*52);
		}
		this.dealer3 = (int)(Math.random()*52);
		while(dealer3==dealer1||dealer3==dealer2)
		{
			dealer3 = (int)(Math.random()*52);
		}
		this.dealer4 = (int)(Math.random()*52);
		while(dealer4==dealer1||dealer4==dealer2||dealer4==dealer3)
		{
			dealer4 = (int)(Math.random()*52);
		}
		this.dealer5 = (int)(Math.random()*52);
		while(dealer5==dealer1||dealer5==dealer2||dealer5==dealer3||dealer5==dealer4)
		{
			dealer5 = (int)(Math.random()*52);
		}
		
		
		//hearts
		//index = 0
		deck.add(new Card(2, "two", "hearts"));
		deck.add(new Card(3, "three", "hearts"));
		deck.add(new Card(4, "four", "hearts"));
		deck.add(new Card(5, "five", "hearts"));
		deck.add(new Card(6, "six", "hearts"));
		deck.add(new Card(7, "seven", "hearts"));
		deck.add(new Card(8, "eight", "hearts"));
		deck.add(new Card(9, "nine", "hearts"));
		deck.add(new Card(10, "ten", "hearts"));
		deck.add(new Card(10, "jack", "hearts"));
		deck.add(new Card(10, "queen", "hearts"));
		deck.add(new Card(10, "king", "hearts"));
		deck.add(new Card(11, "ace", "hearts"));
		//spades
		//index = 13
		deck.add(new Card(2, "two", "spades"));
		deck.add(new Card(3, "three", "spades"));
		deck.add(new Card(4, "four", "spades"));
		deck.add(new Card(5, "five", "spades"));
		deck.add(new Card(6, "six", "spades"));
		deck.add(new Card(7, "seven", "spades"));
		deck.add(new Card(8, "eight", "spades"));
		deck.add(new Card(9, "nine", "spades"));
		deck.add(new Card(10, "ten", "spades"));
		deck.add(new Card(10, "jack", "spades"));
		deck.add(new Card(10, "queen", "spades"));
		deck.add(new Card(10, "king", "spades"));
		deck.add(new Card(11, "ace", "spades"));
		//diamonds
		//index = 26
		deck.add(new Card(2, "two", "diamonds"));
		deck.add(new Card(3, "three", "diamonds"));
		deck.add(new Card(4, "four", "diamonds"));
		deck.add(new Card(5, "five", "diamonds"));
		deck.add(new Card(6, "six", "diamonds"));
		deck.add(new Card(7, "seven", "diamonds"));
		deck.add(new Card(8, "eight", "diamonds"));
		deck.add(new Card(9, "nine", "diamonds"));
		deck.add(new Card(10, "ten", "diamonds"));
		deck.add(new Card(10, "jack", "diamonds"));
		deck.add(new Card(10, "queen", "diamonds"));
		deck.add(new Card(10, "king", "diamonds"));
		deck.add(new Card(11, "ace", "diamonds"));
		//clubs
		//index = 39
		deck.add(new Card(2, "two", "clubs"));
		deck.add(new Card(3, "three", "clubs"));
		deck.add(new Card(4, "four", "clubs"));
		deck.add(new Card(5, "five", "clubs"));
		deck.add(new Card(6, "six", "clubs"));
		deck.add(new Card(7, "seven", "clubs"));
		deck.add(new Card(8, "eight", "clubs"));
		deck.add(new Card(9, "nine", "clubs"));
		deck.add(new Card(10, "ten", "clubs"));
		deck.add(new Card(10, "jack", "clubs"));
		deck.add(new Card(10, "queen", "clubs"));
		deck.add(new Card(10, "king", "clubs"));
		deck.add(new Card(11, "ace", "clubs")); //index 51 (cuz start at 0)
		
		this.playSound();
		
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void sum()
	{
		sum = deck.get(card1).getValue() + deck.get(card2).getValue();
	}
	public void addtosum(int num)
	{
		sum+=deck.get(num).getValue();
	}
	public void sum2()
	{
		sum2 = deck.get(dealer1).getValue() + deck.get(dealer2).getValue();
	}
	public void addtosum2(int num)
	{
		sum2+=deck.get(num).getValue();
	}
	
	public void paint(Graphics window)
	{
		//Create a buffered Image
		if(buffered==null)
		   buffered = (BufferedImage)(createImage(getWidth(),getHeight()));

		windowTemp = buffered.createGraphics();

		windowTemp.setColor(green);
		windowTemp.fillRect(0,0,getWidth(),getHeight());
		
		//draw background
		windowTemp.drawImage(feltImage,0,0,this);
		
		//draw suits
		windowTemp.drawImage(suitsImage,433,50,this);
		
		//draw saucer
		windowTemp.drawImage(saucerImage,560,520,this);
		
		//betting coins
		a=575;
		b=492;
		col=1;
		height=0;
		for(int i=0; i<bet; i++)
		{
			if(col==4)
				a=626;
			windowTemp.drawImage(coinImage,a,b,this);
			b-=11;
			height++;
			if(height==22)
			{
				a-=65;
				b=514;
				height=0;
				col++;
			}
		}
		
		//draw coins
		int x4=62;
		int y4=520;
		for(int i=0; i<28; i++)
		{
			windowTemp.drawImage(coinImage,x4,y4,this);
			y4-=10;
		}
		int x2=160;
		int y2=420;
		for(int i=0; i<11; i++)
		{
			windowTemp.drawImage(coinImage,x2,y2,this);
			y2-=10;
		}
		int x5=40;
		int y5=520;
		for(int i=0; i<10; i++)
		{
			windowTemp.drawImage(coinImage,x5,y5,this);
			y5-=10;
		}
		int x=100;
		int y=520;
		for(int i=0; i<20; i++)
		{
			windowTemp.drawImage(coinImage,x,y,this);
			y-=10;
		}
		int x7=270;
		int y7=520;
		for(int i=0; i<10; i++)
		{
			windowTemp.drawImage(coinImage,x7,y7,this);
			y7-=10;
		}
		int x3=200;
		int y3=520;
		for(int i=0; i<20; i++)
		{
			windowTemp.drawImage(coinImage,x3,y3,this);
			y3-=10;
		}
		int x1=150;
		int y1=520;
		for(int i=0; i<12; i++)
		{
			windowTemp.drawImage(coinImage,x1,y1,this);
			y1-=10;
		}
		int x6=250;
		int y6=520;
		for(int i=0; i<7; i++)
		{
			windowTemp.drawImage(coinImage,x6,y6,this);
			y6-=10;
		}
		int x9=841;
		int y9=520;
		for(int i=0; i<16; i++)
		{
			windowTemp.drawImage(coinImage,x9,y9,this);
			y9-=10;
		}
		int x8=780;
		int y8=520;
		for(int i=0; i<8; i++)
		{
			windowTemp.drawImage(coinImage,x8,y8,this);
			y8-=10;
		}
		int x10=884;
		int y10=520;
		for(int i=0; i<5; i++)
		{
			windowTemp.drawImage(coinImage,x10,y10,this);
			y10-=10;
		}
		
		

		//deal button
		windowTemp.setColor(Color.blue);
		windowTemp.fillRect(815,355,120,65);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(815,355,120,65);
		windowTemp.setColor(Color.white);
		windowTemp.setFont(font2);
		windowTemp.drawString("Deal",830,403);
		
		
		//hit button
		windowTemp.setColor(Color.blue);
		windowTemp.fillRect(700,355,90,65);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(700,355,90,65);
		windowTemp.setColor(Color.white);
		windowTemp.setFont(font2);
		windowTemp.drawString("Hit",715,403);
		
		//stand button
		windowTemp.setColor(Color.blue);
		windowTemp.fillRect(700,435,140,65);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(700,435,140,65);
		windowTemp.setColor(Color.white);
		windowTemp.setFont(font2);
		windowTemp.drawString("Stand",715,483);
		
		//quit
		windowTemp.setColor(Color.blue);
		windowTemp.fillRect(700,515,120,65);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(700,515,120,65);
		windowTemp.setColor(Color.white);
		windowTemp.setFont(font2);
		windowTemp.drawString("Quit",715,563);
		
		int cc = 95;
		windowTemp.setColor(Color.white);
		windowTemp.drawRect(cc,95,130,160);
		windowTemp.drawRect(cc+140,95,130,160);
		windowTemp.drawRect(cc+280,95,130,160);
		windowTemp.drawRect(cc+420,95,130,160);
		windowTemp.drawRect(cc+560,95,130,160);
		
		if(play==true)
		{
			c = 100;
			deck.get(card1).drawMe(windowTemp,c,100,this);
			deck.get(card2).drawMe(windowTemp,c+140,100,this);
			sum();
			
			d = 250;
			dy = 480;
			deck.get(dealer1).drawMe(windowTemp,d,dy,this);
			if(reveal==false)
			{
				windowTemp.setColor(Color.white);
				windowTemp.fillRect(250,480,100,120);
				windowTemp.setColor(Color.black);
				windowTemp.drawRect(250,480,100,120);
				windowTemp.setColor(Color.red);
				windowTemp.fillRect(265,495,70,100);
			}
			deck.get(dealer2).drawMe(windowTemp,d+80,dy-7,this);
			sum2();
			
			
			if(hit==1)
			{
				deal1 = true;
			}
			if(deal1==true)
			{
				deck.get(card3).drawMe(windowTemp,c+280,100,this);
				addtosum(card3);
				repaint();
			}
			if(hit==2)
			{
				deal2 = true;
			}
			if(deal2==true)
			{
				deck.get(card4).drawMe(windowTemp,c+420,100,this);
				addtosum(card4);
				repaint();
			}
			if(hit==3)
			{
				deal3 = true;
			}
			if(deal3==true)
			{
				deck.get(card5).drawMe(windowTemp,c+560,100,this);
				addtosum(card5);
				repaint();
			}
			
			if(dd==1)
				dealHit1 = true;
			if(dealHit1==true)
			{
				deck.get(dealer3).drawMe(windowTemp,d+160,dy-14,this);
				addtosum2(dealer3);
				repaint();
				dealerHit();
			}
			if(dd==2)
				dealHit2 = true;
			if(dealHit2==true)
			{
				deck.get(dealer4).drawMe(windowTemp,d+240,dy-21,this);
				addtosum2(dealer4);
				repaint();
				dealerHit();
			}
			if(dealHit3==true)
			{
				deck.get(dealer5).drawMe(windowTemp,d+320,dy-28,this);
				addtosum2(dealer5);
				repaint();
			}
				
			//sum
			windowTemp.setColor(Color.black);
			windowTemp.setFont(font);
			windowTemp.drawString("Sum: "+sum, 200,320);
			
			//sum2
			windowTemp.setColor(Color.black);
			windowTemp.setFont(fontd);
			if(reveal)
			{
				if(sum2>21)
					windowTemp.drawString("Dealer: BUST",315,450);
				else
					windowTemp.drawString("Dealer: "+sum2,315,450);
			}
			else
				windowTemp.drawString("Dealer: ???",315,450);
		}
		
		
		//money
		windowTemp.setColor(Color.white);
		windowTemp.fillRect(820,170,130,160);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(820,170,130,160);
		windowTemp.drawImage(treasureImage,840,230,this);
		windowTemp.setColor(Color.black);
		windowTemp.setFont(font);
		windowTemp.drawString("$"+score, 835,220);
		
		//bet box
		windowTemp.setColor(Color.pink);
		windowTemp.fillRect(450,360,75,55);
		windowTemp.setColor(Color.black);
		windowTemp.drawRect(450,360,75,55);
		windowTemp.setColor(Color.white);
		windowTemp.setFont(font3);
		windowTemp.drawString("Bet: $"+bet, 380,400);
		int[] xtri = {550,540,560};
		int[] ytri = {360,380,380};
		int[] xtri2 = {550,540,560};
		int[] ytri2 = {415,395,395};
		windowTemp.setColor(Color.white);
		windowTemp.fillPolygon(xtri,ytri,3);
		windowTemp.fillPolygon(xtri2,ytri2,3);
		windowTemp.setColor(Color.black);
		windowTemp.drawPolygon(xtri,ytri,3);
		windowTemp.drawPolygon(xtri2,ytri2,3);
		int[] xxtri = {575,565,585};
		int[] yytri = {360,380,380};
		int[] xxtri2 = {575,565,585};
		int[] yytri2 = {415,395,395};
		windowTemp.setColor(Color.white);
		windowTemp.fillPolygon(xxtri,yytri,3);
		windowTemp.fillPolygon(xxtri2,yytri2,3);
		windowTemp.setColor(Color.black);
		windowTemp.drawPolygon(xxtri,yytri,3);
		windowTemp.drawPolygon(xxtri2,yytri2,3);
		
		
		
		//blackjack sign
		Color rand = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		windowTemp.setColor(rand);
		windowTemp.setFont(f);
		windowTemp.drawString("BlackJack!!",260,bj);
		
		//Bust sign
		windowTemp.setColor(Color.black);
		windowTemp.setFont(f);
		windowTemp.drawString("BUST!!",320,bust);
		
		//Tie (draw) sign
		windowTemp.setColor(Color.blue);
		windowTemp.setFont(f);
		windowTemp.drawString("Draw!",330,tie);
		
		//win sign
		windowTemp.setColor(rand);
		windowTemp.setFont(f);
		windowTemp.drawString("Winner!",280,w);
		
		//lose sign
		windowTemp.setColor(Color.black);
		windowTemp.setFont(f);
		windowTemp.drawString("Tough Luck..",220,l);
		
		//game over
		windowTemp.setColor(Color.red);
		windowTemp.setFont(f);
		windowTemp.drawString("GAME OVER",220,gm);
	
	
		
		
		
		window.drawImage(buffered, 0, 0, null);

	}
	
	public void dealerHit()
	{
		if(sum2<17)
			dd++;
			
		else if(sum2<17 && dd==1)
			dd++;
		
		/*else if(sum2<17 && dealHit2==true)
			dealHit3 = true;*/
		
		else
			points();
	}
	
	public void points()
	{
		
		if(sum>sum2 && sum<21)
		{
			win=true;
		}
		else if(sum>sum2 && sum==21)
		{
			blackjack = true;
		}
		else if(sum2>21 && sum<21)
		{
			win=true;
		}
		else if(sum2>21 && sum==21)
		{
			blackjack=true;
		}
		else if(sum==sum2)
		{
			draw = true;
		}
		else
		{
			lose=true;
		}
		reveal = true;
		repaint();
	}
	
	public void resetGame()
	{
		this.card1 = (int)(Math.random()*52);
		this.card2 = (int)(Math.random()*52);
		while(card2==card1)
			card2 = (int)(Math.random()*52);
		this.card3 = (int)(Math.random()*52);
		while(card3==card1||card3==card2)
			card3 = (int)(Math.random()*52);
		this.card4 = (int)(Math.random()*52);
		while(card4==card1||card4==card2||card4==card3)
			card4 = (int)(Math.random()*52);
		this.card5 = (int)(Math.random()*52);
		while(card5==card1||card5==card2||card5==card3||card5==card4)
			card5 = (int)(Math.random()*52);
		this.dealer1 = (int)(Math.random()*52);
		this.dealer2 = (int)(Math.random()*52);
		while(dealer2==dealer1)
			dealer2 = (int)(Math.random()*52);
		this.dealer3 = (int)(Math.random()*52);
		while(dealer3==dealer1||dealer3==dealer2)
			dealer3 = (int)(Math.random()*52);
		this.dealer4 = (int)(Math.random()*52);
		while(dealer4==dealer1||dealer4==dealer2||dealer4==dealer3)
			dealer4 = (int)(Math.random()*52);
		this.dealer5 = (int)(Math.random()*52);
		while(dealer5==dealer1||dealer5==dealer2||dealer5==dealer3||dealer5==dealer4)
			dealer5 = (int)(Math.random()*52);
		
		hit=dd=0;
		bet=5;
		sum=sum2=0;
		deal1= deal2= deal3= dealHit1= dealHit2 = dealHit3 = false;
		tie=l=w=bust=bj=-30;
		draw=win=lose=blackjack=reveal=play=false;
		betting=true;
		
	}
	
	//mouselistener
	public void mouseClicked(MouseEvent e) {
		m1 = e.getX();
		m2 = e.getY();
		
		System.out.println("You clicked: " + m1 + ", " + m2);
	}
	public void mouseEntered(MouseEvent e) {
	
	}
	public void mouseExited(MouseEvent e) {
	
	}
	public void mousePressed(MouseEvent e) {
	
	}
	public void mouseReleased(MouseEvent e) {
	
	}
	public void resetXY(){
		m1=0;
		m2=0;
	}
	public void playSound()
	{
		 //Create a try catch when dealing with files
		 try
		 {
		    //Make sure your sound file is in the same folder as your java files.  
		    URL url = 
			this.getClass().getClassLoader().getResource("JamesBond.wav");
			//Create a Clip object
		    Clip clip = AudioSystem.getClip();
		    //Open the url
		    clip.open(AudioSystem.getAudioInputStream(url));
		    //Play the clip
		    clip.start();
		 }
		 catch (Exception e)
		 {
		     e.printStackTrace(System.out);
		 }
	}
	public void playSound2()
	{
		 //Create a try catch when dealing with files
		 try
		 {
		    //Make sure your sound file is in the same folder as your java files.  
		    URL url = 
			this.getClass().getClassLoader().getResource("chaching.wav");
			//Create a Clip object
		    Clip clip = AudioSystem.getClip();
		    //Open the url
		    clip.open(AudioSystem.getAudioInputStream(url));
		    //Play the clip
		    clip.start();
		 }
		 catch (Exception e)
		 {
		     e.printStackTrace(System.out);
		 }
	}
	
	//ANIMATE
	public void animate() 
    { 
        //Loop Indefinitely 
        while( true ) 
        { 
            //wait for .1 second 
            try { 
                Thread.sleep(5); 
            } catch(InterruptedException ex) { 
                Thread.currentThread().interrupt(); 
            }
			
			if(betting==true)
			{
				if(m1>=540 && m1<=560 && m2>=360 && m2<=380 && bet<score && bet>0)
				{
					bet++;
					resetXY();
				}
				if(m1>=540 && m1<=560 && m2>=395 && m2<=415 && bet>1)
				{
					bet--;
					resetXY();
				}
				if(m1>=565 && m1<=585 && m2>=360 && m2<=380 && bet<score-9 && bet>0)
				{
					bet+=10;
					resetXY();
				}
				if(m1>=565 && m1<=585 && m2>=395 && m2<=415 && bet>9)
				{
					bet-=10;
					resetXY();
				}
			}
			
			//new deal button
			if(m1>=815 && m1<=935 && m2>=355 && m2<=420 && bet<=score)
			{
				betting=false;
				play=true;
				resetXY();
			}
			if(play==true)
			{
				//hit
				if(m1>=700 && m1<=790 && m2>=355 && m2<=420)
				{
					hit++;
					resetXY();
				}
				//stand
				if(m1>=700 && m1<=840 && m2>=435 && m2<=500)
				{
					dealerHit();
					resetXY();
				}
			}
			//exit
			if(m1>=700 && m1<=820 && m2>=515 && m2<=580)
			{
				System.exit(0);
			}
			if(score<=0)
			{
				gm+=1;
				if(gm>700)
				{
					System.exit(0);
				}
			}
			
			if(blackjack==true)
			{
				bj+=1;
				if(bj>700)
				{
					score+=bet;
					this.playSound2();
					resetGame();
				}
			}
			if(draw==true)
			{
				tie+=1;
				if(tie>700)
				{
					resetGame();
				}
			}
			else if(win==true)
			{
				w+=1;
				if(w>700)
				{
					score+=bet;
					this.playSound2();
					resetGame();
				}
			}
			else if(lose==true)
			{
				l+=1;
				if(l>700)
				{
					score-=bet;
					resetGame();
				}
			}
			else if(sum>21)
			{
				bust+=1;
				if(bust>700)
				{
					score-=bet;
					resetGame();
				}
			}
			
			
			
			repaint();
		}
	}
	
}

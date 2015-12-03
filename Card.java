import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Card 
{
	private String suit;
	private String name;
	private int value;
	
	private Image suitImage;
	private int height, width;
	
	public Card(int value, String name, String suit)
	{
		this.value = value;
		this.name = name;
		this.suit = suit;
		
		if(this.suit.equalsIgnoreCase("hearts"))
		{
			suitImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/hearts.png"));
		}
		else if(this.suit.equalsIgnoreCase("diamonds"))
		{
			suitImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/diamonds.png"));
		}
		else if(this.suit.equalsIgnoreCase("clubs"))
		{
			suitImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/clubs.png"));
		}
		else if(this.suit.equalsIgnoreCase("spades"))
		{
			suitImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/spades.png"));
		}
		
		this.width = 120;
		height = 150;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void drawMe(Graphics window, int x, int y, JFrame table)
	{
		//draw card outline
		window.setColor(Color.white);
		window.fillRect(x,y,width,height);
		window.setColor(Color.black);
		window.drawRect(x,y,width,height);
		
		//draw value/letter
		Font font = new Font("Serif", Font.BOLD, 32);
		window.setFont(font);
		if(this.suit.equals("hearts")||this.suit.equals("diamonds"))
		{
			window.setColor(Color.red);
		}
		else if(this.suit.equals("spades")||this.suit.equals("clubs"))
		{
			window.setColor(Color.black);
		}
		if(this.name.equals("jack"))
		{
			window.drawString("J", x+10, y+30);
			window.drawString("J", x+90, y+140);
		}
		else if(this.name.equals("queen"))
		{
			window.drawString("Q", x+10, y+30);
			window.drawString("Q", x+90, y+140);
		}
		else if(this.name.equals("king"))
		{
			window.drawString("K", x+10, y+30);
			window.drawString("K", x+90, y+140);
		}
		else if(this.name.equals("ace"))
		{
			window.drawString("A", x+10, y+30);
			window.drawString("A", x+90, y+140);
		}
		else if(this.name.equals("ten"))
		{
			window.drawString("10", x+10, y+30);
			window.drawString("10", x+84, y+140);
		}
		else
		{
			window.drawString(this.value+"", x+10, y+30);
			window.drawString(this.value+"", x+94, y+140);
		}
		
		
		//draw suit image
		window.drawImage(suitImage, x+25,y+40,table);
		
		
		
	}
	
}

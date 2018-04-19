import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.*;

public class mutiple_frame implements ActionListener {

	private double zoomFactor = 1;
	private double prevZoomFactor = 1;
	private boolean zoomer;
	
	JFrame myframe = new JFrame();
	JPanel leftPane= new JPanel();
	public void mouseWheelMoved(MouseWheelEvent e) {
	    zoomer = true;
	    //Zoom in
	    if (e.getWheelRotation() < 0) {
	        zoomFactor *= 1.1;
	        //repaint();
	    }
	    //Zoom out
	    if (e.getWheelRotation() > 0) {
	        zoomFactor /= 1.1;
	        //repaint();
	    }
	}
	JPanel rightPane = new JPanel() {
		double f(double x) {
	        return Math.sin(x);
	    }

	    double gCos(double y) {
	        return Math.cos(y);
	    }
	    
	    
		public void paintComponent(Graphics g)
		{ 
			
		super.paintComponent(g);
		
	     FlowLayout myLayout = new FlowLayout();
		 
		 
	     //w is x, and h is y (as in x/y values in a graph)
		 int w = this.getWidth()/2;
	     int h = this.getHeight()/2;

		 Graphics2D g1 = (Graphics2D) g;
		 g1.setStroke(new BasicStroke(2));
		
		 if (zoomer) {
		        AffineTransform at = new AffineTransform();
		        at.scale(zoomFactor, zoomFactor);
		        prevZoomFactor = zoomFactor;
		        g1.transform(at);
		        zoomer = false;
		    }
		 
		 
		 g1.drawString("0", w - 7, h + 13);

		 int xa=w,ya= h;
		 
		 float dash[] = { 3.0f };
		 //set dash line of axis
		 g1.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
			        BasicStroke.JOIN_MITER, 3.0f, dash, 0.0f));
		 
		 g1.setColor(Color.gray);
		 int count=0;
		 //x and  y grid of dash line
		 
		 for (xa=w-500,count=-500 ; xa <=800 ; xa=xa+50,count+=50 )
		 {
		
			 Line2D r = new Line2D.Double(xa-5,ya+400, xa-5, ya-ya);
			 Line2D v = new Line2D.Double( 0,h+count,800,h+count);   
				 g1.draw(r);
				 g1.draw(v);
		 }
		 
		 float das[] = { 0.1f };
		 g1.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
			        BasicStroke.JOIN_MITER, 10.0f, das, 0.0f));
		 
		 // axis in red colored
		 g1.setColor(Color.red);
		 g1.drawLine(0,h,w*2,h);
		 g1.drawLine(w-5,0,w-5,h*2); 
		 
		 //darken stroke 
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setStroke(new BasicStroke(2));
		 g2.setColor(Color.blue);
		
		  
		  
	    
		 
	 
	     Polygon p = new Polygon();
	        

	       for (int x = -170; x <= 450; x++) {
	            p.addPoint(x + 50, h - (int) (100 * f((x / 100.0) 
	                    * Math.PI)));

	        }
	       
	       
	       Polygon p2 = new Polygon();
	       
	   
	       
	        for (int x = -170; x <= 450; x++) {
	            p2.addPoint(x + 50, h - (int) (100 * gCos((x / 100.0) 
	                    * Math.PI)));

	        }
	        
	        g.setColor(Color.red);
	        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	        
	        g.drawString("--sine", 420, 50);
	      
	        

	        g.setColor(Color.blue);
	        g.drawString("--cose", 420, 70);
	        g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);

		}
	};
	
	
	//JButton click = new JButton("Click me");
	JLabel text = new JLabel("Buton Clicked");
	JLabel b1 = new JLabel("xtics");
	JTextField xinput = new JTextField("50");

	
	mutiple_frame(){
		//leftPane.setBackground(Color.CYAN);
		rightPane.setBackground(Color.white);
		//leftPane.add(click);
		leftPane.add(b1);
		leftPane.add(xinput);
		//click.addActionListener(this);
		rightPane.add(text);
		text.setVisible(false);
	
		leftPane.setPreferredSize(new Dimension(270, 500));
		//setSize(200, 500);
		
		myframe.add(leftPane, BorderLayout.WEST);
		myframe.add(rightPane, BorderLayout.CENTER);
		
		JLabel b1=new JLabel("ytics");  
	    JTextField b2=new JTextField("50");  
	    JLabel b3=new JLabel("xtics label");  
	    JTextField b4=new JTextField("50");  
	    JLabel b5=new JLabel("xtics label");  
	    JTextField b6=new JTextField("50");  
	    JLabel b7=new JLabel("Formula(Math.sine etc) ");  
	    JTextField b8=new JTextField("math.sin");  
	        JButton b9=new JButton("Draw");  
	       b9.addActionListener(this); 
	       
	        leftPane.add(b1);leftPane.add(b2);leftPane.add(b3);leftPane.add(b4);leftPane.add(b5);  
	        leftPane.add(b6);leftPane.add(b7);leftPane.add(b8);leftPane.add(b9);  
	  
	        leftPane.setLayout(new GridLayout(6,2));  
	    
	    
		myframe.setSize(800, 500);
		myframe.setLocation(300, 100);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		text.setVisible(true);
		//leftPane.setBackground(Color.orange);
		
	}
	
	
public static void main(String[] args) {
		
	mutiple_frame obj = new mutiple_frame();
	
}
}

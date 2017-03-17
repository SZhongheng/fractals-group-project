package edu.buffalo.cse116;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.IndexColorModel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import edu.buffalo.fractal.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.GridLayout;
//d
public class Test {
	
	FractalPanel FP = new FractalPanel();
	Fractal F = new Fractal();
	private JFrame frame;
	private ColorModelFactory newModel = new ColorModelFactory();
	int x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 72));
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnFractal = new JMenu("Fractal");
		menuBar.add(mnFractal);
		
		JMenuItem mntmBurningShip = new JMenuItem("Burning Ship");
		mnFractal.add(mntmBurningShip);
		mntmBurningShip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FP.updateImage(F.bsArray());
				x=1;
			}
		});
		JMenuItem mntmJulia = new JMenuItem("Julia");
		mnFractal.add(mntmJulia);
		mntmJulia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FP.updateImage(F.jArray());
				x=2;
			}
		});
		
		JMenuItem mntmMandelbrot = new JMenuItem("Mandelbrot");
		mnFractal.add(mntmMandelbrot);
		mntmMandelbrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FP.updateImage(F.maArray());
				x=3;
			}
		});
		
		JMenuItem mntmMultibrot = new JMenuItem("Multibrot");
		mnFractal.add(mntmMultibrot);
		mntmMultibrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FP.updateImage(F.muArray());
				x=4;
			}
		});
		
		JMenu mnColor = new JMenu("Color");
		menuBar.add(mnColor);
		
		
		JMenuItem green = new JMenuItem("Green");
		mnColor.add(green);
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createGreenColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		

		JMenuItem red = new JMenuItem("Red");
		mnColor.add(red);
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createRedColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			
			}
		});
		

		JMenuItem blue = new JMenuItem("Blue");
		mnColor.add(blue);
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createBluesColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		

		JMenuItem purple = new JMenuItem("Purple");
		mnColor.add(purple);
		purple.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createPurpleColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		
		JMenuItem turqoise = new JMenuItem("Turqoise");
		mnColor.add(turqoise);
		turqoise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createTurqoiseColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		
		JMenuItem rainbow = new JMenuItem("Rainbow");
		mnColor.add(rainbow);
		rainbow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createRainbowColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		
		
		JMenuItem gray = new JMenuItem("Gray");
		mnColor.add(gray);
		gray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			FP.setIndexColorModel(newModel.createGrayColorModel(256));
			if(x==1){FP.updateImage(F.bsArray());}
			if(x==2){FP.updateImage(F.jArray());}
			if(x==3){FP.updateImage(F.maArray());}
			if(x==4){FP.updateImage(F.muArray());}
			}
		});
		
		
		
		
		
		
		
		
		
		
        
		
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.getContentPane().add(FP);
	}
	

}

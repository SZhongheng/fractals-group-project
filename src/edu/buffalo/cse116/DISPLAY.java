package edu.buffalo.cse116;
import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.FractalPanel;
import edu.buffalo.fractal.WorkerResult;
import javax.swing.SwingWorker;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class DISPLAY {

	private JFrame frame;
	FRACTALS F = new FRACTALS();
	FractalPanel FP = new FractalPanel();
	ColorModelFactory newModel = new ColorModelFactory();
	ComputePool CP = new ComputePool();
	int count = 0;
	int choice = 0;
	double sx, ex, sy, ey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DISPLAY window = new DISPLAY();
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
	public DISPLAY() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FP.addMouseListener(new mouse());
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.add(FP);
		 //FP.setPreferredSize(new Dimension(1024,1024));
		//FP.setSize(2048, 2048);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmSetEscapeDistance = new JMenuItem("SET ESCAPE DISTANCE");
		mntmSetEscapeDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					F.setEscapeDistance(Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter a numberical value greater than or equal to 0: ", "Example: 2 or 3.7")));
					if (F.getescapeDistance() < 0) {
						throw new NumberFormatException();
					}
					F.createFractals(F.getescapeDistance(), 255);
					FP.updateImage(F.getArray());
				} catch (NumberFormatException n) {
					String[] buttons = { "OK" };
					JOptionPane.showOptionDialog(frame, "Please enter a numerical value greater than or equal to 0!", "ERROR", JOptionPane.WARNING_MESSAGE, 0,
							null, buttons, buttons[0]);
				} catch (NullPointerException npe) {

				}
			}
		});
		mnFile.add(mntmSetEscapeDistance);
		
		JMenuItem mntmSetEscapeTime = new JMenuItem("SET ESCAPE TIME");
		mnFile.add(mntmSetEscapeTime);
		mnFile.add(mntmExit);
		
		JMenu mnFractals = new JMenu("FRACTALS");
		menuBar.add(mnFractals);
		
		JMenuItem mntmBurningShip = new JMenuItem("BURNING SHIP");
		mntmBurningShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setChoice(1);
				F.setRanges(-1.8, -1.7, -0.08, 0.025);
				if (F.getescapeDistance() == 0) {
					F.setEscapeDistance(2);
				}
				F.createFractals(F.getescapeDistance(), 255);
				FP.updateImage(F.getArray());
			}
		});
		mnFractals.add(mntmBurningShip);
		
		JMenuItem mntmJulia = new JMenuItem("JULIA");
		mntmJulia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setChoice(2);
				F.setRanges(-1.7, 1.7, -1.0, 1.0);if (F.getescapeDistance() == 0) {
					F.setEscapeDistance(2);
				}
				F.createFractals(F.getescapeDistance(), 255);
				FP.updateImage(F.getArray());
			}
		});
		mnFractals.add(mntmJulia);
		
		JMenuItem mntmMandelbrot = new JMenuItem("MANDELBROT");
		mntmMandelbrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setChoice(3);
				F.setRanges(-2.15, 0.6, -1.3, 1.3);if (F.getescapeDistance() == 0) {
					F.setEscapeDistance(2);
				}
				F.createFractals(F.getescapeDistance(), 255);
				FP.updateImage(F.getArray());
			}
		});
		mnFractals.add(mntmMandelbrot);
		
		JMenuItem mntmMultibrot = new JMenuItem("MULTIBROT");
		mntmMultibrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.setChoice(4);
				F.setRanges(-1.0, 1.0, -1.3, 1.3);if (F.getescapeDistance() == 0) {
					F.setEscapeDistance(2);
				}
				F.createFractals(F.getescapeDistance(), 255);
				FP.updateImage(F.getArray());
			}
		});
		mnFractals.add(mntmMultibrot);
		
		JMenu mnColors = new JMenu("COLORS");
		menuBar.add(mnColors);
		
		JMenuItem mntmBlue = new JMenuItem("BLUE");
		mntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FP.setIndexColorModel(newModel.createBluesColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmBlue);
		
		JMenuItem mntmGray = new JMenuItem("GRAY");
		mntmGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createGrayColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmGray);
		
		JMenuItem mntmGreen = new JMenuItem("GREEN");
		mntmGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createGreenColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmGreen);
		
		JMenuItem mntmPurple = new JMenuItem("PURPLE");
		mntmPurple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createPurpleColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmPurple);
		
		JMenuItem mntmRainbow = new JMenuItem("RAINBOW");
		mntmRainbow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createRainbowColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmRainbow);
		
		JMenuItem mntmRed = new JMenuItem("RED");
		mntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createRedColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmRed);
		
		JMenuItem mntmTurquoise = new JMenuItem("TURQUOISE");
		mntmTurquoise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createTurqoiseColorModel(256));
				FP.updateImage(F.getArray());
			}
		});
		mnColors.add(mntmTurquoise);
	}
	
	public class mouse implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent z) {
			// TODO Auto-generated method stub
			if (count == 1) {
				ex = z.getX();
				ey = z.getY();
				System.out.println(ex + " " + ey);
				System.out.println(F.translateX(ex) + " " + F.translateY(ey));
				F.setRanges(F.translateX(sx), F.translateX(ex), F.translateY(sy), F.translateY(ey));
				F.createFractals(2, 255);
				FP.updateImage(F.getArray());
				count = -1;
			}
			sx = z.getX();
			sy = z.getY();
			System.out.println(sx + " " + sy);
			System.out.println(F.translateX(sx) + " " + F.translateY(sy));
			count++;
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public abstract class subWorker extends SwingWorker<WorkerResult, Void> {

		protected WorkerResult doInBackground(SwingWorker<WorkerResult, Void>[] instances) throws Exception {
			CP.changePanel(FP);
			CP.generateFractal(128, instances);
			return null;
		}
		
	}
}

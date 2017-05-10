package edu.buffalo.cse116;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.IndexColorModel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import edu.buffalo.fractal.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Canvas;

//d
public class Test {

	static FractalPanel FP = new FractalPanel();
	static Fractal F = new Fractal();
	private JFrame frame;
	private ColorModelFactory newModel = new ColorModelFactory();
	static int x;
	static int y;
	private static double edInput;
	private static double etInput = 255;
	public static int[][] fractalArray;
	
	private static double _startingXRange;
	private static double _endingXRange;
	private static double _startingYRange;
	private static double _endingYRange;
	
	public static void setRanges(double startingXRange, double endingXRange, double startingYRange, double endingYRange) {
		_startingXRange = startingXRange;
		_endingXRange = endingXRange;
		_startingYRange = startingYRange;
		_endingYRange = endingYRange;
	}
	
	public static double translateX(double index) {
		double sx = 0, ex = 0;
		if (x == 1) {
			double inc = 0.1/512;
			 //return -1.8 + x * i;
			sx = ((inc * _startingXRange) + (-1.8));
			ex = ((inc * _endingXRange) + (-1.8));
		}
		
		return sx + ((ex - sx) / (512)) * index;
	}
	
	public static double translateY(double index) {
		double sy = 0, ey = 0;
			if (x == 1) {
				double inc = .105/512;
				//return -0.08 + y * j;
				sy = ((inc * _startingYRange) + (-0.08));
				ey = ((inc * _endingYRange) + (-0.08));
			}
			return sy + ((ey - sy) / (512)) * index;
	}
	

	
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
		frame.setBounds(0, 0, 512, 512);
		//FP.setPreferredSize(new Dimension(1024, 1024));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setFont(menuBar.getFont().deriveFont(menuBar.getFont().getSize() + 10f));
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 30));
		menuBar.add(mnFile);
		
		JMenuItem mnESC = new JMenuItem("Set Escape Distance");
		mnESC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFile.add(mnESC);
		mnESC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					edInput = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter a numberical value greater than or equal to 0: ", "Example: 2 or 3.7"));
					if (edInput < 0) {
						throw new NumberFormatException();
					}
					if (x == 1) {
						FP.updateImage(F.bsArray(edInput, etInput));
					}
					if (x == 2) {
						FP.updateImage(F.jArray(edInput, etInput));
					}
					if (x == 3) {
						FP.updateImage(F.maArray(edInput, etInput ));
					}
					if (x == 4) {
						FP.updateImage(F.muArray(edInput, etInput ));
					}
				} catch (NumberFormatException n) {
					String[] buttons = { "OK" };
					JOptionPane.showOptionDialog(frame, "Please enter a numerical value greater than or equal to 0!", "ERROR", JOptionPane.WARNING_MESSAGE, 0,
							null, buttons, buttons[0]);
				} catch (NullPointerException npe) {

				}
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
		
		JMenuItem mntmSetEscapeTime = new JMenuItem("Set Escape Time");
		mntmSetEscapeTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					etInput = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter a numberical value greater than 0 and lesser than 225: ", "Example: 2 or 3.7"));
					if (etInput < 0 || etInput > 225) {
						throw new NumberFormatException();
					}
					if (x == 1) {
						FP.updateImage(F.bsArray(edInput, etInput ));
					}
					if (x == 2) {
						FP.updateImage(F.jArray(edInput, etInput ));
					}
					if (x == 3) {
						FP.updateImage(F.maArray(edInput, etInput ));
					}
					if (x == 4) {
						FP.updateImage(F.muArray(edInput, etInput ));
					}
				} catch (NumberFormatException n) {
					String[] buttons = { "OK" };
					JOptionPane.showOptionDialog(frame, "Please enter a numerical value greater than 0 and lower than 255!", "ERROR", JOptionPane.WARNING_MESSAGE, 0,
							null, buttons, buttons[0]);
				} catch (NullPointerException npe) {

				}
			}
		});
		mntmSetEscapeTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFile.add(mntmSetEscapeTime);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x == 1) {
					FP.updateImage(F.bsArray(edInput, etInput ));
				}
				if (x == 2) {
					FP.updateImage(F.jArray(edInput, etInput ));
				}
				if (x == 3) {
					FP.updateImage(F.maArray(edInput, etInput ));
				}
				if (x == 4) {
					FP.updateImage(F.muArray(edInput, etInput ));
				}
			}
		});
		mntmReset.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFile.add(mntmReset);
		mnFile.add(mntmExit);

		JMenu mnFractal = new JMenu("Fractal");
		mnFractal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		menuBar.add(mnFractal);

		JMenuItem mntmBurningShip = new JMenuItem("Burning Ship");
		mntmBurningShip.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFractal.add(mntmBurningShip);
		mntmBurningShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.updateImage(F.bsArray(edInput, etInput ));
				x = 1;
			}
		});
		JMenuItem mntmJulia = new JMenuItem("Julia");
		mntmJulia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFractal.add(mntmJulia);
		mntmJulia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.updateImage(F.jArray(edInput, etInput ));
				x = 2;
			}
		});

		JMenuItem mntmMandelbrot = new JMenuItem("Mandelbrot");
		mntmMandelbrot.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFractal.add(mntmMandelbrot);
		mntmMandelbrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.updateImage(F.maArray(edInput, etInput ));
				x = 3;
			}
		});

		JMenuItem mntmMultibrot = new JMenuItem("Multibrot");
		mntmMultibrot.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnFractal.add(mntmMultibrot);
		mntmMultibrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.updateImage(F.muArray(edInput, etInput ));
				x = 4;
			}
		});

		JMenu mnColor = new JMenu("Color");
		mnColor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		menuBar.add(mnColor);
		
				JMenuItem blue = new JMenuItem("Blue");
				blue.setFont(new Font("Tahoma", Font.PLAIN, 30));
				mnColor.add(blue);
				blue.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FP.setIndexColorModel(newModel.createBluesColorModel(256));
						if (x == 1) {
							FP.updateImage(F.bsArray(edInput, etInput ));
						}
						if (x == 2) {
							FP.updateImage(F.jArray(edInput, etInput ));
						}
						if (x == 3) {
							FP.updateImage(F.maArray(edInput, etInput  ));
						}
						if (x == 4) {
							FP.updateImage(F.muArray(edInput, etInput ));
						}
					}
				});
		
				JMenuItem gray = new JMenuItem("Gray");
				gray.setFont(new Font("Tahoma", Font.PLAIN, 30));
				mnColor.add(gray);
				gray.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FP.setIndexColorModel(newModel.createGrayColorModel(256));
						if (x == 1) {
							FP.updateImage(F.bsArray(edInput, etInput ));
						}
						if (x == 2) {
							FP.updateImage(F.jArray(edInput, etInput ));
						}
						if (x == 3) {
							FP.updateImage(F.maArray(edInput, etInput ));
						}
						if (x == 4) {
							FP.updateImage(F.muArray(edInput, etInput ));
						}
					}
				});

		JMenuItem green = new JMenuItem("Green");
		green.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnColor.add(green);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createGreenColorModel(256));
				if (x == 1) {
					FP.updateImage(F.bsArray(edInput, etInput ));
				}
				if (x == 2) {
					FP.updateImage(F.jArray(edInput, etInput ));
				}
				if (x == 3) {
					FP.updateImage(F.maArray(edInput, etInput ));
				}
				if (x == 4) {
					FP.updateImage(F.muArray(edInput, etInput ));
				}
			}
		});
		
				JMenuItem purple = new JMenuItem("Purple");
				purple.setFont(new Font("Tahoma", Font.PLAIN, 30));
				mnColor.add(purple);
				purple.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FP.setIndexColorModel(newModel.createPurpleColorModel(256));
						if (x == 1) {
							FP.updateImage(F.bsArray(edInput, etInput ));
						}
						if (x == 2) {
							FP.updateImage(F.jArray(edInput, etInput ));
						}
						if (x == 3) {
							FP.updateImage(F.maArray(edInput, etInput ));
						}
						if (x == 4) {
							FP.updateImage(F.muArray(edInput, etInput ));
						}
					}
				});
		
				JMenuItem rainbow = new JMenuItem("Rainbow");
				rainbow.setFont(new Font("Tahoma", Font.PLAIN, 30));
				mnColor.add(rainbow);
				rainbow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FP.setIndexColorModel(newModel.createRainbowColorModel(256));
						if (x == 1) {
							FP.updateImage(F.bsArray(edInput, etInput ));
						}
						if (x == 2) {
							FP.updateImage(F.jArray(edInput, etInput ));
						}
						if (x == 3) {
							FP.updateImage(F.maArray(edInput, etInput ));
						}
						if (x == 4) {
							FP.updateImage(F.muArray(edInput, etInput ));
						}
					}
				});

		JMenuItem red = new JMenuItem("Red");
		red.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnColor.add(red);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createRedColorModel(256));
				if (x == 1) {
					FP.updateImage(F.bsArray(edInput, etInput));
				}
				if (x == 2) {
					FP.updateImage(F.jArray(edInput, etInput));
				}
				if (x == 3) {
					FP.updateImage(F.maArray(edInput, etInput ));
				}
				if (x == 4) {
					FP.updateImage(F.muArray(edInput, etInput ));
				}

			}
		});

		JMenuItem turquoise = new JMenuItem("Turquoise");
		turquoise.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mnColor.add(turquoise);
		turquoise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FP.setIndexColorModel(newModel.createTurqoiseColorModel(256));
				if (x == 1) {
					FP.updateImage(F.bsArray(edInput, etInput));
				}
				if (x == 2) {
					FP.updateImage(F.jArray(edInput, etInput));
				}
				if (x == 3) {
					FP.updateImage(F.maArray(edInput, etInput));
				}
				if (x == 4) {
					FP.updateImage(F.muArray(edInput, etInput));
				}
			}
		});

		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.add(FP);
		FP.addMouseListener(new MouseStuff());
	}
	 
	 public static class MouseStuff implements MouseListener, MouseMotionListener {
		 
		 boolean dragging = false;
		private int clickNum = 1;
		
		public int BurningShip(double xInput, double yInput, double escapeDistanceInput, double escapeTimeInput){
			double xCalc = xInput;
			double yCalc = yInput;
			double newX;
			double newY;
			double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
			int passes = 0;
			while(dist <= escapeDistanceInput && passes < escapeTimeInput){
				newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
				newY = Math.abs(2*xCalc*yCalc) + yInput;
				xCalc = newX;
				yCalc = newY;
				passes++;
				dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
			}
			return passes;
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseClicked(MouseEvent z) {
			if (clickNum == 1) {
				_startingXRange = z.getX();
				_startingYRange = z.getY();
			}
			if (clickNum == 2) {
				_endingXRange = z.getX();
				_endingYRange = z.getY();
			}
			System.out.println(z.getX() + " " + z.getY());
			clickNum ++;
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent z) {
			//System.out.println(z.getX() + " " + z.getY());
		}

		@Override
		public void mouseReleased(MouseEvent z) {
			 if (clickNum == 2) {
				 clickNum = 0;
				 if (x == 1) {
					 double pixelIncrement = 0.1/512;
					 /*double sx = ((x * 91) + (-1.8));
						double ex = ((x * 220) + (-1.8));
						return sx + ((ex - sx) / (512)) * i;*/
					 setRanges(_startingXRange, _endingXRange, _startingYRange, _endingYRange);
					 int row = 512;
						int col = 512;
						fractalArray = new int[row][col];
						for (int i = 0; i < fractalArray.length; i++) {
							for (int j = 0; j < fractalArray[0].length; j++) {
								fractalArray[i][j] = this.BurningShip(translateX(i), translateY(j), edInput, etInput);
							}
						}
				 }
				 FP.updateImage(fractalArray);
				 System.out.println(z.getX() + " " + z.getY());
			 }
		}
}
}

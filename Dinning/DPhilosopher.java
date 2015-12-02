package Dinning ;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DPhilosopher extends JFrame 
{
	ExecutorService exec;
	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JLabel lblPhilosper = new JLabel("Philosper_1");
	private final JLabel lblPhilosper_1 = new JLabel("Philosper-2");
	private final JLabel lblPhilosper_2 = new JLabel("Philosper-3");
	private final JLabel lblPhilosper_3 = new JLabel("Philosper-4");
	private final JLabel lblPhilosper_4 = new JLabel("Philosper-5");
	private final JLabel lblThinking = new JLabel("Thinking");
	private final JLabel lblEating = new JLabel("Eating");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{	
				try 
				{
					DPhilosopher frame = new DPhilosopher();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DPhilosopher() 
	{
		textField_9.setForeground(new Color(128, 0, 0));
		textField_9.setBounds(557, 122, 86, 20);
		textField_9.setColumns(10);
		textField_8.setForeground(new Color(128, 0, 0));
		textField_8.setBounds(432, 122, 86, 20);
		textField_8.setColumns(10);
		textField_7.setForeground(new Color(128, 0, 0));
		textField_7.setBounds(305, 122, 86, 20);
		textField_7.setColumns(10);
		textField_6.setForeground(new Color(128, 0, 0));
		textField_6.setBounds(198, 122, 86, 20);
		textField_6.setColumns(10);
		textField_5.setForeground(new Color(128, 0, 0));
		textField_5.setBounds(77, 122, 86, 20);
		textField_5.setColumns(10);
		textField_4.setForeground(new Color(0, 128, 128));
		textField_4.setBounds(557, 84, 86, 20);
		textField_4.setColumns(10);
		textField_3.setForeground(new Color(0, 128, 128));
		textField_3.setBounds(432, 84, 86, 20);
		textField_3.setColumns(10);
		textField_2.setForeground(new Color(0, 128, 128));
		textField_2.setBounds(305, 84, 86, 20);
		textField_2.setColumns(10);
		textField_1.setForeground(new Color(0, 128, 128));
		textField_1.setBounds(198, 84, 86, 20);
		textField_1.setColumns(10);
		textField.setForeground(new Color(0, 128, 128));
		textField.setBackground(Color.WHITE);
		textField.setBounds(77, 84, 86, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setForeground(new Color(72, 209, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRun = new JButton("Start");
		btnRun.setForeground(new Color(255, 255, 255));
		btnRun.setBackground(new Color(0, 128, 0));
		btnRun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ft2 x = new ft2();
			}
		});
		
		btnRun.setBounds(224, 207, 98, 45);
		contentPane.add(btnRun);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBackground(Color.RED);
		btnStop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exec.shutdownNow();
			}
		});
		btnStop.setBounds(437, 207, 98, 45);
		contentPane.add(btnStop);
		
		contentPane.add(textField);
		
		contentPane.add(textField_1);
		
		contentPane.add(textField_2);
		
		contentPane.add(textField_3);
		
		contentPane.add(textField_4);
		
		contentPane.add(textField_5);
		
		contentPane.add(textField_6);
		
		contentPane.add(textField_7);
		
		contentPane.add(textField_8);
		
		contentPane.add(textField_9);
		lblPhilosper.setBounds(84, 44, 66, 14);
		
		contentPane.add(lblPhilosper);
		lblPhilosper_1.setBounds(214, 44, 61, 14);
		
		contentPane.add(lblPhilosper_1);
		lblPhilosper_2.setBounds(325, 44, 66, 14);
		
		contentPane.add(lblPhilosper_2);
		lblPhilosper_3.setBounds(444, 44, 66, 14);
		
		contentPane.add(lblPhilosper_3);
		lblPhilosper_4.setBounds(570, 44, 66, 14);
		
		contentPane.add(lblPhilosper_4);
		lblThinking.setBounds(10, 87, 46, 14);
		
		contentPane.add(lblThinking);
		lblEating.setBounds(10, 125, 40, 14);
		
		contentPane.add(lblEating);
	}
	
	class Chopstick 
	{
		private boolean flag = false;
		public synchronized void take(double idd, String x) throws InterruptedException 
		{
				while (flag) 
				{
					//System.out.println("philosopher" + idd +" waiting for the" + x +"chopstick");
					wait();
				}
				flag = true;
		}
		
		public synchronized void drop(double idd, String x) 
		{
			flag = false;
			System.out.println("philosopher" + idd + " "+ "dropped the" + x +" chopstick");
			notifyAll();
		}
	}
	class Philosopher implements Runnable 
	{
//		private Thread t;
	    private Chopstick left;
		private Chopstick right;
		private final int id;
		public double idd;
		public int f;
	
		private void pause() throws InterruptedException 
		{
			try 
			{
				Thread.sleep(2000);                 //1000 milliseconds is one second.
			}
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}
		}
		public Philosopher(Chopstick left, Chopstick right, int ident) 
		{
			this.left = left;
			this.right = right;
			id = ident;
			idd=(double)id;
			//this.f= 0;
		}
		
		public void run() 
		{
			try 
			{
				while (!Thread.interrupted()) 
				{

					pause();
					
					right.take(idd,"rig");
					left.take(idd,"lef");
					
					if(idd == 0.0)
					{		textField.setText(" ");
						textField_5.setText("Eating");
				}
					else if(idd == 1.0)
					{
						textField_1.setText(" ");
						textField_6.setText("Eating");
					}
					else if(idd == 2.0)
					{
						textField_2.setText(" ");
						textField_7.setText("Eating");
					}
						
					else if(idd == 3.0)
					{
						textField_3.setText(" ");
						textField_8.setText("Eating");
					}
						
					else if(idd == 4.0)
					{
						textField_4.setText(" ");
						textField_9.setText("Eating");
					}
					System.out.println("philosopher"+ idd + "eating");
					pause();
					
					right.drop(idd,"rig");
					left.drop(idd,"lef");
					
					if(idd == 0.0)
					{
						textField_5.setText(" ");
					textField.setText("Thinking");
					}
					else if(idd == 1.0)
					{
						textField_6.setText(" ");
						textField_1.setText("Thinking");
					}
					else if(idd == 2.0)
					{
						textField_7.setText(" ");
						textField_2.setText("Thinking");
					}
					else if(idd == 3.0)
					{
						textField_8.setText(" ");
						textField_3.setText("Thinking");
					}
					else if(idd == 4.0)
					{
						textField_9.setText(" ");
						textField_4.setText("Thinking");
					}
					
				}
			} 
			catch (InterruptedException e) 
			{
				System.out.println("philosopher" + idd + "exiting via interrupt");
			}
		}
	     // public void start(){
	     //    System.out.println("starting Thread " + idd);
	     //    System.out.println("Thread " + idd + "for philosopher " + idd);
	      //   if(t==null)
	       //  {
	       //     t= new Thread(this,id);
	         //   t.start();
	        // }
		
	//}
	}
	
	class ft2
	{
		ft2()
		{
			int size = 5;
			Chopstick[] sticks = new Chopstick[size];
			exec = Executors.newCachedThreadPool();
		
			for (int i = 0; i < size; i++) 
			{
				sticks[i] = new Chopstick();
			}
			
			for (int i = 0; i < size; i++) 
			{
				if (i < (size - 1)) 
				{
					System.out.println("creating thread");
					exec.execute(new Philosopher(sticks[i], sticks[i + 1], i));
	                       // R1.start();
				} 
				else 
				{
					System.out.println("creating thread");		
					exec.execute(new Philosopher(sticks[0], sticks[i], i));
			//	R1.start();
	            }
			}
			System.out.println("Press 'Enter' to quit");
	
			
		}
	}
}
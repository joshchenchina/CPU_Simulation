import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_FrontPage {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_FrontPage window = new Gui_FrontPage();
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
	public Gui_FrontPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("CPU Simulation");
		label.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label.setBounds(143, 72, 154, 48);
		frame.getContentPane().add(label);
		
		JButton btnSimulation = new JButton("Simulation");
		btnSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui_SimulationPage simulationPage = new Gui_SimulationPage();
				simulationPage.runSimulation();
			}
		});
		btnSimulation.setBounds(143, 146, 144, 29);
		frame.getContentPane().add(btnSimulation);
		
		JLabel label_1 = new JLabel("Yizhong Chen");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_1.setBounds(351, 256, 93, 16);
		frame.getContentPane().add(label_1);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(143, 175, 144, 29);
		frame.getContentPane().add(btnExit);
	}

}

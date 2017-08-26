import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.NameList;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class Gui_SimulationPage {

	private JFrame frame;
	private JTextField busSizetextField;
	private JTextField addTextField;
	private JTextField minusTextField;
	private JTextField multipyTextField;
	private JTextField divideTextField;
	private JTextField andTextField;
	private JTextField orTextField;
	private JTextField notTextField;
	private JTextField numRegTextField;
	private JTextField aTextField;
	private JTextField cTextField;
	private JTextField pcTextField;
	private JTextField maTextField;
	private JTextField mdTextField;
	private JTextField spTextField;
	private JTextField mainMemoryTextField;
	/**
	 * Launch the application.
	 */
	public  void runSimulation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_SimulationPage window = new Gui_SimulationPage();
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
	public Gui_SimulationPage() {
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
		
		JLabel lblWordSize = new JLabel("Word Size:");
		lblWordSize.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblWordSize.setBounds(6, 6, 59, 16);
		frame.getContentPane().add(lblWordSize);
		
		JFormattedTextField wordsizeTextField = new JFormattedTextField();
		wordsizeTextField.setBounds(59, 5, 52, 16);
		frame.getContentPane().add(wordsizeTextField);
		
		JButton beginButton = new JButton("Begin");
		beginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CPUsimulator cpu = new CPUsimulator();
				wordsizeTextField.setText(Integer.toString(cpu.dataPath.configuration.word_size));
				busSizetextField.setText(Integer.toString(cpu.dataPath.configuration.bus_size));
				andTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_and()));
				notTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_not()));
				orTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_or()));
				addTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_add()));
				minusTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_minus()));
				multipyTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_multipy()));
				divideTextField.setText(String.valueOf(cpu.dataPath.configuration.alu_divide()));
				numRegTextField.setText(String.valueOf(cpu.dataPath.configuration.number_of_general_registers));
				int j = 103;
				for(int i = 0; i < cpu.dataPath.registerFile.namelist.size(); i++){
					JTextField reg1textField = new JTextField();
					reg1textField = new JTextField();
					reg1textField.setColumns(10);
					reg1textField.setBounds(j+60, 24, 52, 16);
					frame.getContentPane().add(reg1textField);
					reg1textField.setText(cpu.dataPath.registerFile.namelist.get(i));
					
					JTextField regValuetextField = new JTextField();
					regValuetextField = new JTextField();
					regValuetextField.setColumns(10);
					regValuetextField.setBounds(j+60, 50 ,52, 16);
					frame.getContentPane().add(regValuetextField);
					
					regValuetextField.setText((String) cpu.dataPath.registerFile.getValue((cpu.dataPath.registerFile.getBinary(i))));
					j = j+ 60;
				}
				aTextField.setText(cpu.dataPath.a.get_value().toString());
				cTextField.setText(cpu.dataPath.c.get_value().toString());
				maTextField.setText(Integer.toString(cpu.dataPath.memoryAddress.get_value()));
				mdTextField.setText(cpu.dataPath.memoryData.get_value().toString());
				pcTextField.setText(Integer.toString(cpu.dataPath.programCounter.get_value()));
				mainMemoryTextField.setText(cpu.dataPath.mainMemory.mainM.toString());
				spTextField.setText(cpu.dataPath.stackPointer.get_value().toString());
				
			}
		});
		beginButton.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(beginButton);
		
		JLabel lblBusSize = new JLabel("Bus Size:");
		lblBusSize.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblBusSize.setBounds(6, 24, 52, 16);
		frame.getContentPane().add(lblBusSize);
		
		busSizetextField = new JTextField();
		busSizetextField.setBounds(59, 23, 52, 16);
		frame.getContentPane().add(busSizetextField);
		busSizetextField.setColumns(10);
		
		JLabel lblALU = new JLabel("ALU:");
		lblALU.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblALU.setBounds(6, 45, 30, 16);
		frame.getContentPane().add(lblALU);
		
		JLabel lblAdd = new JLabel("add:");
		lblAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAdd.setBounds(4, 62, 30, 16);
		frame.getContentPane().add(lblAdd);
		
		addTextField = new JTextField();
		addTextField.setColumns(10);
		addTextField.setBounds(45, 61, 52, 16);
		frame.getContentPane().add(addTextField);
		
		JLabel lblMinus = new JLabel("minus:");
		lblMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMinus.setBounds(4, 80, 32, 16);
		frame.getContentPane().add(lblMinus);
		
		minusTextField = new JTextField();
		minusTextField.setColumns(10);
		minusTextField.setBounds(45, 80, 52, 16);
		frame.getContentPane().add(minusTextField);
		
		JLabel lblMultipy = new JLabel("multipy:");
		lblMultipy.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMultipy.setBounds(4, 101, 54, 16);
		frame.getContentPane().add(lblMultipy);
		
		multipyTextField = new JTextField();
		multipyTextField.setColumns(10);
		multipyTextField.setBounds(45, 101, 52, 16);
		frame.getContentPane().add(multipyTextField);
		
		JLabel lblDivide = new JLabel("divide:");
		lblDivide.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDivide.setBounds(6, 123, 32, 16);
		frame.getContentPane().add(lblDivide);
		
		divideTextField = new JTextField();
		divideTextField.setColumns(10);
		divideTextField.setBounds(45, 123, 52, 16);
		frame.getContentPane().add(divideTextField);
		
		JLabel lblAnd = new JLabel("and:");
		lblAnd.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAnd.setBounds(6, 144, 30, 16);
		frame.getContentPane().add(lblAnd);
		
		JLabel lblOr = new JLabel("or:");
		lblOr.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblOr.setBounds(6, 166, 30, 16);
		frame.getContentPane().add(lblOr);
		
		JLabel lblNot = new JLabel("not:");
		lblNot.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNot.setBounds(6, 189, 30, 16);
		frame.getContentPane().add(lblNot);
		
		andTextField = new JTextField();
		andTextField.setColumns(10);
		andTextField.setBounds(45, 144, 52, 16);
		frame.getContentPane().add(andTextField);
		
		orTextField = new JTextField();
		orTextField.setColumns(10);
		orTextField.setBounds(45, 166, 52, 16);
		frame.getContentPane().add(orTextField);
		
		notTextField = new JTextField();
		notTextField.setColumns(10);
		notTextField.setBounds(45, 188, 52, 16);
		frame.getContentPane().add(notTextField);
		
		JLabel lblNumberOfRegisters = new JLabel("Number of Registers:");
		lblNumberOfRegisters.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNumberOfRegisters.setBounds(6, 209, 105, 16);
		frame.getContentPane().add(lblNumberOfRegisters);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNumber.setBounds(6, 228, 41, 16);
		frame.getContentPane().add(lblNumber);
		
		numRegTextField = new JTextField();
		numRegTextField.setColumns(10);
		numRegTextField.setBounds(59, 227, 52, 16);
		frame.getContentPane().add(numRegTextField);
		
		JLabel lblGeneralRegisters = new JLabel("General Registers:");
		lblGeneralRegisters.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblGeneralRegisters.setBounds(123, 5, 95, 16);
		frame.getContentPane().add(lblGeneralRegisters);
		
		JLabel lblA = new JLabel("A:");
		lblA.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblA.setBounds(123, 79, 15, 16);
		frame.getContentPane().add(lblA);
		
		aTextField = new JTextField();
		aTextField.setColumns(10);
		aTextField.setBounds(138, 79, 30, 16);
		frame.getContentPane().add(aTextField);
		
		JLabel lblC = new JLabel("C:");
		lblC.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblC.setBounds(171, 80, 15, 16);
		frame.getContentPane().add(lblC);
		
		cTextField = new JTextField();
		cTextField.setColumns(10);
		cTextField.setBounds(180, 79, 30, 16);
		frame.getContentPane().add(cTextField);
		
		JLabel lblPc = new JLabel("PC:");
		lblPc.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblPc.setBounds(211, 80, 24, 16);
		frame.getContentPane().add(lblPc);
		
		pcTextField = new JTextField();
		pcTextField.setColumns(10);
		pcTextField.setBounds(232, 79, 30, 16);
		frame.getContentPane().add(pcTextField);
		
		JLabel lblMa = new JLabel("MA:");
		lblMa.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMa.setBounds(263, 80, 24, 16);
		frame.getContentPane().add(lblMa);
		
		maTextField = new JTextField();
		maTextField.setColumns(10);
		maTextField.setBounds(285, 79, 30, 16);
		frame.getContentPane().add(maTextField);
		
		JLabel lblMd = new JLabel("MD:");
		lblMd.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMd.setBounds(315, 80, 24, 16);
		frame.getContentPane().add(lblMd);
		
		mdTextField = new JTextField();
		mdTextField.setColumns(10);
		mdTextField.setBounds(340, 79, 30, 16);
		frame.getContentPane().add(mdTextField);
		
		JLabel lblSr = new JLabel("SP:");
		lblSr.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSr.setBounds(374, 79, 24, 16);
		frame.getContentPane().add(lblSr);
		
		spTextField = new JTextField();
		spTextField.setColumns(10);
		spTextField.setBounds(396, 80, 30, 16);
		frame.getContentPane().add(spTextField);
		
		JLabel lblMainmemory = new JLabel("MainMemory:");
		lblMainmemory.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMainmemory.setBounds(123, 112, 87, 16);
		frame.getContentPane().add(lblMainmemory);
		
		mainMemoryTextField = new JTextField();
		mainMemoryTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		mainMemoryTextField.setBounds(122, 140, 322, 67);
		frame.getContentPane().add(mainMemoryTextField);
		mainMemoryTextField.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(198, 243, 117, 29);
		frame.getContentPane().add(btnExit);
	}
}

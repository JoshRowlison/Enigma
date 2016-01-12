package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;

public class Enigma implements ActionListener, ListSelectionListener {

	private boolean initialized = false;
	private HashMap<Character, JLabel> keyboard;

	private JFrame frame;
	private JTable RotorTable;
	private RotorTableModel RotorTableModel1;

	private JRadioButton tumb1Button1;
	private JRadioButton tumb2Button1;
	private JRadioButton tumb3Button1;
	private JRadioButton tumb4Button1;
	private JRadioButton tumb5Button1;

	private ButtonGroup radioGroup1;

	private JButton addRotorButton;
	private JButton clearRotorsButton;
	private JButton addPlugButton;
	private JButton clearPlugsButton;

	private JList<Character> inputJListl;
	private JList<Character> outputJList;

	Vector<Character> inVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
	Vector<Character> outVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
	Vector<Character> ringVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
	Vector<Character> notchVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
	Vector<Character> topVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
	private EnigmaMachine theMachine;
	private RotorRackTableModel rackModel;
	private PlugboardTableModel plugTableModel;

	private JSplitPane splitPane;
	private JPanel setupPane;
	private JPanel upperEnigmaPanel;

	private JPanel EnigmaPanel;
	private JButton btnO;
	private JButton btnS;
	private JButton btnP;
	private JButton btnR;
	private JButton btnN;
	private JButton btnM;
	private JButton btnH;
	private JButton btnG;
	private JButton btnI;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnQ;
	private JButton btnT;
	private JButton btnU;
	private JButton btnV;
	private JButton btnW;
	private JButton btnX;
	private JButton btnY;
	private JButton btnZ;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JButton btnE;
	private JButton btnF;
	private JLabel lblQ;
	private JLabel lblW;
	private JLabel lblE;
	private JLabel lblR;
	private JLabel lblT;
	private JLabel lblZ;
	private JLabel lblU;
	private JLabel lblI;
	private JLabel lblO;
	private JLabel lblA;
	private JLabel lblS;
	private JLabel lblD;
	private JLabel lblF;
	private JLabel lblG;
	private JLabel lblH;
	private JLabel lblJ;
	private JLabel lblK;
	private JLabel lblP;
	private JLabel lblY;
	private JLabel lblX;
	private JLabel lblC;
	private JLabel lblV;
	private JLabel lblB;
	private JLabel lblN;
	private JLabel lblM;
	private JLabel lblL;
	private JButton btnInitializeMachine;
	private JTextPane txtpnTheEnigmaMachine;
	private JPanel ringNotchPanel;
	private JLabel lblNotch;
	private JLabel lblRingSetting;

	private JScrollPane ringScroll;

	private JScrollPane notchScroll;
	private JList<Character> ringSettingList;
	private JList<Character> notchList;
	private JLabel lblInitNotComplete;
	private JLabel lblInitNotifications;
	private JPanel helpPanel;
	private JEditorPane dtrpnTheEnigmaMachine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enigma window = new Enigma();
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
	public Enigma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		theMachine = new EnigmaMachine();
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);

		rackModel = new RotorRackTableModel();
		RotorTableModel1 = new RotorTableModel(RotorBox.Rotor1.getCopy());
		plugTableModel = new PlugboardTableModel();

		frame = new JFrame();

		frame.setBounds(100, 100, 858, 803);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		radioGroup1 = new ButtonGroup();

		frame.getContentPane().add(tabbedPane1);

		GridBagLayout gbl_plugboardPane = new GridBagLayout();
		gbl_plugboardPane.columnWidths = new int[] { 150, 110, 35, 150, 0 };
		gbl_plugboardPane.rowHeights = new int[] { 10, 117, 30, 0, 0 };
		gbl_plugboardPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_plugboardPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		keyboard = new HashMap<Character, JLabel>();

		JPanel upperGridPane = new JPanel();

		upperGridPane.setLayout(new GridBagLayout());
		
				helpPanel = new JPanel();
				tabbedPane1.addTab("Help", null, helpPanel, null);
				GridBagLayout gbl_helpPanel = new GridBagLayout();
				gbl_helpPanel.columnWidths = new int[] { 15, 106, 0 };
				gbl_helpPanel.rowHeights = new int[] { 2134, 0 };
				gbl_helpPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
				gbl_helpPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
				helpPanel.setLayout(gbl_helpPanel);
				
						dtrpnTheEnigmaMachine = new JEditorPane();
						dtrpnTheEnigmaMachine.setEditable(false);
						dtrpnTheEnigmaMachine.setText(
								"The Enigma Machine was used by the German Military during WWII to send coded messages.\r\n\r\nThere were variants with special designs, but the general design was consistent.\r\nGenerally used models all had 3 \"Rotors\" which mapped pins on one side to pins on another side via cross-wiring. So an input of 'A' might return 'M' and input 'M' might return 'X' etc. The Ring Setting defined an initial offset from any starting position.\r\n In addition, military models of the device had a plugboard allowing up to 10 pair-swaps among the letters in the alphabet.  So 'A' would return 'X' and 'X' would return 'A'.\r\n Pressing a key on the machine caused a single input character to enter the plugboard(either being swapped for another character or propogated straight through)  before entering the rotor at position 1,2, and 3 in sequence.  The plugboard fed back into the rotors in reverse. Thus input 'M' in the above would yield 'A' in reverse, essentially turning inputs to outputs and vice-versa.\r\n \r\nWith each key press the first rotor would \"index\" once, rotating so the wire previously corresponding to 'A' now corresponded to 'B'. Thus if 'A' mapped to 'M', after indexing 'B' mapped to 'N'. Each rotor had a notch on it that would, when the notch rotated to the correct position, index the next rotor in sequence. Thus the rotor at the first would index every keypress, and (ignoring initial offset) the second rotor would index ever 26 keypresses, with the third indexing every 676 keypresses. Subsequent keypresses would never result in the same value being returned and it was mechanically impossible for any keypress to return its own value (that is 'A' lighting 'A').\r\n \r\nThis simulation neglects the value of the value at the \"Top\" of the rotor. Essentially, any combination of Ring Setting and starting position can be emulated using only the Ring Setting, so there\u2019s no point in simulating the same process twice.\r\n\r\nTo use the simulation, first select a Rotor, a Ring Setting and a Notch position, click Add Rotor and do the same for the second and third Rotors.\r\n\r\nPlugs in the plugboard are assigned by choosing an input and an output to swap, up to 10 may be selected and added to the board.\r\n\r\nAfter all desired Plugs and Rotors are added, click Initialize to prepare the machine for use. Select the Enigma tab and begin inputting letters.\r\n");
						GridBagConstraints gbc_dtrpnTheEnigmaMachine = new GridBagConstraints();
						gbc_dtrpnTheEnigmaMachine.fill = GridBagConstraints.BOTH;
						gbc_dtrpnTheEnigmaMachine.anchor = GridBagConstraints.NORTHWEST;
						gbc_dtrpnTheEnigmaMachine.gridx = 1;
						gbc_dtrpnTheEnigmaMachine.gridy = 0;
						helpPanel.add(dtrpnTheEnigmaMachine, gbc_dtrpnTheEnigmaMachine);

		setupPane = new JPanel();

		tabbedPane1.add(setupPane, "Setup");

		GridBagLayout gbl_setupPane = new GridBagLayout();
		gbl_setupPane.columnWidths = new int[] { 67, 0, 56, 127, 125, 89, 89, 172, 0 };
		gbl_setupPane.rowHeights = new int[] { 88, 491, 0, 0, 0, 44, 0, 0 };
		gbl_setupPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_setupPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setupPane.setLayout(gbl_setupPane);

		JPanel buttonPanel1 = new JPanel();

		buttonPanel1.setLayout(new GridBagLayout());

		tumb1Button1 = new JRadioButton("Rotor 1");
		tumb1Button1.setActionCommand("1");
		tumb1Button1.addActionListener(this);
		tumb1Button1.setSelected(true);

		GridBagConstraints gbc_Tumb1 = new GridBagConstraints();
		gbc_Tumb1.insets = new Insets(0, 5, 5, 5);
		gbc_Tumb1.gridx = 0;
		gbc_Tumb1.gridy = 0;
		radioGroup1.add(tumb1Button1);

		buttonPanel1.add(tumb1Button1, gbc_Tumb1);

		tumb2Button1 = new JRadioButton("Rotor 2");
		tumb2Button1.setActionCommand("2");
		tumb2Button1.addActionListener(this);

		GridBagConstraints gbc_Tumb2 = new GridBagConstraints();
		gbc_Tumb2.insets = new Insets(0, 0, 5, 5);
		gbc_Tumb2.gridx = 0;
		gbc_Tumb2.gridy = 1;
		radioGroup1.add(tumb2Button1);
		buttonPanel1.add(tumb2Button1, gbc_Tumb2);

		tumb3Button1 = new JRadioButton("Rotor 3");
		tumb3Button1.setActionCommand("3");
		tumb3Button1.addActionListener(this);

		GridBagConstraints gbc_Tumb3 = new GridBagConstraints();
		gbc_Tumb3.insets = new Insets(0, 0, 5, 5);
		gbc_Tumb3.gridx = 0;
		gbc_Tumb3.gridy = 2;
		radioGroup1.add(tumb3Button1);
		buttonPanel1.add(tumb3Button1, gbc_Tumb3);

		tumb4Button1 = new JRadioButton("Rotor 4");
		tumb4Button1.setActionCommand("4");
		tumb4Button1.addActionListener(this);

		GridBagConstraints gbc_Tumb4 = new GridBagConstraints();
		gbc_Tumb4.insets = new Insets(0, 0, 5, 5);
		gbc_Tumb4.gridx = 0;
		gbc_Tumb4.gridy = 3;
		radioGroup1.add(tumb4Button1);
		buttonPanel1.add(tumb4Button1, gbc_Tumb4);

		tumb5Button1 = new JRadioButton("Rotor 5");
		tumb5Button1.setActionCommand("5");
		tumb5Button1.addActionListener(this);

		GridBagConstraints gbc_Tumb5 = new GridBagConstraints();
		gbc_Tumb5.insets = new Insets(0, 0, 5, 5);
		gbc_Tumb5.gridx = 0;
		gbc_Tumb5.gridy = 4;
		radioGroup1.add(tumb5Button1);
		buttonPanel1.add(tumb5Button1, gbc_Tumb5);
		GridBagConstraints gbc_buttonPanel1 = new GridBagConstraints();
		gbc_buttonPanel1.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel1.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel1.gridx = 1;
		gbc_buttonPanel1.gridy = 1;

		setupPane.add(buttonPanel1, gbc_buttonPanel1);
		RotorTable = new JTable();
		RotorTable.setPreferredScrollableViewportSize(new Dimension(450, 450));
		RotorTable.setModel(RotorTableModel1);
		GridBagConstraints gbc_RotorTable_1 = new GridBagConstraints();
		gbc_RotorTable_1.fill = GridBagConstraints.BOTH;
		gbc_RotorTable_1.insets = new Insets(0, 0, 5, 5);
		gbc_RotorTable_1.gridx = 2;
		gbc_RotorTable_1.gridy = 1;
		JScrollPane RotorScroll = new JScrollPane(RotorTable);

		setupPane.add(RotorScroll, gbc_RotorTable_1);

		JPanel plugTablePanel = new JPanel();
		plugTablePanel.setLayout(new BorderLayout());
		JTable plugTable = new JTable();
		plugTable.setModel(plugTableModel);
		plugTable.setFillsViewportHeight(true);
		plugTablePanel.setLayout(new BorderLayout());

		JTableHeader plugHeader = plugTable.getTableHeader();

		ringNotchPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		setupPane.add(ringNotchPanel, gbc_panel);
		GridBagLayout gbl_ringNotchPanel = new GridBagLayout();
		gbl_ringNotchPanel.columnWidths = new int[] { 43, 41, 45 };
		gbl_ringNotchPanel.rowHeights = new int[] { 16, 473, 0 };
		gbl_ringNotchPanel.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_ringNotchPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };

		ringNotchPanel.setLayout(gbl_ringNotchPanel);

		lblRingSetting = new JLabel("Ring ");
		GridBagConstraints gbc_lblRingSetting = new GridBagConstraints();
		gbc_lblRingSetting.fill = GridBagConstraints.BOTH;
		gbc_lblRingSetting.insets = new Insets(0, 0, 5, 5);
		gbc_lblRingSetting.gridx = 0;
		gbc_lblRingSetting.gridy = 0;
		ringNotchPanel.add(lblRingSetting, gbc_lblRingSetting);

		lblNotch = new JLabel("Notch");
		GridBagConstraints gbc_lblNotch = new GridBagConstraints();
		gbc_lblNotch.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotch.gridx = 2;
		gbc_lblNotch.gridy = 0;
		ringNotchPanel.add(lblNotch, gbc_lblNotch);

		ringSettingList = new JList<Character>(ringVector);
		ringSettingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ringSettingList.setSelectedIndex(0);
		ringSettingList.setVisibleRowCount(26);
		ringSettingList.addListSelectionListener(this);

		ringScroll = new JScrollPane(ringSettingList);
		GridBagConstraints gbc_ringScroll = new GridBagConstraints();
		gbc_ringScroll.fill = GridBagConstraints.BOTH;
		gbc_ringScroll.insets = new Insets(0, 0, 0, 5);
		gbc_ringScroll.gridx = 0;
		gbc_ringScroll.gridy = 1;
		ringNotchPanel.add(ringScroll, gbc_ringScroll);

		notchList = new JList<Character>(notchVector);
		notchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		notchList.setSelectedIndex(0);
		notchList.setVisibleRowCount(26);
		notchList.addListSelectionListener(this);

		notchScroll = new JScrollPane(notchList);
		GridBagConstraints gbc_notchScroll = new GridBagConstraints();
		gbc_notchScroll.fill = GridBagConstraints.BOTH;
		gbc_notchScroll.gridx = 2;
		gbc_notchScroll.gridy = 1;
		ringNotchPanel.add(notchScroll, gbc_notchScroll);
		GridBagConstraints gbc_plugPickPanel_1 = new GridBagConstraints();
		gbc_plugPickPanel_1.fill = GridBagConstraints.BOTH;
		gbc_plugPickPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_plugPickPanel_1.gridx = 5;
		gbc_plugPickPanel_1.gridy = 1;

		JPanel plugPickPanel = new JPanel();
		GridBagLayout gbl_plugPickPanel = new GridBagLayout();
		gbl_plugPickPanel.columnWidths = new int[] { 45, 30, 45 };
		gbl_plugPickPanel.rowHeights = new int[] { 16, 483, 0 };
		gbl_plugPickPanel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_plugPickPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		plugPickPanel.setLayout(gbl_plugPickPanel);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label_2 = new JLabel("Inputs");
		plugPickPanel.add(label_2, gbc);
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.insets = new Insets(0, 0, 5, 0);
		gbc_1.gridx = 2;
		gbc_1.gridy = 0;
		JLabel label = new JLabel("Outputs");
		plugPickPanel.add(label, gbc_1);

		inputJListl = new JList<Character>(inVector);
		JScrollPane inScroll = new JScrollPane(inputJListl);
		GridBagConstraints gbc_inScroll = new GridBagConstraints();
		gbc_inScroll.fill = GridBagConstraints.BOTH;
		gbc_inScroll.gridx = 0;
		gbc_inScroll.gridy = 1;
		plugPickPanel.add(inScroll, gbc_inScroll);
		inputJListl.setVisibleRowCount(26);
		inputJListl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		outputJList = new JList<Character>(outVector);
		JScrollPane outScroll = new JScrollPane(outputJList);
		GridBagConstraints gbc_outScroll = new GridBagConstraints();
		gbc_outScroll.fill = GridBagConstraints.BOTH;
		gbc_outScroll.gridx = 2;
		gbc_outScroll.gridy = 1;
		plugPickPanel.add(outScroll, gbc_outScroll);
		outputJList.setVisibleRowCount(26);
		outputJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setupPane.add(plugPickPanel, gbc_plugPickPanel_1);

		plugTablePanel.add(plugHeader, BorderLayout.NORTH);
		plugTablePanel.add(plugTable, BorderLayout.CENTER);
		GridBagConstraints gbc_plugTablePanel_1_1 = new GridBagConstraints();
		gbc_plugTablePanel_1_1.fill = GridBagConstraints.BOTH;
		gbc_plugTablePanel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_plugTablePanel_1_1.gridx = 6;
		gbc_plugTablePanel_1_1.gridy = 1;
		setupPane.add(plugTablePanel, gbc_plugTablePanel_1_1);

		addPlugButton = new JButton("Add Plug");
		addPlugButton.setActionCommand("addP");
		addPlugButton.addActionListener(this);

		GridBagConstraints gbc_tablePanel1_1 = new GridBagConstraints();
		gbc_tablePanel1_1.gridwidth = 2;
		gbc_tablePanel1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tablePanel1_1.anchor = GridBagConstraints.WEST;
		gbc_tablePanel1_1.insets = new Insets(0, 0, 5, 5);
		gbc_tablePanel1_1.gridx = 1;
		gbc_tablePanel1_1.gridy = 2;

		JPanel tablePanel1 = new JPanel();
		JTable rackTable = new JTable();

		tablePanel1.setLayout(new BorderLayout());

		JTableHeader rackHeader = rackTable.getTableHeader();

		rackTable.setModel(rackModel);

		tablePanel1.add(rackHeader, BorderLayout.NORTH);
		tablePanel1.add(rackTable, BorderLayout.SOUTH);

		setupPane.add(tablePanel1, gbc_tablePanel1_1);

		addRotorButton = new JButton("Add Rotor");
		GridBagConstraints gbc_addRotorButton = new GridBagConstraints();
		gbc_addRotorButton.insets = new Insets(0, 0, 5, 5);
		gbc_addRotorButton.gridx = 1;
		gbc_addRotorButton.gridy = 3;
		setupPane.add(addRotorButton, gbc_addRotorButton);
		addRotorButton.setActionCommand("Add");
		addRotorButton.addActionListener(this);
		GridBagConstraints gbc_clearRotorsButton_1 = new GridBagConstraints();
		gbc_clearRotorsButton_1.anchor = GridBagConstraints.WEST;
		gbc_clearRotorsButton_1.fill = GridBagConstraints.BOTH;
		gbc_clearRotorsButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_clearRotorsButton_1.gridx = 2;
		gbc_clearRotorsButton_1.gridy = 3;

		clearRotorsButton = new JButton("Clear Rotors");

		clearRotorsButton.setActionCommand("Clear");

		setupPane.add(clearRotorsButton, gbc_clearRotorsButton_1);
		clearRotorsButton.addActionListener(this);

		GridBagConstraints gbc_addPlugButton = new GridBagConstraints();
		gbc_addPlugButton.anchor = GridBagConstraints.WEST;
		gbc_addPlugButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPlugButton.insets = new Insets(0, 0, 5, 5);
		gbc_addPlugButton.gridx = 5;
		gbc_addPlugButton.gridy = 3;

		setupPane.add(addPlugButton, gbc_addPlugButton);

		clearPlugsButton = new JButton("Clear Plugs");
		clearPlugsButton.setActionCommand("clearP");
		clearPlugsButton.addActionListener(this);

		GridBagConstraints gbc_clearPlugsButton = new GridBagConstraints();
		gbc_clearPlugsButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_clearPlugsButton.insets = new Insets(0, 0, 5, 5);
		gbc_clearPlugsButton.gridx = 6;
		gbc_clearPlugsButton.gridy = 3;

		setupPane.add(clearPlugsButton, gbc_clearPlugsButton);

		btnInitializeMachine = new JButton("Initialize Machine");
		GridBagConstraints gbc_btnInitializeMachine = new GridBagConstraints();
		gbc_btnInitializeMachine.insets = new Insets(0, 0, 5, 5);
		gbc_btnInitializeMachine.gridx = 4;
		gbc_btnInitializeMachine.gridy = 4;
		setupPane.add(btnInitializeMachine, gbc_btnInitializeMachine);
		btnInitializeMachine.addActionListener(this);
		btnInitializeMachine.setActionCommand("Init");

		lblInitNotifications = new JLabel("Initialization Already Completed!");
		lblInitNotifications.setVisible(false);
		lblInitNotifications.setFont(new Font("Dialog", Font.BOLD, 18));
		lblInitNotifications.setForeground(Color.RED);
		GridBagConstraints gbc_lblInitNotifications = new GridBagConstraints();
		gbc_lblInitNotifications.gridwidth = 3;
		gbc_lblInitNotifications.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitNotifications.gridx = 3;
		gbc_lblInitNotifications.gridy = 5;
		setupPane.add(lblInitNotifications, gbc_lblInitNotifications);

		EnigmaPanel = new JPanel();
		tabbedPane1.addTab("Enigma", null, EnigmaPanel, null);
		GridBagLayout gbl_EnigmaPanel = new GridBagLayout();
		gbl_EnigmaPanel.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 0, 0, 40 };
		gbl_EnigmaPanel.rowHeights = new int[] { 40, 40, 40, 0, 0, 40, 40, 40, 30, 30, 30, 0, 30, 30 };
		gbl_EnigmaPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_EnigmaPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		EnigmaPanel.setLayout(gbl_EnigmaPanel);

		lblQ = new JLabel("Q");
		lblQ.setOpaque(true);
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		lblQ.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblQ = new GridBagConstraints();
		gbc_lblQ.fill = GridBagConstraints.BOTH;
		gbc_lblQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ.gridx = 0;
		gbc_lblQ.gridy = 0;
		EnigmaPanel.add(lblQ, gbc_lblQ);

		lblW = new JLabel("W");
		lblW.setOpaque(true);
		lblW.setHorizontalAlignment(SwingConstants.CENTER);
		lblW.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblW = new GridBagConstraints();
		gbc_lblW.fill = GridBagConstraints.BOTH;
		gbc_lblW.insets = new Insets(0, 0, 5, 5);
		gbc_lblW.gridx = 1;
		gbc_lblW.gridy = 0;
		EnigmaPanel.add(lblW, gbc_lblW);

		lblE = new JLabel("E");
		lblE.setOpaque(true);
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.fill = GridBagConstraints.BOTH;
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 2;
		gbc_lblE.gridy = 0;
		EnigmaPanel.add(lblE, gbc_lblE);

		lblR = new JLabel("R");
		lblR.setOpaque(true);
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.fill = GridBagConstraints.BOTH;
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.gridx = 3;
		gbc_lblR.gridy = 0;
		EnigmaPanel.add(lblR, gbc_lblR);

		lblT = new JLabel("T");
		lblT.setOpaque(true);
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblT = new GridBagConstraints();
		gbc_lblT.fill = GridBagConstraints.BOTH;
		gbc_lblT.insets = new Insets(0, 0, 5, 5);
		gbc_lblT.gridx = 4;
		gbc_lblT.gridy = 0;
		EnigmaPanel.add(lblT, gbc_lblT);

		lblZ = new JLabel("Z");
		lblZ.setOpaque(true);
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblZ = new GridBagConstraints();
		gbc_lblZ.fill = GridBagConstraints.BOTH;
		gbc_lblZ.insets = new Insets(0, 0, 5, 5);
		gbc_lblZ.gridx = 5;
		gbc_lblZ.gridy = 0;
		EnigmaPanel.add(lblZ, gbc_lblZ);

		lblU = new JLabel("U");
		lblU.setOpaque(true);
		lblU.setHorizontalAlignment(SwingConstants.CENTER);
		lblU.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblU = new GridBagConstraints();
		gbc_lblU.fill = GridBagConstraints.BOTH;
		gbc_lblU.insets = new Insets(0, 0, 5, 5);
		gbc_lblU.gridx = 6;
		gbc_lblU.gridy = 0;
		EnigmaPanel.add(lblU, gbc_lblU);

		lblI = new JLabel("I");
		lblI.setOpaque(true);
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblI = new GridBagConstraints();
		gbc_lblI.fill = GridBagConstraints.BOTH;
		gbc_lblI.insets = new Insets(0, 0, 5, 5);
		gbc_lblI.gridx = 7;
		gbc_lblI.gridy = 0;
		EnigmaPanel.add(lblI, gbc_lblI);

		lblO = new JLabel("O");
		lblO.setOpaque(true);
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblO = new GridBagConstraints();
		gbc_lblO.fill = GridBagConstraints.BOTH;
		gbc_lblO.insets = new Insets(0, 0, 5, 0);
		gbc_lblO.gridx = 8;
		gbc_lblO.gridy = 0;
		EnigmaPanel.add(lblO, gbc_lblO);

		lblA = new JLabel("A");
		lblA.setOpaque(true);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.fill = GridBagConstraints.BOTH;
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 1;
		EnigmaPanel.add(lblA, gbc_lblA);

		lblS = new JLabel("S");
		lblS.setOpaque(true);
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.fill = GridBagConstraints.BOTH;
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 1;
		gbc_lblS.gridy = 1;
		EnigmaPanel.add(lblS, gbc_lblS);

		lblD = new JLabel("D");
		lblD.setOpaque(true);
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.fill = GridBagConstraints.BOTH;
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 2;
		gbc_lblD.gridy = 1;
		EnigmaPanel.add(lblD, gbc_lblD);

		lblF = new JLabel("F");
		lblF.setOpaque(true);
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.fill = GridBagConstraints.BOTH;
		gbc_lblF.insets = new Insets(0, 0, 5, 5);
		gbc_lblF.gridx = 3;
		gbc_lblF.gridy = 1;
		EnigmaPanel.add(lblF, gbc_lblF);

		lblG = new JLabel("G");
		lblG.setOpaque(true);
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		lblG.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblG = new GridBagConstraints();
		gbc_lblG.fill = GridBagConstraints.BOTH;
		gbc_lblG.insets = new Insets(0, 0, 5, 5);
		gbc_lblG.gridx = 4;
		gbc_lblG.gridy = 1;
		EnigmaPanel.add(lblG, gbc_lblG);

		lblH = new JLabel("H");
		lblH.setOpaque(true);
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.fill = GridBagConstraints.BOTH;
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 5;
		gbc_lblH.gridy = 1;
		EnigmaPanel.add(lblH, gbc_lblH);

		lblJ = new JLabel("J");
		lblJ.setOpaque(true);
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblJ = new GridBagConstraints();
		gbc_lblJ.fill = GridBagConstraints.BOTH;
		gbc_lblJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblJ.gridx = 6;
		gbc_lblJ.gridy = 1;
		EnigmaPanel.add(lblJ, gbc_lblJ);

		lblK = new JLabel("K");
		lblK.setOpaque(true);
		lblK.setHorizontalAlignment(SwingConstants.CENTER);
		lblK.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblK = new GridBagConstraints();
		gbc_lblK.fill = GridBagConstraints.BOTH;
		gbc_lblK.insets = new Insets(0, 0, 5, 5);
		gbc_lblK.gridx = 7;
		gbc_lblK.gridy = 1;
		EnigmaPanel.add(lblK, gbc_lblK);

		lblP = new JLabel("P");
		lblP.setOpaque(true);
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		lblP.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.fill = GridBagConstraints.BOTH;
		gbc_lblP.insets = new Insets(0, 0, 5, 5);
		gbc_lblP.gridx = 0;
		gbc_lblP.gridy = 2;
		EnigmaPanel.add(lblP, gbc_lblP);

		lblY = new JLabel("Y");
		lblY.setOpaque(true);
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.fill = GridBagConstraints.BOTH;
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 2;
		EnigmaPanel.add(lblY, gbc_lblY);

		lblX = new JLabel("X");
		lblX.setOpaque(true);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.fill = GridBagConstraints.BOTH;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 2;
		gbc_lblX.gridy = 2;
		EnigmaPanel.add(lblX, gbc_lblX);

		lblC = new JLabel("C");
		lblC.setOpaque(true);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.fill = GridBagConstraints.BOTH;
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 3;
		gbc_lblC.gridy = 2;
		EnigmaPanel.add(lblC, gbc_lblC);

		lblV = new JLabel("V");
		lblV.setOpaque(true);
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		lblV.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblV = new GridBagConstraints();
		gbc_lblV.fill = GridBagConstraints.BOTH;
		gbc_lblV.insets = new Insets(0, 0, 5, 5);
		gbc_lblV.gridx = 4;
		gbc_lblV.gridy = 2;
		EnigmaPanel.add(lblV, gbc_lblV);

		lblB = new JLabel("B");
		lblB.setOpaque(true);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.fill = GridBagConstraints.BOTH;
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 5;
		gbc_lblB.gridy = 2;
		EnigmaPanel.add(lblB, gbc_lblB);

		lblN = new JLabel("N");
		lblN.setOpaque(true);
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.fill = GridBagConstraints.BOTH;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 6;
		gbc_lblN.gridy = 2;
		EnigmaPanel.add(lblN, gbc_lblN);

		lblM = new JLabel("M");
		lblM.setOpaque(true);
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.fill = GridBagConstraints.BOTH;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 7;
		gbc_lblM.gridy = 2;
		EnigmaPanel.add(lblM, gbc_lblM);

		lblL = new JLabel("L");
		lblL.setOpaque(true);
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.fill = GridBagConstraints.BOTH;
		gbc_lblL.insets = new Insets(0, 0, 5, 0);
		gbc_lblL.gridx = 8;
		gbc_lblL.gridy = 2;
		EnigmaPanel.add(lblL, gbc_lblL);

		btnQ = new JButton("Q");
		GridBagConstraints gbc_btnQ = new GridBagConstraints();
		gbc_btnQ.fill = GridBagConstraints.BOTH;
		gbc_btnQ.insets = new Insets(0, 0, 5, 5);
		gbc_btnQ.gridx = 0;
		gbc_btnQ.gridy = 5;
		EnigmaPanel.add(btnQ, gbc_btnQ);
		btnQ.setActionCommand("Q");
		btnQ.addActionListener(this);

		btnW = new JButton("W");
		GridBagConstraints gbc_btnW = new GridBagConstraints();
		gbc_btnW.fill = GridBagConstraints.BOTH;
		gbc_btnW.insets = new Insets(0, 0, 5, 5);
		gbc_btnW.gridx = 1;
		gbc_btnW.gridy = 5;
		EnigmaPanel.add(btnW, gbc_btnW);
		btnW.setActionCommand("W");
		btnW.addActionListener(this);

		btnE = new JButton("E");
		GridBagConstraints gbc_btnE = new GridBagConstraints();
		gbc_btnE.fill = GridBagConstraints.BOTH;
		gbc_btnE.insets = new Insets(0, 0, 5, 5);
		gbc_btnE.gridx = 2;
		gbc_btnE.gridy = 5;
		EnigmaPanel.add(btnE, gbc_btnE);
		btnE.setActionCommand("E");
		btnE.addActionListener(this);

		btnR = new JButton("R");
		GridBagConstraints gbc_btnR = new GridBagConstraints();
		gbc_btnR.fill = GridBagConstraints.BOTH;
		gbc_btnR.insets = new Insets(0, 0, 5, 5);
		gbc_btnR.gridx = 3;
		gbc_btnR.gridy = 5;
		EnigmaPanel.add(btnR, gbc_btnR);
		btnR.setActionCommand("R");
		btnR.addActionListener(this);

		btnT = new JButton("T");
		GridBagConstraints gbc_btnT = new GridBagConstraints();
		gbc_btnT.fill = GridBagConstraints.BOTH;
		gbc_btnT.insets = new Insets(0, 0, 5, 5);
		gbc_btnT.gridx = 4;
		gbc_btnT.gridy = 5;
		EnigmaPanel.add(btnT, gbc_btnT);
		btnT.setActionCommand("T");
		btnT.addActionListener(this);

		btnZ = new JButton("Z");
		GridBagConstraints gbc_btnZ = new GridBagConstraints();
		gbc_btnZ.fill = GridBagConstraints.BOTH;
		gbc_btnZ.insets = new Insets(0, 0, 5, 5);
		gbc_btnZ.gridx = 5;
		gbc_btnZ.gridy = 5;
		EnigmaPanel.add(btnZ, gbc_btnZ);
		btnZ.setActionCommand("Z");
		btnZ.addActionListener(this);

		btnU = new JButton("U");
		GridBagConstraints gbc_btnU = new GridBagConstraints();
		gbc_btnU.fill = GridBagConstraints.BOTH;
		gbc_btnU.insets = new Insets(0, 0, 5, 5);
		gbc_btnU.gridx = 6;
		gbc_btnU.gridy = 5;
		EnigmaPanel.add(btnU, gbc_btnU);
		btnU.setActionCommand("U");
		btnU.addActionListener(this);

		btnI = new JButton("I");
		GridBagConstraints gbc_btnI = new GridBagConstraints();
		gbc_btnI.fill = GridBagConstraints.BOTH;
		gbc_btnI.insets = new Insets(0, 0, 5, 5);
		gbc_btnI.gridx = 7;
		gbc_btnI.gridy = 5;
		EnigmaPanel.add(btnI, gbc_btnI);
		btnI.setActionCommand("I");
		btnI.addActionListener(this);

		btnO = new JButton("O");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 8;
		gbc_btnNewButton_3.gridy = 5;
		EnigmaPanel.add(btnO, gbc_btnNewButton_3);
		btnO.setActionCommand("O");
		btnO.addActionListener(this);

		btnA = new JButton("A");
		btnA.addActionListener(this);
		GridBagConstraints gbc_btnA = new GridBagConstraints();
		gbc_btnA.fill = GridBagConstraints.BOTH;
		gbc_btnA.insets = new Insets(0, 0, 5, 5);
		gbc_btnA.gridx = 0;
		gbc_btnA.gridy = 6;
		EnigmaPanel.add(btnA, gbc_btnA);
		btnA.setActionCommand("A");

		btnS = new JButton("S");
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.fill = GridBagConstraints.BOTH;
		gbc_btnS.insets = new Insets(0, 0, 5, 5);
		gbc_btnS.gridx = 1;
		gbc_btnS.gridy = 6;
		EnigmaPanel.add(btnS, gbc_btnS);
		btnS.setActionCommand("S");
		btnS.addActionListener(this);

		btnD = new JButton("D");
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.fill = GridBagConstraints.BOTH;
		gbc_btnD.insets = new Insets(0, 0, 5, 5);
		gbc_btnD.gridx = 2;
		gbc_btnD.gridy = 6;
		EnigmaPanel.add(btnD, gbc_btnD);
		btnD.setActionCommand("D");
		btnD.addActionListener(this);

		btnF = new JButton("F");
		GridBagConstraints gbc_btnF = new GridBagConstraints();
		gbc_btnF.fill = GridBagConstraints.BOTH;
		gbc_btnF.insets = new Insets(0, 0, 5, 5);
		gbc_btnF.gridx = 3;
		gbc_btnF.gridy = 6;
		EnigmaPanel.add(btnF, gbc_btnF);
		btnF.setActionCommand("F");
		btnF.addActionListener(this);

		btnG = new JButton("G");
		GridBagConstraints gbc_btnG = new GridBagConstraints();
		gbc_btnG.fill = GridBagConstraints.BOTH;
		gbc_btnG.insets = new Insets(0, 0, 5, 5);
		gbc_btnG.gridx = 4;
		gbc_btnG.gridy = 6;
		EnigmaPanel.add(btnG, gbc_btnG);
		btnG.setActionCommand("G");
		btnG.addActionListener(this);

		btnH = new JButton("H");
		GridBagConstraints gbc_btnH = new GridBagConstraints();
		gbc_btnH.fill = GridBagConstraints.BOTH;
		gbc_btnH.insets = new Insets(0, 0, 5, 5);
		gbc_btnH.gridx = 5;
		gbc_btnH.gridy = 6;
		EnigmaPanel.add(btnH, gbc_btnH);
		btnH.setActionCommand("H");
		btnH.addActionListener(this);

		btnJ = new JButton("J");
		GridBagConstraints gbc_btnJ = new GridBagConstraints();
		gbc_btnJ.fill = GridBagConstraints.BOTH;
		gbc_btnJ.insets = new Insets(0, 0, 5, 5);
		gbc_btnJ.gridx = 6;
		gbc_btnJ.gridy = 6;
		EnigmaPanel.add(btnJ, gbc_btnJ);
		btnJ.setActionCommand("J");
		btnJ.addActionListener(this);

		btnK = new JButton("K");
		GridBagConstraints gbc_btnK = new GridBagConstraints();
		gbc_btnK.fill = GridBagConstraints.BOTH;
		gbc_btnK.insets = new Insets(0, 0, 5, 5);
		gbc_btnK.gridx = 7;
		gbc_btnK.gridy = 6;
		EnigmaPanel.add(btnK, gbc_btnK);
		btnK.setActionCommand("K");
		btnK.addActionListener(this);

		btnP = new JButton("P");
		GridBagConstraints gbc_btnP = new GridBagConstraints();
		gbc_btnP.fill = GridBagConstraints.BOTH;
		gbc_btnP.insets = new Insets(0, 0, 5, 5);
		gbc_btnP.gridx = 0;
		gbc_btnP.gridy = 7;
		EnigmaPanel.add(btnP, gbc_btnP);
		btnP.setActionCommand("P");
		btnP.addActionListener(this);

		btnY = new JButton("Y");
		GridBagConstraints gbc_btnY = new GridBagConstraints();
		gbc_btnY.fill = GridBagConstraints.BOTH;
		gbc_btnY.insets = new Insets(0, 0, 5, 5);
		gbc_btnY.gridx = 1;
		gbc_btnY.gridy = 7;
		EnigmaPanel.add(btnY, gbc_btnY);
		btnY.setActionCommand("Y");
		btnY.addActionListener(this);

		btnX = new JButton("X");
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.fill = GridBagConstraints.BOTH;
		gbc_btnX.insets = new Insets(0, 0, 5, 5);
		gbc_btnX.gridx = 2;
		gbc_btnX.gridy = 7;
		EnigmaPanel.add(btnX, gbc_btnX);
		btnX.setActionCommand("X");
		btnX.addActionListener(this);

		btnC = new JButton("C");
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 5, 5);
		gbc_btnC.gridx = 3;
		gbc_btnC.gridy = 7;
		EnigmaPanel.add(btnC, gbc_btnC);
		btnC.setActionCommand("C");
		btnC.addActionListener(this);

		btnV = new JButton("V");
		GridBagConstraints gbc_btnV = new GridBagConstraints();
		gbc_btnV.fill = GridBagConstraints.BOTH;
		gbc_btnV.insets = new Insets(0, 0, 5, 5);
		gbc_btnV.gridx = 4;
		gbc_btnV.gridy = 7;
		EnigmaPanel.add(btnV, gbc_btnV);
		btnV.setActionCommand("V");
		btnV.addActionListener(this);

		btnB = new JButton("B");
		GridBagConstraints gbc_btnB = new GridBagConstraints();
		gbc_btnB.fill = GridBagConstraints.BOTH;
		gbc_btnB.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnB.insets = new Insets(0, 0, 5, 5);
		gbc_btnB.gridx = 5;
		gbc_btnB.gridy = 7;
		EnigmaPanel.add(btnB, gbc_btnB);
		btnB.setActionCommand("B");
		btnB.addActionListener(this);

		btnN = new JButton("N");
		GridBagConstraints gbc_btnN = new GridBagConstraints();
		gbc_btnN.fill = GridBagConstraints.BOTH;
		gbc_btnN.insets = new Insets(0, 0, 5, 5);
		gbc_btnN.gridx = 6;
		gbc_btnN.gridy = 7;
		EnigmaPanel.add(btnN, gbc_btnN);
		btnN.setActionCommand("N");
		btnN.addActionListener(this);

		btnM = new JButton("M");
		GridBagConstraints gbc_btnM = new GridBagConstraints();
		gbc_btnM.fill = GridBagConstraints.BOTH;
		gbc_btnM.insets = new Insets(0, 0, 5, 5);
		gbc_btnM.gridx = 7;
		gbc_btnM.gridy = 7;
		EnigmaPanel.add(btnM, gbc_btnM);
		btnM.setActionCommand("M");
		btnM.addActionListener(this);

		btnL = new JButton("L");
		GridBagConstraints gbc_btnL = new GridBagConstraints();
		gbc_btnL.fill = GridBagConstraints.BOTH;
		gbc_btnL.insets = new Insets(0, 0, 5, 0);
		gbc_btnL.gridx = 8;
		gbc_btnL.gridy = 7;
		EnigmaPanel.add(btnL, gbc_btnL);
		btnL.setActionCommand("L");
		btnL.addActionListener(this);
		keyboard.put('A', lblA);
		keyboard.put('B', lblB);
		keyboard.put('C', lblC);
		keyboard.put('D', lblD);
		keyboard.put('E', lblE);
		keyboard.put('F', lblF);
		keyboard.put('G', lblG);
		keyboard.put('H', lblH);
		keyboard.put('I', lblI);
		keyboard.put('J', lblJ);
		keyboard.put('K', lblK);
		keyboard.put('L', lblL);
		keyboard.put('M', lblM);
		keyboard.put('N', lblN);
		keyboard.put('O', lblO);
		keyboard.put('P', lblP);
		keyboard.put('Q', lblQ);
		keyboard.put('R', lblR);
		keyboard.put('S', lblS);
		keyboard.put('T', lblT);
		keyboard.put('U', lblU);
		keyboard.put('V', lblV);
		keyboard.put('W', lblW);
		keyboard.put('X', lblX);
		keyboard.put('Y', lblY);
		keyboard.put('Z', lblZ);

		lblInitNotComplete = new JLabel("Initialization not complete!");
		lblInitNotComplete.setVisible(false);
		lblInitNotComplete.setFont(new Font("Dialog", Font.BOLD, 18));
		lblInitNotComplete.setForeground(Color.RED);
		GridBagConstraints gbc_lblInitNotComplete = new GridBagConstraints();
		gbc_lblInitNotComplete.gridwidth = 5;
		gbc_lblInitNotComplete.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitNotComplete.gridx = 3;
		gbc_lblInitNotComplete.gridy = 10;
		EnigmaPanel.add(lblInitNotComplete, gbc_lblInitNotComplete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().getClass() == JRadioButton.class) {
			JRadioButton button = (JRadioButton) e.getSource();

			switch (button.getText()) {
			case "Rotor 1":
				RotorTableModel1.switchRotor(RotorBox.Rotor1.getCopy());
				break;
			case "Rotor 2":
				RotorTableModel1.switchRotor(RotorBox.Rotor2.getCopy());
				break;
			case "Rotor 3":
				RotorTableModel1.switchRotor(RotorBox.Rotor3.getCopy());
				break;
			case "Rotor 4":
				RotorTableModel1.switchRotor(RotorBox.Rotor4.getCopy());
				break;
			case "Rotor 5":
				RotorTableModel1.switchRotor(RotorBox.Rotor5.getCopy());
				break;
			}

			ringSettingList.setSelectedIndex(RotorTableModel1.getRotor().getRingSetting());
			notchList.setSelectedIndex(Rotor.STANDARD_ALPHABET.indexOf(RotorTableModel1.getRotor().getNotch()));
		}

		if (e.getSource().getClass().equals(JButton.class)) {
			JButton button = (JButton) e.getSource();
			boolean shift = false;
			switch (button.getActionCommand()) {
			case "Add":
				if (!initialized) {
					String tum = radioGroup1.getSelection().getActionCommand();

					switch (tum) {
					case "1":
						if (rackModel.add(RotorBox.Rotor1)) {
							tumb1Button1.setEnabled(false);
							shift = true;
						}
						break;
					case "2":
						if (rackModel.add(RotorBox.Rotor2)) {
							tumb2Button1.setEnabled(false);
							shift = true;
						}
						break;
					case "3":
						if (rackModel.add(RotorBox.Rotor3)) {
							tumb3Button1.setEnabled(false);
							shift = true;
						}
						break;
					case "4":
						if (rackModel.add(RotorBox.Rotor4)) {
							tumb4Button1.setEnabled(false);
							shift = true;
						}
						break;
					case "5":
						if (rackModel.add(RotorBox.Rotor5)) {
							tumb5Button1.setEnabled(false);
							shift = true;
						}
						break;
					}
					if (shift) {
						shiftSelection();
					}
					ringSettingList.setSelectedIndex(RotorTableModel1.getRotor().getRingSetting());
					notchList.setSelectedIndex(Rotor.STANDARD_ALPHABET.indexOf(RotorTableModel1.getRotor().getNotch()));
				} else {
					lblInitNotifications.setVisible(true);
				}
				break;
			case "Clear":
				if (!initialized) {
					rackModel.clear();
					tumb1Button1.setSelected(true);
					tumb1Button1.setEnabled(true);
					tumb2Button1.setEnabled(true);
					tumb3Button1.setEnabled(true);
					tumb4Button1.setEnabled(true);
					tumb5Button1.setEnabled(true);
					ringSettingList.setSelectedIndex(RotorTableModel1.getRotor().getRingSetting());
					notchList.setSelectedIndex(Rotor.STANDARD_ALPHABET.indexOf(RotorTableModel1.getRotor().getNotch()));
				} else {
					lblInitNotifications.setVisible(true);
				}
				break;
			case "addP":
				if (plugTableModel.getRowCount() <= 10 && !initialized) {
					Character inVal = inputJListl.getSelectedValue();
					Character outVal = outputJList.getSelectedValue();
					if (inVal != null && outVal != null) {
						plugTableModel.addPair(inputJListl.getSelectedValue(), outputJList.getSelectedValue());
						inVector.removeElement(inVal);
						inVector.removeElement(outVal);
						inputJListl.setListData(inVector);
						outVector.removeElement(inVal);
						outVector.removeElement(outVal);
						outputJList.setListData(outVector);
					}
				} else {
					lblInitNotifications.setVisible(true);
				}
				break;
			case "clearP":
				if (!initialized) {
					plugTableModel.clear();
					inVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
					outVector = new Vector<Character>(AlphabetMapping.STANDARD_ALPHABET);
					inputJListl.setListData(inVector);
					outputJList.setListData(outVector);
				} else {
					lblInitNotifications.setVisible(true);
				}
				break;
			case "Init":
				if (!rackModel.getRotor(2).equals(RotorBox.EMPTY)) {
					theMachine.addRotor(rackModel.getRotor(0));
					theMachine.addRotor(rackModel.getRotor(1));
					theMachine.addRotor(rackModel.getRotor(2));
					theMachine.setReflector(new Reflector());

					if (plugTableModel.getMap().size() > 0) {
						theMachine.setPlugBoard(new PlugBoard(plugTableModel.getMap()));
					} else {
						theMachine.setPlugBoard(new PlugBoard());
					}
					initialized = true;
					lblInitNotComplete.setVisible(false);
				}
				break;
			default:
				if (initialized) {
					for (JLabel currentLabel : keyboard.values()) {
						currentLabel.setBackground(Color.GRAY);
					}
					Character val = theMachine.encypher(button.getActionCommand().charAt(0));
					System.out.println(val);
					keyboard.get(val).setBackground(Color.ORANGE);
				} else {
					lblInitNotComplete.setVisible(true);
				}

				break;
			}
		}
	}

	private void shiftSelection() {
		if (tumb1Button1.isEnabled() && tumb1Button1.isSelected() == false) {
			tumb1Button1.setSelected(true);
			RotorTableModel1.switchRotor(RotorBox.Rotor1.getCopy());
		} else if (tumb2Button1.isEnabled() && tumb2Button1.isSelected() == false) {
			tumb2Button1.setSelected(true);
			RotorTableModel1.switchRotor(RotorBox.Rotor2.getCopy());
		} else if (tumb3Button1.isEnabled() && tumb3Button1.isSelected() == false) {
			tumb3Button1.setSelected(true);
			RotorTableModel1.switchRotor(RotorBox.Rotor3.getCopy());
		} else if (tumb4Button1.isEnabled() && tumb4Button1.isSelected() == false) {
			tumb4Button1.setSelected(true);
			RotorTableModel1.switchRotor(RotorBox.Rotor4.getCopy());
		} else if (tumb5Button1.isEnabled() && tumb5Button1.isSelected() == false) {
			tumb5Button1.setSelected(true);
			RotorTableModel1.switchRotor(RotorBox.Rotor5.getCopy());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if (arg0.getSource().getClass().equals(JList.class)) {
			@SuppressWarnings("unchecked")
			JList<Character> sender = (JList<Character>) arg0.getSource();

			if (sender == notchList) {
				RotorTableModel1.getRotor().setNotch(sender.getSelectedValue());
				RotorTableModel1.fireTableDataChanged();
			} else if (sender == ringSettingList) {
				RotorTableModel1.getRotor().setRingSetting(ringSettingList.getSelectedValue());
				RotorTableModel1.fireTableDataChanged();
			}

		}

	}
}

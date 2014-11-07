import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Felulet {

	private JFrame frame;
	private JTextField txtGrfTpusa;
	private JTextField txtSzablyok;
	private JTextField txtDefektls;
	private JTextField txtMtrixMrete;
	private JComboBox<String> comboMatrixMeret;
	private JTextField txtNyeresg;
	private JTextField textFieldNyereseg;
	private JTextField txtKltsg;
	private JTextField textFieldKoltseg;
	private JTextField txtSzomszd;
	private JComboBox<String> comboSzomszed;
	private JTextField txtVgtelenes;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Felulet window = new Felulet();
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
	public Felulet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtGrfTpusa = new JTextField();
		txtGrfTpusa.setBackground(SystemColor.control);
		txtGrfTpusa.setForeground(Color.BLACK);
		txtGrfTpusa.setEditable(false);
		txtGrfTpusa.setText("Gr\u00E1f t\u00EDpusa:");
		txtGrfTpusa.setBounds(10, 43, 86, 20);
		frame.getContentPane().add(txtGrfTpusa);
		txtGrfTpusa.setColumns(10);
		
		final JComboBox<String> comboGraf = new JComboBox<String>();
		comboGraf.setModel(new DefaultComboBoxModel<String>(new String[] {"Erd\u0151s-R\u00E9nyi", "Barab\u00E1si", "Small World", "Sejtautomata"}));
		comboGraf.setBounds(10, 74, 86, 20);
		
		comboGraf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>)event.getSource();
		        String selectedType = (String) combo.getSelectedItem();
		        if (selectedType.equals("Sejtautomata")){
		        	txtNyeresg.setEnabled(true);
		        	textFieldNyereseg.setEnabled(true);
		    		textFieldNyereseg.setEditable(true);
		    		
		    		txtKltsg.setEnabled(true);
		    		textFieldKoltseg.setEditable(true);
		    		textFieldKoltseg.setEnabled(true);
		    		
		    		txtSzomszd.setEnabled(true);
		    		comboSzomszed.setEnabled(true);
		    		comboSzomszed.setEditable(true);
		    		
		    		txtVgtelenes.setEnabled(true);
		    		rdbtnNewRadioButton.setEnabled(true);
		    		
		        }
			}
			
		});
		frame.getContentPane().add(comboGraf);
		
		txtSzablyok = new JTextField();
		txtSzablyok.setEditable(false);
		txtSzablyok.setText("Szab\u00E1lyok:");
		txtSzablyok.setBounds(10, 159, 86, 20);
		frame.getContentPane().add(txtSzablyok);
		txtSzablyok.setColumns(10);
		
		JComboBox<String> comboSzabaly = new JComboBox<String>();
		comboSzabaly.setModel(new DefaultComboBoxModel<String>(new String[] {"\u00D6ssz\u00E9rt\u00E9k"}));
		comboSzabaly.setBounds(10, 188, 86, 20);
		frame.getContentPane().add(comboSzabaly);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(10, 353, 89, 23);
		frame.getContentPane().add(btnStart);
		
		txtDefektls = new JTextField();
		txtDefektls.setEditable(false);
		txtDefektls.setText("Defekt\u00E1l\u00E1s: ");
		txtDefektls.setBounds(302, 43, 86, 20);
		frame.getContentPane().add(txtDefektls);
		txtDefektls.setColumns(10);
		
		JComboBox<String> comboDefekt = new JComboBox<String>();
		comboDefekt.setModel(new DefaultComboBoxModel<String>(new String[] {"0/0", "2/4", "1/10", "5/10"}));
		comboDefekt.setBounds(420, 43, 86, 20);
		frame.getContentPane().add(comboDefekt);
		
		txtMtrixMrete = new JTextField();
		txtMtrixMrete.setEditable(false);
		txtMtrixMrete.setText("M\u00E1trix m\u00E9rete: ");
		txtMtrixMrete.setBounds(302, 74, 86, 20);
		frame.getContentPane().add(txtMtrixMrete);
		txtMtrixMrete.setColumns(10);
		
		comboMatrixMeret = new JComboBox<String>();
		comboMatrixMeret.setModel(new DefaultComboBoxModel<String>(new String[] {"2x2", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10"}));
		comboMatrixMeret.setBounds(420, 74, 86, 20);
		frame.getContentPane().add(comboMatrixMeret);
		
		txtNyeresg = new JTextField();
		txtNyeresg.setEnabled(false);
		txtNyeresg.setEditable(false);
		txtNyeresg.setText("Nyeres\u00E9g: ");
		txtNyeresg.setBounds(302, 135, 86, 20);
		frame.getContentPane().add(txtNyeresg);
		txtNyeresg.setColumns(10);
		
		textFieldNyereseg = new JTextField();
		textFieldNyereseg.setEnabled(false);
		textFieldNyereseg.setEditable(false);
		textFieldNyereseg.setBounds(420, 135, 86, 20);
		frame.getContentPane().add(textFieldNyereseg);
		textFieldNyereseg.setColumns(10);
		
		txtKltsg = new JTextField();
		txtKltsg.setEnabled(false);
		txtKltsg.setEditable(false);
		txtKltsg.setText("K\u00F6lts\u00E9g:");
		txtKltsg.setBounds(302, 169, 86, 20);
		frame.getContentPane().add(txtKltsg);
		txtKltsg.setColumns(10);
		
		textFieldKoltseg = new JTextField();
		textFieldKoltseg.setEditable(false);
		textFieldKoltseg.setEnabled(false);
		textFieldKoltseg.setBounds(420, 169, 86, 20);
		frame.getContentPane().add(textFieldKoltseg);
		textFieldKoltseg.setColumns(10);
		
		txtSzomszd = new JTextField();
		txtSzomszd.setEnabled(false);
		txtSzomszd.setEditable(false);
		txtSzomszd.setText("Szomsz\u00E9d:");
		txtSzomszd.setBounds(302, 201, 86, 20);
		frame.getContentPane().add(txtSzomszd);
		txtSzomszd.setColumns(10);
		
		comboSzomszed = new JComboBox<String>();
		comboSzomszed.setEnabled(false);
		comboSzomszed.setModel(new DefaultComboBoxModel<String>(new String[] {"4", "8"}));
		comboSzomszed.setBounds(420, 200, 86, 20);
		frame.getContentPane().add(comboSzomszed);
		
		txtVgtelenes = new JTextField();
		txtVgtelenes.setEnabled(false);
		txtVgtelenes.setEditable(false);
		txtVgtelenes.setText("V\u00E9gtelenes\u00EDtve legyen?");
		txtVgtelenes.setBounds(302, 232, 148, 20);
		frame.getContentPane().add(txtVgtelenes);
		txtVgtelenes.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Igen");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setBounds(302, 259, 66, 40);
		frame.getContentPane().add(rdbtnNewRadioButton);
	}
}

package br.senai.sp.jandira.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.senai.sp.jandira.model.Tabuada;
import br.senai.sp.jandira.model.ListModelResultado;

public class FrameTabuada extends JFrame{
	private JLabel lblTitulo;
	private JLabel lblMultiplicando;
	private JLabel lblMaxMultiplicador;
	private JLabel lblResultado;
	
	private JTextField txtMultiplicando;
	private JTextField txtMaxMultiplicador;
	
	private JButton btnCalcular;
	private JButton btnLimpar;
	
	private JList<String> listResultado;
	private ListModelResultado modelResultado;
	
	private JScrollPane listResultadoScrollPane;
	
	private Font textFont;
	private Font titleFont;
	
	public FrameTabuada() {
		this.setSize(620,510);
		this.setTitle("Tabuada");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(240, 240, 240));
		
		renderComponents();
		
		this.setVisible(true);
		
		handleEvents();
	}
	
	private void renderComponents() {
		textFont = new Font("Sans Serif", Font.PLAIN, 18);
		titleFont = new Font("Sans Serif", Font.BOLD, 32);
		
		lblTitulo = new JLabel("  Tabuada");
		lblTitulo.setBounds(0, 0, this.getWidth(), 70);
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setForeground(new Color(81, 143, 245));
		lblTitulo.setFont(titleFont); 	
		
		lblMultiplicando = new JLabel("Multiplicando:", SwingConstants.RIGHT);
		lblMultiplicando.setBounds(90, 125, 120, 40);
		lblMultiplicando.setFont(textFont);
		
		txtMultiplicando = new JTextField();
		txtMultiplicando.setBounds(220, 125, 80, 40);
		txtMultiplicando.setFont(textFont);
		txtMultiplicando.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMaxMultiplicador = new JLabel("M?ximo multiplicador:", SwingConstants.RIGHT);
		lblMaxMultiplicador.setBounds(30, 175, 180, 40);
		lblMaxMultiplicador.setFont(textFont);
		
		txtMaxMultiplicador = new JTextField();
		txtMaxMultiplicador.setBounds(220, 175, 80, 40);
		txtMaxMultiplicador.setFont(textFont);
		txtMaxMultiplicador.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 300, 290, 50);
		btnCalcular.setFont(titleFont);
		btnCalcular.setBackground(new Color(147, 196, 125));
		btnCalcular.setForeground(Color.white);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(10, 360, 290, 50);
		btnLimpar.setFont(titleFont);
		btnLimpar.setBackground(Color.RED);
		btnLimpar.setForeground(Color.white);
		
		/**********************************************************************/
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(350, 125, 120, 20);
		lblResultado.setFont(new Font("Sans Serif", Font.BOLD, 18));
		lblResultado.setForeground(new Color(81, 143, 245));
		
		modelResultado = new ListModelResultado();
		
		listResultado = new JList<String>(modelResultado);
		listResultado.setFixedCellHeight(25);
		listResultado.setFont(textFont);
		
		listResultadoScrollPane = new JScrollPane(listResultado);
		listResultadoScrollPane.setBounds(350, 150, 240, 260);
		
		this.getContentPane().add(lblTitulo);
		this.getContentPane().add(lblMultiplicando);
		this.getContentPane().add(txtMultiplicando);
		this.getContentPane().add(lblMaxMultiplicador);
		this.getContentPane().add(txtMaxMultiplicador);
		this.getContentPane().add(btnCalcular);
		this.getContentPane().add(btnLimpar);
		this.getContentPane().add(lblResultado);
		this.getContentPane().add(listResultadoScrollPane);
	}

	private void handleEvents() {
		btnCalcular.addActionListener(e -> { btnCalcularClickEvent(); });
		
		btnLimpar.addActionListener(e -> { btnLimparClickEvent(); });
	}
	
	
	private void btnCalcularClickEvent() {
		if (!txtMaxMultiplicador.getText().isBlank() && !txtMultiplicando.getText().isBlank() ) {
			Tabuada calc = new Tabuada();
			calc.calcular(txtMultiplicando.getText(), txtMaxMultiplicador.getText());
			
			modelResultado.removeAllElements();
			modelResultado.addArrayOfElements(calc.getTabuada());
		}
	}
	
	private void btnLimparClickEvent() {
		modelResultado.removeAllElements();
		txtMultiplicando.grabFocus();
	}
}

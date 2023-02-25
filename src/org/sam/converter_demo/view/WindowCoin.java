package org.sam.converter_demo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.sam.converter_demo.controller.Coordinator;

public class WindowCoin extends JFrame implements ActionListener, FocusListener{
	
	private static final long serialVersionUID = 1L;
	
	private Coordinator myCoordinator;
	
	private JLabel lblTitulo;
	private JLabel lblValor;
	private JLabel lblA;
	private JTextField txtCampo;
	private JLabel lblcampoRes;
	private JLabel lblDe;
	private JLabel lblResultado1;
	private JLabel lblResultado2;
	private JLabel lblResultado3;
	private JComboBox<String> cmbCombo;
	private JButton btnCalcular;
	private JButton btnCancelar;
	private JPanel jpPanel;
	private JSeparator jsSeparador;
	
	private HashMap<Double, String> datos = new HashMap<>();
	double resultadoMonedaDolar = 0, resultadoDolarMoneda = 0, valor = 0, equivalencia = 0;
	NumberFormat formatter = new DecimalFormat("#0.0000");   
	
	public WindowCoin() {
		setSize(800, 400);		
		setLocationRelativeTo(null);
		startComponents();
		setTitle("MONEDAS");
		setResizable(false);		
	}

	private void startComponents() {		
		setLayout(null);
		
		jpPanel = new JPanel();
		jpPanel.setBackground(Color.white);
		jpPanel.setBounds(0, 0, 800, 400);
		
		jsSeparador = new JSeparator();
		jsSeparador.setForeground(new Color(7, 17, 148));
		jsSeparador.setBounds(70, 55, 255, 40);
		
		Font myFont1 = new Font("Ubuntu", Font.BOLD, 18);
		lblTitulo = new JLabel("Convertidor de monedas".toUpperCase());
		lblTitulo.setForeground(new Color(7, 17, 148));
		lblTitulo.setFont(myFont1);
		lblTitulo.setBounds(70, 30, 280, 30);
		
		Font myFont2 = new Font("Ubuntu", Font.BOLD, 16);
		lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(7, 17, 148));
		lblValor.setFont(myFont2);
		lblValor.setBounds(70, 80, 150, 40);
				
		Font myFont3 = new Font("Ubuntu", Font.PLAIN, 16);
		txtCampo = new JTextField();
		txtCampo.setBounds(70,  115, 200, 40);
		txtCampo.setFont(myFont3);		
		txtCampo.setText("1");
		txtCampo.addActionListener(this);
		txtCampo.addFocusListener(this);		
		
		lblA = new JLabel("A");
		lblA.setForeground(new Color(7, 17, 148));
		lblA.setFont(myFont2);
		lblA.setBounds(540, 80, 200, 40);
		
		Border line3 = new LineBorder(new Color(7, 17, 148));
		lblcampoRes = new JLabel();
		lblcampoRes.setBounds(540, 115, 190, 40);
		lblcampoRes.setText(" Dólares estadounidenses");
		lblcampoRes.setBorder(line3);
		lblcampoRes.setFont(myFont3);
				
		lblDe = new JLabel("De");
		lblDe.setForeground(new Color(7, 17, 148));
		lblDe.setFont(myFont2);
		lblDe.setBounds(300, 80, 150, 40);
		
		cmbCombo = new JComboBox<String>();
		cmbCombo.setBounds(290, 115, 230, 40);
		cmbCombo.setBackground(new Color(255, 255, 255));
		cmbCombo.setFont(myFont3);								
		cmbCombo.addActionListener(this);
		
			
		Border line = new LineBorder(new Color(7, 17, 148));
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(70, 180, 300, 40);
		btnCalcular.setBackground(new Color(153, 153, 255));
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setBorder(line);	
		btnCalcular.addActionListener(this);
		
		Border line2 = new LineBorder(Color.GRAY);
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(430, 180, 300, 40);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setForeground(Color.white);
		btnCancelar.setBorder(line2);	
		btnCancelar.addActionListener(this);
						
		lblResultado1 = new JLabel();
		lblResultado1.setBounds(80, 230, 680, 30);			
		lblResultado1.setFont(myFont2);
		
		lblResultado2 = new JLabel();
		lblResultado2.setBounds(80, 260, 680, 30);	
		lblResultado2.setFont(myFont3);		
	
		lblResultado3 = new JLabel();
		lblResultado3.setForeground(new Color(153, 153, 255));
		lblResultado3.setBounds(80, 290, 680, 30);	
		lblResultado3.setFont(myFont2);
		
		add(lblTitulo);
		add(jsSeparador);
		add(txtCampo);
		add(lblcampoRes);
		add(lblValor);
		add(lblDe);
		add(lblA);
		add(cmbCombo);
		add(btnCalcular);
		add(btnCancelar);
		add(lblResultado1);
		add(lblResultado2);
		add(lblResultado3);
		add(jpPanel);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	   
		
		if (e.getSource() == btnCalcular) {	
			
		//Manejo de erro, cuando campo está vacío.
			try {
				valor =  Double.valueOf(txtCampo.getText());
			}catch (NumberFormatException exexception) {				
				System.out.println(exexception.getMessage());				
				exexception.printStackTrace();
			}
			
			if(!txtCampo.getText().isEmpty()) {	
				
				datos.forEach((k, v) ->{
					if(v.equals(cmbCombo.getSelectedItem())) {
						resultadoMonedaDolar = myCoordinator.convertirMonedaDolar(valor, k);	
						resultadoDolarMoneda = myCoordinator.convertirDolarMoneda(valor, k);
						equivalencia = k;
					}
					//campo.setText("");
				});			
				
				lblResultado1.setText(" " + valor + " " + cmbCombo.getSelectedItem() + "  =  " + " $ " + formatter.format(resultadoMonedaDolar) + " USD");
				lblResultado2.setText("      1.0 " +  cmbCombo.getSelectedItem()  + "  =  $ " + equivalencia + " USD");
				lblResultado3.setText(" " + valor + " USD = " + formatter.format(resultadoDolarMoneda) + " " + cmbCombo.getSelectedItem());
				
			} else {
				JOptionPane.showInternalMessageDialog(null, "¡Ingresa un valor numérico!");
				txtCampo.setText("1");
				txtCampo.requestFocus();
			}
			
		}				
		
		if (e.getSource() == btnCancelar) {	
			
			 int reply =  JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION);
						 
			  if (reply == JOptionPane.YES_OPTION)
              {				  
				  //System.exit(0);				  
				  lblResultado1.setText("");
				  lblResultado2.setText("");
				  lblResultado3.setText("");
				  txtCampo.setText("1");
				  dispose();
              }
		}
		
	}	
		
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	@Override
	public void focusGained(FocusEvent e) {
		
		if (e.getSource() == txtCampo) {		
			
			myCoordinator.consultarPaises().forEach((k, v) -> {
				datos.put(k, v);
				cmbCombo.addItem(v);
			}); 			
			
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub		
	}
	


}
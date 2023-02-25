package org.sam.converter_demo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class WindowGrade extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private Coordinator myCoordinator;
	
	private JLabel lblTitulo;
	private JLabel lblValor;
	private JTextField txtCampo;
	private JLabel lblDe;
	private JLabel lblResultado1;
	private JLabel lblResultado2;
	private JLabel lblResultado3;
	private JComboBox<String> cmbCombo;
	private JButton btnCalcular;
	private JButton btnCancelar;
	private JPanel jpPanel;
	private JSeparator jsSeparador;
	
	double resultadoMonedaDolar = 0, resultadoDolarMoneda = 0, valor = 0, equivalencia = 0;
	
	
	public WindowGrade() {
		setSize(600, 400);		
		setLocationRelativeTo(null);
		startComponents();
		setTitle("GRADOS");
		setResizable(false);		
	}

	private void startComponents() {		
		setLayout(null);
		
		jpPanel = new JPanel();
		jpPanel.setBackground(Color.white);
		jpPanel.setBounds(0, 0, 600, 400);
		
		jsSeparador = new JSeparator();
		jsSeparador.setForeground(Color.GRAY);
		jsSeparador.setBounds(70, 55, 240, 40);
		
		Font myFont1 = new Font("Ubuntu", Font.BOLD, 18);
		lblTitulo = new JLabel("Convertidor de grados".toUpperCase());
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setFont(myFont1);
		lblTitulo.setBounds(70, 30, 280, 30);
		
		Font myFont2 = new Font("Ubuntu", Font.BOLD, 16);
		lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.GRAY);
		lblValor.setFont(myFont2);
		lblValor.setBounds(70, 80, 150, 40);
				
		Font myFont3 = new Font("Ubuntu", Font.PLAIN, 16);
		txtCampo = new JTextField();
		txtCampo.setBounds(70,  115, 210, 40);
		txtCampo.setFont(myFont3);		
		txtCampo.setText("1");
		txtCampo.addActionListener(this);		
					
		lblDe = new JLabel("De");
		lblDe.setForeground(Color.GRAY);
		lblDe.setFont(myFont2);
		lblDe.setBounds(300, 80, 150, 40);
		
		cmbCombo = new JComboBox<String>();
		cmbCombo.setBounds(300, 115, 230, 40);
		cmbCombo.setBackground(new Color(255, 255, 255));
		cmbCombo.setFont(myFont3);				
		cmbCombo.addItem("Celsius To Fahrenheit");
		cmbCombo.addItem("Celsius To Kelvin");
		cmbCombo.addItem("Celsius To Rankine");		
		cmbCombo.addItem("Fahrenheit To Celsius");
		cmbCombo.addItem("Fahrenheit To Kelvin");
		cmbCombo.addItem("Fahrenheit To Rankine");
		cmbCombo.addItem("Kelvin To Celsius");
		cmbCombo.addItem("Kelvin To Fahrenheit");
		cmbCombo.addItem("FKelvin To Rankine");
		cmbCombo.addItem("Rankine To Celsius");
		cmbCombo.addItem("Rankine To Fahrenheit");
		cmbCombo.addItem("Rankine To Kelvin");
		cmbCombo.addActionListener(this);
		
			
		Border line = new LineBorder(new Color(7, 17, 148));
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(70, 180, 210, 40);
		btnCalcular.setBackground(new Color(153, 153, 255));
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setBorder(line);	
		btnCalcular.addActionListener(this);
		
		Border line2 = new LineBorder(Color.GRAY);
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(300, 180, 230, 40);
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
		lblResultado3.setBounds(80, 290, 680, 30);	
		lblResultado3.setForeground(new Color(153, 153, 255));
		lblResultado3.setFont(myFont2);
		
		add(lblTitulo);
		add(jsSeparador);
		add(txtCampo);		
		add(lblValor);
		add(lblDe);	
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
				
				lblResultado1.setText("°"+cmbCombo.getSelectedItem().toString().substring(0, 1) + " = " + valor );
				lblResultado2.setText("      " + cmbCombo.getSelectedItem());
				lblResultado3.setText(myCoordinator.convertirGrado(valor, cmbCombo.getSelectedIndex()));
				
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

}
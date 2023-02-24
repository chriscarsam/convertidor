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
	
	private JLabel titulo;
	private JLabel lblLabel1;
	private JLabel lblLabel3;
	private JTextField campo;
	private JLabel campoRes;
	private JLabel lblLabel2;
	private JLabel lblResultado1;
	private JLabel lblResultado2;
	private JLabel lblResultado3;
	private JComboBox<String> combo;
	private JButton btn1;
	private JButton btn2;
	private JPanel bg;
	private JSeparator sub;
	
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
		
		bg = new JPanel();
		bg.setBackground(Color.white);
		bg.setBounds(0, 0, 800, 400);
		
		sub = new JSeparator();
		sub.setForeground(new Color(7, 17, 148));
		sub.setBounds(70, 55, 255, 40);
		
		Font myFont1 = new Font("Ubuntu", Font.BOLD, 18);
		titulo = new JLabel("Convertidor de monedas".toUpperCase());
		titulo.setForeground(new Color(7, 17, 148));
		titulo.setFont(myFont1);
		titulo.setBounds(70, 30, 280, 30);
		
		Font myFont2 = new Font("Ubuntu", Font.BOLD, 16);
		lblLabel1 = new JLabel("Valor");
		lblLabel1.setForeground(new Color(7, 17, 148));
		lblLabel1.setFont(myFont2);
		lblLabel1.setBounds(70, 80, 150, 40);
				
		Font myFont3 = new Font("Ubuntu", Font.PLAIN, 16);
		campo = new JTextField();
		campo.setBounds(70,  115, 200, 40);
		campo.setFont(myFont3);		
		campo.setText("1");
		campo.addActionListener(this);
		campo.addFocusListener(this);		
		
		lblLabel3 = new JLabel("A");
		lblLabel3.setForeground(new Color(7, 17, 148));
		lblLabel3.setFont(myFont2);
		lblLabel3.setBounds(540, 80, 200, 40);
		
		Border line3 = new LineBorder(new Color(7, 17, 148));
		campoRes = new JLabel();
		campoRes.setBounds(540, 115, 190, 40);
		campoRes.setText(" Dólares estadounidenses");
		campoRes.setBorder(line3);
		campoRes.setFont(myFont3);
				
		lblLabel2 = new JLabel("De");
		lblLabel2.setForeground(new Color(7, 17, 148));
		lblLabel2.setFont(myFont2);
		lblLabel2.setBounds(300, 80, 150, 40);
		
		combo = new JComboBox<String>();
		combo.setBounds(290, 115, 230, 40);
		combo.setBackground(new Color(255, 255, 255));
		combo.setFont(myFont3);								
		combo.addActionListener(this);
		
			
		Border line = new LineBorder(new Color(7, 17, 148));
		btn1 = new JButton();
		btn1.setText("Calcular");
		btn1.setBounds(70, 180, 300, 40);
		btn1.setBackground(new Color(153, 153, 255));
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBorder(line);	
		btn1.addActionListener(this);
		
		Border line2 = new LineBorder(Color.GRAY);
		btn2 = new JButton();
		btn2.setText("Cancelar");
		btn2.setBounds(430, 180, 300, 40);
		btn2.setBackground(Color.GRAY);
		btn2.setForeground(Color.white);
		btn2.setBorder(line2);	
		btn2.addActionListener(this);
						
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
		
		add(titulo);
		add(sub);
		add(campo);
		add(campoRes);
		add(lblLabel1);
		add(lblLabel2);
		add(lblLabel3);
		add(combo);
		add(btn1);
		add(btn2);
		add(lblResultado1);
		add(lblResultado2);
		add(lblResultado3);
		add(bg);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	   
		
		if (e.getSource() == btn1) {	
			
		//Manejo de erro, cuando campo está vacío.
			try {
				valor =  Double.valueOf(campo.getText());
			}catch (NumberFormatException exexception) {				
				System.out.println(exexception.getMessage());				
				exexception.printStackTrace();
			}
			
			if(!campo.getText().isEmpty()) {	
				
				datos.forEach((k, v) ->{
					if(v.equals(combo.getSelectedItem())) {
						resultadoMonedaDolar = myCoordinator.convertirMonedaDolar(valor, k);	
						resultadoDolarMoneda = myCoordinator.convertirDolarMoneda(valor, k);
						equivalencia = k;
					}
					//campo.setText("");
				});			
				
				lblResultado1.setText(" " + valor + " " + combo.getSelectedItem() + "  =  " + " $ " + formatter.format(resultadoMonedaDolar) + " USD");
				lblResultado2.setText("      1.0 " +  combo.getSelectedItem()  + "  =  $ " + equivalencia + " USD");
				lblResultado3.setText(" " + valor + " USD = " + formatter.format(resultadoDolarMoneda) + " " + combo.getSelectedItem());
				
			} else {
				JOptionPane.showInternalMessageDialog(null, "¡Ingresa un valor numérico!");
				campo.setText("1");
				campo.requestFocus();
			}
			
		}				
		
		if (e.getSource() == btn2) {	
			
			 int reply =  JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION);
						 
			  if (reply == JOptionPane.YES_OPTION)
              {				  
				  //System.exit(0);				  
				  lblResultado1.setText("");
				  lblResultado2.setText("");
				  lblResultado3.setText("");
				  campo.setText("1");
				  dispose();
              }
		}
		
	}	
		
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}

	@Override
	public void focusGained(FocusEvent e) {
		
		if (e.getSource() == campo) {		
			
			myCoordinator.consultarPaises().forEach((k, v) -> {
				datos.put(k, v);
				combo.addItem(v);
			}); 			
			
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
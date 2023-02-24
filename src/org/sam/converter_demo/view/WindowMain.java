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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.sam.converter_demo.controller.Coordinator;

public class WindowMain extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;	
	
	private Coordinator myCoordinator;
	
	private JLabel titulo;
	private JLabel lblLabel;
	private JComboBox<String> combo;
	private JButton btnSelect;
	private JButton btnCancel;
	private JPanel bg;
	private JSeparator sub;
	
	
	
	public WindowMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(570, 280);	
		setLocationRelativeTo(null);
		setTitle("MENÚ");
		setResizable(false);
		
		startComponents();
	}

	private void startComponents() {
		setLayout(null);
		
		bg = new JPanel();
		bg.setBackground(Color.white);
		bg.setBounds(0, 0, 570, 280);
		
		sub = new JSeparator();
		sub.setForeground(new Color(255, 140, 0));
		sub.setBounds(200, 45, 155, 40);
		
		Font myFont1 = new Font("Ubuntu", Font.BOLD, 18);
		titulo = new JLabel("CONVERTIDORES");
		titulo.setFont(myFont1);
		titulo.setForeground(new Color(255, 140, 0));
		titulo.setBounds(200, 20, 280, 30);
		
		Font myFont2 = new Font("Ubuntu", Font.BOLD, 16);
		lblLabel = new JLabel("Seleccione :");
		lblLabel.setForeground(new Color(255, 140, 0));
		lblLabel.setFont(myFont2);
		lblLabel.setBounds(75, 70, 200, 40);
					
		Font myFont3 = new Font("Ubuntu", Font.PLAIN, 16);
		combo = new JComboBox<String>();
		combo.setBounds(200, 70, 300, 40);
		combo.setBackground(new Color(255, 255, 255));
		combo.setFont(myFont3);
		combo.addItem("      $    ->     Convertir moneda");
		combo.addItem("      °     ->     Convertir grados");
		
		Border line = new LineBorder(new Color(255, 165, 0));
		btnSelect = new JButton("Select");
		btnSelect.setBounds(75, 140, 200, 40);
		btnSelect.setBackground(new Color(255, 140, 0));
		btnSelect.setForeground(new Color(255, 255, 255));
		btnSelect.setBorder(line);
		btnSelect.addActionListener(this);
		
		Border line2 = new LineBorder(Color.DARK_GRAY);
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(300, 140, 200, 40);
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBorder(line2);
		btnCancel.addActionListener(this);
		
		add(titulo);
		add(sub);
		add(lblLabel);
		add(combo);
		add(btnSelect);
		add(btnCancel);
		add(bg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		if (e.getSource() == btnSelect) {
			myCoordinator.showWindow(combo.getSelectedIndex());					
		}		
		
		if (e.getSource() == btnCancel) {
			 int reply =  JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION);
			 
			  if (reply == JOptionPane.YES_OPTION)
             {		
				  System.exit(0);
             }
		}
		
	}

	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}
	
}

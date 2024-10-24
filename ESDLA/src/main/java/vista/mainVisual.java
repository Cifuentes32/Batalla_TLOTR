package vista;

import javax.swing.*;

import controlador.controlJuego;

import java.awt.*;
import java.util.*;
import modelo.Heroes;
import modelo.Hobbits;
import modelo.Humanos;
import modelo.Bestias;
import modelo.Elfos;

public class mainVisual {

	private JTextField nombreHeroe;
	private JTextField vidaHeroe;
	private JTextField armaduraHeroe;
	private JTextField nombreBestia;
	private JTextField vidaBestia;
	private JTextField armaduraBestia;
	private JButton anadirHeroe;
	private JButton anadirBestia;
	private JButton botonSubirHeroe;
	private JButton botonBajarHeroe;
	private JButton botonEliminarHeroe;
	private JButton botonSubirBestia;
	private JButton botonBajarBestia;
	private JButton botonEliminarBestia;
	private JList areaLuchaHeroes;
	private JScrollPane scrollLuchaHeroes;
	private JList areaLuchaBestias;
	private JScrollPane scrollLuchaBestias;
	private JButton lucha;
	private JPanel panelResultado;
	private JScrollPane scrollResultadoBatalla;
	private JTextArea textAreaResultadoBatalla;
	private JComboBox<String> selectorRazaHeroes;
	private JComboBox<String> selectorRazaBestias;
	private ArrayList<Heroes> listaHeroes = new ArrayList<>();
	private ArrayList<Bestias> listaBestias = new ArrayList<>();
	private JOptionPane errorLucha;
	private JOptionPane errorCamposHeroe;
	private JOptionPane errorCamposBestia;

	public static void main(String[] args) {
		new mainVisual().iniciar();

	}

	public void iniciar() {
		JFrame ventana = new JFrame("Batalla por la Tierra Media");

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JPanel panelSuperior = new JPanel(new GridLayout(1, 2));

		JPanel panelHeroes = new JPanel(new GridBagLayout());
		JPanel panelBestias = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		nombreHeroe = new JTextField();
		nombreHeroe.setPreferredSize(new Dimension(150, 25));

		vidaHeroe = new JTextField();
		vidaHeroe.setPreferredSize(new Dimension(150, 25));

		armaduraHeroe = new JTextField();
		armaduraHeroe.setPreferredSize(new Dimension(150, 25));
		
		errorCamposHeroe = new JOptionPane();

		anadirHeroe = new JButton("Añadir Héroe");

		String[] razaHeroes = { "Elfos", "Humanos", "Hobbits" };
		selectorRazaHeroes = new JComboBox<>(razaHeroes);
		selectorRazaHeroes.setPreferredSize(new Dimension(150, 25));

		nombreBestia = new JTextField();
		nombreBestia.setPreferredSize(new Dimension(150, 25));

		vidaBestia = new JTextField();
		vidaBestia.setPreferredSize(new Dimension(150, 25));

		armaduraBestia = new JTextField();
		armaduraBestia.setPreferredSize(new Dimension(150, 25));

		anadirBestia = new JButton("Añadir Bestia");
		
		errorCamposHeroe = new JOptionPane();

		String[] razaBestias = { "Orcos", "Trasgos" };
		selectorRazaBestias = new JComboBox<>(razaBestias);
		selectorRazaBestias.setPreferredSize(new Dimension(150, 25));

		panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		panelHeroes.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Héroes"),
				BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		panelBestias.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Bestias"),
				BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		gbc.gridx = 0;
		gbc.gridy = 0;
		panelHeroes.add(new JLabel("Nombre:"), gbc);
		gbc.gridx = 1;
		panelHeroes.add(nombreHeroe, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panelHeroes.add(new JLabel("Raza:"), gbc);
		gbc.gridx = 1;
		panelHeroes.add(selectorRazaHeroes, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panelHeroes.add(new JLabel("Vida:"), gbc);
		gbc.gridx = 1;
		panelHeroes.add(vidaHeroe, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panelHeroes.add(new JLabel("Armadura:"), gbc);
		gbc.gridx = 1;
		panelHeroes.add(armaduraHeroe, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		panelHeroes.add(anadirHeroe, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBestias.add(new JLabel("Nombre:"), gbc);
		gbc.gridx = 1;
		panelBestias.add(nombreBestia, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panelBestias.add(new JLabel("Raza:"), gbc);
		gbc.gridx = 1;
		panelBestias.add(selectorRazaBestias, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panelBestias.add(new JLabel("Vida:"), gbc);
		gbc.gridx = 1;
		panelBestias.add(vidaBestia, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panelBestias.add(new JLabel("Armadura:"), gbc);
		gbc.gridx = 1;
		panelBestias.add(armaduraBestia, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		panelBestias.add(anadirBestia, gbc);

		panelSuperior.add(panelHeroes);
		panelSuperior.add(panelBestias);

		DefaultListModel<Heroes> modeloHeroes = new DefaultListModel<>();
		DefaultListModel<Bestias> modeloBestias = new DefaultListModel<>();

		JPanel panelLucha = new JPanel(new GridBagLayout());
		panelLucha.setBorder(BorderFactory.createTitledBorder("Lucha"));
		GridBagConstraints gbcLucha = new GridBagConstraints();
		gbcLucha.insets = new Insets(10, 10, 10, 10);

		JPanel panelLuchaHeroes = new JPanel(new BorderLayout());
		JPanel panelLuchaBestias = new JPanel(new BorderLayout());

		areaLuchaHeroes = new JList();
		scrollLuchaHeroes = new JScrollPane(areaLuchaHeroes);
		panelLuchaHeroes.add(scrollLuchaHeroes, BorderLayout.CENTER);

		areaLuchaBestias = new JList();
		scrollLuchaBestias = new JScrollPane(areaLuchaBestias);
		panelLuchaBestias.add(scrollLuchaBestias, BorderLayout.CENTER);

		panelLuchaHeroes.setBorder(BorderFactory.createTitledBorder("Héroes"));
		panelLuchaBestias.setBorder(BorderFactory.createTitledBorder("Bestias"));

		JPanel panelBotonesHeroes = new JPanel(new GridLayout(1, 3));
		botonSubirHeroe = new JButton("Subir Héroe");
		botonBajarHeroe = new JButton("Bajar Héroe");
		botonEliminarHeroe = new JButton("Eliminar Héroe");
		panelBotonesHeroes.add(botonSubirHeroe);
		panelBotonesHeroes.add(botonBajarHeroe);
		panelBotonesHeroes.add(botonEliminarHeroe);

		JPanel panelBotonesBestias = new JPanel(new GridLayout(1, 3));
		botonSubirBestia = new JButton("Subir Bestia");
		botonBajarBestia = new JButton("Bajar Bestia");
		botonEliminarBestia = new JButton("Eliminar Bestia");
		panelBotonesBestias.add(botonSubirBestia);
		panelBotonesBestias.add(botonBajarBestia);
		panelBotonesBestias.add(botonEliminarBestia);

		panelLuchaHeroes.add(panelBotonesHeroes, BorderLayout.SOUTH);
		panelLuchaBestias.add(panelBotonesBestias, BorderLayout.SOUTH);

		areaLuchaHeroes.setModel(modeloHeroes);
		areaLuchaBestias.setModel(modeloBestias);

		lucha = new JButton("LUCHA!!!");
		lucha.setPreferredSize(new Dimension(200, 40));
		
		errorLucha = new JOptionPane();

		gbcLucha.gridx = 0;
		gbcLucha.gridy = 0;
		gbcLucha.weightx = 0.5;
		gbcLucha.fill = GridBagConstraints.BOTH;
		panelLucha.add(panelLuchaHeroes, gbcLucha);

		gbcLucha.gridx = 1;
		gbcLucha.gridy = 0;
		gbcLucha.weightx = 0.5;
		panelLucha.add(panelLuchaBestias, gbcLucha);

		gbcLucha.gridx = 0;
		gbcLucha.gridy = 1;
		gbcLucha.gridwidth = 2;
		gbcLucha.fill = GridBagConstraints.CENTER;
		panelLucha.add(lucha, gbcLucha);

		textAreaResultadoBatalla = new JTextArea();
		textAreaResultadoBatalla.setEditable(false); 
		textAreaResultadoBatalla.setLineWrap(true);   
		textAreaResultadoBatalla.setWrapStyleWord(true);  
		textAreaResultadoBatalla.setBackground(Color.WHITE); 
		
		scrollResultadoBatalla = new JScrollPane(textAreaResultadoBatalla);
		panelResultado = new JPanel(new BorderLayout());
		panelResultado.setBorder(BorderFactory.createCompoundBorder(
		    BorderFactory.createTitledBorder("Resultados"),
		    BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));

		panelResultado.add(scrollResultadoBatalla, BorderLayout.CENTER);

		gbcLucha.gridx = 0;
		gbcLucha.gridy = 2;
		gbcLucha.gridwidth = 2;
		gbcLucha.weighty = 0.2;
		gbcLucha.fill = GridBagConstraints.BOTH;
		panelLucha.add(panelResultado, gbcLucha);
		
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(panelLucha, BorderLayout.CENTER);

		new controlJuego(this);

		ventana.add(panelPrincipal);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 900);
		ventana.setVisible(true);

	}

	public JTextField getNombreHeroe() {
		return nombreHeroe;
	}

	public JTextField getVidaHeroe() {
		return vidaHeroe;
	}

	public JTextField getArmaduraHeroe() {
		return armaduraHeroe;
	}

	public JTextField getNombreBestia() {
		return nombreBestia;
	}

	public JTextField getVidaBestia() {
		return vidaBestia;
	}

	public JTextField getArmaduraBestia() {
		return armaduraBestia;
	}

	public JComboBox<String> getSelectorRazaHeroes() {
		return selectorRazaHeroes;
	}

	public JComboBox<String> getSelectorRazaBestias() {
		return selectorRazaBestias;
	}

	public ArrayList<Heroes> getListaHeroes() {
		return listaHeroes;
	}

	public void setListaHeroes(ArrayList<Heroes> listaHeroes) {
		this.listaHeroes = listaHeroes;
	}

	public ArrayList<Bestias> getListaBestias() {
		return listaBestias;
	}

	public void setListaBestias(ArrayList<Bestias> listaBestias) {
		this.listaBestias = listaBestias;
	}

	public JButton getAnadirHeroe() {
		return anadirHeroe;
	}

	public JButton getAnadirBestia() {
		return anadirBestia;
	}

	public JScrollPane getScrollLuchaHeroes() {
		return scrollLuchaHeroes;
	}

	public void setScrollLuchaHeroes(JScrollPane scrollLuchaHeroes) {
		this.scrollLuchaHeroes = scrollLuchaHeroes;
	}

	public JScrollPane getScrollLuchaBestias() {
		return scrollLuchaBestias;
	}

	public void setScrollLuchaBestias(JScrollPane scrollLuchaBestias) {
		this.scrollLuchaBestias = scrollLuchaBestias;
	}

	public JList<Heroes> getAreaLuchaHeroes() {
		return areaLuchaHeroes;
	}

	public void setAreaLuchaHeroes(JList<Heroes> areaLuchaHeroes) {
		this.areaLuchaHeroes = areaLuchaHeroes;
	}

	public JList<Bestias> getAreaLuchaBestias() {
		return areaLuchaBestias;
	}

	public void setAreaLuchaBestias(JList<Bestias> areaLuchaBestias) {
		this.areaLuchaBestias = areaLuchaBestias;
	}

	public JButton getBotonSubirHeroe() {
		return botonSubirHeroe;
	}

	public JButton getBotonBajarHeroe() {
		return botonBajarHeroe;
	}

	public JButton getBotonEliminarHeroe() {
		return botonEliminarHeroe;
	}

	public JButton getBotonSubirBestia() {
		return botonSubirBestia;
	}

	public JButton getBotonBajarBestia() {
		return botonBajarBestia;
	}

	public JButton getBotonEliminarBestia() {
		return botonEliminarBestia;
	}

	public JPanel getPanelResultado() {
		return panelResultado;
	}


	public JButton getLucha() {
		return lucha;
	}

	
	
	public JTextArea getTextAreaResultadoBatalla() {
		return textAreaResultadoBatalla;
	}

	public void setTextAreaResultadoBatalla(String texto) {
	    textAreaResultadoBatalla.setText(texto);
	}

	public JOptionPane getErrorLucha() {
		return errorLucha;
	}

	public JOptionPane getErrorCamposHeroe() {
		return errorCamposHeroe;
	}

	public JOptionPane getErrorCamposBestia() {
		return errorCamposBestia;
	}

	
	

}

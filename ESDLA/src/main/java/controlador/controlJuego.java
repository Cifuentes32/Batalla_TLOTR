package controlador;

import vista.mainVisual;
import modelo.Bestias;
import modelo.Elfos;
import modelo.Humanos;
import modelo.Hobbits;
import modelo.Heroes;
import modelo.Orcos;
import modelo.Personaje;
import modelo.Trasgos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class controlJuego {

	private mainVisual vista;
	private ArrayList<Heroes> ejercitoHeroes;
	private ArrayList<Bestias> ejercitoBestias;

	public controlJuego(mainVisual vista) {
		this.vista = vista;
		this.ejercitoHeroes = vista.getListaHeroes();
		this.ejercitoBestias = vista.getListaBestias();
		configurarAcciones();
	}

	private void configurarAcciones() {
		vista.getAnadirHeroe().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getAreaLuchaHeroes().removeAll();
				if (validarDatosHeroe()) {
					manejarAnadirHeroe();
					mostrarHeroes();
				} else {

					return;
				}
			}
		});

		vista.getAnadirBestia().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarDatosBestia()) {
					manejarAnadirBestia();
					mostrarBestias();
				} else {
					return;
				}
			}
		});

		vista.getBotonBajarBestia().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bajarBestia();

			}
		});
		vista.getBotonSubirBestia().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				subirBestia();

			}
		});
		vista.getBotonEliminarBestia().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarBestia();

			}
		});
		vista.getBotonBajarHeroe().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bajarHeroe();
			}
		});
		vista.getBotonSubirHeroe().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				subirHeroe();

			}
		});
		vista.getBotonEliminarHeroe().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarHeroe();

			}
		});

		vista.getLucha().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				iniciarLucha();

			}
		});

	}

	private void manejarAnadirHeroe() {

		String razaHeroesSeleccionada = (String) vista.getSelectorRazaHeroes().getSelectedItem();
		String nombreHeroe = vista.getNombreHeroe().getText();
		int armaduraHeroeNuevo = Integer.parseInt(vista.getArmaduraHeroe().getText());
		int vidaHeroeNuevo = Integer.parseInt(vista.getVidaHeroe().getText());

		switch (razaHeroesSeleccionada) {
		case "Elfos":

			Elfos nuevoElfo = new Elfos(nombreHeroe, armaduraHeroeNuevo, vidaHeroeNuevo);

			ejercitoHeroes.add(nuevoElfo);

			break;

		case "Humanos":

			Humanos nuevoHumano = new Humanos(nombreHeroe, armaduraHeroeNuevo, vidaHeroeNuevo);

			ejercitoHeroes.add(nuevoHumano);

			break;

		case "Hobbits":

			Hobbits nuevoHobbit = new Hobbits(nombreHeroe, armaduraHeroeNuevo, vidaHeroeNuevo);

			ejercitoHeroes.add(nuevoHobbit);

			break;

		default:

			System.out.println("ERROR RAZA HEROE");

			break;
		}
		limpiarCamposHeroe();

	}

	private void manejarAnadirBestia() {

		String razaBestiaSeleccionada = (String) vista.getSelectorRazaBestias().getSelectedItem();
		String nombreBestia = vista.getNombreBestia().getText();
		int armaduraBestiaNuevo = Integer.parseInt(vista.getArmaduraBestia().getText());
		int vidaBestiaNuevo = Integer.parseInt(vista.getVidaBestia().getText());

		switch (razaBestiaSeleccionada) {
		case "Orcos":

			Orcos nuevoOrco = new Orcos(nombreBestia, armaduraBestiaNuevo, vidaBestiaNuevo);

			ejercitoBestias.add(nuevoOrco);

			break;

		case "Trasgos":

			Trasgos nuevoTrasgo = new Trasgos(nombreBestia, armaduraBestiaNuevo, vidaBestiaNuevo);

			ejercitoBestias.add(nuevoTrasgo);

			break;

		default:

			System.out.println("ERROR RAZA BESTIA");

			break;

		}

		limpiarCamposBestia();

	}

	private boolean validarDatosHeroe() {

		String nombreHeroe = vista.getNombreHeroe().getText().trim();
		String armaduraTexto = vista.getArmaduraHeroe().getText().trim();
		String vidaTexto = vista.getVidaHeroe().getText().trim();

		if (nombreHeroe.isEmpty() || armaduraTexto.isEmpty() || vidaTexto.isEmpty()) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir al héroe, uno o varios campos están vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarCamposInt(armaduraTexto, vidaTexto)) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir al héroe, los campos armadura y vida deben ser números.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarCamposTexto(nombreHeroe)) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir al héroe, el nombre debe contener solo texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean validarDatosBestia() {
		String nombreBestia = vista.getNombreBestia().getText().trim();
		String armaduraTexto = vista.getArmaduraBestia().getText().trim();
		String vidaTexto = vista.getVidaBestia().getText().trim();

		if (nombreBestia.isEmpty() || armaduraTexto.isEmpty() || vidaTexto.isEmpty()) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir la bestia, uno o varios campos están vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarCamposInt(armaduraTexto, vidaTexto)) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir bestia, los campos armadura y vida deben ser números.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!validarCamposTexto(nombreBestia)) {
			vista.getErrorCamposHeroe().showMessageDialog(null,
					"No se puede añadir la bestia, el nombre debe contener solo texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean validarCamposTexto(String campo) {
		try {
			Integer.parseInt(campo);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private boolean validarCamposInt(String armadura, String vida) {
		return esNumero(armadura) && esNumero(vida);
	}

	private boolean esNumero(String campo) {
		try {
			Integer.parseInt(campo);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void limpiarCamposHeroe() {
		vista.getNombreHeroe().setText("");
		vista.getArmaduraHeroe().setText("");
		vista.getVidaHeroe().setText("");

	}

	private void limpiarCamposBestia() {
		vista.getNombreBestia().setText("");
		vista.getArmaduraBestia().setText("");
		vista.getVidaBestia().setText("");
	}

	private void mostrarHeroes() {

		DefaultListModel<Heroes> modeloHeroes = new DefaultListModel<>();
		for (Heroes heroe : ejercitoHeroes) {
			modeloHeroes.addElement(heroe);
		}
		vista.getAreaLuchaHeroes().setModel(modeloHeroes);
	}

	private void mostrarBestias() {
		DefaultListModel<Bestias> modeloBestias = new DefaultListModel<>();
		for (Bestias bestia : ejercitoBestias) {
			modeloBestias.addElement(bestia);
		}
		vista.getAreaLuchaBestias().setModel(modeloBestias);
	}

	private void subirHeroe() {

		int direccion = -1;
		int indiceSeleccionado = vista.getAreaLuchaHeroes().getSelectedIndex();

		int nuevaPosicion = indiceSeleccionado + direccion;

		if (nuevaPosicion < 0 || nuevaPosicion >= ejercitoHeroes.size()) {
			return;
		}

		Heroes heroeMovido = ejercitoHeroes.get(indiceSeleccionado);

		ejercitoHeroes.remove(indiceSeleccionado);
		ejercitoHeroes.add(nuevaPosicion, heroeMovido);

		actualizarListaHeroes();

	}

	private void bajarHeroe() {
		int direccion = 1;
		int indiceSeleccionado = vista.getAreaLuchaHeroes().getSelectedIndex();

		int nuevaPosicion = indiceSeleccionado + direccion;

		if (nuevaPosicion < 0 || nuevaPosicion >= ejercitoHeroes.size()) {
			return;
		}

		Heroes heroeMovido = ejercitoHeroes.get(indiceSeleccionado);

		ejercitoHeroes.remove(indiceSeleccionado);
		ejercitoHeroes.add(nuevaPosicion, heroeMovido);

		actualizarListaHeroes();

	}

	private void eliminarHeroe() {

		Heroes heroeSeleccionado = vista.getAreaLuchaHeroes().getSelectedValue();

		ejercitoHeroes.remove(heroeSeleccionado);

		actualizarListaHeroes();

	}

	private void subirBestia() {

		int direccion = -1;
		int indiceSeleccionado = vista.getAreaLuchaBestias().getSelectedIndex();

		int nuevaPosicion = indiceSeleccionado + direccion;

		if (nuevaPosicion < 0 || nuevaPosicion >= ejercitoBestias.size()) {
			return;
		}

		Bestias bestiaMovida = ejercitoBestias.get(indiceSeleccionado);

		ejercitoBestias.remove(indiceSeleccionado);
		ejercitoBestias.add(nuevaPosicion, bestiaMovida);

		actualizarListaBestias();

	}

	private void bajarBestia() {

		int direccion = 1;
		int indiceSeleccionado = vista.getAreaLuchaBestias().getSelectedIndex();

		int nuevaPosicion = indiceSeleccionado + direccion;

		if (nuevaPosicion < 0 || nuevaPosicion >= ejercitoBestias.size()) {
			return;
		}

		Bestias bestiaMovida = ejercitoBestias.get(indiceSeleccionado);

		ejercitoBestias.remove(indiceSeleccionado);
		ejercitoBestias.add(nuevaPosicion, bestiaMovida);

		actualizarListaBestias();

	}

	private void eliminarBestia() {

		Bestias bestiaSeleccionada = vista.getAreaLuchaBestias().getSelectedValue();

		ejercitoBestias.remove(bestiaSeleccionada);

		actualizarListaBestias();

	}

	private void actualizarListaHeroes() {
		DefaultListModel<Heroes> modelo = new DefaultListModel<>();

		for (Heroes h : ejercitoHeroes) {
			modelo.addElement(h);
		}

		vista.getAreaLuchaHeroes().setModel(modelo);
	}

	private void actualizarListaBestias() {
		DefaultListModel<Bestias> modelo = new DefaultListModel<>();

		for (Bestias b : ejercitoBestias) {
			modelo.addElement(b);
		}

		vista.getAreaLuchaBestias().setModel(modelo);
	}

	private void iniciarLucha() {
		if (ejercitoHeroes.isEmpty() || ejercitoBestias.isEmpty()) {
			System.out.println("NO HAY PERSONAJES EN UNO O AMBOS EJÉRCITOS");
			vista.getErrorLucha().showMessageDialog(null,
					"No se puede iniciar la lucha, uno o ambos ejércitos están vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarResultados();
	}

	private void mostrarResultados() {
		vista.setTextAreaResultadoBatalla("");
		appendTextAreaResultadoBatalla("\nInicio del combate");
		appendTextAreaResultadoBatalla("--------------------------------------------------\n");

		while (Personaje.hayPersonajesVivosHeroes(ejercitoHeroes)
				&& Personaje.hayPersonajesVivosBestias(ejercitoBestias)) {
			for (int i = 0; i < ejercitoHeroes.size(); i++) {
				Heroes heroe = ejercitoHeroes.get(i);
				if (heroe.estaVivo()) {
					Personaje oponenteBestia = buscarOponenteVivoBestias(ejercitoBestias);

					if (oponenteBestia != null) {
						int danioHeroe = heroe.atacar();
						oponenteBestia.recibirDanio(danioHeroe);
						appendTextAreaResultadoBatalla((heroe.getNombre() + " ataca a " + oponenteBestia.getNombre()
								+ " infligiendo " + (danioHeroe - oponenteBestia.getArmadura()) + " de daño.\n"));

						if (oponenteBestia.estaVivo()) {
							int danioBestia = oponenteBestia.atacar();
							heroe.recibirDanio(danioBestia);
							appendTextAreaResultadoBatalla((oponenteBestia.getNombre() + " ataca a " + heroe.getNombre()
									+ " infligiendo " + (danioBestia - heroe.getArmadura()) + " de daño.\n"));
							if (!heroe.estaVivo()) {
								appendTextAreaResultadoBatalla(heroe.getNombre() + " ha caído.");
							}
						} else {
							appendTextAreaResultadoBatalla(oponenteBestia.getNombre() + " ha caído.");
						}

					}
				}
			}

			appendTextAreaResultadoBatalla("\nEstado actual de los Ejércitos:\n");
			appendTextAreaResultadoBatalla("Ejército de Héroes:");
			for (Personaje heroe : ejercitoHeroes) {
				appendTextAreaResultadoBatalla(heroe.toString() + "\n");
			}
			appendTextAreaResultadoBatalla("\nEjército de Bestias:");
			for (Personaje bestia : ejercitoBestias) {
				appendTextAreaResultadoBatalla(bestia.toString() + "\n");
			}
			appendTextAreaResultadoBatalla("--------------------------------------------------\n");
		}

		if (Personaje.hayPersonajesVivosHeroes(ejercitoHeroes)) {
			appendTextAreaResultadoBatalla("¡Los Héroes han ganado la batalla!");
		} else {
			appendTextAreaResultadoBatalla("¡Las Bestias han ganado la batalla!");
		}

		vista.getListaHeroes().clear();
		actualizarListaHeroes();
		vista.getListaBestias().clear();
		actualizarListaBestias();
	}

	public void appendTextAreaResultadoBatalla(String texto) {
		vista.getTextAreaResultadoBatalla().append(texto);
	}

	private static Personaje buscarOponenteVivoBestias(ArrayList<Bestias> ejercitoBestias) {
		for (Personaje p : ejercitoBestias) {
			if (p.estaVivo()) {
				return p;
			}
		}
		return null;
	}

}

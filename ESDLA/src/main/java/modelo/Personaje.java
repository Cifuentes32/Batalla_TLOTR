package modelo;

import java.util.ArrayList;

public abstract class Personaje {

	protected String nombre;
	protected int armadura;
	protected int vida;

	public Personaje(String nombre, int armadura, int vida) {
		this.nombre = nombre;
		this.armadura = armadura;
		this.vida = vida;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getArmadura() {
		return armadura;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int recibirDanio(int danio) {
		if (danio > armadura) {
			vida -= (danio - armadura);
			if (vida < 0) {
				vida = 0;
			}
		}
		return vida;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	public static boolean hayPersonajesVivos(Personaje[] ejercitoHeroes) {
		for (Personaje personaje : ejercitoHeroes) {
			if (personaje.estaVivo()) {
				return true;
			}
		}
		return false;
	}
	public static boolean hayPersonajesVivosHeroes(ArrayList<Heroes> ejercitoHeroes) {
		for (Personaje personaje : ejercitoHeroes) {
			if (personaje.estaVivo()) {
				return true;
			}
		}
		return false;
	}
	public static boolean hayPersonajesVivosBestias(ArrayList<Bestias> ejercitoBestias) {
		for (Personaje personaje : ejercitoBestias) {
			if (personaje.estaVivo()) {
				return true;
			}
		}
		return false;
	}
	
	

	public abstract int atacar();
}

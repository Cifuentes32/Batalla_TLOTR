package modelo;

public class Humanos extends Heroes{

	public Humanos(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}
	
	public void mostrarInfo() {
	    System.out.println("Humano: " + getNombre() + ", Vida: " + getVida() + ", Armadura: " + getArmadura());
	}


}

package modelo;

public class Trasgos extends Bestias{

	public Trasgos(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}

	public void mostrarInfo() {
	    System.out.println("Trasgo: " + getNombre() + ", Vida: " + getVida() + ", Armadura: " + getArmadura());
	}

	
}

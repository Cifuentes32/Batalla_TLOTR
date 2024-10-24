package modelo;

public class Hobbits extends Heroes{

	public Hobbits(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}
	
	public int danioReducido(Bestias enemigo) {
		
		int potenciaOfensiva = super.atacar();

		if (enemigo instanceof Trasgos) {
			potenciaOfensiva -= 5;
		}

		return potenciaOfensiva;

	}
	
	public void mostrarInfo() {
	    System.out.println("Hobbit: " + getNombre() + ", Vida: " + getVida() + ", Armadura: " + getArmadura());
	}


}

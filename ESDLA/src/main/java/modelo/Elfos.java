package modelo;

public class Elfos extends Heroes {

	public Elfos(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}

	public int atacar(Bestias enemigo) {
		int potenciaOfensiva = super.atacar();

		if (enemigo instanceof Orcos) {
			potenciaOfensiva += 10;
		}

		return potenciaOfensiva;

	}
	
	public void mostrarInfo() {
	    System.out.println("Elfo: " + getNombre() + ", Vida: " + getVida() + ", Armadura: " + getArmadura());
	}


}

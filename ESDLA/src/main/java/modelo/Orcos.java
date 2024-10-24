package modelo;

public class Orcos extends Bestias {

	public Orcos(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}

	public int atacar(Heroes enemigo) {
		int potenciaAtaque = super.atacar();

		int armaduraOriginal = enemigo.getArmadura();

		int armaduraReducida = (int) (enemigo.getArmadura() * 0.10);
		enemigo.setArmadura(enemigo.getArmadura() - armaduraReducida);

		if (enemigo.getArmadura() < 0) {
			enemigo.setArmadura(0);
		}

		int danioInfligido = potenciaAtaque - enemigo.getArmadura();
		if (danioInfligido > 0) {
			enemigo.recibirDanio(danioInfligido);
		}

		enemigo.setArmadura(armaduraOriginal);

		return danioInfligido;
	}

	public void mostrarInfo() {
	    System.out.println("Orco: " + getNombre() + ", Vida: " + getVida() + ", Armadura: " + getArmadura());
	}

	
	

}

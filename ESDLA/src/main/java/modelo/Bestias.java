package modelo;

public class Bestias extends Personaje {

	public Bestias(String nombre, int armadura, int vida) {
		super(nombre, armadura, vida);
	}

	@Override
	public int atacar() {

		return (int) (Math.random() * 91);

	}

	public boolean esOrco() {
		return this instanceof Orcos;
	}

	public boolean esTrasgo() {
		return this instanceof Trasgos;
	}

	@Override
    public String toString() {
        String raza = "Desconocida";
        if (this instanceof Orcos) {
            raza = "Orco";
        } else if (this instanceof Trasgos) {
            raza = "Trasgo";
        }

        return raza + " [Nombre: " + nombre + ", Armadura: " + armadura + ", Vida: " + vida + "]";
    }

}
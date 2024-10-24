package modelo;

public class Heroes extends Personaje {

    public Heroes(String nombre, int armadura, int vida) {
        super(nombre, armadura, vida); 
    }

    @Override
    public int atacar() {
        int tirada1 = (int) (Math.random() * 101); 
        int tirada2 = (int) (Math.random() * 101);
        return Math.max(tirada1, tirada2); 
    }

    @Override
    public String toString() {
        String raza = "Desconocida";
        if (this instanceof Elfos) {
            raza = "Elfo";
        } else if (this instanceof Humanos) {
            raza = "Humano";
        } else if (this instanceof Hobbits) {
            raza = "Hobbit";
        }

        return raza + " [Nombre: " + nombre + ", Armadura: " + armadura + ", Vida: " + vida + "]";
    }
	
    
    
}

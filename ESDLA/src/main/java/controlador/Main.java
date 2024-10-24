package controlador;

import modelo.Elfos;
import modelo.Hobbits;
import modelo.Humanos;
import modelo.Orcos;
import modelo.Personaje;
import modelo.Trasgos;

public class Main {

	public static void main(String[] args) {
		Personaje[] ejercitoHeroes = new Personaje[3];
		ejercitoHeroes[0] = new Elfos("Legolas", 30, 150);
		ejercitoHeroes[1] = new Hobbits("Frodo", 10, 20);
		ejercitoHeroes[2] = new Humanos("Aragorn", 50, 150);

		Personaje[] ejercitoBestias = new Personaje[3];
		ejercitoBestias[0] = new Orcos("Azog", 60, 200);
		ejercitoBestias[1] = new Trasgos("Gorbag", 30, 120);
		ejercitoBestias[2] = new Orcos("Lurtz", 50, 220);

		System.out.println("Ejército de Héroes:");
		for (Personaje heroe : ejercitoHeroes) {
			System.out.println(heroe.toString());
		}

		System.out.println("\nEjército de Bestias:");
		for (Personaje bestia : ejercitoBestias) {
			System.out.println(bestia.toString());
		}

		System.out.println("\nInicio del combate");
		System.out.println("--------------------------------------------------\n");

		while (Personaje.hayPersonajesVivos(ejercitoHeroes) && Personaje.hayPersonajesVivos(ejercitoBestias)) {

			for (int i = 0; i < ejercitoHeroes.length; i++) {
				if (ejercitoHeroes[i].estaVivo()) {
					Personaje oponenteBestia = buscarOponenteVivo(ejercitoBestias);

					if (oponenteBestia != null) {
						int danioHeroe = ejercitoHeroes[i].atacar();
						oponenteBestia.recibirDanio(danioHeroe);
						System.out.println(ejercitoHeroes[i].getNombre() + " ataca a " + oponenteBestia.getNombre()
								+ " infligiendo " + (danioHeroe- oponenteBestia.getArmadura()) + " de daño.\n");

						if (oponenteBestia.estaVivo()) {
							int danioBestia = oponenteBestia.atacar();
							ejercitoHeroes[i].recibirDanio(danioBestia);
							System.out.println(oponenteBestia.getNombre() + " ataca a " + ejercitoHeroes[i].getNombre()
									+ " infligiendo " + (danioHeroe- ejercitoHeroes[i].getArmadura()) + " de daño.\n");
							if (!ejercitoHeroes[i].estaVivo()) {
								System.out.println(ejercitoHeroes[i].getNombre() + " ha caído.");
							}
						} else {
							System.out.println(oponenteBestia.getNombre() + " ha caído.");
						}
					}
				}
			}

			System.out.println("\nEstado actual de los Ejércitos:");
			System.out.println("Ejército de Héroes:");
			for (Personaje heroe : ejercitoHeroes) {
				System.out.println(heroe.toString());
			}
			System.out.println("\nEjército de Bestias:");
			for (Personaje bestia : ejercitoBestias) {
				System.out.println(bestia.toString());
			}
			System.out.println("--------------------------------------------------\n");
		}

		if (Personaje.hayPersonajesVivos(ejercitoHeroes)) {
			System.out.println("¡Los Héroes han ganado la batalla!");
		} else if (Personaje.hayPersonajesVivos(ejercitoBestias)) {
			System.out.println("¡Las Bestias han ganado la batalla!");
		} else {
			System.out.println("¡La batalla terminó en empate, todos los personajes han caído!");
		}
	}

	private static Personaje buscarOponenteVivo(Personaje[] ejercito) {
		for (Personaje p : ejercito) {
			if (p.estaVivo()) {
				return p;
			}
		}
		return null;
	}
}

package dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Jugador;
import model.Jugadores;

public class Unmarshall {
	File ficheroPantallas = new File (System.getProperty("user.dir") + File.separator + "resources" 
			+ File.separator + "entrada.xml");
	ArrayList<Jugador> jugador =  new ArrayList<Jugador>();
	
	public ArrayList<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(ArrayList<Jugador> jugador) {
		this.jugador = jugador;
	}

	public void init() {
		Jugadores jugadores = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Jugadores.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			jugadores = (Jugadores) unmarshaller.unmarshal(ficheroEntrada());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		if (jugadores == null) System.out.println("Error");
		else {
			for (Jugador j : jugadores.getJugadores()) {
				
				System.out.println(j);
			}
			jugador.addAll(jugadores.getJugadores());
		}
	}
	
	private File ficheroEntrada() {
		String rutaDirectorio = System.getProperty("user.dir");
		String rutaFichero = rutaDirectorio  + File.separator + "resources" + File.separator
				+ "entrada.xml";
		File ficheroEntrada = new File(rutaFichero);
		return ficheroEntrada;
	}
}

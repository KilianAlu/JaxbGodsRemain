package dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Jugador;
import model.Jugadores;



public class Marshall {
	File resultado = new File (System.getProperty("user.dir") + File.separator + "resources" 
			+ File.separator + "salida.xml");
	
	
	public void generarXml(ArrayList<Jugador> jugador) {
		Jugadores jugadores  = new Jugadores();
		jugadores.setJugadores(jugador);
		try {
			JAXBContext context = JAXBContext.newInstance(Jugadores.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(jugadores, resultado);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

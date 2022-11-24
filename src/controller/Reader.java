package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dao.Marshall;
import model.Atributo;
import model.Habilidad;
import model.Jugador;

public class Reader {
	File ficheroAcciones = new File (System.getProperty("user.dir") + File.separator + "resources" 
			+ File.separator + "acciones.txt");
	
	

	public Reader(){
	
	}
	public void leerAcciones(ArrayList<Jugador> jugador) {
		ArrayList<Jugador> listaJugador =  jugador;
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader(ficheroAcciones));
			 String linia;
			
			while((linia = br.readLine()) != null) { 
				String[] accion = linia.split(" ");
				int id;
				switch (linia.charAt(0)) {
				case 'P':
					 id = Integer.parseInt(accion[1])-1;
					System.out.println("Mostrando Personaje");
					System.out.println(listaJugador.get(id));
					break;
				case 'B':
					 id = Integer.parseInt(accion[1])-1;
							for(int o=0;o<listaJugador.get(id).getHabilidades().size();o++) {
								if(listaJugador.get(id).getHabilidades().get(o).getId() == Integer.parseInt(accion[2])) {
									listaJugador.get(id).getHabilidades().remove(o);
									System.out.println("Se ha eliminado la habilidad");
									break;
								}
							}
					break;
				case 'A':
					 id = Integer.parseInt(accion[1])-1;
							if(accion.length >9) {	
								String nombre = "";
								String elemento = "";
								int posicion = 0;
								if(accion.length == 12) {
									 nombre = accion[3];
									 elemento = accion [4];
									 posicion += 2;
								}
								Atributo PS = new Atributo(Integer.parseInt(accion[posicion + 3]), "PS");
								Atributo ATQ = new Atributo(Integer.parseInt(accion[posicion + 4]), "ATQ");
								Atributo SATQ = new Atributo(Integer.parseInt(accion[posicion + 5]), "SATQ");
								Atributo STA = new Atributo(Integer.parseInt(accion[posicion + 6]), "STA");
								Atributo VEL = new Atributo(Integer.parseInt(accion[posicion + 7]), "VEL");
								Atributo DEF = new Atributo(Integer.parseInt(accion[posicion + 8]), "DEF");
								Atributo SDEF = new Atributo(Integer.parseInt(accion[posicion + 9]), "SDEF");
								Atributo[] atributo = {PS, ATQ, SATQ, STA, VEL, DEF, SDEF};
								Habilidad habilidad = new Habilidad(Integer.parseInt(accion[2]), nombre, elemento, atributo);
								listaJugador.get(id).getHabilidades().add(habilidad);
								System.out.println("La habilidad ha sido anadida.");
							}
							else {
								System.out.println("Faltan Parametros");
							}
						
					
					break;
				case 'S':
					Marshall marshall = new Marshall();
					marshall.generarXml(listaJugador);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


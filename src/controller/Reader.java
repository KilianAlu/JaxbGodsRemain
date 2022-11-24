package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
				switch (linia.charAt(0)) {
				case 'P':
					System.out.println("Mostrando Personaje");
					for(int i=0;i < listaJugador.size();i++) {
						if(Integer.toString(listaJugador.get(i).getId()).equals(accion[1])) {
							System.out.println(listaJugador.get(i));
						}
					}
					break;
				case 'B':
					for(int i=0;i < listaJugador.size();i++) {
						if(Integer.toString(listaJugador.get(i).getId()).equals(accion[1])) {
							for(int o=0;o<listaJugador.get(i).getHabilidades().size();o++) {
								if(Integer.toString(listaJugador.get(i).getHabilidades().get(o).getId()).equals(accion[2])) {
									listaJugador.get(i).getHabilidades().remove(o);
									System.out.println("Se ha eliminado la habilidad");
								}
							}
						}
					}
					break;
				case 'A':
					for(int i=0;i < listaJugador.size();i++) {
						if(Integer.toString(listaJugador.get(i).getId()).equals(accion[1])) {
							if(accion.length >9) {	
								String nombre = "";
								String elemento = "";
								if(accion.length == 12) {
									 nombre = accion[3];
									 elemento = accion [4];
								}
								Atributo PS = new Atributo(Integer.parseInt(accion[5]), "PS");
								Atributo ATQ = new Atributo(Integer.parseInt(accion[6]), "ATQ");
								Atributo SATQ = new Atributo(Integer.parseInt(accion[7]), "SATQ");
								Atributo STA = new Atributo(Integer.parseInt(accion[8]), "STA");
								Atributo VEL = new Atributo(Integer.parseInt(accion[9]), "VEL");
								Atributo DEF = new Atributo(Integer.parseInt(accion[10]), "DEF");
								Atributo SDEF = new Atributo(Integer.parseInt(accion[11]), "SDEF");
								Atributo[] atributo = {PS, ATQ, SATQ, STA, VEL, DEF, SDEF};
								Habilidad habilidad = new Habilidad(Integer.parseInt(accion[2]), nombre, elemento, atributo);
								listaJugador.get(i).getHabilidades().add(habilidad);
								System.out.println("La habilidad ha sido añadida.");
							}
						}
					}
					break;
				case 'S':
					
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


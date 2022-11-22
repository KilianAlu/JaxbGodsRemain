package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	File ficheroAcciones = new File (System.getProperty("user.dir") + File.separator + "resources" 
			+ File.separator + "acciones.txt");
	

	
	
	public Reader(){
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader(ficheroAcciones));
			 String linia;
			
			while((linia = br.readLine()) != null) { 
				String[] accion = linia.split("");
				switch (linia.charAt(0)) {
				case 'P':
					break;
				case 'B':
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


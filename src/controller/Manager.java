package controller;

import dao.Unmarshall;

public class Manager {
	
	private static  Manager manager;
	private Unmarshall unmarshall;
	private Reader reader;
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}
	
	private Manager() {
	this.unmarshall = new Unmarshall();
	this.reader = new Reader();
	}
	
	public void run() {
		unmarshall.init();
		reader.leerAcciones(unmarshall.getJugador());
	}
}

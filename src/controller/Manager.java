package controller;

import dao.Unmarshall;

public class Manager {
	
	private static  Manager manager;
	private Unmarshall unmarshall;
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}
	
	private Manager() {
	
	}
}

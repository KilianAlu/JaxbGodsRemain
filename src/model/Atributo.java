package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="atributo")
public class Atributo {
	
	private String id;
	private int value;

	public Atributo(int value,String id) {
		this.id = id;
		this.value = value;
	}

	public Atributo() {

	}

	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlValue
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ":" + value + "]";
	}
	
	
	
	
}

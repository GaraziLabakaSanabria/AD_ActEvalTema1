package ej4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Producto {
	private int id;
	private String codigo;
	private String nombre;
	private String categoria;
	private int stock;
	private double precio;
	
	public static final int CODIGO = 8;
	public static final int NOMBRE = 20;
	public static final int CATEGORIA = 12;
	
	// tamaño int + num bytes string fijas * 2 
	public static final int tamRegistroTotal = 4 + (CODIGO*2) + (NOMBRE*2) + (CATEGORIA*2) + 4 + 8;

	public void escribirString(RandomAccessFile raf, int longitud, String textoArray) throws IOException {
		while(textoArray.length() < longitud) {
			textoArray += "*";
		} 
		
		if(textoArray.length() > longitud) {
			textoArray.substring(0, longitud);
		}
		
		raf.writeChars(textoArray);
	}
	
	public String leerString(RandomAccessFile raf, int longitud) throws IOException {
		String linea = "";
		for(int i = 0; i < longitud; i++) {
			 linea += raf.readChar();
		}
		return linea;
		
	}
	
}

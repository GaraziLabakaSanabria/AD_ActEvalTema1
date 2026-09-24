package ej4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.IntBuffer;

public class Main {

	public static void main(String[] args) throws IOException {
		// tamaños individuales
		final int CODIGO = 8;
		final int NOMBRE = 20;
		final int CATEGORIA = 12;
		
		// tamaño int + num bytes string fijas * 2 
		final int tamRegistroTotal = 4 + (CODIGO*2) + (NOMBRE*2) + (CATEGORIA*2) + 4 + 8;
		
		RandomAccessFile raf = new RandomAccessFile("inventario.dat", "rw");
		
		// leer arrays del fichero y guardarlos en el inventario.dat
		
		int[] ids = {1, 2, 3, 4, 5, 6, 7, 8};

		String[] codigos = {
		    "EQ0001", "EQ0002", "EQ0003", "EQ0004",
		    "EQ0005", "EQ0006", "EQ0007", "EQ0008"
		};

		String[] nombres = {
		    "Portatil Lenovo",
		    "Monitor Dell 24",
		    "Teclado Logitech",
		    "Raton Inalambrico",
		    "Webcam Logitech",
		    "Proyector Epson",
		    "Dock USB-C",
		    "Auriculares Jabra"
		};

		String[] categorias = {
		    "portatil",
		    "monitor",
		    "periferico",
		    "periferico",
		    "periferico",
		    "proyector",
		    "accesorio",
		    "audio"
		};

		int[] stocks = {6, 12, 18, 25, 9, 4, 14, 11};

		double[] precios = {899.90, 189.95, 49.90, 24.50, 79.00, 549.99, 129.00, 159.90};

		// 1. Posicionar puntero
		byte posPuntero = (byte) raf.getFilePointer();
		System.out.println(posPuntero);
		raf.seek(posPuntero);
	
		StringBuilder sbIds = new StringBuilder();
		StringBuilder sbNombres = new StringBuilder();
		StringBuilder sbCat = new StringBuilder();
		StringBuilder sbStock = new StringBuilder();
		StringBuilder sbPrecio = new StringBuilder();
		
		Producto p = new Producto();
		
		
		for(int i = 0; i < ids.length; i++) {
			raf.writeInt(ids[i]);
			p.escribirString(raf, CODIGO, codigos[i]);
			p.escribirString(raf, NOMBRE, nombres[i]);
			p.escribirString(raf, CATEGORIA, categorias[i]);
			raf.writeInt(stocks[i]);
			raf.writeDouble(precios[i]);
			
		}
		
		
		
		
		
		
		
	}
}




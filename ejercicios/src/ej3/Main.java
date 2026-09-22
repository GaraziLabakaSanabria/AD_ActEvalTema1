package ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		FileInputStream fi = new FileInputStream(f);
		
		
		// leer cuatro bytes
		
		byte[] bytesIniciales = new byte[4];
		int numBytes = 0;
		
			bytesIniciales = fi.readNBytes(4);
			System.out.println(Arrays.toString(bytesIniciales));

			numBytes = bytesIniciales.length;
			int [] arrayZip = {80, 75, 3, 4};
			Boolean esZIP = false;
			int contadorCoincidencias = 0;
			
			System.out.println("El archivo tiene " + numBytes + " bytes en la cabecera");
			
			// ¿cuántos bytes se han leído realmente?
			// ReadNBytes ya devuelve el array con los bytes leídos
			
			// comprobar las posiciones de la cabecera
			if(numBytes < 4) {
				System.out.println("El archivo es demasiado corto");
			} else {
				// si tiene más de 4 bytes, iterar
				for (int i = 0; i < numBytes; i++) {
					// si la posición de i coincide con la posición del array, coincide
					if(bytesIniciales[i] == arrayZip[i]) {
						System.out.println("El valor coincide con el resultado esperado");
						contadorCoincidencias++;
					} else {
						System.out.println("El valor no coincide con el resultado esperaodo");
					}
				}
				
				if(contadorCoincidencias == 4) {
					esZIP = true;
					System.out.println("La cabecera coincide con un zip");
				} else {
					System.out.println("El archivo no es un zip");
				}
				
				fi.close();
			}
		}
		
		
	}

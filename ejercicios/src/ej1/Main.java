package ej1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("src/ej1/entrada.txt");
		FileReader fr = new FileReader(f);
		FileWriter fw = new FileWriter("src/ej1/salida.txt");
		StringBuilder sb = new StringBuilder();
		char caracterFinal;
		
		try {
			int i = 0;
			// mientras el fr no llegue al final del texto
			while ((i = fr.read()) != -1) {
					
				// leer carácter a carácter y convertir a char
				char caracteres = (char) i;
				String charStr = String.valueOf(caracteres);
				
				// todos los caracteres a mayúsculas y números a #
				if(Character.isDigit(caracteres)) {
					caracterFinal = '#';
				} else {
					caracterFinal = Character.toUpperCase(caracteres);
				}
				
				fw.write(caracterFinal);
				
			}
			
			fw.close();
			fr.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}

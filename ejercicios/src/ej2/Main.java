package ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// crear BufferedReader y writer
		BufferedReader br = new BufferedReader(new FileReader("src/ej2/accesos.log"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("errores.log"));
		
		
		String linea = "";
		int i = 0;
		int errores = 0;
		
		// mientras haya texto
		while ((linea = br.readLine()) != null) {
			// si la línea contiene error, pasarla al array
			if (linea.contains("error".toUpperCase())) {
				errores ++;
				bw.write(linea);
				bw.newLine();
				
				bw.append("Número de errores: " + errores);
			}
			
		}
		
		br.close();
		bw.close();
	}

}

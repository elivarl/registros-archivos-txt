package com.files.registros.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.files.registros.model.Cliente;

public class ArchivoService {

	private String ruta = "D:\\clientes.txt";
	private String contenido;

	// guardar clientes en el archivo
	public void guardarClientes(List<Cliente> listaClientes) {
		List<Cliente> listaRegistros= new ArrayList<Cliente>();

		File archivo = new File(ruta);
		// si no existe lo creamos
		if (!archivo.exists()) {
			crearArchivo(archivo, listaClientes);
		} else {// otenemos los registros
			System.out.println("Obtener registros....");
			listaRegistros=obtenerClientes();
			ArrayList<Cliente> listaNueva=(ArrayList<Cliente>) Stream.concat(listaRegistros.stream(), listaClientes.stream()).collect(Collectors.toList());
			listaNueva.forEach(c->System.out.println(c));
			//borra el archivo
			archivo.delete();
			crearArchivo(archivo, listaNueva);
		}

	}
	
	//obtener los clientes desde el archivo
	public List<Cliente> obtenerClientes() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		String registro[]= null;

		// Apertura del fichero y creacion de BufferedReader para poder
		// hacer una lectura comoda (disponer del metodo readLine()).
		archivo = new File("D:\\clientes.txt");
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				//System.out.println(linea);
				registro=linea.split("\t");
				//poner en el objeto
				listaClientes.add(new Cliente(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], registro[4], registro[5], registro[6]));
			}
			
			
			//cerrar la conexion
			if (null != fr) {
				fr.close();
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaClientes;
	}
	
	//crea el archivo
	public void crearArchivo(File archivo, List<Cliente> listaClientes ) {
		try {
			contenido="";
			// poner en una cadena los registros
			listaClientes.forEach(c -> {
				contenido += c.getId() + "\t" + c.getNombre() + "\t" + c.getDni() + "\t" + c.getDireccion() + "\t"
						+ c.getCiudad() + "\t" + c.getCorreo() + "\t" + c.getTelefono() + "\n";
			});
			archivo.createNewFile();
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public Optional<Cliente> obtenerCliente(String dni) {		
		return obtenerClientes().stream().filter(c->c.getDni().equals(dni)).findFirst();
	}
	
	public int obtenerIndex(String dni) {
		int index=0;
		for (Cliente cliente : obtenerClientes()) {
			if (cliente.getDni().equals(dni)) {
				return index;
			}
			index++;
		}
		return index;
	}
	
	public void modificarCliente(List<Cliente> listaClientes) {
		File archivo = null;
		archivo = new File("D:\\clientes.txt");
		archivo.delete();
		crearArchivo(archivo, listaClientes);
	}
	
}

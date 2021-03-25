package com.files.registros.ejecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.files.registros.model.Cliente;
import com.files.registros.servicios.ArchivoService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArchivoService service= new ArchivoService();
		
		Cliente c1= new Cliente(1, "Leonardo Acosta", "10474856", "Av. Juan de Aliaga 246", "Lima", "lacosta25744@gmail.com", "925998419");
		Cliente c2= new Cliente(2, "Juan Rodríguez", "11425698", "Av. 28 de Julio 4598", "Lima", "jjrodr9542@hotmail.com", "926485142");
		Cliente c3= new Cliente(3, "Erick Aliaga", "12365898", "Av. Quito 2365", "Cuzco", "32565865@unfv.edu.pe", "946521578");
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		//para cada acción se debe comentar y descomentar el fragmento de codigo
		
		//**************1. guardar***********************
		//listaClientes.add(c1);
		//listaClientes.add(c2);
		//service.guardarClientes(listaClientes);
		
		
		//**************2. añadir mas registros****************
		//listaClientes.add(c3);
		//service.guardarClientes(listaClientes);

		
		//******************** 3 modificar un registro ******************
		//buscar el registro
	/*Optional<Cliente>c= service.obtenerCliente("11425698");
		if (c.isPresent()) {
			System.out.println(c);
			//se modifica el regitsro
			Cliente clienteMod= c.get();
			clienteMod.setCiudad("Loja");
			System.out.println("Index: "+service.obtenerIndex("11425698"));
			int index=service.obtenerIndex("11425698");
			//obtener todos los registros
			List<Cliente> lista= service.obtenerClientes();
			lista.remove(index);
			lista.add(index,clienteMod);
			service.modificarCliente(lista);
			
			System.out.println(c);
		}else {
			System.out.println("No se encuentra el cliente");
		}*/
		
		//********************************4. eliminar un registro *****************************
		/*Optional<Cliente>clienteEliminar= service.obtenerCliente("11425698");
		if (clienteEliminar.isPresent()) {			
			//obtenemos el index
			int index=service.obtenerIndex("11425698");
			List<Cliente> lista= service.obtenerClientes();
			lista.remove(index);
			service.modificarCliente(lista);
		}else {
			System.out.println("No se encuentra el cliente");
		}*/		
		
	}

}

package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class DB {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();	
	public void agregarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		DB.listaEmpresas.add(empresa);
	}
	/**
	 * Emulacion de base de datos 
	 */
	public List<Empresa> getEmpresas(){
		return DB.listaEmpresas;
	}
}

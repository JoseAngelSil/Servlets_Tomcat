package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();	
	private static Integer llaveSecuencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa.setId(DB.llaveSecuencial++);
		empresa.setNombre("Alura");
		
		empresa2.setId(DB.llaveSecuencial++);
		empresa2.setNombre("Test");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
	}
	
	public void agregarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.setId(DB.llaveSecuencial++);
		DB.listaEmpresas.add(empresa);
		
	}
	/**
	 * Emulacion de base de datos 
	 */
	public List<Empresa> getEmpresas(){
		return DB.listaEmpresas;
	}
	
	public void eleminarEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id)
				it.remove();
		}
		/*
		for(Empresa empresa: listaEmpresas) {
			if(empresa.getId() == id) {
				listaEmpresas.remove(empresa);
				break;
			}
		}*/
	}
	public Empresa buscarEmpresaID(Integer id) {
		for(Empresa emp : listaEmpresas) {
			if(emp.getId() == id) {
				return  emp;
			}
		}
		return null;
	}
}

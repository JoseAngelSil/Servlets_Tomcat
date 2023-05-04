package com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();	
	private static List<Usuario> listaUsuarios = new ArrayList<>();
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
		
		Usuario u1 = new Usuario();
		u1.setLogin("jose");
		u1.setContrasena("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("admin");
		u2.setContrasena("jose");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
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
	public Usuario existeUsuario(String paramLogin, String paramContrasena) {
		// TODO Auto-generated method stub
		for(Usuario user: listaUsuarios) {
			if(user.esIgual(paramLogin, paramContrasena))
				return user;
		}
		return null;
	}
}

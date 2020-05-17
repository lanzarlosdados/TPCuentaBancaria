package ar.edu.unlam.pb2.cuenta;

import java.util.ArrayList;

public class Banco {
     
	private String nombre;
	private ArrayList<CuentaCorriente> listaDeCuentaCorriente;
	private ArrayList<CuentaSueldo>  listaDeCuentaSueldo;
	private ArrayList<CuentaBancaria> listaDeCuentaBancariaDeUnCliente;
	
	public Banco(String nombre) {
		super();
		this.nombre = nombre;
		listaDeCuentaCorriente = new ArrayList<>();
		listaDeCuentaSueldo = new ArrayList<>();
		listaDeCuentaBancariaDeUnCliente = new ArrayList<>();
	}
	
	
	public ArrayList<CuentaCorriente> getListaDeCuentaCorriente() {
		return listaDeCuentaCorriente;
	}


	public ArrayList<CuentaSueldo> getListaDeCuentaSueldo() {
		return listaDeCuentaSueldo;
	}


	public String getNombre() {
		return nombre;
	}


	public Boolean agregarCuentaCorriente(CuentaCorriente c){
		 
		 if(!listaDeCuentaCorriente.contains(c)){
			 
			 return listaDeCuentaCorriente.add(c);
		 }
		return false;
	} 
	
	public Boolean agregarCuentaSueldo(CuentaSueldo c){
		 
		 if(!listaDeCuentaSueldo.contains(c)){
			 
			 return listaDeCuentaSueldo.add(c);
		 }
		return false;
	} 
    
	public Boolean transferirEntreCuentaCorriente(Integer cbuOrigen, Integer cbuDestino,Double monto){
		 
		CuentaCorriente cuentaOrigen=buscarCuentaCorriente(cbuOrigen);
		CuentaCorriente cuentaDestino=buscarCuentaCorriente(cbuDestino);
		
		    if(cuentaOrigen.extraer(monto)){
		    	cuentaDestino.depositar(monto);
		    	return true;  
		    }
		return false;    
    }
	
	public Boolean transferirEntreCuentaSueldo(Integer cbuOrigen, Integer cbuDestino,Double monto){
		 
		CuentaSueldo cuentaOrigen=buscarCuentaSueldo(cbuOrigen);
		CuentaSueldo cuentaDestino=buscarCuentaSueldo(cbuDestino);
		
		    if(cuentaOrigen.extraer(monto)){
		    	cuentaDestino.depositar(monto);
		    	return true;  
		    }
		return false;    
    }
	
	
	public CuentaCorriente buscarCuentaCorriente(Integer cbu){
		
		for(CuentaCorriente cc : listaDeCuentaCorriente){
			if(cc.getCbu().equals(cbu)){
				return cc;
			}
		}
		return null;
	}
	
   public CuentaSueldo buscarCuentaSueldo(Integer cbu){
		
		for(CuentaSueldo cs : listaDeCuentaSueldo){
			if(cs.getCbu().equals(cbu)){
				return cs;
			}
		}
		return null;
	}
   
   public ArrayList<CuentaBancaria> obtenerListadoDeCuentaDeUnCliente(Integer dni){
	   
	   ArrayList<CuentaBancaria> cuentasDelBanco = new ArrayList<>();
	   cuentasDelBanco.addAll(listaDeCuentaCorriente);
	   cuentasDelBanco.addAll(listaDeCuentaSueldo);
	   
	     for(CuentaBancaria cb : cuentasDelBanco ){
	    	 
	    	 if(cb.getCliente().getDni().equals(dni)){
	    		 
	    		 listaDeCuentaBancariaDeUnCliente.add(cb);
	    	 }
	     }
	   return listaDeCuentaBancariaDeUnCliente;
   }
   
   public Integer cantidadDeCuentasDelBanco(){
	   
	   Integer cantidadDeCuentasDelBanco = listaDeCuentaCorriente.size()+listaDeCuentaSueldo.size();
	   return cantidadDeCuentasDelBanco;
   }
}

package ar.edu.unlam.pb2.cuenta;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestBanco {

	

	@Test
	public void testQueAgregeUnaCuentaCorriente() {
		
		Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d, 2000d);
		
		Boolean actual = miBanco.agregarCuentaCorriente(cuenta1);
		
		assertTrue(actual);
		
	}
    

	@Test
	public void testQueAgregeUnaCuentaSueldo() {
		
		Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		
		Boolean actual = miBanco.agregarCuentaSueldo(cuenta1);
		
		assertTrue(actual);
		
	}
    @Test
    public void testQueTransfieraEntreCuentaSueldo(){
    	Integer cbuCuentaOrigen =100;
    	Integer cbuCuentaDestino = 200;
    	Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		CuentaSueldo cuenta2 = new CuentaSueldo(200, cliente1, 10000d);
		
		miBanco.agregarCuentaSueldo(cuenta1);
		miBanco.agregarCuentaSueldo(cuenta2);
		
		Boolean transferencia=miBanco.transferirEntreCuentaSueldo(cbuCuentaOrigen, cbuCuentaDestino, 5000d);
		
		Double estadoDeSaldoEnCuentaOrigen = miBanco.buscarCuentaSueldo(cbuCuentaOrigen).getSaldo();
		Double esperado = 5000d;
		
		Double estadoDeCuentaEnCuentaDestino = miBanco.buscarCuentaSueldo(cbuCuentaDestino).getSaldo();
		Double depositadoEsperado = 15000d;
		
		assertEquals(depositadoEsperado,estadoDeCuentaEnCuentaDestino,0.01);
		assertEquals(esperado,estadoDeSaldoEnCuentaOrigen,0.01);
		assertTrue(transferencia);
		
    }
    
    @Test
    public void testQueTransfieraEntreCuentaCorriente(){
    	
    	Integer cbuCuentaOrigen =100;
    	Integer cbuCuentaDestino = 200;
    	
    	Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d,2000d);
		CuentaCorriente cuenta2 = new CuentaCorriente(200, cliente1, 10000d,2000d);
		
		miBanco.agregarCuentaCorriente(cuenta1);
		miBanco.agregarCuentaCorriente(cuenta2);
		
		Boolean transferencia=miBanco.transferirEntreCuentaCorriente(cbuCuentaOrigen, cbuCuentaDestino, 12000d);
		
		Double estadoDeSaldoEnCuentaOrigen = miBanco.buscarCuentaCorriente(cbuCuentaOrigen).getSaldo();
		Double esperado = -2100d;
		
		Double estadoDeCuentaEnCuentaDestino = miBanco.buscarCuentaCorriente(cbuCuentaDestino).getSaldo();
		Double depositadoEsperado = 22000d;
		
		assertEquals(depositadoEsperado,estadoDeCuentaEnCuentaDestino,0.01);
		assertEquals(esperado,estadoDeSaldoEnCuentaOrigen,0.01);
		assertTrue(transferencia);
		
    }
    
    @Test
    public void testQueEncuentreUnaCuentaSueldo(){
    	
    	Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		CuentaSueldo cuenta2 = new CuentaSueldo(200, cliente1, 10000d);
		
		miBanco.agregarCuentaSueldo(cuenta1);
		miBanco.agregarCuentaSueldo(cuenta2);
		
		Integer cbuABuscar=100;
		CuentaSueldo cuentaSueldo = miBanco.buscarCuentaSueldo(cbuABuscar);
		CuentaSueldo cuentaSueldoEsperada = new CuentaSueldo(100, cliente1, 10000d);

		
		assertEquals(cuentaSueldoEsperada,cuentaSueldo);
    }
    
    @Test
    public void testQueEncuentreUnaCuentaCorriente(){
    	
    	Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d,2000d);
		CuentaCorriente cuenta2 = new CuentaCorriente(200, cliente1, 10000d,2000d);
		
		miBanco.agregarCuentaCorriente(cuenta1);
		miBanco.agregarCuentaCorriente(cuenta2);
		
		Integer cbuABuscar=100;
		CuentaCorriente cuentaCorriente = miBanco.buscarCuentaCorriente(cbuABuscar);
		CuentaCorriente cuentaCorrienteEsperada = new CuentaCorriente(100, cliente1, 10000d,3000d);

		
		assertEquals(cuentaCorrienteEsperada,cuentaCorriente);
    }
    
    @Test
    public void testCantidadDeCuentasEnUnBanco(){
    	
    	Banco miBanco = new Banco("De La Plazita");
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d,2000d);
		CuentaCorriente cuenta2 = new CuentaCorriente(200, cliente1, 10000d,2000d);
		
		CuentaSueldo cuenta3= new CuentaSueldo(100, cliente1, 10000d);
		CuentaSueldo cuenta4 = new CuentaSueldo(200, cliente1, 10000d);
    	
		miBanco.agregarCuentaCorriente(cuenta1);
		miBanco.agregarCuentaCorriente(cuenta2);
		miBanco.agregarCuentaSueldo(cuenta3);
		miBanco.agregarCuentaSueldo(cuenta4);
		
		Integer cantidadDeuentasDeUnBanco = miBanco.cantidadDeCuentasDelBanco();
		Integer valorEsperado = 4 ;
		
		assertEquals(valorEsperado,cantidadDeuentasDeUnBanco);
    }
    
    @Test
    public void testObtenerListaDeCuentasDeUnCliente(){
   
    Banco miBanco = new Banco("De La Plazita");
	Cliente cliente1 = new Cliente(528,"fabian", "zarate");
	
	CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d,2000d);
	CuentaCorriente cuenta2 = new CuentaCorriente(200, cliente1, 10000d,2000d);
	
	CuentaSueldo cuenta3= new CuentaSueldo(100, cliente1, 10000d);
	CuentaSueldo cuenta4 = new CuentaSueldo(200, cliente1, 10000d);
	
	miBanco.agregarCuentaCorriente(cuenta1);
	miBanco.agregarCuentaCorriente(cuenta2);
	miBanco.agregarCuentaSueldo(cuenta3);
	miBanco.agregarCuentaSueldo(cuenta4);
    
    ArrayList<CuentaBancaria> listaDeCuentasDeUnCliente = miBanco.obtenerListadoDeCuentaDeUnCliente(528);
    
    Boolean valorActual = listaDeCuentasDeUnCliente.contains(new CuentaCorriente(100, cliente1, 10000d,2000d));
    Boolean valorActual1 = listaDeCuentasDeUnCliente.contains(new CuentaCorriente(200, cliente1, 10000d,2000d));
    Boolean valorActual2 = listaDeCuentasDeUnCliente.contains(new CuentaSueldo(100, cliente1, 10000d));
    Boolean valorActual3 = listaDeCuentasDeUnCliente.contains(new CuentaSueldo(200, cliente1, 10000d));
    
    assertTrue(valorActual);
    assertTrue(valorActual1);
    assertTrue(valorActual2);
    assertTrue(valorActual3);
    }
}
